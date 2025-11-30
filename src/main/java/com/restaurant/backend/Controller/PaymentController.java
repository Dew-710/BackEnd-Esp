package com.restaurant.backend.Controller;

import com.restaurant.backend.Entity.Payment;
import com.restaurant.backend.Service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Payment payment) {
        Payment created = paymentService.create(payment);
        return ResponseEntity.ok(
                Map.of(
                        "message", "Payment created successfully",
                        "payment", created
                )
        );
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<?> getByOrder(@PathVariable Long orderId) {
        Payment payment = paymentService.getByOrder(orderId);
        return ResponseEntity.ok(
                Map.of(
                        "message", "Payment retrieved successfully",
                        "payment", payment
                )
        );
    }
}
