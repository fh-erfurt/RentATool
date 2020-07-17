package de.rat.controller;

import de.rat.model.customer.Customer;
import de.rat.model.employee.Employee;
import de.rat.model.logistics.Tool;
import de.rat.storage.repository.CustomerRepository;
import de.rat.storage.repository.EmployeeRepository;
import de.rat.storage.repository.ToolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;

/** Controller for all pages they are handle with the User
 * sets parameter and generate the data for the views

 * @author Marco Petzold, Christian König, Danny Steinbrecher
 */
@Controller
public class UserController {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    EmployeeRepository employeeRepository;


    @GetMapping("/userManagement")
    public String welcome() {
        return "userManagement";
    }


    @RequestMapping(path="/customer")
    public String listAllCustomer(Model model)
    {
        List<Customer> listCustomer= (List<Customer>) customerRepository.findAll();

        model.addAttribute("listCustomer", listCustomer);

        return "customer";
    }

    @RequestMapping(path="/employee")
    public String listAllEmployees(Model model)
    {
        List<Employee> listEmployee= (List<Employee>) employeeRepository.findAll();

        model.addAttribute("listEmployee", listEmployee);

        return "employee";
    }


}
