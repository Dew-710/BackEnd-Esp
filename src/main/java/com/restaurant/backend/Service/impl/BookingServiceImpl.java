package com.restaurant.backend.Service.impl;

import com.restaurant.backend.Entity.Booking;
import com.restaurant.backend.Repository.BookingRepository;
import com.restaurant.backend.Service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;


    @Override
    public List<Booking> getAllBookings() {
        return List.of();
    }

    @Override
    public List<Booking> findAll() {
        return List.of();
    }

    @Override
    public Booking findById(Long id) {
        return null;
    }

    @Override
    public Booking createBooking(Booking booking) {
        return null;
    }

    @Override
    public Booking create(Booking booking) {
        return null;
    }

    @Override
    public Booking updateBooking(Long id, Booking booking) {
        return null;
    }

    @Override
    public Booking getBookingById(long id) {
        return null;
    }

    @Override
    public Booking getBookingByCustomerId(long customerId) {
        return null;
    }

    @Override
    public Booking assignTable(Long id, Long tableId) {
        return null;
    }

    @Override
    public void deleteBooking(Long id) {

    }

    @Override
    public Booking updateStatus(Long id, String confirmed) {
        return null;
    }
}
