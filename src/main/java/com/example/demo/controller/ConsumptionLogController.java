package com.example.demo.controller;

import com.example.demo.model.ConsumptionLog;
import com.example.demo.service.ConsumptionLogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consumption")
@RequiredArgsConstructor
@Tag(name = "Consumption Log Management", description = "APIs for managing consumption logs")
public class ConsumptionLogController {
    private final ConsumptionLogService consumptionLogService;

    @PostMapping("/{stockRecordId}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('STAFF') or hasRole('USER')")
    @Operation(summary = "Log consumption for a stock record")
    public ResponseEntity<ConsumptionLog> logConsumption(
            @PathVariable Long stockRecordId,
            @Valid @RequestBody ConsumptionLog consumptionLog) {
        return new ResponseEntity<>(
                consumptionLogService.logConsumption(stockRecordId, consumptionLog),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/record/{stockRecordId}")
    @Operation(summary = "Get consumption logs by stock record ID")
    public ResponseEntity<List<ConsumptionLog>> getLogsByStockRecord(@PathVariable Long stockRecordId) {
        return ResponseEntity.ok(consumptionLogService.getLogsByStockRecord(stockRecordId));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get consumption log by ID")
    public ResponseEntity<ConsumptionLog> getLogById(@PathVariable Long id) {
        return ResponseEntity.ok(consumptionLogService.getLog(id));
    }
}