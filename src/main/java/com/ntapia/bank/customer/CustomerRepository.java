package com.ntapia.bank.customer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Customer Repository
 */
interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByFullName(String fullName);
}
