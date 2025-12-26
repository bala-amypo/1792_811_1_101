package com.example.demo.model;

import java.time.LocalDateTime;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PredictionRule {

    private Long id;
    private String ruleName;
    private int averageDaysWindow;
    private int minDailyUsage;
    private int maxDailyUsage;
    private LocalDateTime createdAt;
}
