package com.ntapia.bank.service.impl;

import com.ntapia.bank.dao.TransactionRepository;
import com.ntapia.bank.exception.TransactionInvalidDataException;
import com.ntapia.bank.exception.TransactionNotFoundException;
import com.ntapia.bank.model.Transaction;
import com.ntapia.bank.service.TransactionService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Business logic implementation to Transaction
 */
@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository repository;


    @Autowired
    public TransactionServiceImpl(TransactionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Transaction> list() {
        return repository.findAll();
    }

    @Override
    public Transaction get(Long id) {
        return repository.findById(id).orElseThrow(TransactionNotFoundException::new);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Transaction save(Transaction object) {
        validate(object);
        return repository.save(object);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Transaction update(Transaction object, Long id) {
        validate(object);

        Transaction transaction = repository.findById(id).orElseThrow(TransactionNotFoundException::new);
        transaction.setAmount(object.getAmount());
        transaction.setDate(object.getDate());
        transaction.setDescription(object.getDescription());

        return repository.save(transaction);
    }

    private void validate(Transaction object) {
        if (object == null || StringUtils.isBlank(object.getDescription()) || object.getAmount() == null
                || object.getDate() == null) {
            throw new TransactionInvalidDataException();
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void delete(Long id) {
        repository.delete(repository.findById(id).orElseThrow(TransactionNotFoundException::new));
    }

    @Override
    public List<Transaction> findByCardId(Long cardId) {
        return repository.findByCardId(cardId);
    }
}
