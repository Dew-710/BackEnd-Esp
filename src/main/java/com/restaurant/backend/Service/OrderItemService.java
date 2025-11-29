package com.restaurant.backend.Service;

import com.restaurant.backend.Entity.OrderItem;

import java.util.List;

public interface OrderItemService {
    List<OrderItem> findAll();

    OrderItem findById(Long id);

    OrderItem create(OrderItem item);

    OrderItem update(Long id, OrderItem item);

    void delete(Long id);

    OrderItem getOrderItemById(long id);
    OrderItem getOrderItemByOrderId(long orderId);
    OrderItem createOrderItem(OrderItem orderItem);
    OrderItem updateOrderItem(OrderItem orderItem);
}
