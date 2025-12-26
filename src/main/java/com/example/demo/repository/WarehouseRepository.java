package com.example.demo.repository;

import com.example.demo.model.StockRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StockRecordRepository extends JpaRepository<StockRecord, Long> {
    List<StockRecord> findByProductId(long productId);
    
    List<StockRecord> findByWarehouseId(long warehouseId);
    
    @Query("SELECT sr FROM StockRecord sr WHERE sr.product.id = :productId AND sr.warehouse.id = :warehouseId")
    Optional<StockRecord> findByProductIdAndWarehouseId(@Param("productId") long productId, 
                                                        @Param("warehouseId") long warehouseId);
}