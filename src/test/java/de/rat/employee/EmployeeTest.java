package de.rat.employee;

import de.rat.employee.Department;
import de.rat.employee.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.GregorianCalendar;

class EmployeeTest {

    //Variable declaration
    private Department deptRental;
    private Department deptLogistics;
    private Department deptManagement;

    private Employee empDanny;
    private Employee empMichael;
    private Employee empJonas;

    @BeforeEach
    void setUp() {
        deptRental = new Department("Verleih");
        deptLogistics = new Department("Logistik");
        deptManagement = new Department("Geschaeftsleitung");

        empDanny = new Employee("Steinbrecher", "Danny", new GregorianCalendar(2019, GregorianCalendar.DECEMBER, 15),
                "Johannesstraße", 5, 99084, "Erfurt", "Germany", deptManagement);
        empMichael = new Employee("Müller", "Michael", new GregorianCalendar(2017, GregorianCalendar.FEBRUARY, 5),
                "Michaelistraße", 17, 99086, "Erfurt", "Germany", deptLogistics, empDanny);
        empJonas = new Employee("Casio", "Jonas", new GregorianCalendar(2000, GregorianCalendar.OCTOBER, 30),
                "Leipzigerstraße", 99, 99084, "Weimar", "Germany", deptRental, empDanny);
    }


    // Main Test --------------------------------
    @Test
    void should_return_null_if_the_employee_has_no_supervisor(){
        Assertions.assertNull(empDanny.getSupervisor());
    }

    @Test
    void should_return_the_correct_supervisor_from_this_employee(){
        Assertions.assertEquals(empDanny, empMichael.getSupervisor());
    }




}