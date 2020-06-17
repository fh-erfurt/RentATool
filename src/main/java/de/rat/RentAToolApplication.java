package de.rat;

import de.rat.model.customer.Customer;
import de.rat.storage.core.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class RentAToolApplication {
	private static final Logger log = LoggerFactory.getLogger(RentAToolApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RentAToolApplication.class);
	}



}
