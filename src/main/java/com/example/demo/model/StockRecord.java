package com.example.demo.model;

import lombok.*;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockRecord {
    private Long id;
    private Product product;
    private Warehouse warehouse;
    private Integer currentQuantity;
    private LocalDateTime lastUpdated;
}
