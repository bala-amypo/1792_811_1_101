package com.example.inventory.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private int currentStock;

    @Column(nullable = false)
    private int minimumStock;

    private LocalDate lastRestockDate;

    
    public Inventory() {
    }

   
    public Inventory(String productName, int currentStock, int minimumStock) {
        this.productName = productName;
        this.currentStock = currentStock;
        this.minimumStock = minimumStock;
        this.lastRestockDate = LocalDate.now();
    }

   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }
    
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getCurrentStock() {
        return currentStock;
    }
    
    public void setCurrentStock(int currentStock) {
        this.currentStock = currentStock;
    }

    public int getMinimumStock() {
        return minimumStock;
    }
    
    public void setMinimumStock(int minimumStock) {
        this.minimumStock = minimumStock;
    }

    public LocalDate getLastRestockDate() {
        return lastRestockDate;
    }

    public void setLastRestockDate(LocalDate lastRestockDate) {
        this.lastRestockDate = lastRestockDate;
    }
}
