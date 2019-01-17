package com.ntapia.bank.customer;

import com.ntapia.bank.model.Customer;

/**
 *
 */
class CustomerUtil {

    private CustomerUtil() {
    }

    static Customer getCustomerStub1() {
        return Customer.builder().fullName("Bart").address("address 1").city("DC").phone("123").build();
    }

    static Customer getCustomerStub2() {
        return Customer.builder().fullName("Homer").address("address 2").city("Miami").phone("456").build();
    }
}
