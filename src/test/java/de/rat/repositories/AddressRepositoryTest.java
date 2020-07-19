package de.rat.repositories;

import de.rat.model.common.Address;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
class AddressRepositoryTest {

    private Address address1;

    @Autowired
    AddressRepository repository;

    @BeforeEach
    void setUp(){
        repository.findAll();
        address1 = new Address("Strasse", "1","12345","Arnstadt","Deutschland");
        repository.save(address1);
    }

    @Test
    public void is_address_saved_in_database(){

     Address address2 = repository.findById(address1.getId());
     assertEquals("12345", address2.getZip());
    }

    // TODO: warum eine for schleife, wenn man dann mit einem statischen Object arbeitet?
    @Test
    public void is_address_finded_by_city(){

        List<Address> allAddresses = repository.findByCity("Arnstadt");
        for(Address address: allAddresses)
        {
            assertEquals("Arnstadt",address1.getCity());
        }
    }


    // representative update test for all repositories
    @Test
    public void is_street_changing(){

        String newStreet = new String("Strasse");
        address1.setStreet(newStreet);
        repository.save(address1);

        Address address3 = repository.findById(address1.getId());
        assertEquals("Strasse",address3.getStreet());
    }

    // representative delete test for all repositories
    @Test
    public void is_address_deleted(){

        repository.delete(address1);
        List<Address> allAddresses = repository.findByCity("Arnstadt");

        assertTrue(allAddresses.isEmpty());
    }

    @Test
    public void check_database_for_address(){

        Address checkAddress = repository.findByStreetnameHouseNumberCity("Strasse", "1","Arnstadt");
        assertEquals(checkAddress.getStreet(),address1.getStreet());
    }
}