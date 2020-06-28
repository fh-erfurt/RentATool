package de.rat.storage.repository;

import de.rat.model.customer.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface CustomerRepository extends CrudRepository<Customer,Integer>
{

    Customer findById(int id);

    List<Customer> findByLastname(String lastname);

}
