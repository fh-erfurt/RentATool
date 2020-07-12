package de.rat.storage.repository;

import de.rat.model.common.Person;
import de.rat.model.customer.Customer;
import de.rat.model.employee.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface EmployeeRepository extends PersonBaseRepository<Employee>, CrudRepository<Employee, Integer>
{

}