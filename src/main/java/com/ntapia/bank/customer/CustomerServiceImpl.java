package com.ntapia.bank.customer;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;

/**
 *
 */
@Service
@Transactional(Transactional.TxType.REQUIRED)
public class CustomerServiceImpl implements CustomerService {

    private static final String FIELD_NAME = "name";
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
    public Customer saveOrUpdate(Customer object) {
        if (object == null || StringUtils.isBlank(object.getFullName())) {
            throw new CustomerInvalidDataException();
        }

        object.setFullName(object.getFullName().toUpperCase());
        if (object.getId() == null) {
            repository.findByFullName(object.getFullName()).ifPresent(c -> {
                throw new CustomerAlreadyExistException();
            });
        }

        return repository.save(object);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
