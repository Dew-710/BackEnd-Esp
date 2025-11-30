package com.restaurant.backend.Controller;

import com.restaurant.backend.Entity.Booking;
import com.restaurant.backend.Service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Booking booking) {
        Booking created = bookingService.createBooking(booking);
        return ResponseEntity.ok(
                Map.of(
                        "message", "Booking created successfully",
                        "booking", created
                )
        );
    }

    @GetMapping("/list")
    public ResponseEntity<?> getAll() {
        List<Booking> bookings = bookingService.getAllBookings();
        return ResponseEntity.ok(
                Map.of(
                        "message", "Bookings retrieved successfully",
                        "bookings", bookings
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Booking booking = bookingService.getBookingById(id);
        return ResponseEntity.ok(
                Map.of(
                        "message", "Booking retrieved successfully",
                        "booking", booking
                )
        );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Booking booking) {
        Booking updated = bookingService.updateBooking(id, booking);
        return ResponseEntity.ok(
                Map.of(
                        "message", "Booking updated successfully",
                        "booking", updated
                )
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.ok(
                Map.of("message", "Booking deleted successfully")
        );
    }

    // ⭐ Nghiệp vụ thực tế
    @PutMapping("/{id}/assign-table/{tableId}")
    public ResponseEntity<?> assignTable(@PathVariable Long id, @PathVariable Long tableId) {
        Booking booking = bookingService.assignTable(id, tableId);
        return ResponseEntity.ok(
                Map.of(
                        "message", "Table assigned successfully",
                        "booking", booking
                )
        );
    }

    @PutMapping("/{id}/confirm")
    public ResponseEntity<?> confirm(@PathVariable Long id) {
        Booking booking = bookingService.updateStatus(id, "CONFIRMED");
        return ResponseEntity.ok(
                Map.of(
                        "message", "Booking confirmed successfully",
                        "booking", booking
                )
        );
    }

    @PutMapping("/{id}/cancel")
    public ResponseEntity<?> cancel(@PathVariable Long id) {
        Booking booking = bookingService.updateStatus(id, "CANCELED");
        return ResponseEntity.ok(
                Map.of(
                        "message", "Booking canceled successfully",
                        "booking", booking
                )
        );
    }
}
