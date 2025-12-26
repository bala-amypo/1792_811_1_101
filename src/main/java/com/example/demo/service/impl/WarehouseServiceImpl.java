package com.example.demo.service.impl;

import com.example.demo.entity.Warehouse;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.WarehouseRepository;
import com.example.demo.service.WarehouseService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class WarehouseServiceImpl implements WarehouseService {

    private final WarehouseRepository repository;

    public WarehouseServiceImpl(WarehouseRepository repository) {
        this.repository = repository;
    }

    @Override
    public Warehouse create(Warehouse warehouse) {
        warehouse.setCreatedAt(LocalDateTime.now());
        return repository.save(warehouse);
    }

    @Override
    public List<Warehouse> getAll() {
        return repository.findAll();
    }

    @Override
    public Warehouse getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Warehouse not found"));
    }
}
