package de.rat.customer;

import de.rat.common.Address;
import de.rat.customer.Customer;
import de.rat.employee.Company;
import de.rat.employee.Department;
import de.rat.employee.Employee;
import de.rat.logistics.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
//Variable declaration
private Department deptRental;
private Department deptLogistics;
private Department deptManagement;

private Employee empDanny;
private Employee empMichael;
private Employee empJonas;

private Customer custMaria;
private Customer custLudwig;

private Company rentATool;
private Address musterhausen;
private Station station1;
private Manufacturer bosch;

private Tool drill;
private Tool hammer;
private Tool welder;


    @BeforeEach
    void setUp() {
        rentATool = new Company("Rent a Tool");
        musterhausen = new Address("Musterstrasse", 1, 99099, "Erfurt", "Deutschland");
        bosch = new Manufacturer("Bosch", musterhausen, "Mr Smith", "123456");
        station1 = new Station("S1", 3, musterhausen);

        drill = new Tool("123", bosch, "Bohrer", Category.HANDTOOL, "1-4-5", ToolStatus.AVAILABLE, 3.0);
        hammer = new Tool("12553", bosch, "Hammer", Category.HANDTOOL, "1-4-6", ToolStatus.ISINREPAIR, 2.5);
        welder = new Tool("ewv133", bosch, "Schweißgerät", Category.HANDTOOL, "1-4-7", ToolStatus.ISRENTED, 3.5);

        station1.addToolToBox(welder);

        custMaria = new Customer("Schmidt", "Maria", new GregorianCalendar(2005, GregorianCalendar.AUGUST, 29), "maria.schmidt@web.de",
        "Weimarerlandstraße", 53, 99986, "Dresden", "Germany", "561616310651");
        custLudwig = new Customer("Ebert", "Ludwig", new GregorianCalendar(1937, GregorianCalendar.DECEMBER, 17), "crazyemail@web.de",
        "Bahnhofsstraße", 16, 99067, "Gotha", "Germany", "01236/465854");
    }


    @Test
    void should_put_and_get_tool_in_inventory() {
        custLudwig.putToolInInventory(drill);
        assertEquals(drill,custLudwig.getToolFromInventory(drill));
    }

    @Test
    void after_removing_the_tool_from_the_inventory_the_tool_is_not_even_in_the_inventory(){
        custLudwig.putToolInInventory(drill);
        custLudwig.getToolFromInventory(drill);
        assertNull(custLudwig.getToolFromInventory(drill));
    }

    @Test
    void should_get_null_if_the_tool_is_not_in_the_inventory() {
        custLudwig.putToolInInventory(drill);
        assertNull(custLudwig.getToolFromInventory(hammer));
    }


    @Test
    void should_get_a_tool_from_the_station_in_the_inventory() {

        Boolean checkGetComplete = custLudwig.getToolFromStation(welder,  station1);
        assertEquals(true, checkGetComplete);
    }

    @Test
    void should_put_a_tool_from_the_inventory_in_the_station() {
        custLudwig.putToolInInventory(drill);
        Boolean checkPutComplete = custLudwig.returnToolToStation(drill, station1);
        assertEquals(true, checkPutComplete);
    }
}