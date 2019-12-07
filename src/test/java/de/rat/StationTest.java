package de.rat;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StationTest {

    @Before
    public void initialize() {
        Address testaddress = new Address("Musterstrasse", 1, 99099, "Erfurt", "Deutschland");
        Station station = new Station("S1", 3, testaddress);
        Manufacturer Bosch = new Manufacturer("Bosch",testaddress,"Mr Smith","123456");
        Tool testtool = new Tool("123",Bosch,"Hammer","bla","1AE","available",3.5);
    }

    @Test public void isAToolAdded ()
    {
        Address testaddress = new Address("Musterstrasse", 1, 99099, "Erfurt", "Deutschland");
        Station station = new Station("S1", 30, testaddress);
        Manufacturer Bosch = new Manufacturer("Bosch",testaddress,"Mr Smith","123456");
        Tool testtool = new Tool("123",Bosch,"Hammer","bla","1AE","available",3.5);

        station.addToolToBox(testtool);
        assertEquals(1, station.getNumberOfTools());

    }
    @Test public void isBoxLimitReached ()
    {
        Address testaddress = new Address("Musterstrasse", 1, 99099, "Erfurt", "Deutschland");
        Station station = new Station("S1", 3, testaddress);
        Manufacturer Bosch = new Manufacturer("Bosch",testaddress,"Mr Smith","123456");
        Tool testtool = new Tool("123",Bosch,"Hammer","bla","1AE","available",3.5);
        Tool testtool1 = new Tool("123",Bosch,"Hammer","bla","1AE","available",3.5);
        Tool testtool2 = new Tool("123",Bosch,"Hammer","bla","1AE","available",3.5);

        station.addToolToBox(testtool);
        station.addToolToBox(testtool2);
        station.addToolToBox(testtool1);
        station.addToolToBox(testtool2);

        assertEquals(3, station.getNumberOfTools());

    }

    @Test public void isToolRemoved () {
        Address testaddress = new Address("Musterstrasse", 1, 99099, "Erfurt", "Deutschland");
        Station station = new Station("S1", 3, testaddress);
        Manufacturer Bosch = new Manufacturer("Bosch", testaddress, "Mr Smith", "123456");
        Tool testtool = new Tool("123", Bosch, "Hammer", "bla", "1AE", "available", 3.5);
        Tool testtool1 = new Tool("123", Bosch, "Hammer", "bla", "1AE", "available", 3.5);
        Tool testtool2 = new Tool("123", Bosch, "Hammer", "bla", "1AE", "available", 3.5);

        station.addToolToBox(testtool);
        station.addToolToBox(testtool2);
        station.addToolToBox(testtool1);
        station.getNumberOfTools();

        Tool test = station.removeToolFromBox(testtool1);
        assertEquals(2, station.getNumberOfTools());
    }
}