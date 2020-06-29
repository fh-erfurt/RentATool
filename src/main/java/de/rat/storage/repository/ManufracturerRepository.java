package de.rat.storage.repository;

import de.rat.model.logistics.Manufacturer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ManufracturerRepository extends CrudRepository<Manufacturer,Integer> {

//    Manufacturer findById(int id);
//    Manufacturer findByName(String name);

}