package com.ntapia.bank.customer;

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
@Transactional(propagation = Propagation.REQUIRED)
public class CustomerServiceImpl implements CustomerService {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerServiceImpl.class);

    private static final String FIELD_NAME = "fullName";
    private static final Sort DEFAULT_SORT = new Sort(Sort.Direction.ASC, FIELD_NAME);

    private final CustomerRepository repository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Customer> list() {
        return repository.findAll(DEFAULT_SORT);
    }

    @Override
    public Customer get(Long id) {
        return repository.findById(id).orElseThrow(CustomerNotFoundException::new);
    }

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

    @Override
    public void delete(Long id) {
        repository.delete(repository.findById(id).orElseThrow(CustomerNotFoundException::new));
    }
}
