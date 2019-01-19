package com.ntapia.bank.service;

import com.ntapia.bank.common.CRUDService;
import com.ntapia.bank.model.Transaction;

import java.util.List;

/**
 * Business logic contract to Transaction
 */
public interface TransactionService extends CRUDService<Transaction> {

    List<Transaction> findByCardId(Long cardId);
}
