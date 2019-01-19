package com.ntapia.bank.controller;

import com.ntapia.bank.common.Util;
import com.ntapia.bank.model.Transaction;
import com.ntapia.bank.service.TransactionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 */
@RestController
public class TransactionController {

    private static final String FIELD_CARD_ID = "cardid";
    private static final String PATH = "/transaction";

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/transaction/{id}")
    public Transaction get(@PathVariable Long id) {
        return transactionService.get(id);
    }

    @GetMapping(PATH)
    public List<Transaction> findByCardId(@RequestParam(FIELD_CARD_ID) Long cardId) {
        return transactionService.findByCardId(cardId);
    }

    @PostMapping(PATH)
    public Transaction post(@RequestBody Transaction customer) {
        return transactionService.save(customer);
    }

    @PutMapping(PATH + Util.PATH_ID)
    public Transaction put(@RequestBody Transaction transaction, @PathVariable Long id) {
        return transactionService.update(transaction, id);
    }

    @DeleteMapping(PATH)
    public void delete(@PathVariable Long id) {
        transactionService.delete(id);
    }
}
