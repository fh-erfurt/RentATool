package de.rat.controller;

import de.rat.model.Dummy;
import de.rat.model.employee.Employee;
import de.rat.storage.exceptions.DummyNotFoundException;
import de.rat.storage.exceptions.EmployeeNotFoundException;
import de.rat.storage.repository.DummyRepository;
import de.rat.storage.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class EmployeeController {

        @Autowired
        EmployeeRepository repository;

        @GetMapping("/employees")
        List<Employee> all() {
            return (List<Employee>) repository.findAll();
        }

        @PostMapping("/employees")
        Employee newEmployee(@RequestBody Employee newEmployee) {
            return repository.save(newEmployee);
        }

        // Single item

        @GetMapping("/employees/{id}")
        Employee one(@PathVariable Long id) {

            return repository.findById(id)
                    .orElseThrow(() -> new EmployeeNotFoundException(id));
        }

    }
