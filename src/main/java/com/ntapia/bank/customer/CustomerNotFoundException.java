// Copyright (c) 2018 Boomi, Inc.
package com.ntapia.bank.customer;

/**
 *
 */
public class CustomerNotFoundException extends RuntimeException{

    public CustomerNotFoundException() {
        super("Customer not found");
    }
}
