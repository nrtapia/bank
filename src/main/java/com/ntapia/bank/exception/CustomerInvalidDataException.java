package com.ntapia.bank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CustomerInvalidDataException extends RuntimeException {

    public CustomerInvalidDataException() {
        super("Full name it's required");
    }
}
