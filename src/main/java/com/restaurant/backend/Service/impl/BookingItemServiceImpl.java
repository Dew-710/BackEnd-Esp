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
        return List.of();
    }

    @Override
    public BookingItem findById(Long id) {
        return null;
    }

    @Override
    public BookingItem create(BookingItem item) {
        return null;
    }

    @Override
    public BookingItem update(Long id, BookingItem item) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public BookingItem getBookingItemById(long id) {
        return null;
    }

    @Override
    public BookingItem getBookingItemByBookingId(long bookingId) {
        return null;
    }

    @Override
    public List<BookingItem> getByBooking(long bookingId) {
        return null;
    }
}
