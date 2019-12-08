package de.rat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.GregorianCalendar;


class PersonTest {

    // @BeforeEach
    // Setup Departments
    private Department deptRental = new Department("Verleih");
    private Department deptLogistics = new Department("Logistik");
    private Department deptManagement = new Department("Geschaeftsleitung");

    // Setup Employees
    private Employee empDanny = new Employee("Steinbrecher", "Danny", new GregorianCalendar(2019,GregorianCalendar.DECEMBER,15),
        "Johannesstraße", 5, 99084, "Erfurt", "Germany", deptManagement, null);
    private Employee empMichael = new Employee("Müller", "Michael", new GregorianCalendar(2017, GregorianCalendar.FEBRUARY,5),
        "Michaelistraße", 17, 99086, "Erfurt", "Germany", deptLogistics, empDanny);
    private Employee empJonas = new Employee("Casio", "Jonas", new GregorianCalendar(2000, GregorianCalendar.OCTOBER,30),
        "Leipzigerstraße", 99, 99084, "Weimar", "Germany", deptRental, empDanny);

    // Setup Customer
    private Customer custMaria = new Customer("Schmidt", "Maria", new GregorianCalendar(2005, GregorianCalendar.AUGUST,29), "maria.schmidt@web.de",
        "Weimarerlandstraße", 53, 99986, "Dresden", "Germany", "561616310651");
    private Customer custLudwig = new Customer("Ebert", "Ludwig", new GregorianCalendar(1937, GregorianCalendar.DECEMBER,17), "crazyemail@web.de",
        "Bahnhofsstraße", 16, 99067, "Gotha", "Germany", "01236/465854");


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