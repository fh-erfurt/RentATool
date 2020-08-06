package de.rat.repositories;

import de.rat.model.logistics.Warehouse;
import org.springframework.data.repository.CrudRepository;

public interface WarehouseRepository extends CrudRepository<Warehouse, Integer> {
    Warehouse findById(int id);
}