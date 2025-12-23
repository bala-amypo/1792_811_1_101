package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.PredictionRule;
import com.example.demo.repository.PredictionRuleRepository;

@RestController
@RequestMapping("/api/predict/rules")
public class PredictionRuleController {

    private final PredictionRuleRepository repo;

    public PredictionRuleController(PredictionRuleRepository repo) {
        this.repo = repo;
    }

    // CREATE
    @PostMapping
    public PredictionRule create(@RequestBody PredictionRule rule) {
        return repo.save(rule);
    }

    // READ ALL
    @GetMapping
    public List<PredictionRule> getAll() {
        return repo.findAll();
    }

    
}
