package com.example.demo.repository;

import com.example.demo.model.StockRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StockRecordRepository extends JpaRepository<StockRecord, Long> {

    // REQUIRED by StockRecordServiceImpl
    List<StockRecord> findByProductId(long productId);
}
