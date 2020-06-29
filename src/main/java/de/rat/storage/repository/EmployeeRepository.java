package de.rat.storage.repository;

import de.rat.model.employee.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface EmployeeRepository extends CrudRepository<Employee,Integer> {

//    Employee findById(int id);
//
//    List<Employee> findBySupervisor(Employee supervisor);
}