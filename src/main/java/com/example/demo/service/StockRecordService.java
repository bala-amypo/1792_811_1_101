package com.example.demo.service;

import com.example.demo.model.StockRecord;
import java.util.List;

public interface StockRecordService {

    StockRecord createStockRecord(
            long productId,
            long warehouseId,
            StockRecord stockRecord
    );

    StockRecord getStockRecord(long id);

    List<StockRecord> getRecordsBy_product(long productId);
}
