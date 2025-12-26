package com.example.demo.model;

import java.time.LocalDateTime;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Warehouse {

    private Long id;
    private String warehouseName;
    private String location;
    private LocalDateTime createdAt;
}
