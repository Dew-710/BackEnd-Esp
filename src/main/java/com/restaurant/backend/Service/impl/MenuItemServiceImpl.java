package com.restaurant.backend.Service.impl;

import com.restaurant.backend.Entity.MenuItem;
import com.restaurant.backend.Repository.MenuItemRepository;
import com.restaurant.backend.Service.MenuItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuItemServiceImpl implements MenuItemService {

    private final MenuItemRepository menuItemRepository;

    @Override
    public List<MenuItem> findAll() {
        return menuItemRepository.findAll();
    }

    @Override
    public MenuItem findById(Long id) {
        return menuItemRepository.findById(id).orElseThrow(() -> new RuntimeException("Menu item not found"));
    }

    @Override
    public MenuItem create(MenuItem item) {
        return menuItemRepository.save(item);
    }

    @Override
    public MenuItem update(Long id, MenuItem item) {
        MenuItem existing = findById(id);
        existing.setName(item.getName());
        existing.setPrice(item.getPrice());
        existing.setDescription(item.getDescription());
        existing.setImageUrl(item.getImageUrl());
        existing.setCategory(item.getCategory());
        existing.setStatus(item.getStatus());
        return menuItemRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        menuItemRepository.deleteById(id);
    }

    @Override
    public MenuItem getMenuItemById(long id) {
        return null;
    }

    @Override
    public MenuItem getMenuItemByCategoryId(long categoryId) {
        return null;
    }

    @Override
    public MenuItem getMenuItemByStatus(String status) {
        return null;
    }
}
