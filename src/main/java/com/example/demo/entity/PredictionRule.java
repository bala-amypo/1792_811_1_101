package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "prediction_rules")
public class PredictionRule {

    @Id
    private Long id;
    private String ruleName;
    private int thresholdDays;

    public PredictionRule() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRuleName() { return ruleName; }
    public void setRuleName(String ruleName) { this.ruleName = ruleName; }

    public int getThresholdDays() { return thresholdDays; }
    public void setThresholdDays(int thresholdDays) {
        this.thresholdDays = thresholdDays;
    }
}
