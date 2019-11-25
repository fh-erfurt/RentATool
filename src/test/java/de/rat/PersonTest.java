package de.rat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void get_the_employee_all_attributes_from_the_person_class() {
        Address address = new Address("Straße", 5, 12354, "Erfurt", "Germany");
        Account account = new Account();
        Department department = new Department("anvfsapfovb");
        Employee employee1 = new Employee("Steinbrecher", "Danny", "2019.11.15", address, account, department, null);

        Assertions.assertEquals(address, employee1.getAddress());
        Assertions.assertEquals(account, employee1.getAccount());
        Assertions.assertEquals(department, employee1.getDepartment());
        Assertions.assertEquals("Steinbrecher", employee1.getLastname());
        Assertions.assertEquals("Danny", employee1.getFirstname());
        Assertions.assertEquals("2019.11.15", employee1.getBirthday());
        Assertions.assertEquals(null, employee1.getSupervisor());


    }

}