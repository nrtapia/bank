package com.ntapia.bank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class TransactionInvalidDataException extends RuntimeException {

    public TransactionInvalidDataException() {
        super("Description, Date, and Amount it's required");
    }
}
