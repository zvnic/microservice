package ru.datavendor.fraud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.datavendor.fraud.model.FraudCheckHistory;

public interface FraudCheckHistoryRepository extends JpaRepository<FraudCheckHistory, Integer> {
}