package com.example.demo.service;

import com.example.demo.model.ConsumptionLog;

public interface ConsumptionLogService {

    ConsumptionLog createLog(ConsumptionLog log);

    ConsumptionLog getLogById(Long id);
}
