package de.rat;

import de.rat.common.Address;
import de.rat.customer.Customer;
import de.rat.employee.Company;
import de.rat.employee.Department;
import de.rat.employee.Employee;
import de.rat.logistics.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class RentalTest {


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
    private Station pickupStation;
    private Station returnStation;
    private Warehouse warehouse;
    private Manufacturer bosch;

    private Rental rental;

    private Tool drill;
    private Tool hammer;
    private Tool welder;
    private Tool welder2;


    @BeforeEach
    void setUp() {
        rental = new Rental();

        musterhausen = new Address("Musterstrasse", 1, 99099, "Erfurt", "Deutschland");
        bosch = new Manufacturer("Bosch", musterhausen, "Mr Smith", "123456");
        pickupStation = new Station("S1", 3, musterhausen);
        returnStation = new Station("S2", 20, musterhausen);

        drill = new Tool("123", bosch, "Bohrer", Category.HANDTOOL, "1-4-5", ToolStatus.AVAILABLE, 3.0);
        hammer = new Tool("12553", bosch, "Hammer", Category.HANDTOOL, "1-4-6", ToolStatus.ISINREPAIR, 2.5);
        welder = new Tool("ewv133", bosch, "Schweißgerät", Category.HANDTOOL, "1-4-7", ToolStatus.ISRENTED, 3.5);
        welder2 = new Tool("ewv133", bosch, "Schweißgerät", Category.HANDTOOL, "1-4-7", ToolStatus.ISRENTED, 3.5);

        custMaria = new Customer("Schmidt", "Maria", new GregorianCalendar(2005, GregorianCalendar.AUGUST, 29), "maria.schmidt@web.de",
                "Weimarerlandstraße", 53, 99986, "Dresden", "Germany", "561616310651",rentATool);
        custLudwig = new Customer("Ebert", "Ludwig", new GregorianCalendar(1937, GregorianCalendar.DECEMBER, 17), "crazyemail@web.de",
                "Bahnhofsstraße", 16, 99067, "Gotha", "Germany", "01236/465854", rentATool);

        warehouse = new Warehouse();
    }

    // Main Test --------------------------------
    @Test
    void sholud_rent_a_tool(){
        boolean checkRent = rental.rentATool(drill, pickupStation, custMaria, warehouse);

        assertTrue(checkRent);
        Assertions.assertEquals(drill, pickupStation.removeToolFromBox(drill));

        //TODO: wait until the method "findeRentProcess" is compledet
        //Assertions.assertEquals(drill, rental.findOrCreateOpenBillFromCustomer(pickupStation, custMaria).findRentProcess(drill).getRentedTool());
    }

    @Test
    void should_return_false_if_the_station_is_full(){
        pickupStation.addToolToBox(hammer);
        pickupStation.addToolToBox(welder);
        pickupStation.addToolToBox(welder2);

        assertFalse(rental.rentATool(drill, pickupStation, custMaria, warehouse));
    } 

    @Test
    void should_return_false_if_the_tool_is_not_in_this_warehouse(){
        //TODO: check if rentATool gets false if the tool is not in the warehouse

        //TODO: wait until the method "removeToolFromWarehouse" is compledet
        assertFalse(rental.rentATool(drill, pickupStation, custMaria, warehouse));
    }

    @Test
    void should_return_a_tool(){
        //Assertions.assertNull(station1.removeToolFromBox(drill));
    }

    
    @Test
    void should_return_false_if_the_tool_is_not_in_this_station(){

    }

    @Test
    void should_return_false_if_there_is_no_open_bill_from_this_customer(){

    }

    @Test
    void should_return_false_if_there_is_no_open_rentProcess_with_this_tool(){

    }


}