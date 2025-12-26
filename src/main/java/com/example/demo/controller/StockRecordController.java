package com.example.demo.controller;

import com.example.demo.model.StockRecord;
import com.example.demo.service.StockRecordService;
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
@RequestMapping("/api/stocks")
@RequiredArgsConstructor
@Tag(name = "Stock Record Management", description = "APIs for managing stock records")
public class StockRecordController {
    private final StockRecordService stockRecordService;

    @PostMapping("/{productId}/{warehouseId}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('STAFF')")
    @Operation(summary = "Create a new stock record")
    public ResponseEntity<StockRecord> createStockRecord(
            @PathVariable Long productId,
            @PathVariable Long warehouseId,
            @Valid @RequestBody StockRecord stockRecord) {
        return new ResponseEntity<>(
                stockRecordService.createStockRecord(productId, warehouseId, stockRecord),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/product/{productId}")
    @Operation(summary = "Get stock records by product ID")
    public ResponseEntity<List<StockRecord>> getRecordsByProduct(@PathVariable Long productId) {
        return ResponseEntity.ok(stockRecordService.getRecordsBy_product(productId));
    }

    @GetMapping("/warehouse/{warehouseId}")
    @Operation(summary = "Get stock records by warehouse ID")
    public ResponseEntity<List<StockRecord>> getRecordsByWarehouse(@PathVariable Long warehouseId) {
        return ResponseEntity.ok(stockRecordService.getRecordsByWarehouse(warehouseId));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get stock record by ID")
    public ResponseEntity<StockRecord> getStockRecordById(@PathVariable Long id) {
        return ResponseEntity.ok(stockRecordService.getStockRecordById(id));
    }
}