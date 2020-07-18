package de.rat.repositories;

import de.rat.model.employee.Employee;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface EmployeeRepository extends PersonBaseRepository<Employee> { }