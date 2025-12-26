package com.example.demo.service;

import com.example.demo.entity.StockRecord;
import java.util.List;

public interface StockRecordService {

    StockRecord create(Long productId, Long warehouseId, StockRecord record);

    List<StockRecord> getRecordsBy_product(Long productId);

    List<StockRecord> getRecordsByWarehouse(Long warehouseId);

    StockRecord get(Long id);
}
