package com.restaurant.backend.Service;

import com.restaurant.backend.Entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> findAll();

    Order findById(Long id);

    Order create(Order order);

    Order update(Long id, Order order);

    void delete(Long id);

    Order createOrder(Order order);
    Order getOrderByCustomerId(long customerId);
    Order getOrderByTableId(long tableId);

}
