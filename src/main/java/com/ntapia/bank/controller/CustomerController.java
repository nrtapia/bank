package com.ntapia.bank.controller;

import com.ntapia.bank.service.CustomerService;
import com.ntapia.bank.model.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

    private static final String PATH_ID = "/{id}";

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> get() {
        return customerService.list();
    }

    @GetMapping(PATH_ID)
    public Customer get(@PathVariable Long id) {
        return customerService.get(id);
    }

    @PostMapping
    public Customer post(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @PutMapping(PATH_ID)
    public Customer put(@RequestBody Customer customer, @PathVariable Long id) {
        return customerService.update(customer, id);
    }

    @DeleteMapping(PATH_ID)
    public void put(@PathVariable Long id) {
        customerService.delete(id);
    }
}
