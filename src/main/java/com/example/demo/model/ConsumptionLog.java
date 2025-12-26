package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "consumption_logs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConsumptionLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_record_id", nullable = false)
    @NotNull
    private StockRecord stockRecord;

    @Column(nullable = false)
    @Min(value = 1, message = "Consumed quantity must be at least 1")
    private Integer consumedQuantity;

    @Column(nullable = false)
    private LocalDate consumedDate;

    @Column(nullable = false)
    @Builder.Default
    private LocalDateTime loggedAt = LocalDateTime.now();
}