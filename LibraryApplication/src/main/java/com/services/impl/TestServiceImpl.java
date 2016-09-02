package com.services.impl;

/**
 * Created by Anita on 2016/08/29.
 */

import com.domain.TestDomain;
import com.repositories.TestRepo;
import com.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


@Service
public class TestServiceImpl implements TestService {
    @Autowired
    TestRepo repository;


    @Override
    public TestDomain create(TestDomain entity) {
        return repository.save(entity);
    }

    @Override
    public TestDomain readById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Set<TestDomain> readAll() {
        Set<TestDomain> result = new HashSet<TestDomain>();

        Iterator iterator = repository.findAll().iterator();
        while (iterator.hasNext()) {
            result.add((TestDomain) iterator.next());
        }
        return result;
    }

    @Override
    public TestDomain update(TestDomain entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(TestDomain entity) {
        repository.delete(entity);

    }
}


