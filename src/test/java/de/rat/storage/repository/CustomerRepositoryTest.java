package de.rat.storage.repository;

import de.rat.model.common.Address;
import de.rat.model.customer.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class CustomerRepositoryTest {

    private Customer custHans;

    @Autowired
    CustomerRepository repository;
    private static final Logger log = LoggerFactory.getLogger(CustomerRepositoryTest.class);


    @BeforeEach
    void setUp(){
        custHans =  new Customer("Müller", "Hans", LocalDate.of(2005, 8, 29),"hans@web.de","Kastanienallee","1A","01144", "Berlin","DE","0176767676");
        repository.save(custHans);
    }


    @Test
    public void  is_first_user_added_to_database() {

        Customer customer = repository.findById(custHans.getId());
        assertEquals("Hans",customer.getFirstname()) ;

    }


}
