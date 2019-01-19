package com.ntapia.bank.dao;

import com.ntapia.bank.model.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repository to access Customer data
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByFullName(String fullName);
}
