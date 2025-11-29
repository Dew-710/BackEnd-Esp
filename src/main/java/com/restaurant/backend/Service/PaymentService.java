package com.restaurant.backend.Service;

import com.restaurant.backend.Entity.Payment;

import java.util.List;

public interface PaymentService {
    List<Payment> findAll();

    Payment findById(Long id);

    Payment create(Payment payment);

    Payment update(Long id, Payment payment);

    void delete(Long id);

    String processPayment(long orderId, double amount);
}
