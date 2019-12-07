package de.rat;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StationTest {

    @Before
    public void initialize() {
        Address testaddress = new Address("Musterstrasse", 1, 99099, "Erfurt", "Deutschland");
        Station station = new Station("S1", 30, testaddress);
        Manufacturer Bosch = new Manufacturer("Bosch","Strasse1","Mr Smith","123456");
        Tool testtool = new Tool("123",Bosch,"Hammer","bla","1AE","available",3.5);
    }

    @Test public boolean isAToolInTheBox ()
    {
        Address testaddress = new Address("Musterstrasse", 1, 99099, "Erfurt", "Deutschland");
        Station station = new Station("S1", 30, testaddress);
        Manufacturer Bosch = new Manufacturer("Bosch","Strasse1","Mr Smith","123456");
        Tool testtool = new Tool("123",Bosch,"Hammer","bla","1AE","available",3.5);



        return false;
    }

}