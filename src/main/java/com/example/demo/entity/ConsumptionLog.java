package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "consumption_logs")
public class ConsumptionLog {

    @Id
    private Long id;
    private Long stockRecordId;
    private int consumedQuantity;
    private LocalDateTime consumedAt;

    public ConsumptionLog() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getStockRecordId() { return stockRecordId; }
    public void setStockRecordId(Long stockRecordId) { this.stockRecordId = stockRecordId; }

    public int getConsumedQuantity() { return consumedQuantity; }
    public void setConsumedQuantity(int consumedQuantity) {
        this.consumedQuantity = consumedQuantity;
    }

    public LocalDateTime getConsumedAt() { return consumedAt; }
    public void setConsumedAt(LocalDateTime consumedAt) {
        this.consumedAt = consumedAt;
    }
}
