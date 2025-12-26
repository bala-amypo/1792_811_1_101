
package com.example.demo.service.impl;

import com.example.demo.model.StockRecord;
import com.example.demo.repository.StockRecordRepository;
import com.example.demo.service.StockRecordService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class StockRecordServiceImpl implements StockRecordService {

    private final StockRecordRepository repository;

    public StockRecordServiceImpl(StockRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public StockRecord createStockRecord(StockRecord record) {
        record.setLastUpdated(LocalDateTime.now());
        return repository.save(record);
    }

    @Override
    public StockRecord getStockRecordById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Stock record not found"));
    }
}
