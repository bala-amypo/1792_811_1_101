package com.example.demo.service;

import com.example.demo.model.PredictionRule;

public interface PredictionService {

    PredictionRule createRule(PredictionRule rule);

    PredictionRule getRuleById(Long id);
}
