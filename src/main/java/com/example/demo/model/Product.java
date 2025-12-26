package com.example.demo.model;

import java.time.LocalDateTime;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private Long id;
    private String productName;
    private String category;
    private String sku;
    private LocalDateTime createdAt;
}
