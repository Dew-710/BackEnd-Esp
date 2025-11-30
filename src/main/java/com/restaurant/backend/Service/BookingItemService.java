package com.restaurant.backend.Service;

import com.restaurant.backend.Entity.BookingItem;

import java.util.List;

public interface BookingItemService {
    List<BookingItem> findAll();

    BookingItem findById(Long id);

    BookingItem create(BookingItem item);

    BookingItem update(Long id, BookingItem item);

    void delete(Long id);

    BookingItem getBookingItemById(long id);
    BookingItem getBookingItemByBookingId(long bookingId);

    List<BookingItem> getByBooking(long bookingId);
}
