package de.rat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.GregorianCalendar;


class PersonTest {

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

        drill = new Tool("123", bosch, "Bohrer", "Handwerkzeug", "1-4-5", ToolStatus.AVAILABLE, 3.0);
        hammer = new Tool("12553", bosch, "Hammer", "Handwerkzeug", "1-4-6", ToolStatus.ISINREPAIR, 2.5);
        welder = new Tool("ewv133", bosch, "Schweißgerät", "Handwerkzeug", "1-4-7", ToolStatus.ISRENTED, 3.5);

        rentATool.getStock().add(drill);
        rentATool.getStock().add(hammer);

        station1.addToolToBox(welder);

        deptRental = new Department("Verleih");
        deptLogistics = new Department("Logistik");
        deptManagement = new Department("Geschaeftsleitung");

        empDanny = new Employee("Steinbrecher", "Danny", new GregorianCalendar(2019, GregorianCalendar.DECEMBER, 15),
                "Johannesstraße", 5, 99084, "Erfurt", "Germany", deptManagement, null);
        empMichael = new Employee("Müller", "Michael", new GregorianCalendar(2017, GregorianCalendar.FEBRUARY, 5),
                "Michaelistraße", 17, 99086, "Erfurt", "Germany", deptLogistics, empDanny);
        empJonas = new Employee("Casio", "Jonas", new GregorianCalendar(2000, GregorianCalendar.OCTOBER, 30),
                "Leipzigerstraße", 99, 99084, "Weimar", "Germany", deptRental, empDanny);

        custMaria = new Customer("Schmidt", "Maria", new GregorianCalendar(2005, GregorianCalendar.AUGUST, 29), "maria.schmidt@web.de",
                "Weimarerlandstraße", 53, 99986, "Dresden", "Germany", "561616310651",rentATool);
        custLudwig = new Customer("Ebert", "Ludwig", new GregorianCalendar(1937, GregorianCalendar.DECEMBER, 17), "crazyemail@web.de",
                "Bahnhofsstraße", 16, 99067, "Gotha", "Germany", "01236/465854", rentATool);
    }



    // Main Test --------------------------------


    @Test
    void can_an_customer_put_a_tool_in_his_rentedTool_inventory_from_a_station(){
        Assertions.assertEquals(welder, station1.removeToolFromBox(welder));
    }

    @Test
    void should_give_null_if_the_searched_tool_is_not_in_the_station(){
        Assertions.assertNull(station1.removeToolFromBox(drill));
    }

    @Test
    void can_cutomer_rent_a_tool(){
        custLudwig.rentATool(drill, station1);
    }






    //Employee and Customer Informations ------------------------------
    @Test
    void create_correct_password_for_customer_and_employee(){
        Assertions.assertEquals("da151219st", empDanny.getAccount().getPassword());
        Assertions.assertEquals("ma290805sc", custMaria.getAccount().getPassword());
    }

    @Test
    void create_correct_email_for_employee(){
        Assertions.assertEquals("danny.steinbrecher@rat.de", empDanny.getAccount().getEmail());
    }

    @Test
    void set_correct_email_for_customer(){
        Assertions.assertEquals("maria.schmidt@web.de", custMaria.getAccount().getEmail());
    }

    @Test
    void set_correct_role_for_customer_and_employee(){
        Assertions.assertEquals(Role.EMPLOYEE, empDanny.getAccount().getRole());
        Assertions.assertEquals(Role.CUSTOMER, custMaria.getAccount().getRole());
    }



}