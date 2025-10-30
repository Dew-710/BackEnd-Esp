package com.example.backend.websocket;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class IoTWebSocketHandler extends TextWebSocketHandler {

    private final Set<WebSocketSession> readySessions = ConcurrentHashMap.newKeySet();

    @Override public void afterConnectionEstablished(WebSocketSession session) {
        readySessions.add(session);
        System.out.println("ESP32 ready: " + session.getId());
    }

    @Override public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        readySessions.remove(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) {
        String payload = message.getPayload();
        System.out.println("From ESP32: " + payload);

        if ("ESP32 ready!".equals(payload)) {
            readySessions.add(session);                 // mark as image-capable
            try {
                session.sendMessage(new TextMessage("Server received: ESP32 ready!"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        if ("IMAGE_OK".equals(payload)) {
            System.out.println("ESP32 confirmed image reception");
        }
    }

    /** Send a file **only** to devices that announced readiness */
    public void broadcastImageBytes(byte[] jpgData) {
        try {
            // 1️⃣ Decode ảnh JPG
            BufferedImage img = ImageIO.read(new ByteArrayInputStream(jpgData));
            if (img == null) {
                System.err.println("❌ Cannot decode image (null)");
                return;
            }

            // 2️⃣ Resize về 128x64 cho OLED
            Image scaled = img.getScaledInstance(128, 64, Image.SCALE_SMOOTH);
            BufferedImage bwImg = new BufferedImage(128, 64, BufferedImage.TYPE_BYTE_BINARY);
            Graphics2D g = bwImg.createGraphics();
            g.drawImage(scaled, 0, 0, null);
            g.dispose();

            // 3️⃣ Convert thành raw bitmap (1 bit/pixel)
            ByteArrayOutputStream rawOut = new ByteArrayOutputStream();
            for (int y = 0; y < 64; y++) {
                for (int x = 0; x < 128; x += 8) {
                    int byteVal = 0;
                    for (int b = 0; b < 8; b++) {
                        int pixel = bwImg.getRGB(x + b, y);
                        int gray = (pixel & 0xFF);
                        if (gray == 0x00) byteVal |= (1 << b);
                    }
                    rawOut.write(byteVal);
                }
            }

            byte[] rawBitmap = rawOut.toByteArray();

            // 4️⃣ Encode base64 và gửi từng phần (phân mảnh an toàn)
            String base64 = Base64.getEncoder().encodeToString(rawBitmap);
            int chunkSize = 4000;
            int total = (int) Math.ceil((double) base64.length() / chunkSize);

            for (int i = 0; i < total; i++) {
                int start = i * chunkSize;
                int end = Math.min(base64.length(), start + chunkSize);
                String part = base64.substring(start, end);

                String msg = "IMG|" + (i + 1) + "/" + total + "|" + part;

                for (WebSocketSession s : readySessions) {
                    if (s.isOpen()) {
                        s.sendMessage(new TextMessage(msg));
                    }
                }

                Thread.sleep(30); // tránh nghẽn buffer
            }

            System.out.println("✅ Sent image as bitmap to ESP32 (" + total + " parts)");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
