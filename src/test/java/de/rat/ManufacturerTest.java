package de.rat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManufacturerTest {

@Test
    void this_method_can_change_the_manufactor()
{
    Manufacturer manufacture=new Manufacturer("Bosch","Bosch-Str.1a","Herr Bosch","05642-458759");
    manufacture.changeManufacture("Makita", "Makita-Str. 2a","Herr Makita","9999-9999");
    assertEquals("Makita", manufacture.getName());
    assertEquals("Makita-Str. 2a", manufacture.getAddress());
    assertEquals("Herr Makita", manufacture.getAgent());
    assertEquals("9999-9999", manufacture.getPhoneNumber());

}

}