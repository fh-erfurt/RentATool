package de.rat.employee;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeNotificationTest {

    //Variable declaration

    private Employee empDanny;
    private Employee empMichael;
    private Employee empJonas;

    @BeforeEach
    void setUp() {


        empDanny = new Employee("Steinbrecher", "Danny", new GregorianCalendar(2019, GregorianCalendar.DECEMBER, 15),
                "Johannesstraße", 5, 99084, "Erfurt", "Germany");
        empMichael = new Employee("Müller", "Michael", new GregorianCalendar(2017, GregorianCalendar.FEBRUARY, 5),
                "Michaelistraße", 17, 99086, "Erfurt", "Germany", empDanny);
        empJonas = new Employee("Casio", "Jonas", new GregorianCalendar(2000, GregorianCalendar.OCTOBER, 30),
                "Leipzigerstraße", 99, 99084, "Weimar", "Germany", empDanny);
    }

    @Test
    public void add_a_employee_to_the_list() {


    }

    @Test
    public void sendNotificationToAllEmployees() {
    }
}