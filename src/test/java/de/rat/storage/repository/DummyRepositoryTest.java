package de.rat.storage.repository;

import de.rat.model.Dummy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;


import java.time.LocalDate;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
class DummyRepositoryTest {

    @Autowired
    DummyRepository repository;
    private static final Logger log = LoggerFactory.getLogger(DummyRepositoryTest.class);

    @Test
    @Rollback(false)
    void  Test() {


        repository.save(new Dummy("Hans", LocalDate.of(2018,5,20)));

        Dummy dummy = repository.findById(1);
        log.info("Customer found with findById(1L):");
        log.info("--------------------------------");
        log.info(dummy.getName());
        log.info("");


        log.info("Customer found with findById(1L):");
        log.info("--------------------------------");
        log.info(String.valueOf(dummy.getCreated()));
        log.info(dummy.toString());
        log.info("");
    }
}


