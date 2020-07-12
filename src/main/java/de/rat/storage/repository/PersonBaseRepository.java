package de.rat.storage.repository;

import de.rat.model.common.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

@NoRepositoryBean
public interface PersonBaseRepository <T extends Person> extends CrudRepository<T, Integer> {

    T findById(int id);

    @Query("FROM #{#entityName} c where c.account.id =:account_id ")
    T findByAccount_id(@Param("account_id") Integer account_id);
}
