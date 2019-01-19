package com.ntapia.bank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class AdviserInvalidDataException extends RuntimeException {

    public AdviserInvalidDataException() {
        super("Full name and Speciality it's required");
    }
}
