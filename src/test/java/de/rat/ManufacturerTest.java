package de.rat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManufacturerTest {

    @Test
    void increase_id_when_object_create()
    {
        Manufacturer manufacturer=new Manufacturer("VW","Test","Müller","017263732");
        assertEquals(1,manufacturer.getManufacturerId());
        Manufacturer manufacturer2=new Manufacturer("VW","Test","Müller","017263732");
        assertEquals(2,manufacturer2.getManufacturerId());
    }

}