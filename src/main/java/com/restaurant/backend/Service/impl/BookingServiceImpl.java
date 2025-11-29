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
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking findById(Long id) {
        return bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("Booking not found"));
    }

    @Override
    public Booking create(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public Booking update(Long id, Booking booking) {
        Booking existing = findById(id);
        existing.setCustomer(booking.getCustomer());
        existing.setTable(booking.getTable());
        existing.setDate(booking.getDate());
        existing.setTime(booking.getTime());
        existing.setGuests(booking.getGuests());
        existing.setNote(booking.getNote());
        existing.setStatus(booking.getStatus());
        return bookingRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        bookingRepository.deleteById(id);
    }

    @Override
    public Booking getBookingById(long id) {
        return null;
    }

    @Override
    public Booking getBookingByCustomerId(long customerId) {
        return null;
    }
}
