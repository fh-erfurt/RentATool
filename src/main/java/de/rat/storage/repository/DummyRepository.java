package de.rat.storage.repository;

import de.rat.model.Dummy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface DummyRepository extends CrudRepository<Dummy,Long>
{
    Dummy findById(long id);
}
