package com.ntapia.bank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 */
@ResponseStatus(value = HttpStatus.ALREADY_REPORTED)
public class CustomerAlreadyExistException extends RuntimeException {

    public CustomerAlreadyExistException() {
        super("Customer already exist!");
    }
}
