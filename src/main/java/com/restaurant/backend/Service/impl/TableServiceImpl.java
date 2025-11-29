package com.restaurant.backend.Service.impl;

import com.restaurant.backend.Entity.Table;
import com.restaurant.backend.Repository.RestaurantTableRepository;
import com.restaurant.backend.Service.TableService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TableServiceImpl implements TableService {

    private final RestaurantTableRepository tableRepository;

    @Override
    public List<Table> findAll() {
        return tableRepository.findAll();
    }

    @Override
    public Table findById(Long id) {
        return tableRepository.findById(id).orElseThrow(() -> new RuntimeException("Table not found"));
    }

    @Override
    public Table create(Table table) {
        return tableRepository.save(table);
    }

    @Override
    public Table update(Long id, Table table) {
        Table existing = findById(id);
        existing.setTableName(table.getTableName());
        existing.setCapacity(table.getCapacity());
        existing.setStatus(table.getStatus());
        return tableRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        tableRepository.deleteById(id);
    }

    @Override
    public Table GetTablebyId(long id) {
        return null;
    }
}
