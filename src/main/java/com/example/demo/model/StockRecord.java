package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;

    private int reorderThreshold;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Warehouse warehouse;

    // 🔥 ADD THIS FIELD
    private LocalDateTime lastUpdated;
}
