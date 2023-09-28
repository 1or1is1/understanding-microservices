package com.quantum.fraud.service;

import com.quantum.fraud.entity.FraudCheckHistory;
import com.quantum.fraud.repository.FraudCheckHistoryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public record FraudCheckHistoryService(FraudCheckHistoryRepository fraudCheckHistoryRepository) {

    public boolean isFraudulentCustomer(Integer customerId) {
        FraudCheckHistory fraudCheckHistory = FraudCheckHistory.builder()
                .isFraudster(false)
                .customerId(customerId)
                .createdAt(LocalDateTime.now())
                .build();
        fraudCheckHistoryRepository.save(fraudCheckHistory);
        return false;
    }
}
