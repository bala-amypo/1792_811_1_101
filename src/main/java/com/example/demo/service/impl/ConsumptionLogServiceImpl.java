package com.example.demo.service.impl;

import com.example.demo.entity.ConsumptionLog;
import com.example.demo.entity.StockRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ConsumptionLogRepository;
import com.example.demo.repository.StockRecordRepository;
import com.example.demo.service.ConsumptionLogService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ConsumptionLogServiceImpl implements ConsumptionLogService {

    private final ConsumptionLogRepository logRepo;
    private final StockRecordRepository stockRepo;

    public ConsumptionLogServiceImpl(ConsumptionLogRepository logRepo,
                                     StockRecordRepository stockRepo) {
        this.logRepo = logRepo;
        this.stockRepo = stockRepo;
    }

    @Override
    public ConsumptionLog logConsumption(Long stockRecordId, ConsumptionLog log) {

        if (log.getConsumedDate().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("consumedDate cannot be future");
        }

        StockRecord stock = stockRepo.findById(stockRecordId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("StockRecord not found"));

        log.setStockRecord(stock);
        return logRepo.save(log);
    }

    @Override
    public List<ConsumptionLog> getLogsByStockRecord(Long stockRecordId) {
        return logRepo.findByStockRecordId(stockRecordId);
    }

    @Override
    public ConsumptionLog getLog(Long id) {
        return logRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("ConsumptionLog not found"));
    }
}
