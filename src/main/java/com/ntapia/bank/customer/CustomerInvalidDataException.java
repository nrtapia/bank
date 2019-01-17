// Copyright (c) 2018 Boomi, Inc.
package com.ntapia.bank.customer;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
class CustomerInvalidDataException extends RuntimeException {

    public CustomerInvalidDataException() {
        super("Full name is required");
    }
}