package com.example.demo.service;

import com.example.demo.model.StockRecord;

public interface StockRecordService {

    StockRecord createStockRecord(StockRecord record);

    StockRecord getStockRecordById(Long id);
}
