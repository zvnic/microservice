package ru.datavendor.fraud.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.datavendor.fraud.model.FraudCheckHistory;
import ru.datavendor.fraud.repository.FraudCheckHistoryRepository;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudCheckService {

    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    public boolean isFraudulentCostumer(Integer costumerId) {
        fraudCheckHistoryRepository.save(FraudCheckHistory.builder()
                .customerId(costumerId)
                .isFraudster(false)
                .createdAt(LocalDateTime.now())
                .build());
        return false;
    }
}
