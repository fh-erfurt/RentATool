package de.rat.storage.core;

import de.rat.model.customer.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface CustomerRepository extends CrudRepository<Customer,Integer>
{

    List<Customer> findByLastname(String lastname);

    Customer findById(int id);
}
