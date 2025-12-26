package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "consumption_logs")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConsumptionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long stockRecordId;

    private int consumedQuantity;

    // ⚠️ MUST be LocalDate (NOT LocalDateTime) – testcase requirement
    private LocalDate consumedDate;
}
