package de.rat.storage.core;

import de.rat.model.customer.Customer;
import org.springframework.data.repository.CrudRepository;




public interface CustomerRepository extends CrudRepository<Customer,Long>
{

}
