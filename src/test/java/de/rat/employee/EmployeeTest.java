package de.rat.employee;

import de.rat.Rental;
import de.rat.common.*;
import de.rat.customer.*;
import de.rat.logistics.*;
import de.rat.billing.*;

import org.junit.jupiter.api.*;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EmployeeTest {

    //Variable declaration
    private Employee empMichael;
    private Employee empJonas;

    private Customer custMartin;

    private Warehouse warehouse;
    private Tool drill;
    private Manufacturer bosch;
    private Station stationOne;
    private Address musterhausen;

    @BeforeEach
    void setUp() {

        empJonas = new Employee("Hecht", "Jonas", new GregorianCalendar(2019, GregorianCalendar.DECEMBER, 15),
                "Johannesstraße", 5, 99084, "Weimar", "Germany", null);
        empMichael = new Employee("Müller", "Michael", new GregorianCalendar(2017, GregorianCalendar.FEBRUARY, 5),
                "Michaelistraße", 17, 99086, "Erfurt", "Germany", empJonas);

        custMartin = new Customer("Schmidt", "Martin", new GregorianCalendar(2005, GregorianCalendar.AUGUST, 29), "maria.schmidt@web.de",
                "Weimarerlandstraße", 53, 99986, "Dresden", "Germany", "561616310651");

        musterhausen = new Address("Musterstrasse", 1, 99099, "Erfurt", "Deutschland");
        bosch = new Manufacturer("Bosch", musterhausen, "Mr Smith", "123456");
        drill = new Tool("123", bosch, "Bohrer", Category.HANDTOOL, "1-4-5", ToolStatus.AVAILABLE, 3.0);
        stationOne = new Station("S1", 3, musterhausen);

        warehouse = new Warehouse();

    }

    // Main Test --------------------------------
    @Test
    void should_return_null_if_the_employee_has_no_supervisor(){
        Assertions.assertNull(empJonas.getSupervisor());
    }

    @Test
    void should_return_the_correct_supervisor_from_this_employee(){
        Assertions.assertEquals(empJonas, empMichael.getSupervisor());
    }

    @Test
    void create_correct_password_for_customer_and_employee(){
        Assertions.assertEquals("jo151219he", empJonas.getAccount().getPassword());
    }

    @Test
    void create_correct_email_for_employee(){
        Assertions.assertEquals("jonas.hecht@rat.de", empJonas.getAccount().getEmail());
    }

    @Test
    void set_correct_role_for_the_employee(){
        Assertions.assertEquals(Role.EMPLOYEE, empJonas.getAccount().getRole());
    }

    @Test
    void should_set_the_discount_and_move_bills_to_Close_Bills(){

        warehouse.putToolInWarehouse(drill);
        Rental.rentATool(drill, stationOne, custMartin, warehouse);
        Bill bill = Billing.findOpenBillFromCustomer(custMartin);
        GregorianCalendar today = new GregorianCalendar();
        Rental.returnTool(drill,stationOne,custMartin,warehouse, today);

        assertTrue(empJonas.setDiscountAndMoveBillsToCloseBills(bill, 5));

        Assertions.assertNull(Billing.findBillInListByReference(bill, Billing.getOpenBills()));
        Assertions.assertNull(Billing.findBillInListByReference(bill, Billing.getCheckBills()));
        Assertions.assertEquals(bill, Billing.findBillInListByReference(bill, Billing.getClosedBills()));
    }

    @Test
    void should_return_false_if_the_Bill_is_null(){
        Bill bill = null;
        assertFalse(empJonas.setDiscountAndMoveBillsToCloseBills(bill, 5));
    }


}