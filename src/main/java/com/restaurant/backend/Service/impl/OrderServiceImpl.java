package com.restaurant.backend.Service.impl;

import com.restaurant.backend.Entity.Order;
import com.restaurant.backend.Entity.OrderItem;
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
        return List.of();
    }

    @Override
    public Order findById(Long id) {
        return null;
    }

    @Override
    public Order create(Order order) {
        return null;
    }

    @Override
    public Order update(Long id, Order order) {
        return null;
    }

    @Override
    public void delete(Long id) {

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

    @Override
    public List<Order> getAll() {
        return List.of();
    }

    @Override
    public Order getById(Long id) {
        return null;
    }

    @Override
    public Order removeItem(Long orderId, Long itemId) {
        return null;
    }

    @Override
    public Order checkout(Long orderId) {
        return null;
    }

    @Override
    public Order addItem(Long orderId, List<OrderItem> items) {
        return null;
    }
}
