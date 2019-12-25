package de.rat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManufacturerTest {

@Test
    void can_changed_the_attributes_of_manufacturer()
{
    Address address1=new Address("Bosch-Str.1",1,99425,"Weimar","DE");
    Address address2=new Address("Bosch-Str.1",1,99425,"Erfurt","DE");
    Address address3=new Address("Bosch-Str.1",1,99425,"Leipzig","DE");
    Manufacturer manufacture=new Manufacturer("Bosch",address1,"Herr Bosch","05642-458759");
    manufacture.changeManufacture("Makita", address2,"Herr Makita","9999-9999");
    assertEquals("Makita", manufacture.getName());
    assertEquals(address2, manufacture.getAddress());
    assertEquals("Herr Makita", manufacture.getAgent());
    assertEquals("9999-9999", manufacture.getPhoneNumber());

}

@Test
    void was_the_manufacturer_added_to_the_list()
{
    Address address1=new Address("Bosch-Str.1",1,99425,"Weimar","DE");
    Address address2=new Address("Bosch-Str.1",1,99425,"Erfurt","DE");
    Address address3=new Address("Bosch-Str.1",1,99425,"Leipzig","DE");
    Manufacturer manufacture3=new Manufacturer("Einhell",address1,"Herr Einhell","05642-4554654659");
    Manufacturer manufacture2=new Manufacturer("Siemens",address2,"Herr Siemens","05642-4584565465759");
    //assertEquals(2,Manufacturer.manufacturerList.size());

    Manufacturer manufacture4=new Manufacturer("Einhell",address3,"Herr Einhell","05642-4554654659");
    Manufacturer manufacture5=new Manufacturer("Siemens",address2,"Herr Siemens","05642-4584565465759");
    //assertEquals(4,Manufacturer.manufacturerList.size());


}


@Test
        void can_the_manufacturer_removed_from_list()
{
    Address address1=new Address("Bosch-Str.1",1,99425,"Weimar","DE");
    Manufacturer manufacture3=new Manufacturer("Einhell",address1,"Herr Einhell","05642-4554654659");
    Manufacturer manufacture2=new Manufacturer("Siemens",address1,"Herr Siemens","05642-4584565465759");
    //Manufacturer.manufacturerList.size();
    manufacture3.removeFromManufacturerList("Einhell");
    //Manufacturer.manufacturerList.size();

}
}