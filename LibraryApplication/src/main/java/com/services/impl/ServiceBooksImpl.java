package com.services.impl;


import com.domain.booksystem.Books;
import com.repositories.RepoBooks;
import com.services.ServiceBooks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Anita on 2016/08/27.
 */
@Service
public class ServiceBooksImpl implements ServiceBooks {

    @Autowired
    RepoBooks repository;


    @Override
    public Books create(Books entity) {
        return repository.save(entity);
    }

    @Override
    public Books readById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Set<Books> readAll() {
        Set<Books> result = new HashSet<Books>();

        Iterator iterator = repository.findAll().iterator();
        while(iterator.hasNext()){
            result.add((Books) iterator.next());
        }

        /*while (repository.findAll().iterator().hasNext()) {
            result.add(repository.findAll().iterator().next());
        }*/
        return result;
    }
    @Override
    public Books update(Books entity) {
        return repository.save(entity);
    }
    @Override
    public void delete(Books entity) {
        repository.delete(entity);

    }
}