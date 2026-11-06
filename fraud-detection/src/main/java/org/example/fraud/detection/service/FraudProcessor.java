package org.example.fraud.detection.service;

import lombok.RequiredArgsConstructor;
import org.example.fraud.detection.repository.TransactionRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FraudProcessor {

    private final TransactionRepository transactionRepository;

    @KafkaListener(topics = "fraud-alerts", groupId = "fraud-processor")
    public void handleFraudAlert(String message) {
        System.out.println("Received fraud alert: " + message);

        // Парсинг userID из сообщения
        if (message.startsWith("Fraud detected")) {
            String[] parts = message.split(" ");
            Long userId = Long.parseLong(parts[2]);
            transactionRepository.markSuspicious(userId);
        }
    }
}
