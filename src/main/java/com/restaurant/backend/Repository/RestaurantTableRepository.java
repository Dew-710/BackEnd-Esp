package com.restaurant.backend.Repository;

import com.restaurant.backend.Entity.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantTableRepository extends JpaRepository<Table, Long> {
}
