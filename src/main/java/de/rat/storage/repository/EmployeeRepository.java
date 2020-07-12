package de.rat.storage.repository;

import de.rat.model.employee.Employee;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface EmployeeRepository extends PersonBaseRepository<Employee> { }