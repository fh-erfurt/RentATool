package de.rat.storage.repository;

import de.rat.model.customer.Customer;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CustomerRepository extends PersonBaseRepository<Customer>{ }
