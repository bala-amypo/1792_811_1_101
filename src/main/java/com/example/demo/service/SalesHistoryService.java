package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Inventory;
import com.example.demo.entity.SalesHistory;
import com.example.demo.exception.InvalidRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.InventoryRepository;
import com.example.demo.repository.SalesHistoryRepository;

@Service
@Transactional
public class SalesHistoryService {

    private final SalesHistoryRepository salesHistoryRepository;
    private final InventoryRepository inventoryRepository;

    public SalesHistoryService(
            SalesHistoryRepository salesHistoryRepository,
            InventoryRepository inventoryRepository) {
        this.salesHistoryRepository = salesHistoryRepository;
        this.inventoryRepository = inventoryRepository;
    }

    
    public SalesHistory recordSale(Long inventoryId, int quantitySold) {

        if (inventoryId == null) {
            throw new InvalidRequestException("Inventory ID cannot be null");
        }

        if (quantitySold <= 0) {
            throw new InvalidRequestException(
                    "Quantity sold must be greater than zero");
        }

        Inventory inventory = inventoryRepository.findById(inventoryId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Inventory not found with id: " + inventoryId));

        if (inventory.getQuantity() < quantitySold) {
            throw new InvalidRequestException(
                    "Insufficient inventory quantity");
        }

        inventory.setQuantity(
                inventory.getQuantity() - quantitySold);
        inventoryRepository.save(inventory);

        
        SalesHistory salesHistory = new SalesHistory();
        salesHistory.setProductName(inventory.getProductName());
        salesHistory.setQuantitySold(quantitySold);
        salesHistory.setSoldAt(LocalDateTime.now());

        return salesHistoryRepository.save(salesHistory);
    }

    @Transactional(readOnly = true)
    public List<SalesHistory> getAllSalesHistory() {
        return salesHistoryRepository.findAll();
    }

    @Transactional(readOnly = true)
    public SalesHistory getSalesHistoryById(Long id) {

        if (id == null) {
            throw new InvalidRequestException("Sales history ID cannot be null");
        }

        return salesHistoryRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Sales history not found with id: " + id));
    }
}
