package com.example.demo.controller;

import com.example.demo.model.PredictionRule;
import com.example.demo.service.PredictionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/predict")
@RequiredArgsConstructor
@Tag(name = "Prediction Management", description = "APIs for restock predictions")
public class PredictionController {
    private final PredictionService predictionService;

    @GetMapping("/restock-date/{stockRecordId}")
    @Operation(summary = "Predict next restock date for a stock record")
    public ResponseEntity<LocalDate> predictRestockDate(@PathVariable Long stockRecordId) {
        return ResponseEntity.ok(predictionService.predictRestockDate(stockRecordId));
    }

    @PostMapping("/rules")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Create a new prediction rule")
    public ResponseEntity<PredictionRule> createRule(@Valid @RequestBody PredictionRule rule) {
        return new ResponseEntity<>(predictionService.createRule(rule), HttpStatus.CREATED);
    }

    @GetMapping("/rules")
    @Operation(summary = "Get all prediction rules")
    public ResponseEntity<List<PredictionRule>> getAllRules() {
        return ResponseEntity.ok(predictionService.getAllRules());
    }
}