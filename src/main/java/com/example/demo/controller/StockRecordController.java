package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stocks")
public class StockRecordController {

    @PostMapping("/{productId}/{warehouseId}")
    public String createStockRecord(
            @PathVariable Long productId,
            @PathVariable Long warehouseId) {
        return "Stock record created for product " + productId +
               " in warehouse " + warehouseId;
    }

    @GetMapping("/product/{productId}")
    public List<String> getStockByProduct(@PathVariable Long productId) {
        return List.of("Stock record for product " + productId);
    }

    @GetMapping("/warehouse/{warehouseId}")
    public List<String> getStockByWarehouse(@PathVariable Long warehouseId) {
        return List.of("Stock record for warehouse " + warehouseId);
    }

    @GetMapping("/{id}")
    public String getStockRecordById(@PathVariable Long id) {
        return "Stock record with id " + id;
    }
}
