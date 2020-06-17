package de.rat.storage.core;

import de.rat.model.Dummy;
import de.rat.model.customer.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface DummyRepository extends CrudRepository<Dummy,Long>
{
    Customer findById(long id);
}
