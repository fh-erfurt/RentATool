package de.rat.common;

import de.rat.customer.Customer;
import de.rat.employee.Employee;
import de.rat.logistics.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.GregorianCalendar;


class PersonTest {

    //Variable declaration
    private Employee empJonas;

    private Customer custMaria;

    private Address musterhausen;
    private Station station1;
    private Manufacturer bosch;

    private Tool drill;
    private Tool hammer;
    private Tool welder;


    @BeforeEach
    void setUp() {
        musterhausen = new Address("Musterstrasse", 1, 99099, "Erfurt", "Deutschland");
        bosch = new Manufacturer("Bosch", musterhausen, "Mr Smith", "123456");
        station1 = new Station("S1", 3, musterhausen);

        drill = new Tool("123", bosch, "Bohrer", Category.HANDTOOL, "1-4-5", ToolStatus.AVAILABLE, 3.0);
        hammer = new Tool("12553", bosch, "Hammer", Category.HANDTOOL, "1-4-6", ToolStatus.ISINREPAIR, 2.5);
        welder = new Tool("ewv133", bosch, "Schweißgerät", Category.HANDTOOL, "1-4-7", ToolStatus.ISRENTED, 3.5);

        station1.addToolToBox(welder);

        empJonas = new Employee("Hecht", "Jonas", new GregorianCalendar(2019, GregorianCalendar.DECEMBER, 15),
                "Johannesstraße", 5, 99084, "Weimar", "Germany", null);

        custMaria = new Customer("Schmidt", "Maria", new GregorianCalendar(2005, GregorianCalendar.AUGUST, 29), "maria.schmidt@web.de",
                "Weimarerlandstraße", 53, 99986, "Dresden", "Germany", "561616310651");
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


    //Employee and Customer Informations ------------------------------
    @Test
    void create_correct_password_for_customer_and_employee(){
        Assertions.assertEquals("jo151219he", empJonas.getAccount().getPassword());
        Assertions.assertEquals("ma290805sc", custMaria.getAccount().getPassword());
    }

    @Test
    void create_correct_email_for_employee(){
        Assertions.assertEquals("jonas.hecht@rat.de", empJonas.getAccount().getEmail());
    }

    @Test
    void set_correct_email_for_customer(){
        Assertions.assertEquals("maria.schmidt@web.de", custMaria.getAccount().getEmail());
    }

    @Test
    void set_correct_role_for_customer_and_employee(){
        Assertions.assertEquals(Role.EMPLOYEE, empJonas.getAccount().getRole());
        Assertions.assertEquals(Role.CUSTOMER, custMaria.getAccount().getRole());
    }



}