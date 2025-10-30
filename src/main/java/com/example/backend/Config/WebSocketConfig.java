package com.example.backend.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.backend.websocket.IoTWebSocketHandler;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    private final IoTWebSocketHandler ioTWebSocketHandler;

    @Autowired
    public WebSocketConfig(IoTWebSocketHandler ioTWebSocketHandler) {
        this.ioTWebSocketHandler = ioTWebSocketHandler;
    }

        @Override
        public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
            registry.addHandler(ioTWebSocketHandler, "/ws/iot").setAllowedOrigins("*");
    }
}
