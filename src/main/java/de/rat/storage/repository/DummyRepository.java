package de.rat.storage.repository;

import de.rat.model.Dummy;
import org.springframework.data.repository.CrudRepository;


public interface DummyRepository extends CrudRepository<Dummy,Long>
{
    Dummy findById(long id);


}
