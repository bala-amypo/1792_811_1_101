package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.StockRecord;

public interface StockRecordRepository extends JpaRepository<StockRecord, Long> {
}
