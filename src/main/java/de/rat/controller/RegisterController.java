package de.rat.controller;

import de.rat.model.common.*;
import de.rat.model.customer.Customer;
import de.rat.storage.repository.AccountRepository;
import de.rat.storage.repository.AddressRepository;
import de.rat.storage.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
public class RegisterController {

    @Autowired
    private CustomerRepository repositoryCustomer;
    private AccountRepository repositoryAccount;
    private AddressRepository repositoryAddress;
    public RegisterController(AccountRepository accRepo, AddressRepository repositoryAddress) {
        this.repositoryAccount = accRepo;
        this.repositoryAddress = repositoryAddress;
    }

    @GetMapping("/register")
    public String showForm(Model model) {
        Person newPerson=new Person();
        Customer newCustomer=new Customer();
        Account userAccount =new Account();
        Address userAddress =new Address();
        Date newDate =new Date();
        model.addAttribute("newPerson", newPerson);
        model.addAttribute("newCustomer", newCustomer);
        model.addAttribute("userAccount", userAccount);
        model.addAttribute("userAddress",userAddress);
        model.addAttribute("newDate",newDate);
        List<String> roleList = Arrays.asList("CUSTOMER");
        model.addAttribute("roleList",roleList);
        return "register_form";
    }
    //save in DB
    @PostMapping("/save")
    public String saveCustomer(@Valid @ModelAttribute("newCustomer") Customer newCustomer,BindingResult bindingResultCust,@Valid @ModelAttribute("userAccount") Account userAccount,BindingResult bindingResultAcc,@Valid @ModelAttribute("userAddress") Address userAddress,BindingResult bindingResultAdd) {
        userAccount.setRole(Role.CUSTOMER);
        if (bindingResultAcc.hasErrors()) {
            return "register_form";
        }
        if (bindingResultCust.hasErrors()) {
            return "register_form";
        }

        if (bindingResultAdd.hasErrors()) {
            return "register_form";
        }
        repositoryCustomer.save(newCustomer);
        repositoryAccount.save(userAccount);
       newCustomer.setAddress(userAddress);
       newCustomer.setAccount(userAccount);
        repositoryAddress.save(userAddress);
        return "/registrationSuccessfull";
    }




}
