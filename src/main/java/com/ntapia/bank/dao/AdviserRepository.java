package com.ntapia.bank.dao;

import com.ntapia.bank.model.Adviser;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository to access Adviser data
 */
public interface AdviserRepository extends JpaRepository<Adviser, Long> {

}
