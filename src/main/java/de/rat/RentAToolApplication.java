package de.rat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
//@EnableJpaRepositories(basePackageClasses = LoginUserRepository.class)
public class RentAToolApplication {
	public static void main(String[] args) {
		SpringApplication.run(RentAToolApplication.class, args);
	}

}
