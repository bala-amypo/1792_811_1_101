package com.example.demo.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.StockRecord;
import com.example.demo.repository.StockRecordRepository;
import com.example.demo.service.StockRecordService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StockRecordServiceImpl implements StockRecordService {

    private final StockRecordRepository recordRepo;

    @Override
    public StockRecord createStockRecord(Long productId, Long warehouseId, StockRecord record) {
        record.setProductId(productId);
        record.setWarehouseId(warehouseId);
        record.setLastUpdated(LocalDateTime.now());
        return recordRepo.save(record);
    }

    @Override
    public StockRecord getStockRecord(Long id) {
        return recordRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("StockRecord not found"));
    }

    @Override
    public List<StockRecord> getRecordsBy_product(Long productId) {
        return recordRepo.findByProductId(productId);
    }
}
