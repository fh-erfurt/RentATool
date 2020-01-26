package de.rat.employee;

import de.rat.common.Role;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.GregorianCalendar;

class EmployeeTest {

    //Variable declaration

    private Employee empDanny;
    private Employee empMichael;
    private Employee empJonas;

    @BeforeEach
    void setUp() {


        empJonas = new Employee("Hecht", "Jonas", new GregorianCalendar(2019, GregorianCalendar.DECEMBER, 15),
                "Johannesstraße", 5, 99084, "Weimar", "Germany", null);
        empMichael = new Employee("Müller", "Michael", new GregorianCalendar(2017, GregorianCalendar.FEBRUARY, 5),
                "Michaelistraße", 17, 99086, "Erfurt", "Germany", empJonas);

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


}