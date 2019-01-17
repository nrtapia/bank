// Copyright (c) 2018 Boomi, Inc.
package com.ntapia.bank.customer;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 */
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
class CustomerException extends RuntimeException {

    public CustomerException(String message) {
    }
}
