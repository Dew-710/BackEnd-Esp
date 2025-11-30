package com.restaurant.backend.Service;

import com.restaurant.backend.Entity.Order;
import com.restaurant.backend.Entity.OrderItem;

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

    List<Order> getAll();

    Order getById(Long id);

    

    Order removeItem(Long orderId, Long itemId);

    Order checkout(Long orderId);

    Order addItem(Long orderId, List<OrderItem> items);
}
