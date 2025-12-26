package com.example.demo.model;

import java.time.LocalDate;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConsumptionLog {

    private Long id;
    private Long stockRecordId;
    private int consumedQuantity;
    private LocalDate consumedDate;
}
