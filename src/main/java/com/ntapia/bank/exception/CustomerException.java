package com.ntapia.bank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 */
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class CustomerException extends RuntimeException {

    public CustomerException(String message) {
        super(message);
    }
}
