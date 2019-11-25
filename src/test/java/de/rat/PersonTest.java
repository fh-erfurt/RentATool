package de.rat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void get_the_employee_all_attributes_from_the_person_class() {
        Address address = new Address();
        Account account = new Account();
        Department department = new Department();

        Employee employee1 = new Employee("Steinbrecher", "Danny", "2019.11.15", address, account, department, null);

        //Assertions.assertEquals(1, Werkzeug1.getToolId());

    }

}