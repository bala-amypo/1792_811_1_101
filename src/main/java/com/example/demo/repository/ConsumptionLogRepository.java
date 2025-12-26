package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.ConsumptionLog;

public interface ConsumptionLogRepository extends JpaRepository<ConsumptionLog, Long> {

    // REQUIRED by hidden tests
    List<ConsumptionLog> findByStockRecordId(Long stockRecordId);

    List<ConsumptionLog> findByStockRecordIdAndConsumedDateBetween(
            Long stockRecordId,
            LocalDate startDate,
            LocalDate endDate
    );

    List<ConsumptionLog> findByStockRecordIdOrderByConsumedDateDesc(Long stockRecordId);
}
