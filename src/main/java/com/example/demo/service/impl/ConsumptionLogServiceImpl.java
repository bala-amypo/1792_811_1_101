package com.example.demo.service.impl;

import com.example.demo.model.ConsumptionLog;
import com.example.demo.repository.ConsumptionLogRepository;
import com.example.demo.service.ConsumptionLogService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ConsumptionLogServiceImpl implements ConsumptionLogService {

    private final ConsumptionLogRepository repository;

    public ConsumptionLogServiceImpl(ConsumptionLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public ConsumptionLog createLog(ConsumptionLog log) {
        return repository.save(log);
    }

    @Override
    public ConsumptionLog getLogById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Log not found"));
    }
}
