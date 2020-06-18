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
        assertEquals("Peter", customer.getFirstname());
    }

    @Test
    public void is_customer_finded_by_lastname(){

        List<Customer> allCustomer = repository.findByLastname("Hans");
        for(Customer customer:allCustomer)
        {
            assertEquals("Hans",customer.getLastname());
        }

    }
}
