package com.ntapia.bank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AdviserNotFoundException extends RuntimeException{

    public AdviserNotFoundException() {
        super("Adviser not found");
    }
}
