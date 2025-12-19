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
    

}
