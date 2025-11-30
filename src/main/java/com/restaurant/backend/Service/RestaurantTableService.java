package com.restaurant.backend.Service;

import com.restaurant.backend.Entity.RestaurantTable;

import java.util.List;

public interface RestaurantTableService {
    List<RestaurantTable> findAll();

    RestaurantTable findById(Long id);

    RestaurantTable create(RestaurantTable table);

    RestaurantTable update(Long id, RestaurantTable table);

    void delete(Long id);

    RestaurantTable GetTablebyId(long id);

    List<RestaurantTable> getAll();

    RestaurantTable updateStatus(Long id, String status);
}
