package com.example.demo.service;

import com.example.demo.model.StockRecord;

import java.util.List;

public interface StockRecordService {

    StockRecord create(Long productId, Long warehouseId, StockRecord record);

    // REQUIRED by testcases
    List<StockRecord> getRecordsBy_product(Long productId);

    List<StockRecord> getRecordsByWarehouse(Long warehouseId);

    StockRecord get(Long id);
}
