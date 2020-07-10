package de.rat.model.logistics;

import de.rat.model.common.Address;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManufacturerTest {

    //Variable declaration
    private Address address1;
    private Address address2;
    private Manufacturer manufacture;

    @BeforeEach
    void setUp() {

       address1 = new Address("Bosch-Str.1", 1, "99425", "Weimar", "DE");
       address2 = new Address("Bosch-Str.1", 1, "99425", "Erfurt", "DE");
       manufacture = new Manufacturer("Bosch", address1, "Herr Bosch", "05642-458759");
    }



    // Main Test --------------------------------
@Test
    void can_changed_the_attributes_of_manufacturer()
{
    manufacture.changeManufacture("Makita", address2,"Herr Makita","9999-9999");
    assertEquals("Makita", manufacture.getName());
    assertEquals(address2, manufacture.getAddress());
    assertEquals("Herr Makita", manufacture.getAgent());
    assertEquals("9999-9999", manufacture.getPhoneNumber());

}


}