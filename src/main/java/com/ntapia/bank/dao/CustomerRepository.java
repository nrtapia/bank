package com.ntapia.bank.dao;

import com.ntapia.bank.model.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Customer Repository
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByFullName(String fullName);
}
