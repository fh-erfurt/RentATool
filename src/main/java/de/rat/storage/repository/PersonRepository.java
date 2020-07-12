package de.rat.storage.repository;

import de.rat.model.billing.Bill;
import de.rat.model.common.Account;
import de.rat.model.common.Address;
import de.rat.model.common.Person;
import de.rat.model.common.Role;
import de.rat.model.customer.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public interface PersonRepository extends PersonBaseRepository<Person> {

//    Person findById(int id);
//    Person findByAccount_id(int id);


//    Account findBy(int CustomerId);
//    Account findByEmail(String email);  //ToDo test if it works

//    List<Person> findByRole(Role role);
//    Optional<Person> findByEmail(String email);
//
//    @Query("FROM Bill b where b.customer.lastname=:customerLastName ")
//    List<Bill> findByCustomer(@Param("customerLastName") String customerLastName);


}
