package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.StockRecord;
import com.example.demo.repository.StockRecordRepository;

@RestController
@RequestMapping("/api/stocks")
public class StockRecordController {

    private final StockRecordRepository repo;

    public StockRecordController(StockRecordRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public StockRecord create(@RequestBody StockRecord stock) {
        return repo.save(stock);
    }

    @GetMapping
    public List<StockRecord> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public StockRecord getById(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

   

    
}
