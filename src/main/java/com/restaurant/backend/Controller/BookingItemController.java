package com.restaurant.backend.Controller;

import com.restaurant.backend.Entity.BookingItem;
import com.restaurant.backend.Service.BookingItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/booking-items")
public class BookingItemController {

    private final BookingItemService bookingItemService;

    public BookingItemController(BookingItemService bookingItemService) {
        this.bookingItemService = bookingItemService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody BookingItem item) {
        BookingItem created = bookingItemService.create(item);
        return ResponseEntity.ok(
                Map.of(
                        "message", "Booking item created successfully",
                        "bookingItem", created
                )
        );
    }

    @GetMapping("/booking/{bookingId}")
    public ResponseEntity<?> getByBooking(@PathVariable Long bookingId) {
        List<BookingItem> bookingItems = bookingItemService.getByBooking(bookingId);
        return ResponseEntity.ok(
                Map.of(
                        "message", "Booking items retrieved successfully",
                        "bookingItems", bookingItems
                )
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        bookingItemService.delete(id);
        return ResponseEntity.ok(
                Map.of("message", "Booking item deleted successfully")
        );
    }
}
