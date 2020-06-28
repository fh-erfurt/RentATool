package de.rat.storage.repository;

import de.rat.model.logistics.Warehouse;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface WarehouseRepository extends CrudRepository<Warehouse,Integer>
{

    Warehouse findById(int id);


}