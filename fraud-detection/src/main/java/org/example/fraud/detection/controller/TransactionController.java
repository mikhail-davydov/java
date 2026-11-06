package org.example.fraud.detection.controller;

import lombok.RequiredArgsConstructor;
import org.example.fraud.detection.model.Transaction;
import org.example.fraud.detection.repository.TransactionRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionRepository transactionRepository;

    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        transaction.setStatus(Transaction.Status.NEW);
        transaction.setTimestamp(LocalDateTime.now());
        return transactionRepository.save(transaction);
    }

}
