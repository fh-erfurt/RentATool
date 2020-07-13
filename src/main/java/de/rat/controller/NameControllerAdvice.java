package de.rat.controller;

import de.rat.account.details.AccountDetails;
import de.rat.model.common.Account;
import de.rat.model.common.Person;
import de.rat.model.customer.Customer;
import de.rat.model.employee.Employee;
import de.rat.storage.repository.AccountRepository;
import de.rat.storage.repository.CustomerRepository;
//import de.rat.storage.repository.PersonRepository;
import de.rat.storage.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class NameControllerAdvice {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @ModelAttribute
    public void addBugetToModel(Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            Object principal = auth.getPrincipal();
            if (principal instanceof AccountDetails) {
                AccountDetails account = (AccountDetails) principal;
                Integer accountId = account.getId();

                Customer customer = customerRepository.findByAccount_id(accountId);
                Employee employee = employeeRepository.findByAccount_id(accountId);

                if(customer != null){
                    model.addAttribute("authUserFirstName", customer.getFirstname());
                    model.addAttribute("authUserLastName", customer.getLastname());
                }else{
                    model.addAttribute("authUserFirstName", employee.getFirstname());
                    model.addAttribute("authUserLastName", employee.getLastname());
                }
            }
        }
    }


    public Person getAuthUser() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            Object principal = auth.getPrincipal();
            if (principal instanceof AccountDetails) {
                AccountDetails account = (AccountDetails) principal;
                Integer accountId = account.getId();

                Customer customer = customerRepository.findByAccount_id(accountId);
                Employee employee = employeeRepository.findByAccount_id(accountId);

                if(customer != null){
                    return customer;
                }else{
                    return employee;
                }
            }
        }
        return null;
    }
}