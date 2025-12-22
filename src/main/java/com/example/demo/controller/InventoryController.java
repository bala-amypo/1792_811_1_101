package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Inventory;
import com.example.demo.service.InventoryService;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

   
    @PostMapping
    public ResponseEntity<Inventory> addInventory(
            @RequestBody Inventory inventory) {

        Inventory savedInventory =
                inventoryService.addInventory(inventory);

        return new ResponseEntity<>(
                savedInventory, HttpStatus.CREATED);
    }

    
    @GetMapping
    public ResponseEntity<List<Inventory>> getAllInventory() {
        return ResponseEntity.ok(
                inventoryService.getAllInventory());
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<Inventory> getInventoryById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                inventoryService.getInventoryById(id));
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<Inventory> updateInventory(
            @PathVariable Long id,
            @RequestBody Inventory inventory) {

        return ResponseEntity.ok(
                inventoryService.updateInventory(id, inventory));
    }

   
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInventory(
            @PathVariable Long id) {

        inventoryService.deleteInventory(id);
        return ResponseEntity.noContent().build();
    }
}
