package com.example.majorproject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    @Modifying
    @Transactional
    @Query("update Transaction t set t.status = :status where t.externalId = :externalId")
    void updateTransaction(String externalId, String status);

    Transaction findByExternalId(String externalId);
}
