package com.example.demo.repository;

import com.example.demo.model.ConsumptionLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ConsumptionLogRepository extends JpaRepository<ConsumptionLog, Long> {
    List<ConsumptionLog> findByStockRecordIdOrderByConsumedDateDesc(long stockRecordId);
    
    @Query("SELECT cl FROM ConsumptionLog cl WHERE cl.stockRecord.id = :stockRecordId AND cl.consumedDate BETWEEN :startDate AND :endDate")
    List<ConsumptionLog> findByStockRecordIdAndConsumedDateBetween(@Param("stockRecordId") long stockRecordId,
                                                                   @Param("startDate") LocalDate startDate,
                                                                   @Param("endDate") LocalDate endDate);
}