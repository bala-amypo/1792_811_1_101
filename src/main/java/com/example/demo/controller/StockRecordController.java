package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.StockRecord;
import com.example.demo.service.StockRecordService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/stocks")
@RequiredArgsConstructor
public class StockRecordController {

    private final StockRecordService stockRecordService;

    @PostMapping("/product/{productId}/warehouse/{warehouseId}")
    @ResponseStatus(HttpStatus.CREATED)
    public StockRecord createStock(
            @PathVariable Long productId,
            @PathVariable Long warehouseId,
            @RequestBody StockRecord record) {
        return stockRecordService.createStockRecord(productId, warehouseId, record);
    }

    @GetMapping("/{id}")
    public StockRecord getStock(@PathVariable Long id) {
        return stockRecordService.getStockRecord(id);
    }

    @GetMapping("/product/{productId}")
    public List<StockRecord> getStockByProduct(@PathVariable Long productId) {
        return stockRecordService.getRecordsBy_product(productId);
    }
}
