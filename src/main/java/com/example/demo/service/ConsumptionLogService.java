package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.ConsumptionLog;
import com.example.demo.model.StockRecord;
import com.example.demo.repository.ConsumptionLogRepository;
import com.example.demo.repository.StockRecordRepository;
import jakarta.transaction.Transactional;
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

    @Transactional
    public ConsumptionLog logConsumption(long stockRecordId, ConsumptionLog log) {
        StockRecord stockRecord = stockRecordRepository.findById(stockRecordId)
                .orElseThrow(() -> new ResourceNotFoundException("StockRecord not found with id: " + stockRecordId));

        // Validate future date
        if (log.getConsumedDate().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("consumedDate cannot be future");
        }

        // Validate quantity
        if (log.getConsumedQuantity() <= 0) {
            throw new IllegalArgumentException("Consumed quantity must be greater than 0");
        }

        // Update stock record quantity
        int newQuantity = stockRecord.getCurrentQuantity() - log.getConsumedQuantity();
        if (newQuantity < 0) {
            throw new IllegalArgumentException("Insufficient stock. Current quantity: " + 
                                               stockRecord.getCurrentQuantity());
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
                .orElseThrow(() -> new ResourceNotFoundException("ConsumptionLog not found with id: " + id));
    }

    public List<ConsumptionLog> getLogsByStockRecordAndDateRange(long stockRecordId, LocalDate startDate, LocalDate endDate) {
        return consumptionLogRepository.findByStockRecordIdAndConsumedDateBetween(stockRecordId, startDate, endDate);
    }
}