package de.rat;

import de.rat.model.Dummy;
import de.rat.model.customer.Customer;
import de.rat.storage.core.CustomerRepository;
import de.rat.storage.core.DummyRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

//@DataJpaTest

@SpringBootTest
class RentAToolApplicationTests {

	private static final Logger log = LoggerFactory.getLogger(RentAToolApplicationTests.class);


	DummyRepository repository;

	@Test
	void contextLoads() {


		repository.save(new Dummy("Hans"));
	}

}
