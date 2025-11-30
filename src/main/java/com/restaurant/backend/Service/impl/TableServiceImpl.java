package com.restaurant.backend.Service.impl;

import com.restaurant.backend.Entity.RestaurantTable;
import com.restaurant.backend.Repository.RestaurantTableRepository;
import com.restaurant.backend.Service.RestaurantTableService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TableServiceImpl implements RestaurantTableService {

    private final RestaurantTableRepository tableRepository;


    @Override
    public List<RestaurantTable> findAll() {
        return List.of();
    }

    @Override
    public RestaurantTable findById(Long id) {
        return null;
    }

    @Override
    public RestaurantTable create(RestaurantTable table) {
        return null;
    }

    @Override
    public RestaurantTable update(Long id, RestaurantTable table) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public RestaurantTable GetTablebyId(long id) {
        return null;
    }

    @Override
    public List<RestaurantTable> getAll() {
        return List.of();
    }

    @Override
    public RestaurantTable updateStatus(Long id, String status) {
        return null;
    }
}
