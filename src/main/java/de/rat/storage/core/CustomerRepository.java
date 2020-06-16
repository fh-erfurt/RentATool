package de.rat.storage.core;

import de.rat.model.customer.Customer;
import org.springframework.data.repository.CrudRepository;
import de.rat.model.logistics.Tool;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Tool,Long>
{
    List<Customer> findByDescription(String lastName);
    Tool findById(long id);
}
