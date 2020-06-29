package de.rat.storage.repository;

import de.rat.model.logistics.Station;
import org.springframework.data.repository.CrudRepository;




public interface StationRepository extends CrudRepository<Station,Integer>
{

    Station findById(int id);

}
