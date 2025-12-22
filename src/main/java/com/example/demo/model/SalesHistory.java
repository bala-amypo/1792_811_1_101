package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class SalesHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long inventoryId;
    private int quantitySold;
    private LocalDate saleDate;

    public SalesHistory() {}

    public SalesHistory(Long inventoryId, int quantitySold, LocalDate saleDate) {
        this.inventoryId = inventoryId;
        this.quantitySold = quantitySold;
        this.saleDate = saleDate;
    }

    public Long getId() {
        return id;
    }

    public Long getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Long inventoryId) {
        this.inventoryId = inventoryId;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }
}
