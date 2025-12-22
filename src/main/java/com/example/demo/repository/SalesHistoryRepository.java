package com.example.demo.repository;

import com.example.demo.entity.SalesHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesHistoryRepository extends JpaRepository<SalesHistory, Long> {
}
