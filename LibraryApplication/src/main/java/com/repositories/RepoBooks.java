package com.repositories;

import com.domain.booksystem.Books;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Anita on 2016/08/27.
 */

@Repository
public interface RepoBooks extends CrudRepository<Books, Long> {
}
