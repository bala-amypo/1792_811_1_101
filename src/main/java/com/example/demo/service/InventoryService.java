package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Inventory;
import com.example.demo.exception.InvalidRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.InventoryRepository;

@Service
@Transactional
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    
    public Inventory addInventory(Inventory inventory) {

        if (inventory == null) {
            throw new InvalidRequestException("Inventory data cannot be null");
        }

        if (inventory.getProductName() == null ||
            inventory.getProductName().trim().isEmpty()) {
            throw new InvalidRequestException("Product name cannot be empty");
        }

        if (inventory.getQuantity() < 0) {
            throw new InvalidRequestException("Quantity cannot be negative");
        }

        return inventoryRepository.save(inventory);
    }

    
    @Transactional(readOnly = true)
    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }

    
    @Transactional(readOnly = true)
    public Inventory getInventoryById(Long id) {

        if (id == null) {
            throw new InvalidRequestException("Inventory ID cannot be null");
        }

        return inventoryRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Inventory not found with id: " + id));
    }

    
    public Inventory updateInventory(Long id, Inventory updatedInventory) {

        Inventory existingInventory = getInventoryById(id);

        if (updatedInventory.getProductName() != null &&
            !updatedInventory.getProductName().trim().isEmpty()) {
            existingInventory.setProductName(
                    updatedInventory.getProductName());
        }

        if (updatedInventory.getQuantity() >= 0) {
            existingInventory.setQuantity(
                    updatedInventory.getQuantity());
        }

        return inventoryRepository.save(existingInventory);
    }

    
    public void deleteInventory(Long id) {
        Inventory inventory = getInventoryById(id);
        inventoryRepository.delete(inventory);
    }
}
