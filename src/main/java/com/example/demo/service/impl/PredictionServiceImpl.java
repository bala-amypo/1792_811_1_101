package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.ConsumptionLog;
import com.example.demo.model.PredictionRule;
import com.example.demo.model.StockRecord;
import com.example.demo.repository.ConsumptionLogRepository;
import com.example.demo.repository.PredictionRuleRepository;
import com.example.demo.repository.StockRecordRepository;
import com.example.demo.service.PredictionService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PredictionServiceImpl implements PredictionService {

    private final StockRecordRepository stockRepo;
    private final ConsumptionLogRepository logRepo;
    private final PredictionRuleRepository ruleRepo;

    public PredictionServiceImpl(StockRecordRepository stockRepo,
                                 ConsumptionLogRepository logRepo,
                                 PredictionRuleRepository ruleRepo) {
        this.stockRepo = stockRepo;
        this.logRepo = logRepo;
        this.ruleRepo = ruleRepo;
    }

    @Override
    public LocalDate predictRestockDate(Long stockRecordId) {

        StockRecord stock = stockRepo.findById(stockRecordId)
                .orElseThrow(() -> new ResourceNotFoundException("StockRecord not found"));

        List<ConsumptionLog> logs = logRepo.findByStockRecordId(stockRecordId);

        if (logs.isEmpty()) return LocalDate.now();

        int avg = logs.stream()
                .mapToInt(ConsumptionLog::getConsumedQuantity)
                .sum() / logs.size();

        if (avg == 0) return LocalDate.now();

        return LocalDate.now()
                .plusDays(stock.getCurrentQuantity() / avg);
    }

    @Override
    public PredictionRule createRule(PredictionRule rule) {
        return ruleRepo.save(rule);
    }

    @Override
    public List<PredictionRule> getAllRules() {
        return ruleRepo.findAll();
    }
}
