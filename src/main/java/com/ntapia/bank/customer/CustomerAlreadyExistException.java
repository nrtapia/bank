// Copyright (c) 2018 Boomi, Inc.
package com.ntapia.bank.customer;

/**
 *
 */
public class CustomerAlreadyExistException extends RuntimeException{

    public CustomerAlreadyExistException() {
        super("Customer already exist!");
    }
}
