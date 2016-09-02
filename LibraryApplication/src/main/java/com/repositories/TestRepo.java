package com.repositories;

/**
 * Created by Anita on 2016/08/29.
 */
import com.domain.TestDomain;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by hashcode on 2016/07/23.
 */
@Repository
public interface TestRepo extends CrudRepository<TestDomain, Long> {
}
