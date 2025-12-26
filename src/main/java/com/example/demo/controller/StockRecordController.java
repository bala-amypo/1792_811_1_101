package com.example.demo.controller;

import com.example.demo.model.StockRecord;
import com.example.demo.service.StockRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
public class StockRecordController {

    private final StockRecordService stockRecordService;

    public StockRecordController(StockRecordService stockRecordService) {
        this.stockRecordService = stockRecordService;
    }

    @PostMapping
    public StockRecord createStockRecord(@RequestBody StockRecord record) {
        return stockRecordService.createStockRecord(record);
    }

    @GetMapping("/product/{productId}")
    public List<StockRecord> getByProduct(@PathVariable long productId) {
        return stockRecordService.getRecordsByProduct(productId);
    }
}
