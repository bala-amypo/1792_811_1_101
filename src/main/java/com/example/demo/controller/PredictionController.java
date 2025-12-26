package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.PredictionRule;
import com.example.demo.service.PredictionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/prediction")
@RequiredArgsConstructor
public class PredictionController {

    private final PredictionService predictionService;

    @PostMapping("/rules")
    @ResponseStatus(HttpStatus.CREATED)
    public PredictionRule createRule(@RequestBody PredictionRule rule) {
        return predictionService.createRule(rule);
    }

    @GetMapping("/rules")
    public List<PredictionRule> getAllRules() {
        return predictionService.getAllRules();
    }

    @GetMapping("/restock/{stockRecordId}")
    public LocalDate predict(@PathVariable Long stockRecordId) {
        return predictionService.predictRestockDate(stockRecordId);
    }
}
