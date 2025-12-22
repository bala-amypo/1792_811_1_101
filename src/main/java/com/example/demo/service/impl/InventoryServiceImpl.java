package com.example.demo.service.impl;

import com.example.demo.entity.Inventory;
import com.example.demo.repository.InventoryRepository;
import com.example.demo.service.InventoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository repository;

    public InventoryServiceImpl(InventoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Inventory createInventory(Inventory inventory) {
        return repository.save(inventory);
    }

    @Override
    public List<Inventory> getAllInventory() {
        return repository.findAll();
    }

    @Override
    public Inventory getInventoryById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Inventory (Long id, Inventory inventory) {
        inventory.setId(id);
        return repository.save(inventory);
    }

    @Override
    public void deleteInventory(Long id) {
        repository.deleteById(id);
    }
}
