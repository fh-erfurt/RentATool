package de.rat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {

    //Variable declaration


    private Company rentATool;
    private Address musterhausen;
    private Manufacturer bosch;

    private Tool drill;
    private Tool hammer;
    private Tool welder;

    @BeforeEach
    void setUp() {
        rentATool = new Company("Rent a Tool");
        musterhausen = new Address("Musterstrasse", 1, 99099, "Erfurt", "Deutschland");
        bosch = new Manufacturer("Bosch", musterhausen, "Mr Smith", "123456");

        drill = new Tool("123", bosch, "Bohrer", Category.HANDTOOL, "1-4-5", ToolStatus.AVAILABLE, 3.0);
        hammer = new Tool("12553", bosch, "Hammer", Category.HANDTOOL, "1-4-6", ToolStatus.ISINREPAIR, 2.5);
        welder = new Tool("ewv133", bosch, "Schweißgerät", Category.HANDTOOL, "1-4-7", ToolStatus.ISRENTED, 3.5);

        //rentATool.getStock().add(drill);
        //rentATool.getStock().add(hammer);

    }

    @Test
    void can_an_employee_pick_a_tool_from_the_stock(){
        //Assertions.assertEquals(drill, rentATool.findToolInStockOfCompany(drill));
    }

    @Test
    void should_give_null_if_the_searched_tool_is_not_in_the_stock(){
        //Assertions.assertNull(rentATool.findToolInStockOfCompany(hammer));
    }

    @Test
    void should_give_null_if_the_searched_tool_is_not_available(){
        //Assertions.assertNull(rentATool.findToolInStockOfCompany(welder));
    }

}