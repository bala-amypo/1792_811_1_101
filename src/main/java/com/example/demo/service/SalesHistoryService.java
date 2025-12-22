package com.example.demo.service;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.demo.entity.SalesHistory;

@Service
public class SalesHistoryService {

    // In-memory storage
    private Map<Long, SalesHistory> salesMap = new HashMap<>();

    // CREATE
    public SalesHistory addSales(SalesHistory sales) {
        salesMap.put(sales.getId(), sales);
        return sales;
    }

    // READ ALL
    public List<SalesHistory> getAllSales() {
        return new ArrayList<>(salesMap.values());
    }

    // READ BY ID
    public SalesHistory getSalesById(Long id) {
        return salesMap.get(id);
    }

    // UPDATE
    public SalesHistory updateSales(Long id, SalesHistory sales) {
        salesMap.put(id, sales);
        return sales;
    }

    // DELETE
    public SalesHistory deleteSales(Long id) {
        return salesMap.remove(id);
    }
}
