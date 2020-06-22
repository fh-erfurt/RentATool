package de.rat.storage.repository;

import de.rat.model.common.Address;
import de.rat.model.customer.Customer;
import de.rat.model.logistics.Category;
import de.rat.model.logistics.Manufacturer;
import de.rat.model.logistics.Tool;
import de.rat.model.logistics.ToolStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@DataJpaTest
class CustomerRepositoryTest {

    private Customer custHans;

    @Autowired
    CustomerRepository repository;
    private static final Logger log = LoggerFactory.getLogger(CustomerRepositoryTest.class);


    @BeforeEach
    void setUp(){
        custHans =  new Customer("Müller", "Hans");
        repository.save(custHans);
    }

    @Test
    public void is_customer_finded_by_lastname(){

        List<Customer> allCustomer = repository.findByLastname("Müller");
        for(Customer customer: allCustomer)
        {
            assertEquals("Müller",customer.getLastname());
        }
    }

    @Test
    public void  is_first_user_added_to_database() {

        Customer customer = repository.findById(custHans.getId());
        assertEquals("Hans",customer.getFirstname()) ;

        log.info("Customer found with findById("+ custHans.getId() + "):");
        log.info("--------------------------------");
        log.info("From Class:");
        log.info(String.valueOf(custHans.getId()));
        log.info(String.valueOf(custHans.getFirstname()));
        log.info("--------------------------------");
        log.info("From Database:");
        log.info(String.valueOf(customer.getId()));
        log.info(String.valueOf(customer.getFirstname()));
        log.info("");

    }


}
