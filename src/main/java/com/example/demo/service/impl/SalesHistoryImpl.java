package com.example.demo.service.impl;

import com.example.demo.entity.SalesHistory;
import com.example.demo.repository.SalesHistoryRepository;
import com.example.demo.service.SalesHistoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesHistorySerImpl implements SalesHistoryService {

    private final SalesHistoryRepository repository;

    public SalesHistoryServiceImpl(SalesHistoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public SalesHistory createSalesHistory(SalesHistory salesHistory) {
        return repository.save(salesHistory);
    }

    @Override
    public List<SalesHistory> getAllSalesHistory() {
        return repository.findAll();
    }

    @Override
    public SalesHistory getSalesHistoryById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public SalesHistory updateSalesHistory(Long id, SalesHistory salesHistory) {
        salesHistory.setId(id);
        return repository.save(salesHistory);
    }

    @Override
    public void deleteSalesHistory(Long id) {
        repository.deleteById(id);
    }
}
