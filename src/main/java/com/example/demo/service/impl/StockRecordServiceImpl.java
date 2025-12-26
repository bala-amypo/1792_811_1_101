package com.example.demo.service.impl;

import com.example.demo.model.Product;
import com.example.demo.model.StockRecord;
import com.example.demo.model.Warehouse;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.StockRecordRepository;
import com.example.demo.repository.WarehouseRepository;
import com.example.demo.service.StockRecordService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StockRecordServiceImpl implements StockRecordService {

    private final StockRecordRepository recordRepo;
    private final ProductRepository productRepo;
    private final WarehouseRepository warehouseRepo;

    public StockRecordServiceImpl(
            StockRecordRepository recordRepo,
            ProductRepository productRepo,
            WarehouseRepository warehouseRepo) {
        this.recordRepo = recordRepo;
        this.productRepo = productRepo;
        this.warehouseRepo = warehouseRepo;
    }

    @Override
    public StockRecord createStockRecord(long productId, long warehouseId, StockRecord record) {
        Product product = productRepo.findById(productId).orElse(null);
        Warehouse warehouse = warehouseRepo.findById(warehouseId).orElse(null);

        record.setProduct(product);
        record.setWarehouse(warehouse);
        record.setLastUpdated(LocalDateTime.now());

        return recordRepo.save(record);
    }

    @Override
    public StockRecord getStockRecord(long id) {
        return recordRepo.findById(id).orElse(null);
    }

    @Override
    public List<StockRecord> getRecordsBy_product(long productId) {
        return recordRepo.findByProductId(productId);
    }
}
