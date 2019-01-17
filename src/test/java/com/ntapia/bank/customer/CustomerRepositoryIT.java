// Copyright (c) 2018 Boomi, Inc.
package com.ntapia.bank.customer;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    private Card mockCard1;
    private Card mockCard2;

    @Before
    public void init() {
        mockCustomer1 = CustomerUtil.getCustomerStub1();
        mockCustomer2 = CustomerUtil.getCustomerStub2();
        mockCard1 = Card.builder().number1("0000").number2("1111").number3("2222").number4("3333").cardType(
                "credit card").ccv("999").build();
        mockCard2 = Card.builder().number1("5555").number2("6666").number3("7777").number4("8888").cardType(
                "debit card").ccv("000").build();
    }

    @Test
    public void testSave() {
        Customer customer = repository.save(mockCustomer1);
        assertNotNull("Save operation fail", customer);
        assertNotNull("Id not found", customer.getId());
    }

    @Test
    public void testSaveCards() {
        List<Card> cards = Optional.ofNullable(mockCustomer1.getCards()).orElse(new ArrayList<>());
        cards.add(mockCard1);
        cards.add(mockCard2);
        mockCustomer1.setCards(cards);

        Customer customer = repository.save(mockCustomer1);
        assertNotNull("Save operation fail", customer);
        assertNotNull("Id not found", customer.getId());
        assertNotNull("Cards not found", customer.getCards());
        assertEquals("Cards size grong", 2, customer.getCards().size());

        mockCustomer1.getCards().forEach(card -> assertNotNull(card.getId()));
    }

    @Test
    public void testFind() {
        repository.save(mockCustomer1);
        repository.save(mockCustomer2);

        List<Customer> customerList = repository.findAll(new Sort(Sort.Direction.ASC, "fullName"));
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
