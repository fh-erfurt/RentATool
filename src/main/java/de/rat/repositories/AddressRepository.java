package de.rat.repositories;

import de.rat.model.common.Address;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface AddressRepository extends CrudRepository<Address, Integer> {

    Address findById(int id);

    //Query for searching address after street, houseNr and city
    @Query("FROM Address a where a.street=:street AND a.houseNr=:houseNr AND a.city=:city")
    Address findByStreetnameHouseNumberCity(@Param("street") String street,@Param("houseNr") String houseNr,@Param("city") String city);

    List<Address> findByCity(String city);
}
