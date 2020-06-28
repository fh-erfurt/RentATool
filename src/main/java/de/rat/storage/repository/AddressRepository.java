package de.rat.storage.repository;

import de.rat.model.customer.Customer;
import org.apache.tomcat.jni.Address;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface AddressRepository extends CrudRepository<Address,Integer> {

    Address findById(int id);
    Address findByStreetnameHouseNumberCity(String street, int houseNr, String city);

}
