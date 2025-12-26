package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Product;
import com.example.demo.model.StockRecord;
import com.example.demo.model.Warehouse;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.StockRecordRepository;
import com.example.demo.repository.WarehouseRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StockRecordService {
    private final StockRecordRepository stockRecordRepository;
    private final ProductRepository productRepository;
    private final WarehouseRepository warehouseRepository;

    @Transactional
    public StockRecord createStockRecord(long productId, long warehouseId, StockRecord stockRecord) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + productId));
        
        Warehouse warehouse = warehouseRepository.findById(warehouseId)
                .orElseThrow(() -> new ResourceNotFoundException("Warehouse not found with id: " + warehouseId));

        // Check for duplicate stock record
        if (stockRecordRepository.findByProductIdAndWarehouseId(productId, warehouseId).isPresent()) {
            throw new IllegalArgumentException("StockRecord already exists for product " + productId + 
                                               " and warehouse " + warehouseId);
        }

        stockRecord.setProduct(product);
        stockRecord.setWarehouse(warehouse);
        stockRecord.setLastUpdated(LocalDateTime.now());
        
        return stockRecordRepository.save(stockRecord);
    }

    // MUST be named exactly like this according to constraints
    public List<StockRecord> getRecordsBy_product(long productId) {
        return stockRecordRepository.findByProductId(productId);
    }

    public List<StockRecord> getRecordsByWarehouse(long warehouseId) {
        return stockRecordRepository.findByWarehouseId(warehouseId);
    }

    public StockRecord getStockRecordById(Long id) {
        return stockRecordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("StockRecord not found with id: " + id));
    }

    @Transactional
    public StockRecord updateStockQuantity(Long id, Integer newQuantity) {
        StockRecord stockRecord = getStockRecordById(id);
        stockRecord.setCurrentQuantity(newQuantity);
        stockRecord.setLastUpdated(LocalDateTime.now());
        return stockRecordRepository.save(stockRecord);
    }
}