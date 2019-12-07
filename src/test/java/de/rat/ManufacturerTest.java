package de.rat;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManufacturerTest {

    @Before public void initialize()
    {
        Manufacturer manufacture=new Manufacturer("Bosch","Bosch-Str.1a","Herr Bosch","05642-45545559");
        Manufacturer manufacture2=new Manufacturer("Siemens","Siemens-Str.1a","Herr Siemens","05642-4584565465759");
        Manufacturer manufacture3=new Manufacturer("Einhell","Einhell-Str.1a","Herr Einhell","05642-4554654659");

    }

@Test
    void can_changed_the_attributes_of_manufacturer()
{
    Manufacturer manufacture=new Manufacturer("Bosch","Bosch-Str.1a","Herr Bosch","05642-458759");
    manufacture.changeManufacture("Makita", "Makita-Str. 2a","Herr Makita","9999-9999");
    assertEquals("Makita", manufacture.getName());
    assertEquals("Makita-Str. 2a", manufacture.getAddress());
    assertEquals("Herr Makita", manufacture.getAgent());
    assertEquals("9999-9999", manufacture.getPhoneNumber());

}


@Test
    void was_the_manufacturer_added_to_the_list()
{
    Manufacturer manufacture3=new Manufacturer("Einhell","Einhell-Str.1a","Herr Einhell","05642-4554654659");
    Manufacturer manufacture2=new Manufacturer("Siemens","Siemens-Str.1a","Herr Siemens","05642-4584565465759");
    assertEquals(2,Manufacturer.manufacturerList.size());

    Manufacturer manufacture4=new Manufacturer("Einhell","Einhell-Str.1a","Herr Einhell","05642-4554654659");
    Manufacturer manufacture5=new Manufacturer("Siemens","Siemens-Str.1a","Herr Siemens","05642-4584565465759");
    assertEquals(4,Manufacturer.manufacturerList.size());

}
}