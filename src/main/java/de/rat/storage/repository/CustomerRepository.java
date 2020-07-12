package de.rat.storage.repository;

import de.rat.model.billing.Bill;
import de.rat.model.common.Person;
import de.rat.model.customer.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface CustomerRepository extends PersonBaseRepository<Customer>, CrudRepository<Customer, Integer>
{

    Customer findById(int id);
    Customer findByAccount_id(int id);

//    @Query("FROM Customer c where c.account.id =:account_id ")
//    Customer findByAccount_id(@Param("account_id") Integer account_id);



    List<Customer> findByLastname(String lastname);



}
