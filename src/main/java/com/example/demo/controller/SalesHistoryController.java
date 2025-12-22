package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.SalesHistory;
import com.example.demo.service.SalesHistoryService;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SalesHistoryController {

    @Autowired
    private SalesHistoryService salesHistoryService;

    // CREATE / ADD SALES HISTORY
    @PostMapping("/add")
    public SalesHistory addSalesHistory(@RequestBody SalesHistory salesHistory) {
        return salesHistoryService.addSalesHistory(salesHistory);
    }

    // READ ALL SALES HISTORY
    @GetMapping("/all")
    public List<SalesHistory> getAllSalesHistory() {
        return salesHistoryService.getAllSalesHistory();
    }

    // READ SALES HISTORY BY ID
    @GetMapping("/{id}")
    public SalesHistory getSalesHistoryById(@PathVariable Integer id) {
        return salesHistoryService.getSalesHistoryById(id);
    }

    // UPDATE SALES HISTORY
    @PutMapping("/update/{id}")
    public SalesHistory updateSalesHistory(@PathVariable Integer id, @RequestBody SalesHistory salesHistory) {
        return salesHistoryService.updateSalesHistory(id, salesHistory);
    }

    // DELETE SALES HISTORY
    @DeleteMapping("/delete/{id}")
    public SalesHistory deleteSalesHistory(@PathVariable Integer id) {
        return salesHistoryService.deleteSalesHistory(id);
    }
}
