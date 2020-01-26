package de.rat.common;

import de.rat.common.Address;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AddressTest {
    //Variable declaration
    private Address address1;


    @BeforeEach
    void setUp() {
    address1 = new Address("Bosch-Strasse", 1, 99425, "Weimar", "DE");
    }

    @Test
     void get_the_Attribute_of_class_Address(){

        assertEquals("Bosch-Strasse",address1.getStreet());
        assertEquals(1,address1.getHauseNr());
        assertEquals(99425,address1.getZip());
        assertEquals("Weimar",address1.getCity());
        assertEquals("DE",address1.getCountry());
    }

    @Test
     void set_the_Attribute_of_class_Address() {
        //When
        address1.setStreet("Linde 2");
        address1.setCity("Erfurt");
        address1.setCountry("FR");
        address1.setHauseNr(3);
        address1.setZip(12345);

        //Then
        assertEquals("Linde 2",address1.getStreet());
        assertEquals(3,address1.getHauseNr());
        assertEquals(12345, address1.getZip());
        assertEquals("Erfurt",address1.getCity());
        assertEquals("FR",address1.getCountry());

    }

    @Test
    void should_give_true_when_the_Address_available()
    {
        assertFalse(address1.checkAddress("Linde 2", 1, 99425, "Weimar", "DE"));
        assertTrue(address1.checkAddress("Bosch-Strasse", 1, 99425, "Weimar", "DE"));
    }

    @Test
    void should_be_able_to_chnage_the_address(){
        assertTrue(address1.changeAddress("Linde 2", 1, 99425, "Weimar", "DE"));
        assertEquals("Linde 2",address1.getStreet());
    }


}

