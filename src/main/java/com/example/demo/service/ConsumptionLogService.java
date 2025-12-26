package com.example.demo.service;

import com.example.demo.model.ConsumptionLog;
import com.example.demo.model.StockRecord;
import com.example.demo.repository.ConsumptionLogRepository;
import com.example.demo.repository.StockRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsumptionLogService {
    private final ConsumptionLogRepository consumptionLogRepository;
    private final StockRecordRepository stockRecordRepository;

    public ConsumptionLog logConsumption(long stockRecordId, ConsumptionLog log) {
        StockRecord stockRecord = stockRecordRepository.findById(stockRecordId)
                .orElseThrow(() -> new RuntimeException("StockRecord not found with id: " + stockRecordId));

        if (log.getConsumedDate().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("consumedDate cannot be future");
        }

        int newQuantity = stockRecord.getCurrentQuantity() - log.getConsumedQuantity();
        if (newQuantity < 0) {
            throw new IllegalArgumentException("Insufficient stock");
        }
        
        stockRecord.setCurrentQuantity(newQuantity);
        stockRecord.setLastUpdated(LocalDateTime.now());
        stockRecordRepository.save(stockRecord);

        log.setStockRecord(stockRecord);
        log.setLoggedAt(LocalDateTime.now());
        
        return consumptionLogRepository.save(log);
    }

    public List<ConsumptionLog> getLogsByStockRecord(long stockRecordId) {
        return consumptionLogRepository.findByStockRecordIdOrderByConsumedDateDesc(stockRecordId);
    }

    public ConsumptionLog getLog(Long id) {
        return consumptionLogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ConsumptionLog not found with id: " + id));
    }
}