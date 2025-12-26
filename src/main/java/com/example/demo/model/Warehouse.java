package com.example.demo.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Warehouse {
    private Long id;
    private String warehouseName;
    private String location;
}
