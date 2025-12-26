package com.example.demo.service.impl;

import com.example.demo.model.ConsumptionLog;
import com.example.demo.model.StockRecord;
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

        StockRecord record = stockRepo.findById(stockRecordId)
                .orElseThrow(() -> new RuntimeException("StockRecord not found"));

        log.setStockRecord(record);

        // ✅ FIX IS HERE (LocalDate, not LocalDateTime)
        log.setConsumedDate(LocalDate.now());

        return logRepo.save(log);
    }

    @Override
    public List<ConsumptionLog> getLogsByStockRecord(Long stockRecordId) {
        return logRepo.findByStockRecordId(stockRecordId);
    }
}
