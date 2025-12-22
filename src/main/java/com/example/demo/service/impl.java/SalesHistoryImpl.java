package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.SalesHistory;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.SalesHistoryRepository;
import com.example.demo.service.SalesHistoryService;


@Service
public class SalesHistoryServiceImpl implements SalesHistoryService {

    private final SalesHistoryRepository salesHistoryRepository;

    
    public SalesHistoryServiceImpl(SalesHistoryRepository salesHistoryRepository) {
        this.salesHistoryRepository = salesHistoryRepository;
    }

    @Override
    public SalesHistory addSalesRecord(SalesHistory salesHistory) {
        return salesHistoryRepository.save(salesHistory);
    }

    @Override
    public SalesHistory getSalesRecordById(Long id) {
        return salesHistoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Sales record not found with id: " + id));
    }

    
    @Override
    public List<SalesHistory> getAllSalesRecords() {
        return salesHistoryRepository.findAll();
    }

    
    @Override
    public SalesHistory updateSalesRecord(Long id, SalesHistory salesHistoryDetails) {
        SalesHistory existingRecord = salesHistoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Sales record not found with id: " + id));

        existingRecord.setProductName(salesHistoryDetails.getProductName());
        existingRecord.setQuantitySold(salesHistoryDetails.getQuantitySold());
        existingRecord.setSaleDate(salesHistoryDetails.getSaleDate());
        existingRecord.setTotalPrice(salesHistoryDetails.getTotalPrice());

        return salesHistoryRepository.save(existingRecord);
    }

   
    @Override
    public void deleteSalesRecord(Long id) {
        SalesHistory existingRecord = salesHistoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Sales record not found with id: " + id));

        salesHistoryRepository.delete(existingRecord);
    }
}
