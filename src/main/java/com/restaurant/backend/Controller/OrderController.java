package com.restaurant.backend.Controller;

import com.restaurant.backend.Entity.OrderItem;
import com.restaurant.backend.Entity.Order;
import com.restaurant.backend.Service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Order order) {
        Order created = orderService.create(order);
        return ResponseEntity.ok(
                Map.of(
                        "message", "Order created successfully",
                        "order", created
                )
        );
    }

    @GetMapping("/list")
    public ResponseEntity<?> getAll() {
        List<Order> orders = orderService.getAll();
        return ResponseEntity.ok(
                Map.of(
                        "message", "Orders retrieved successfully",
                        "orders", orders
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Order order = orderService.getById(id);
        return ResponseEntity.ok(
                Map.of(
                        "message", "Order retrieved successfully",
                        "order", order
                )
        );
    }

    // ⭐ Nghiệp vụ thực tế
    @PostMapping("/{orderId}/add-item")
    public ResponseEntity<?> addItem(@PathVariable Long orderId, @RequestBody List<OrderItem> items) {
        Order order = orderService.addItem(orderId, items);
        return ResponseEntity.ok(
                Map.of(
                        "message", "Items added to order successfully",
                        "order", order
                )
        );
    }

    @DeleteMapping("/{orderId}/remove-item/{itemId}")
    public ResponseEntity<?> removeItem(@PathVariable Long orderId, @PathVariable Long itemId) {
        Order order = orderService.removeItem(orderId, itemId);
        return ResponseEntity.ok(
                Map.of(
                        "message", "Item removed from order successfully",
                        "order", order
                )
        );
    }

    @PutMapping("/{orderId}/checkout")
    public ResponseEntity<?> checkout(@PathVariable Long orderId) {
        Order order = orderService.checkout(orderId);
        return ResponseEntity.ok(
                Map.of(
                        "message", "Order checked out successfully",
                        "order", order
                )
        );
    }
}
