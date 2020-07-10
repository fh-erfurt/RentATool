package de.rat.storage.repository;

import de.rat.model.common.Address;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@DataJpaTest
class AddressRepositoryTest {


    private Address address1;
    private Address address3;

    @Autowired
    AddressRepository repository;

    @BeforeEach
    void setUp(){
        repository.findAll();
        address1 = new Address("Weg", 1,12345,"Erfurt","Deutschland");
        repository.save(address1);
    }

    @Test
    public void is_address_saved_in_database(){

     Address address2 = repository.findById(address1.getId());
     assertEquals(12345, address2.getZip());

    }

    @Test
    public void is_address_finded_by_city(){

        List<Address> allAddresses = repository.findByCity("Erfurt");
        for(Address address: allAddresses)
        {
            assertEquals("Erfurt",address1.getCity());
        }

    }


    // representativ update test for all repositories
    @Test
    public void is_street_changing(){

        String newStreet = new String("Strasse");
        address1.setStreet(newStreet);
        repository.save(address1);

        Address address3 = repository.findById(address1.getId());
        assertEquals("Strasse",address3.getStreet());

    }

    // representativ delete test for all repositories
    @Test
    public void is_address_deleted(){

        repository.delete(address1);
        List<Address> allAddresses = repository.findByCity("Erfurt");

        assertTrue(allAddresses.isEmpty());

    }

}