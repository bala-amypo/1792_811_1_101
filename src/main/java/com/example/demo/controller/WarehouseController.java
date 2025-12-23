package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/warehouses")
public class WarehouseController {

    @PostMapping("/")
    public String createWarehouse() {
        return "Warehouse created";
    }

    @GetMapping("/")
    public List<String> getAllWarehouses() {
        return List.of("Warehouse1", "Warehouse2");
    }

    @GetMapping("/{id}")
    public String getWarehouseById(@PathVariable Long id) {
        return "Warehouse with id " + id;
    }
}
