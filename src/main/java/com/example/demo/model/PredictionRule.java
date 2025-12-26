package com.example.demo.model;

import lombok.*;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PredictionRule {
    private Long id;
    private String ruleName;
    private Integer threshold;
    private LocalDateTime createdAt;
}
