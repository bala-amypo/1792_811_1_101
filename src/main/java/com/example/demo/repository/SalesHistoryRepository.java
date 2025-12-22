package com.example.demo.repository;

import com.example.demo.entity.SalesHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesHistoryRepository extends JpaRepository<SalesHistory, Long> {
    List<SalesHistory> findByProductName(String productName);
}
