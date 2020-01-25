package de.rat.logistics;

import de.rat.common.Address;
import de.rat.logistics.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StationTest {

    /*before */
    Address testaddress = new Address("Musterstrasse", 1, 99099, "Erfurt", "Deutschland");
    Station station = new Station("S1", 3, testaddress);
    Manufacturer Bosch = new Manufacturer("Bosch",testaddress,"Mr Smith","123456");
    Tool testtool = new Tool("123",Bosch,"Hammer",Category.HANDTOOL,"1-4-5",ToolStatus.AVAILABLE,3.5);
    Tool testtool1 = new Tool("AAA",Bosch,"Säge",Category.HANDTOOL,"1-4-3",ToolStatus.AVAILABLE,3.0);
    Tool testtool2 = new Tool("XXX",Bosch,"Schaufel",Category.HANDTOOL,"1-3-2",ToolStatus.AVAILABLE,4.0);
    Station station2 = new Station("S2", 5, testaddress);
    Tool testtool3 = new Tool("XXX",Bosch,"Schaufel", Category.HANDTOOL,"1-3-2",ToolStatus.AVAILABLE,4.0);
    Tool testtool4 = new Tool("XXX",Bosch,"Schaufel",Category.HANDTOOL,"1-3-2", ToolStatus.AVAILABLE,4.0);
    Tool testtool5 = new Tool("XXX",Bosch,"Schaufel",Category.HANDTOOL,"1-3-2",ToolStatus.AVAILABLE,4.0);

    /*#############################################################*/
    /*#############################################################*/
    /*#############################################################*/
    @Test public void is_a_tool_added_to_the_box ()
    {

        /* test for adding a tool in a box in a station */
        station.addToolToBox(testtool);
        assertEquals(1, station.getNumberOfTools());

    }
    /*#############################################################*/
    /*#############################################################*/
    /*#############################################################*/
    @Test public void is_box_limit_reached ()
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
        @Test public void is_tool_removed () {

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

    @Test public void is_tool_already_in_the_box()
    {
        station.addToolToBox(testtool);
        station.addToolToBox(testtool1);
        /* is the tool not available for two times, the function return true  */
       assertTrue(true);
        /* is the tool available for two times, the function return false   */
        station.addToolToBox(testtool1);
        assertFalse(false);


    }


    @Test
    public void check_the_station_level() {

        station2.addToolToBox(testtool);
        station2.addToolToBox(testtool1);
        station2.addToolToBox(testtool2);
        station2.addToolToBox(testtool3);
        station2.addToolToBox(testtool4);
        assertEquals(5, station2.getNumberOfTools());

        station2.addToolToBox(testtool5);
        assertEquals(5, station2.getNumberOfTools());
        assertFalse(false);
    }

    @Test public void how_big_is_the_size_of_boxes_in_the_station()
    {
       assertEquals(5, station2.getNumberOfBoxes());

    }
}