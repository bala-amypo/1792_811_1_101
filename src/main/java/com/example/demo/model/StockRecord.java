package com.example.demo.model;

import java.time.LocalDateTime;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockRecord {

    private Long id;
    private Long productId;
    private Long warehouseId;
    private int currentQuantity;
    private int reorderThreshold;
    private LocalDateTime lastUpdated;
}
