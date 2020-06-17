package de.rat.storage.repository;

import de.rat.model.Dummy;
import de.rat.model.customer.Customer;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DummyRepositoryTest {

    @Autowired
    DummyRepository repository;
    private static final Logger log = LoggerFactory.getLogger(DummyRepositoryTest.class);

    @Test
    void  Test() {

        repository.save(new Dummy("Hans"));

        Dummy dummy = repository.findById(1);
        log.info("Customer found with findById(1L):");
        log.info("--------------------------------");
        log.info(dummy.getName());
        log.info("");


        log.info("Customer found with findById(1L):");
        log.info("--------------------------------");
        log.info(dummy.toString());
        log.info("");
    }
}


