package com.ntapia.bank.dao;

import com.ntapia.bank.model.Transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Repository to access Transaction data
 */
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query("SELECT t FROM Transaction t where t.card.id = :cardId ORDER BY date DESC")
    List<Transaction> findByCardId(@Param("cardId") Long cardId);
}
