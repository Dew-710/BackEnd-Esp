package com.restaurant.backend.Controller;

import com.restaurant.backend.Entity.OrderItem;
import com.restaurant.backend.Service.OrderItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/order-items")
public class OrderItemController {

    private final OrderItemService service;

    public OrderItemController(OrderItemService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody OrderItem item) {
        OrderItem created = service.create(item);
        return ResponseEntity.ok(
                Map.of(
                        "message", "Order item created successfully",
                        "orderItem", created
                )
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok(
                Map.of("message", "Order item deleted successfully")
        );
    }
}
