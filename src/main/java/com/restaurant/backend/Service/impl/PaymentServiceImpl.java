package com.restaurant.backend.Service.impl;

import com.restaurant.backend.Entity.Payment;
import com.restaurant.backend.Repository.PaymentRepository;
import com.restaurant.backend.Service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Override
    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment findById(Long id) {
        return paymentRepository.findById(id).orElseThrow(() -> new RuntimeException("Payment not found"));
    }

    @Override
    public Payment create(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Payment update(Long id, Payment payment) {
        Payment existing = findById(id);
        existing.setOrder(payment.getOrder());
        existing.setAmount(payment.getAmount());
        existing.setMethod(payment.getMethod());
        existing.setPaidAt(payment.getPaidAt());
        return paymentRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        paymentRepository.deleteById(id);
    }

    @Override
    public String processPayment(long orderId, double amount) {
        return "";
    }

    @Override
    public Payment getByOrder(Long orderId) {
        return null;
    }
}
