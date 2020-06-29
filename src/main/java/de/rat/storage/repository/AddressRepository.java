package de.rat.storage.repository;


import de.rat.model.common.Address;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface AddressRepository extends CrudRepository<Address,Integer> {

    Address findById(int id);

    //ToDO Query
   // Address findByStreetnameHouseNumberCity(String street, int houseNr, String city);

}
