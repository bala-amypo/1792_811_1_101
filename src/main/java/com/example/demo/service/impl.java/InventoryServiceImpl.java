package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Inventory;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.InventoryRepository;
import com.example.demo.service.InventoryService;


@Service
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

   
    public InventoryServiceImpl(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    
    @Override
    public Inventory addInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    
    @Override
    public Inventory getInventoryById(Long id) {
        return inventoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Inventory item not found with id: " + id));
    }

    
    @Override
    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }

   
    @Override
    public Inventory updateInventory(Long id, Inventory inventoryDetails) {
        Inventory existingInventory = inventoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Inventory item not found with id: " + id));

        existingInventory.setName(inventoryDetails.getName());
        existingInventory.setQuantity(inventoryDetails.getQuantity());
        existingInventory.setPrice(inventoryDetails.getPrice());

        return inventoryRepository.save(existingInventory);
    }

    
    @Override
    public void deleteInventory(Long id) {
        Inventory existingInventory = inventoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Inventory item not found with id: " + id));

        inventoryRepository.delete(existingInventory);
    }
}
