package com.restaurant.backend.Service.impl;

import com.restaurant.backend.Entity.Order;
import com.restaurant.backend.Repository.OrderRepository;
import com.restaurant.backend.Service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @Override
    public Order create(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order update(Long id, Order order) {
        Order existing = findById(id);
        existing.setCustomer(order.getCustomer());
        existing.setTable(order.getTable());
        existing.setStaff(order.getStaff());
        existing.setBooking(order.getBooking());
        existing.setOrderTime(order.getOrderTime());
        existing.setStatus(order.getStatus());
        existing.setTotal(order.getTotal());
        return orderRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Order createOrder(Order order) {
        return null;
    }

    @Override
    public Order getOrderByCustomerId(long customerId) {
        return null;
    }

    @Override
    public Order getOrderByTableId(long tableId) {
        return null;
    }
}
