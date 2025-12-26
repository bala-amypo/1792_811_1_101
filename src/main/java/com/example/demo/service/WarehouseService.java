package com.example.demo.service;

import com.example.demo.model.Warehouse;

import java.util.List;

public interface WarehouseService {

    Warehouse create(Warehouse warehouse);

    List<Warehouse> getAll();

    Warehouse getById(Long id);
}
