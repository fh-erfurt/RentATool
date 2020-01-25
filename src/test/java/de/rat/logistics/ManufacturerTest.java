package de.rat.logistics;

import de.rat.common.Address;
import de.rat.logistics.Manufacturer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManufacturerTest {
   /*before*/
        Address address1 = new Address("Bosch-Str.1", 1, 99425, "Weimar", "DE");
        Address address2 = new Address("Bosch-Str.1", 1, 99425, "Erfurt", "DE");
        Address address3 = new Address("Bosch-Str.1", 1, 99425, "Leipzig", "DE");
        Manufacturer manufacture = new Manufacturer("Bosch", address1, "Herr Bosch", "05642-458759");


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