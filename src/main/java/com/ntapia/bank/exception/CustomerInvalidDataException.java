package com.ntapia.bank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CustomerInvalidDataException extends RuntimeException {

    CustomerInvalidDataException(String message) {
        super(message);
    }

    public CustomerInvalidDataException() {
        this("Full name is required");
    }
}
