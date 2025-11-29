package com.restaurant.backend.Service;

import com.restaurant.backend.Entity.Booking;

import java.util.List;

public interface BookingService {
    List<Booking> findAll();

    Booking findById(Long id);

    Booking create(Booking booking);

    Booking update(Long id, Booking booking);

    void delete(Long id);

    Booking getBookingById(long id);
    Booking getBookingByCustomerId(long customerId);
}
