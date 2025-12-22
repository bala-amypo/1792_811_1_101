package com.example.demo.controller;

import com.example.demo.entity.SalesHistory;
import com.example.demo.repository.SalesHistoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SalesHistoryController {

    private final SalesHistoryRepository salesHistoryRepository;

    public SalesHistoryController(SalesHistoryRepository salesHistoryRepository) {
        this.salesHistoryRepository = salesHistoryRepository;
    }

    @PostMapping
    public SalesHistory create(@RequestBody SalesHistory history) {
        return salesHistoryRepository.save(history);
    }

    @GetMapping
    public List<SalesHistory> getAll() {
        return salesHistoryRepository.findAll();
    }

    @GetMapping("/{id}")
    public SalesHistory getById(@PathVariable Long id) {
        return salesHistoryRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public SalesHistory update(@PathVariable Long id, @RequestBody SalesHistory history) {
        history.setId(id);
        return salesHistoryRepository.save(history);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        salesHistoryRepository.deleteById(id);
    }
}
