package de.rat.storage.repository;

import de.rat.model.customer.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository repository;
    private static final Logger log = LoggerFactory.getLogger(CustomerRepositoryTest.class);

    @BeforeEach
    void setUp(){
        repository.save(new Customer("Hans", "Peter"));
    }


    @Test
    public void  is_first_user_added_to_database() {

        //repository.save(new Customer("Hans", "Peter"));

        Customer customer = repository.findById(1);
        log.info("Customer found with findById(1L):");
        log.info("--------------------------------");
        log.info(customer.toString());
        log.info("");
        assertEquals("Peter", customer.getFirstname());


    }

}
