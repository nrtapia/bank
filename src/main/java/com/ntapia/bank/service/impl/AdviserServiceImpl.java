package com.ntapia.bank.service.impl;

import com.ntapia.bank.common.Util;
import com.ntapia.bank.dao.AdviserRepository;
import com.ntapia.bank.exception.AdviserInvalidDataException;
import com.ntapia.bank.exception.AdviserNotFoundException;
import com.ntapia.bank.model.Adviser;
import com.ntapia.bank.service.AdviserService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Business logic implementation to Adviser
 */
@Service
public class AdviserServiceImpl implements AdviserService {

    private final AdviserRepository repository;

    @Autowired
    public AdviserServiceImpl(AdviserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Adviser> list() {
        return repository.findAll(Util.SORT_BY_FULL_NAME);
    }

    @Override
    public Adviser get(Long id) {
        return repository.findById(id).orElseThrow(AdviserNotFoundException::new);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Adviser save(Adviser object) {
        validate(object);
        return repository.save(object);
    }

    private void validate(Adviser object) {
        if (object == null || StringUtils.isBlank(object.getFullName()) || StringUtils.isBlank(
                object.getSpeciality())) {
            throw new AdviserInvalidDataException();
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Adviser update(Adviser object, Long id) {
        validate(object);

        Adviser adviser = repository.findById(id).orElseThrow(AdviserNotFoundException::new);
        adviser.setFullName(object.getFullName());
        adviser.setSpeciality(object.getSpeciality());

        return repository.save(adviser);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void delete(Long id) {
        repository.delete(repository.findById(id).orElseThrow(AdviserNotFoundException::new));
    }
}
