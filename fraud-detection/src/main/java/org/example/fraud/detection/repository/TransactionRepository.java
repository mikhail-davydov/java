package org.example.fraud.detection.repository;

import org.example.fraud.detection.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {

    @Modifying
    @Query("UPDATE Transaction t SET t.status = SUSPICIOUS WHERE t.userId = :userId")
    void markSuspicious(@Param("userId") Long userId);

}
