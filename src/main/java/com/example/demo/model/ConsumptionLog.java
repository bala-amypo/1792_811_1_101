package com.example.demo.model;

import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConsumptionLog {
    private Long id;
    private StockRecord stockRecord;
    private Integer consumedQuantity;
    private LocalDate consumedDate;
    private LocalDateTime loggedAt;
}
