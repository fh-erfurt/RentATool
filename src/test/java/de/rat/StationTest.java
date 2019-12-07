package de.rat;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StationTest {

    /*before */
    Address testaddress = new Address("Musterstrasse", 1, 99099, "Erfurt", "Deutschland");
    Station station = new Station("S1", 3, testaddress);
    Manufacturer Bosch = new Manufacturer("Bosch",testaddress,"Mr Smith","123456");
    Tool testtool = new Tool("123",Bosch,"Hammer","bla","1AE","available",3.5);
    Tool testtool1 = new Tool("123",Bosch,"Hammer","bla","1AE","available",3.5);
    Tool testtool2 = new Tool("123",Bosch,"Hammer","bla","1AE","available",3.5);


    /*#############################################################*/
    /*#############################################################*/
    /*#############################################################*/
    @Test public void isAToolAdded ()
    {

        /* test for adding a tool in a box in a station */
        station.addToolToBox(testtool);
        assertEquals(1, station.getNumberOfTools());

    }
    /*#############################################################*/
    /*#############################################################*/
    /*#############################################################*/
    @Test public void isBoxLimitReached ()
    {
        /* test that box limit has no overflow */
        station.addToolToBox(testtool);
        station.addToolToBox(testtool1);
        station.addToolToBox(testtool2);

        /* printout for last adding because limit is reached */
        assertEquals(false, station.addToolToBox(testtool));

    }
    /*#############################################################*/
    /*#############################################################*/
    /*#############################################################*/
        @Test public void isToolRemoved () {

            station.addToolToBox(testtool);
            station.addToolToBox(testtool1);
            station.addToolToBox(testtool2);

            /* test that remove a  tool is working  */
            Tool boxTool = station.removeToolFromBox(testtool1);
            assertEquals(2, station.getNumberOfTools());

            /* check that remove tool is the required tool*/
            Tool compareTool = testtool1;
            assertEquals(compareTool, boxTool);
    }
}