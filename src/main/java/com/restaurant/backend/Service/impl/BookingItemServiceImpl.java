package com.restaurant.backend.Service.impl;

import com.restaurant.backend.Entity.BookingItem;
import com.restaurant.backend.Repository.BookingItemRepository;
import com.restaurant.backend.Service.BookingItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingItemServiceImpl implements BookingItemService {

    private final BookingItemRepository bookingItemRepository;

    @Override
    public List<BookingItem> findAll() {
        return bookingItemRepository.findAll();
    }

    @Override
    public BookingItem findById(Long id) {
        return bookingItemRepository.findById(id).orElseThrow(() -> new RuntimeException("Booking item not found"));
    }

    @Override
    public BookingItem create(BookingItem item) {
        return bookingItemRepository.save(item);
    }

    @Override
    public BookingItem update(Long id, BookingItem item) {
        BookingItem existing = findById(id);
        existing.setBooking(item.getBooking());
        existing.setMenuItem(item.getMenuItem());
        existing.setQuantity(item.getQuantity());
        existing.setPrice(item.getPrice());
        return bookingItemRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        bookingItemRepository.deleteById(id);
    }

    @Override
    public BookingItem getBookingItemById(long id) {
        return null;
    }

    @Override
    public BookingItem getBookingItemByBookingId(long bookingId) {
        return null;
    }
}
