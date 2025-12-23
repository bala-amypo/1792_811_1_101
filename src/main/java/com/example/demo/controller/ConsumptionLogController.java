package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/consumption")
public class ConsumptionLogController {

    @PostMapping("/{stockRecordId}")
    public String logConsumption(@PathVariable Long stockRecordId) {
        return "Consumption logged for stockRecord " + stockRecordId;
    }

    @GetMapping("/record/{stockRecordId}")
    public List<String> getConsumptionLogs(@PathVariable Long stockRecordId) {
        return List.of("Consumption log for stockRecord " + stockRecordId);
    }

    @GetMapping("/{id}")
    public String getLogById(@PathVariable Long id) {
        return "Consumption log with id " + id;
    }
}
