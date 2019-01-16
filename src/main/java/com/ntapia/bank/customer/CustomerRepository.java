package com.ntapia.bank.customer;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Customer Repository
 */
interface CustomerRepository extends JpaRepository<Customer, Long> {

}
