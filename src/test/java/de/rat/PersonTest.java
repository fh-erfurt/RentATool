package de.rat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void get_the_employee_all_attributes_from_the_person_class() {
        Department department = new Department("anvfsapfovb");
        Employee employee1 = new Employee("Steinbrecher", "Danny", "2019.11.15",
                "Straße", 5, 12354, "Erfurt", "Germany",
                department, null);

        Assertions.assertEquals(department, employee1.getDepartment());
        Assertions.assertEquals("Steinbrecher", employee1.getLastname());
        Assertions.assertEquals("Danny", employee1.getFirstname());
        Assertions.assertEquals("2019.11.15", employee1.getBirthday());
        Assertions.assertEquals("Straße", employee1.getAddress().getStreet());
        Assertions.assertEquals(5, employee1.getAddress().getHauseNr());
        Assertions.assertEquals(12354, employee1.getAddress().getZip());
        Assertions.assertEquals("Erfurt", employee1.getAddress().getCity());
        Assertions.assertEquals("Germany", employee1.getAddress().getCountry());
        Assertions.assertEquals("Steinbrecher.Danny@rat.de", employee1.getAccount().getEmail());
        assertNull(employee1.getSupervisor());
    }

    @Test
    void was_the_person_added_to_the_list(){
//        Department department = new Department("anvfsapfovb");
//        Employee employee1 = new Employee("Steinbrecher", "Danny", "2019.11.15", "Hans", "wurst@t.de", "122346" ,
//                "Straße", 5, 12354, "Erfurt", "Germany",
//                department, null);
//        Employee employee2= new Employee("Peter", "Hans", "2019.11.15", "Hans", "wurst@t.de", "122346" ,
//                "Straße", 5, 12354, "Erfurt", "Germany",
//                department, null);
//
//        Customer cutomer= new Customer("Peter", "Hans", "2019.11.15", "Hans", "wurst@t.de", "122346" ,
//                "Straße", 5, 12354, "Erfurt", "Germany",
//                "234234234");
//        Assertions.assertEquals(2, Person.employeeList.size());
//        Assertions.assertEquals(1, Person.customerList.size());
    }

}