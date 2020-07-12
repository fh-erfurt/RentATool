package de.rat.controller;

import de.rat.account.details.AccountDetails;
import de.rat.model.common.Account;
import de.rat.model.common.Person;
import de.rat.model.customer.Customer;
import de.rat.storage.repository.AccountRepository;
import de.rat.storage.repository.CustomerRepository;
//import de.rat.storage.repository.PersonRepository;
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
    AccountRepository accountRepository;
//
//    @Autowired
//    PersonRepository personRepository;

    @ModelAttribute
    public void addBugetToModel(Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            Object principal = auth.getPrincipal();
            if (principal instanceof AccountDetails) {
                AccountDetails account = (AccountDetails) principal;
                Integer username1 = account.getId();



//                Person person = personRepository.findByAccount_id(username1);
//                model.addAttribute("authUserName", person.getFirstname());

                Customer customer = customerRepository.findByAccount_id(username1);
                model.addAttribute("authUserName", customer.getFirstname());
//
//                Account account2 = accountRepository.findById(1);
//                model.addAttribute("authUserName", account2.getEmail());

            }
        }

    }
}