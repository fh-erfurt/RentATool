package de.rat;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    // @BeforeEach
    // void setUp(){

        // Setup Departments
        private Department deptRental = new Department("Verleih");
        private Department deptLogistics = new Department("Logistik");
        private Department deptManagement = new Department("Geschaeftsleitung");

        // Setup Employees
        private Employee empDanny = new Employee("Steinbrecher", "Danny", "2019.11.15",
            "Johannesstraße", 5, 99084, "Erfurt", "Germany", deptManagement, null);
        private Employee empMichael = new Employee("Müller", "Michael", "2017.01.05",
            "Michaelistraße", 17, 99086, "Erfurt", "Germany", deptLogistics, empDanny);
        private Employee empJonas = new Employee("Casio", "Jonas", "2000.09.30",
            "Leipzigerstraße", 99, 99084, "Weimar", "Germany", deptRental, empDanny);

        // Setup Customer
        private Customer custMaria = new Customer("Schmidt", "Maria", "2005.07.29", "maria.schmidt@web.de",
            "Weimarerlandstraße", 53, 99986, "Dresden", "Germany", "561616310651");
        private Customer custLudwig = new Customer("Ebert", "Ludwig", "1937.11.17", "crazyemail@web.de",
            "Bahnhofsstraße", 16, 99067, "Gotha", "Germany", "01236/465854");

//    @Test
//    void get_the_employee_all_attributes_from_the_person_class() {
//        Assertions.assertEquals(department, employee1.getDepartment());
//        Assertions.assertEquals("Steinbrecher", employee1.getLastname());
//        Assertions.assertEquals("Danny", employee1.getFirstname());
//        Assertions.assertEquals("2019.11.15", employee1.getBirthday());
//        Assertions.assertEquals("Straße", employee1.getAddress().getStreet());
//        Assertions.assertEquals(5, employee1.getAddress().getHauseNr());
//        Assertions.assertEquals(12354, employee1.getAddress().getZip());
//        Assertions.assertEquals("Erfurt", employee1.getAddress().getCity());
//        Assertions.assertEquals("Germany", employee1.getAddress().getCountry());
//        Assertions.assertEquals("Steinbrecher.Danny@rat.de", employee1.getAccount().getEmail());
//        Assertions.assertEquals("Steinbrecher", employee1.getAccount().getPassword());
//        Assertions.assertEquals("Mitarbeiter", employee1.getAccount().getRole());
//        assertNull(employee1.getSupervisor());
//    }


    @Test
    void create_correct_password_for_customer_and_employee(){
        Assertions.assertEquals("da241289st", empDanny.getAccount().getPassword());
        Assertions.assertEquals("ma290705sc", custMaria.getAccount().getPassword());
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