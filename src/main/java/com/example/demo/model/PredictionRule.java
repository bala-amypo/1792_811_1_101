package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.ConsumptionLog;
import com.example.demo.service.ConsumptionLogService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/consumption")
@RequiredArgsConstructor
public class ConsumptionLogController {

    private final ConsumptionLogService consumptionLogService;

    @PostMapping("/stock/{stockRecordId}")
    @ResponseStatus(HttpStatus.CREATED)
    public ConsumptionLog logConsumption(
            @PathVariable Long stockRecordId,
            @RequestBody ConsumptionLog log) {
        return consumptionLogService.logConsumption(stockRecordId, log);
    }

    @GetMapping("/stock/{stockRecordId}")
    public List<ConsumptionLog> getLogs(@PathVariable Long stockRecordId) {
        return consumptionLogService.getLogsByStockRecord(stockRecordId);
    }
}
