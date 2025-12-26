package com.example.demo.service;

import com.example.demo.model.PredictionRule;
import com.example.demo.repository.PredictionRuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PredictionService {
    private final PredictionRuleRepository predictionRuleRepository;

    public LocalDate predictRestockDate(long stockRecordId) {
        // Simple implementation
        return LocalDate.now().plusDays(7);
    }

    public List<PredictionRule> getAllRules() {
        return predictionRuleRepository.findAll();
    }

    public PredictionRule createRule(PredictionRule rule) {
        return predictionRuleRepository.save(rule);
    }
}