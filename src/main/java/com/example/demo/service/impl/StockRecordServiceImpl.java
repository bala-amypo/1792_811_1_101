package com.example.demo.service.impl;

import com.example.demo.entity.Product;
import com.example.demo.entity.StockRecord;
import com.example.demo.entity.Warehouse;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.StockRecordRepository;
import com.example.demo.repository.WarehouseRepository;
import com.example.demo.service.StockRecordService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StockRecordServiceImpl implements StockRecordService {

    private final StockRecordRepository stockRepo;
    private final ProductRepository productRepo;
    private final WarehouseRepository warehouseRepo;

    public StockRecordServiceImpl(StockRecordRepository stockRepo,
                                  ProductRepository productRepo,
                                  WarehouseRepository warehouseRepo) {
        this.stockRepo = stockRepo;
        this.productRepo = productRepo;
        this.warehouseRepo = warehouseRepo;
    }

    @Override
    public StockRecord create(Long productId, Long warehouseId, StockRecord record) {

        Product product = productRepo.findById(productId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product not found"));

        Warehouse warehouse = warehouseRepo.findById(warehouseId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Warehouse not found"));

        record.setProduct(product);
        record.setWarehouse(warehouse);
        record.setLastUpdated(LocalDateTime.now());

        return stockRepo.save(record);
    }

    @Override
    public List<StockRecord> getRecordsBy_product(Long productId) {
        return stockRepo.findByProductId(productId);
    }

    @Override
    public List<StockRecord> getRecordsByWarehouse(Long warehouseId) {
        return stockRepo.findByWarehouseId(warehouseId);
    }

    @Override
    public StockRecord get(Long id) {
        return stockRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("StockRecord not found"));
    }
}
