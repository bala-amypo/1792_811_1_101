package com.example.demo.service.impl;

import com.example.demo.model.PredictionRule;
import com.example.demo.repository.PredictionRuleRepository;
import com.example.demo.service.PredictionService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PredictionServiceImpl implements PredictionService {

    private final PredictionRuleRepository repository;

    public PredictionServiceImpl(PredictionRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public PredictionRule createRule(PredictionRule rule) {
        return repository.save(rule);
    }

    @Override
    public PredictionRule getRuleById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rule not found"));
    }
}
