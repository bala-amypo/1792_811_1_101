package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Warehouse;
import com.example.demo.repository.WarehouseRepository;

@RestController
@RequestMapping("/api/warehouses")
public class WarehouseController {

    private final WarehouseRepository repo;

    public WarehouseController(WarehouseRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public Warehouse create(@RequestBody Warehouse warehouse) {
        return repo.save(warehouse);
    }

    @GetMapping
    public List<Warehouse> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Warehouse getById(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

   
}
