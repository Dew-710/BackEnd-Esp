package com.restaurant.backend.Service.impl;

import com.restaurant.backend.Entity.OrderItem;
import com.restaurant.backend.Repository.OrderItemRepository;
import com.restaurant.backend.Service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository orderItemRepository;

    @Override
    public List<OrderItem> findAll() {
        return orderItemRepository.findAll();
    }

    @Override
    public OrderItem findById(Long id) {
        return orderItemRepository.findById(id).orElseThrow(() -> new RuntimeException("Order item not found"));
    }

    @Override
    public OrderItem create(OrderItem item) {
        return orderItemRepository.save(item);
    }

    @Override
    public OrderItem update(Long id, OrderItem item) {
        OrderItem existing = findById(id);
        existing.setOrder(item.getOrder());
        existing.setMenuItem(item.getMenuItem());
        existing.setQuantity(item.getQuantity());
        existing.setPrice(item.getPrice());
        return orderItemRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        orderItemRepository.deleteById(id);
    }

    @Override
    public OrderItem getOrderItemById(long id) {
        return null;
    }

    @Override
    public OrderItem getOrderItemByOrderId(long orderId) {
        return null;
    }

    @Override
    public OrderItem createOrderItem(OrderItem orderItem) {
        return null;
    }

    @Override
    public OrderItem updateOrderItem(OrderItem orderItem) {
        return null;
    }
}
