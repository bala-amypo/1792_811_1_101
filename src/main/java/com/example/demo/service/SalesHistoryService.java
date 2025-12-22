package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.SalesHistory;

public interface SalesHistoryService {

    SalesHistory recordSale(Long inventoryId, int quantitySold);

    List<SalesHistory> getAllSalesHistory();

    SalesHistory getSalesHistoryById(Long id);
}
