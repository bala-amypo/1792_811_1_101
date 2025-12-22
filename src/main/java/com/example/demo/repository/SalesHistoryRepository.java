package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.SalesHistory;

@Repository
public interface SalesHistoryRepository extends JpaRepository<SalesHistory, Long> {
    // Add custom query methods here if required
}
