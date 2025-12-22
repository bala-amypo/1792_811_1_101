package com.example.demo.controller;

import com.example.demo.entity.Inventory;
import com.example.demo.repository.InventoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryRepository inventoryRepository;

    public InventoryController(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @PostMapping
    public Inventory create(@RequestBody Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @GetMapping
    public List<Inventory> getAll() {
        return inventoryRepository.findAll();
    }

    @GetMapping("/{id}")
    public Inventory getById(@PathVariable Long id) {
        return inventoryRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Inventory update(@PathVariable Long id, @RequestBody Inventory inventory) {
        inventory.setId(id);
        return inventoryRepository.save(inventory);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        inventoryRepository.deleteById(id);
    }
}
