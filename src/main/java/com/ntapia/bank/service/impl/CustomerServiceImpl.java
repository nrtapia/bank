package com.ntapia.bank.service.impl;

import com.ntapia.bank.common.Util;
import com.ntapia.bank.dao.CustomerRepository;
import com.ntapia.bank.exception.CustomerAlreadyExistException;
import com.ntapia.bank.exception.CustomerException;
import com.ntapia.bank.exception.CustomerInvalidDataException;
import com.ntapia.bank.exception.CustomerNotFoundException;
import com.ntapia.bank.model.Customer;
import com.ntapia.bank.service.CustomerService;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerServiceImpl.class);

    private final CustomerRepository repository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Customer> list() {
        return repository.findAll(Util.DEFAULT_SORT);
    }

    @Override
    public Customer get(Long id) {
        return repository.findById(id).orElseThrow(CustomerNotFoundException::new);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Customer save(Customer object) {
        if (object == null || StringUtils.isBlank(object.getFullName())) {
            throw new CustomerInvalidDataException();
        }

        object.setFullName(object.getFullName().toUpperCase());
        repository.findByFullName(object.getFullName()).ifPresent(c -> {
            throw new CustomerAlreadyExistException();
        });

        try {
            return repository.save(object);
        } catch (Exception e) {
            LOG.error("Error save Customer", e);
            throw new CustomerException(e.getMessage());
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Customer update(Customer object, Long id) {
        if (object == null || id == null || StringUtils.isBlank(object.getFullName())) {
            throw new CustomerInvalidDataException();
        }

        object.setFullName(object.getFullName().toUpperCase());
        Customer customer = repository.findByFullName(object.getFullName()).orElseThrow(CustomerNotFoundException::new);
        if (!id.equals(customer.getId())) {
            throw new CustomerAlreadyExistException();
        }

        try {
            customer.setFullName(object.getFullName());
            customer.setAddress(object.getAddress());
            customer.setCity(object.getCity());
            customer.setPhone(object.getPhone());
            return repository.save(customer);
        } catch (Exception e) {
            LOG.error("Error update Customer", e);
            throw new CustomerException(e.getMessage());
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void delete(Long id) {
        repository.delete(repository.findById(id).orElseThrow(CustomerNotFoundException::new));
    }
}
