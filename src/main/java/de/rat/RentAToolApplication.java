package de.rat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class RentAToolApplication {
	private static final Logger log = LoggerFactory.getLogger(RentAToolApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RentAToolApplication.class);
	}

}
