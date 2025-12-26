package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.ConsumptionLog;
import com.example.demo.model.PredictionRule;
import com.example.demo.model.StockRecord;
import com.example.demo.repository.ConsumptionLogRepository;
import com.example.demo.repository.PredictionRuleRepository;
import com.example.demo.repository.StockRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PredictionService {
    private final StockRecordRepository stockRecordRepository;
    private final ConsumptionLogRepository consumptionLogRepository;
    private final PredictionRuleRepository predictionRuleRepository;

    public LocalDate predictRestockDate(long stockRecordId) {
        StockRecord stockRecord = stockRecordRepository.findById(stockRecordId)
                .orElseThrow(() -> new ResourceNotFoundException("StockRecord not found with id: " + stockRecordId));

        // Get the active prediction rule (using first rule for simplicity)
        PredictionRule rule = predictionRuleRepository.findAll().stream()
                .findFirst()
                .orElse(PredictionRule.builder()
                        .ruleName("Default Rule")
                        .windowSize(30)
                        .build());

        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusDays(rule.getWindowSize());

        List<ConsumptionLog> recentLogs = consumptionLogRepository
                .findByStockRecordIdAndConsumedDateBetween(stockRecordId, startDate, endDate);

        if (recentLogs.isEmpty()) {
            // If no consumption history, return null or far future date
            return null;
        }

        // Calculate average daily consumption
        double totalConsumption = recentLogs.stream()
                .mapToInt(ConsumptionLog::getConsumedQuantity)
                .sum();
        
        long daysInWindow = ChronoUnit.DAYS.between(startDate, endDate) + 1;
        double averageDailyConsumption = totalConsumption / daysInWindow;

        if (averageDailyConsumption <= 0) {
            return null;
        }

        // Calculate days until reorder threshold is reached
        int remainingStock = stockRecord.getCurrentQuantity();
        int reorderThreshold = stockRecord.getReorderThreshold();
        
        if (remainingStock <= reorderThreshold) {
            // Already at or below reorder threshold
            return LocalDate.now();
        }

        int stockAboveThreshold = remainingStock - reorderThreshold;
        double daysUntilReorder = stockAboveThreshold / averageDailyConsumption;

        return LocalDate.now().plusDays((long) Math.ceil(daysUntilReorder));
    }

    public List<PredictionRule> getAllRules() {
        return predictionRuleRepository.findAll();
    }

    public PredictionRule createRule(PredictionRule rule) {
        return predictionRuleRepository.save(rule);
    }
}