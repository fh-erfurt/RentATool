package de.rat;

import de.rat.billing.Bill;
import de.rat.common.Address;
import de.rat.customer.Customer;
import de.rat.customer.RentProcess;
import de.rat.employee.Company;
import de.rat.employee.Department;
import de.rat.employee.Employee;
import de.rat.logistics.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class RentalTest {


    //Variable declaration
    private Customer custMaria;
    private Customer custLudwig;

    private Address musterhausen;
    private Station stationOne;
    private Station stationTwo;
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
        stationOne = new Station("S1", 30, musterhausen);
        stationTwo = new Station("S2", 20, musterhausen);

        drill = new Tool("123", bosch, "Bohrer", Category.HANDTOOL, "1-4-5", ToolStatus.AVAILABLE, 3.0);
        hammer = new Tool("12553", bosch, "Hammer", Category.HANDTOOL, "1-4-6", ToolStatus.ISINREPAIR, 2.5);
        welder = new Tool("ewv133", bosch, "Schweißgerät", Category.HANDTOOL, "1-4-7", ToolStatus.ISRENTED, 3.5);
        welder2 = new Tool("ewv133", bosch, "Schweißgerät", Category.HANDTOOL, "1-4-7", ToolStatus.ISRENTED, 3.5);

        custMaria = new Customer("Schmidt", "Maria", new GregorianCalendar(2005, GregorianCalendar.AUGUST, 29), "maria.schmidt@web.de",
                "Weimarerlandstraße", 53, 99986, "Dresden", "Germany", "561616310651");
        custLudwig = new Customer("Ebert", "Ludwig", new GregorianCalendar(1937, GregorianCalendar.DECEMBER, 17), "crazyemail@web.de",
                "Bahnhofsstraße", 16, 99067, "Gotha", "Germany", "01236/465854");

        warehouse = new Warehouse();
    }


    @Test
    void should_rent_a_tool(){
        warehouse.putToolInWarehouse(drill);
        assertTrue(rental.rentATool(drill, stationOne, custMaria, warehouse));
    }

    @Test
    void should_return_false_if_the_station_is_full(){
        stationOne.addToolToBox(hammer);
        stationOne.addToolToBox(welder);
        stationOne.addToolToBox(welder2);

        assertFalse(rental.rentATool(drill, stationOne, custMaria, warehouse));
    } 

    @Test
    void should_return_false_if_the_tool_is_not_in_this_warehouse(){
        //TODO: check if rentATool gets false if the tool is not in the warehouse
        assertFalse( rental.rentATool(hammer,stationOne,custLudwig,warehouse));

        //TODO: wait until the method "removeToolFromWarehouse" is compledet
      //  assertFalse(rental.rentATool(drill, pickupStation, custMaria, warehouse));
    }

    @Test
    void should_return_a_tool(){
        warehouse.putToolInWarehouse(drill);
        assertTrue(rental.rentATool(drill, stationOne, custMaria, warehouse));

        GregorianCalendar today = new GregorianCalendar();
        assertTrue(rental.returnTool(drill,stationOne,custMaria,warehouse, today));
    }

    
    @Test
    void should_return_false_if_the_tool_is_not_in_this_station(){
        GregorianCalendar today = new GregorianCalendar();
        boolean checkReturn=rental.returnTool(drill,stationOne,custMaria,warehouse, today);
        assertFalse(checkReturn);
    }

    @Test
    void should_return_false_if_there_is_no_open_bill_from_this_customer(){
        GregorianCalendar today = new GregorianCalendar();
        boolean toolInReturnStation=stationOne.addToolToBox(drill);
        boolean checkReturn=rental.returnTool(drill,stationOne,custMaria,warehouse, today);
        assertFalse(checkReturn);
    }

    @Test
    void should_return_false_if_there_is_no_open_rentProcess_with_this_tool(){
        GregorianCalendar today = new GregorianCalendar();
        boolean result= warehouse.putToolInWarehouse(drill);
        boolean checkRent = rental.rentATool(drill, stationOne, custMaria, warehouse);

        boolean toolInReturnStation=stationOne.addToolToBox(drill);

        boolean checkReturn=rental.returnTool(drill,stationOne,custLudwig,warehouse, today);
        assertFalse(checkReturn);
    }


}