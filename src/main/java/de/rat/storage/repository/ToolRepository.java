package de.rat.storage.repository;

import de.rat.model.customer.Customer;
import de.rat.model.logistics.Tool;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ToolRepository extends CrudRepository<Tool,Integer>
{

    Tool findByDescription(String description);
    Tool findById(int id);

}

