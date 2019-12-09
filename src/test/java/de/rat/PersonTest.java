package de.rat;

import org.junit.Before;
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

    @BeforeEach
    void setupDepartments(){
       deptRental = new Department("Verleih");
       deptLogistics = new Department("Logistik");
       deptManagement = new Department("Geschaeftsleitung");
    }

    @BeforeEach
    void setupEmployees() {
        empDanny = new Employee("Steinbrecher", "Danny", new GregorianCalendar(2019, GregorianCalendar.DECEMBER, 15),
                "Johannesstraße", 5, 99084, "Erfurt", "Germany", deptManagement, null);
        empMichael = new Employee("Müller", "Michael", new GregorianCalendar(2017, GregorianCalendar.FEBRUARY, 5),
                "Michaelistraße", 17, 99086, "Erfurt", "Germany", deptLogistics, empDanny);
        empJonas = new Employee("Casio", "Jonas", new GregorianCalendar(2000, GregorianCalendar.OCTOBER, 30),
                "Leipzigerstraße", 99, 99084, "Weimar", "Germany", deptRental, empDanny);
    }

    @BeforeEach
    void setupCustomer() {
        custMaria = new Customer("Schmidt", "Maria", new GregorianCalendar(2005, GregorianCalendar.AUGUST, 29), "maria.schmidt@web.de",
                "Weimarerlandstraße", 53, 99986, "Dresden", "Germany", "561616310651",rentATool);
        custLudwig = new Customer("Ebert", "Ludwig", new GregorianCalendar(1937, GregorianCalendar.DECEMBER, 17), "crazyemail@web.de",
                "Bahnhofsstraße", 16, 99067, "Gotha", "Germany", "01236/465854", rentATool);
    }


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