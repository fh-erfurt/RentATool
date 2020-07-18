package de.rat.model;

import de.rat.model.common.*;
import de.rat.model.customer.*;
import de.rat.model.employee.*;
import de.rat.model.logistics.*;

import de.rat.storage.repository.RentalBillTest;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


class RentalTest {

    private static final Logger log = LoggerFactory.getLogger(RentalBillTest.class);

    //Variable declaration
    private Customer custLuise;
    private Customer custDennis;

    private Address musterhausen;
    private Station stationOne;
    private Warehouse warehouse;
    private Manufacturer bosch;


    private Tool drill;
    private Tool hammer;
    private Tool welder;
    private Tool welder2;

    private Employee empDanny;
    private Employee empMichael;
    private Employee empJonas;



    @BeforeEach
    void setUp() {

        musterhausen = new Address("Musterstrasse", "1", "99099", "Erfurt", "Deutschland");
        bosch = new Manufacturer("Bosch", musterhausen, "Mr Smith", "123456");
        stationOne = new Station("S1", 3, musterhausen);

        drill = new Tool("123", bosch, "Bohrer", Category.HANDTOOL, "1-4-5", ToolStatus.AVAILABLE, new BigDecimal(3));
        hammer = new Tool("12553", bosch, "Hammer", Category.HANDTOOL, "1-4-6", ToolStatus.AVAILABLE, new BigDecimal("2.5"));
        welder = new Tool("ewv133", bosch, "Schweißgerät", Category.HANDTOOL, "1-4-7", ToolStatus.ISRENTED, new BigDecimal("3.5"));
        welder2 = new Tool("ewv133", bosch, "Schweißgerät", Category.HANDTOOL, "1-4-7", ToolStatus.ISRENTED, new BigDecimal("3.5"));

        custLuise = new Customer("Schmidt", "Luise", LocalDate.of(2005, 8, 29), "maria.schmidt@web.de",
                "Weimarerlandstraße", "53", "99986", "Dresden", "Germany", "561616310651");
        custDennis = new Customer("Ebert", "Dennis", LocalDate.of(1937, 12, 17), "crazyemail@web.de",
                "Bahnhofsstraße", "16", "99067", "Gotha", "Germany", "01236/465854");
        custLuise.setId(111111);

        empDanny = new Employee("Steinbrecher", "Danny", LocalDate.of(2019, 12, 15),
                "Johannesstraße", "5", "99084", "Erfurt", "Germany", null);
        empMichael = new Employee("Müller", "Michael", LocalDate.of(2017, 2, 5),
                "Michaelistraße", "17", "99086", "Erfurt", "Germany", empDanny);
        empJonas = new Employee("Casio", "Jonas", LocalDate.of(2000, 10, 30),
                "Leipzigerstraße", "99", "99084", "Weimar", "Germany", empDanny);

        EmployeeNotification.addEmployee(empDanny);
        EmployeeNotification.addEmployee(empMichael);
        EmployeeNotification.addEmployee(empJonas);

        warehouse = new Warehouse();
    }

    // Rent Process
    @Test
    void should_rent_a_tool(){
        warehouse.putToolInWarehouse(drill);
        assertTrue(Rental.rentATool(drill, stationOne, custLuise, warehouse));
    }

    @Test
    void should_return_false_if_the_tool_is_not_in_this_warehouse(){
        assertFalse(Rental.rentATool(hammer,stationOne,custDennis,warehouse));
    }

    @Test
    void should_return_false_if_the_station_is_full(){
        stationOne.addToolToBox(hammer);
        stationOne.addToolToBox(welder);
        stationOne.addToolToBox(welder2);

        warehouse.putToolInWarehouse(drill);

        assertFalse(Rental.rentATool(drill, stationOne, custLuise, warehouse));
    }


    // Return Process
    @Test
    void should_return_a_tool()  {
        warehouse.putToolInWarehouse(drill);
        Rental.rentATool(drill, stationOne, custLuise, warehouse);
        //assertTrue(Rental.returnTool(drill, stationOne, custMaria, warehouse));
    }

    @Test
    void should_return_false_if_the_tool_is_not_in_this_station(){
        assertFalse(Rental.returnTool(drill,stationOne,custLuise,warehouse));
    }

    @Test
    void should_return_false_if_there_is_no_open_bill_from_this_customer(){
        stationOne.addToolToBox(drill);
        assertFalse(Rental.returnTool(drill,stationOne,custLuise,warehouse));
    }

    @Test
    void should_return_false_if_there_is_no_open_rentProcess_with_this_tool(){
        warehouse.putToolInWarehouse(drill);
        Rental.rentATool(drill, stationOne, custLuise, warehouse);
        stationOne.addToolToBox(drill);
        Rental.returnTool(drill,stationOne,custLuise,warehouse);

        assertFalse(Rental.returnTool(drill,stationOne,custDennis,warehouse));
    }
}