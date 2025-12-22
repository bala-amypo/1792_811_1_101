package com.example.demo.service;

import com.example.demo.entity.SalesHistory;
import java.util.List;

public interface SalesHistoryService {

    SalesHistory createSalesHistory(SalesHistory salesHistory);

    List<SalesHistory> getAllSalesHistory();

    SalesHistory getSalesHistoryById(Long id);

    SalesHistory updateSalesHistory(Long id, SalesHistory salesHistory);

    void deleteSalesHistory(Long id);
}
