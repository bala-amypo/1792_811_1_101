package com.example.inventory.entity;

import jakarta.presistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String product name;
    private int currentStock;
    private int minimumStock;
    private LocalDate lastRestockDate;

    public Inventory() {}

    public Inventory(String productName, int currentStock, int minimumstock) {
        this.productName = productName;
        this.currentStock = currentStock;
        this.minimumStock = minimumStock;
        this.lastRestockDate = lastRestockSate;
    }

    public Long getId() {
        return id;
    }

    public String getProductName() {
        return productname;
    }
    
    
    


    }


