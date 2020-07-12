package de.rat.storage.repository;

import de.rat.model.common.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface PersonBaseRepository <T extends Person> extends CrudRepository<T, Integer> {

    Person findById(int id);
//
//    @Query("select u from #{#entityName} as u where u.email = ?1 ")
//    T findByEmail(String email);
}
