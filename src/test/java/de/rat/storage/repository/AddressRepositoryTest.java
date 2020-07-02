package de.rat.storage.repository;

import de.rat.model.common.Address;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class AddressRepositoryTest {

    private Address address1;

    @Autowired
    AddressRepository repository;

    @BeforeEach
    void setUp(){
        address1 = new Address("Weg", 1,12345,"Erfurt","Deutschland");
        repository.save(address1);
    }

    @Test
    public void is_address_saved_in_database(){

     Address address2 = repository.findById(address1.getId());
     assertEquals(12345, address1.getZip());

    }

    @Test
    public void is_address_finded_by_city(){

        List<Address> allAddresses = repository.findByCity("Erfurt");
        for(Address address: allAddresses)
        {
            assertEquals("Erfurt",address1.getCity());
        }

    }






}