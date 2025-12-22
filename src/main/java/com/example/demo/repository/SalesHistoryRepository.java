package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SalesHistoryRepository
        extends JpaRepository<SalesHistory, Long> {
    List<SalesHistory> findByProductName(String productName);
}
