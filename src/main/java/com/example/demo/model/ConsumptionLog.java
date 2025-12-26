package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "consumption_logs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConsumptionLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "stock_record_id", nullable = false)
    private StockRecord stockRecord;

    @Column(nullable = false)
    @Min(1)
    private Integer consumedQuantity;

    @Column(nullable = false)
    private LocalDate consumedDate;

    @Builder.Default
    private LocalDateTime loggedAt = LocalDateTime.now();
}