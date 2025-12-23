package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.ConsumptionLog;
import com.example.demo.repository.ConsumptionLogRepository;

@RestController
@RequestMapping("/api/consumption")
public class ConsumptionLogController {

    private final ConsumptionLogRepository repo;

    public ConsumptionLogController(ConsumptionLogRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public ConsumptionLog create(@RequestBody ConsumptionLog log) {
        return repo.save(log);
    }

    @GetMapping
    public List<ConsumptionLog> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ConsumptionLog getById(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        repo.deleteById(id);
        return "Consumption log deleted";
    }
}
