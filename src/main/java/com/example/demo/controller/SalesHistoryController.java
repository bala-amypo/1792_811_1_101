package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.SalesHistory;
import com.example.demo.service.SalesHistoryService;

@RestController
@RequestMapping("/api/sales")
public class SalesHistoryController {

    private final SalesHistoryService salesHistoryService;

    public SalesHistoryController(SalesHistoryService salesHistoryService) {
        this.salesHistoryService = salesHistoryService;
    }

    
    @PostMapping("/record")
    public ResponseEntity<SalesHistory> recordSale(
            @RequestParam Long inventoryId,
            @RequestParam int quantitySold) {

        SalesHistory salesHistory =
                salesHistoryService.recordSale(inventoryId, quantitySold);

        return new ResponseEntity<>(salesHistory, HttpStatus.CREATED);
    }

    
    @GetMapping
    public ResponseEntity<List<SalesHistory>> getAllSalesHistory() {
        return ResponseEntity.ok(
                salesHistoryService.getAllSalesHistory());
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<SalesHistory> getSalesHistoryById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                salesHistoryService.getSalesHistoryById(id));
    }
}
