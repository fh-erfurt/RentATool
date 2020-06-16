package de.rat.web;

import de.rat.model.customer.Customer;
import de.rat.storage.core.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.GregorianCalendar;

@DataJpaTest
class RentAToolApplicationTests {
CustomerRepository rep;
	private static final Logger log = LoggerFactory.getLogger(RentAToolApplicationTests.class);



	CustomerRepository repository;
	@Test
	void contextLoads() {


		repository.save(new Customer("Ebert", "Ludwig", new GregorianCalendar(1937, GregorianCalendar.DECEMBER, 17), "crazyemail@web.de",
				"Bahnhofsstraße", 16, 99067, "Gotha", "Germany", "01236/465854"));
	}

}
