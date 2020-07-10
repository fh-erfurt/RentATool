package de.rat.storage.repository;

import de.rat.model.common.Address;
import de.rat.model.customer.Customer;
import de.rat.model.logistics.Manufacturer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@DataJpaTest
class ManufracturerRepositoryTest {

    private Address address1;
    private Manufacturer manufacturer1;

    @Autowired
    AddressRepository aRepo;

    @Autowired
    ManufracturerRepository mRepo;

    @BeforeEach
    void setUp(){
        address1 = new Address("Weg", "1","12345","Erfurt","Deutschland");
        aRepo.save(address1);

        manufacturer1 = new Manufacturer("Bosch",address1,"Schmidt","0123456");
        mRepo.save(manufacturer1);

    }

    @Test
    public void is_manufracturer_saved_in_database(){

        Optional<Manufacturer> manufacturer2 = mRepo.findById(manufacturer1.getId());
        assertEquals("Bosch",manufacturer1.getName());

    }

}