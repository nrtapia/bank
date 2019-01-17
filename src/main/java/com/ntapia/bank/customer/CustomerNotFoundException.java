// Copyright (c) 2018 Boomi, Inc.
package com.ntapia.bank.customer;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
class CustomerNotFoundException extends RuntimeException {

    CustomerNotFoundException() {
        super("Customer not found");
    }
}
