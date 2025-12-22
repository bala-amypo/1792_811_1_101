package com.example.demo.service;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Inventory;

@Service
public class InventoryService {

    // In-memory storage
    private Map<Long, Inventory> inventoryMap = new HashMap<>();

    // CREATE
    public Inventory addInventory(Inventory inventory) {
        inventoryMap.put(inventory.getId(), inventory);
        return inventory;
    }

    // READ ALL
    public List<Inventory> getAllInventory() {
        return new ArrayList<>(inventoryMap.values());
    }

    // READ BY ID
    public Inventory getInventoryById(Long id) {
        return inventoryMap.get(id);
    }

    // UPDATE
    public Inventory updateInventory(Long id, Inventory inventory) {
        inventoryMap.put(id, inventory);
        return inventory;
    }

    // DELETE
    public Inventory deleteInventory(Long id) {
        return inventoryMap.remove(id);
    }
}
