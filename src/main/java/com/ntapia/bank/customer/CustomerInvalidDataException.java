// Copyright (c) 2018 Boomi, Inc.
package com.ntapia.bank.customer;

/**
 *
 */
public class CustomerInvalidDataException extends RuntimeException {

    public CustomerInvalidDataException() {
        super("Full name is required");
    }
}
