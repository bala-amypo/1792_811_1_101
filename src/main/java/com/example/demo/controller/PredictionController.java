package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/predict")
public class PredictionController {

    @GetMapping("/restock-date/{stockRecordId}")
    public String predictRestockDate(@PathVariable Long stockRecordId) {
        return "Predicted restock date for stockRecord " + stockRecordId;
    }

    @PostMapping("/rules")
    public String createPredictionRule() {
        return "Prediction rule created";
    }

    @GetMapping("/rules")
    public List<String> getAllPredictionRules() {
        return List.of("Rule1", "Rule2");
    }
}
