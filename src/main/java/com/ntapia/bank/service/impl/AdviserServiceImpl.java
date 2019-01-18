package com.ntapia.bank.service.impl;

import com.ntapia.bank.common.Util;
import com.ntapia.bank.dao.AdviserRepository;
import com.ntapia.bank.model.Adviser;
import com.ntapia.bank.service.AdviserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
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
        return repository.findAll(Util.DEFAULT_SORT);
    }

    @Override
    public Adviser get(Long id) {
        return repository.getOne(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Adviser save(Adviser object) {
        return repository.save(object);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Adviser update(Adviser object, Long id) {
        Adviser adviser = repository.getOne(id);
        adviser.setFullName(object.getFullName());
        adviser.setSpeciality(object.getSpeciality());

        return repository.save(adviser);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void delete(Long id) {
        Adviser adviser = repository.getOne(id);
        repository.delete(adviser);
    }
}
