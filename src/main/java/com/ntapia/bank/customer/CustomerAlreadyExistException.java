// Copyright (c) 2018 Boomi, Inc.
package com.ntapia.bank.customer;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 */
@ResponseStatus(value = HttpStatus.ALREADY_REPORTED)
class CustomerAlreadyExistException extends RuntimeException {

    public CustomerAlreadyExistException() {
        super("Customer already exist!");
    }
}
