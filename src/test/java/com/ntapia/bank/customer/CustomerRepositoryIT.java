// Copyright (c) 2018 Boomi, Inc.
package com.ntapia.bank.customer;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertNotNull;

/**
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@PropertySource("application-test.properties")
public class CustomerRepositoryIT {

    @Autowired
    private CustomerRepository repository;

    private Customer mockCustomer1;
    private Customer mockCustomer2;

    @Before
    public void init() {
        mockCustomer1 = Customer.builder().fullName("Bart").address("address 1").city("DC").phone("123").build();
        mockCustomer2 = Customer.builder().fullName("Homer").address("address 2").city("Miami").phone("456").build();
    }

    @Test
    public void testSave() {
        Customer customer = repository.save(mockCustomer1);
        assertNotNull("Save operation fail", customer);
        assertNotNull("Id not found", customer.getId());
    }

    @Test
    public void testFind() {
        repository.save(mockCustomer1);
        repository.save(mockCustomer2);

        List<Customer> customerList = repository.findAll();
        assertNotNull("List not found", customerList);
        assertEquals("Customer list size wrong", 2, customerList.size());
    }

    @Test
    public void testUpdate() {
        final String newAddress = "Las Vegas Street";
        Customer persisted = repository.save(mockCustomer1);

        persisted.setAddress(newAddress);
        Customer updated = repository.save(persisted);

        assertEquals("Update address fail", newAddress, updated.getAddress());
    }

    @Test
    public void testDelete() {
        Customer persisted = repository.save(mockCustomer1);
        System.out.println(persisted);
        assertNotNull("Customer not found", repository.findById(persisted.getId()));

        repository.delete(persisted);
        assertFalse("Customer not deleted", repository.findById(persisted.getId()).isPresent());
    }
}
