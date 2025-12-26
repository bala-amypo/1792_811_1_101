package com.example.demo.service;

import com.example.demo.model.ConsumptionLog;
import java.util.List;

public interface ConsumptionLogService {

    ConsumptionLog logConsumption(long stockRecordId, ConsumptionLog log);

    List<ConsumptionLog> getLogsByStockRecord(long stockRecordId);
}
