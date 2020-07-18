package de.rat.repositories;

import de.rat.model.customer.Customer;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CustomerRepository extends PersonBaseRepository<Customer>{ }
