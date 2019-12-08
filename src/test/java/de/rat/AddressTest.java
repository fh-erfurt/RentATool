package de.rat;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    Address address1=new Address("Bosch-Str.1",1,99425,"Weimar","DE");


    @Test

     void get_the_Attribute_of_class_Address(){
    // When
       String street = address1.getStreet();
        String city = address1.getCity();
        String country = address1.getCountry();
       int hauseNr = address1.getHauseNr();
       int zip = address1.getZip();


       // Then
        assertEquals("Bosch-Str.1",street);
        assertEquals(1,hauseNr);
        assertEquals(99425,zip);
        assertEquals("Weimar",city);
        assertEquals("DE",country);
    }

    @Test
     void set_the_Attribute_of_class_Address() {
        //When
      /*  address1.setStreet("Linde 2");
        address1.setCity("Erfurt");
        address1.setCountry("FR");
        address1.setHauseNr(3);
        address1.setZip(12345);*/

        //Then
        assertEquals("Linde 2",address1.getStreet());
        assertEquals(3,address1.getHauseNr());
        assertEquals(12345, address1.getZip());
        assertEquals("Erfurt",address1.getCity());
        assertEquals("FR",address1.getCountry());

    }


}

