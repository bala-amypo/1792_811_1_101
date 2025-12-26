package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "stock_records", 
       uniqueConstraints = @UniqueConstraint(columnNames = {"product_id", "warehouse_id"}))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StockRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    @NotNull
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warehouse_id", nullable = false)
    @NotNull
    private Warehouse warehouse;

    @Column(nullable = false)
    @Min(value = 0, message = "Current quantity cannot be negative")
    private Integer currentQuantity;

    @Column(nullable = false)
    @Min(value = 1, message = "Reorder threshold must be greater than 0")
    private Integer reorderThreshold;

    @Column(nullable = false)
    @Builder.Default
    private LocalDateTime lastUpdated = LocalDateTime.now();
}