package com.restaurant.backend.Service;

import com.restaurant.backend.Entity.Table;

import java.util.List;

public interface TableService {
    List<Table> findAll();

    Table findById(Long id);

    Table create(Table table);

    Table update(Long id, Table table);

    void delete(Long id);

    Table GetTablebyId(long id);
}
