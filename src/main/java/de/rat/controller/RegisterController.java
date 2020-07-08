package de.rat.controller;

import de.rat.model.common.Account;
import de.rat.model.common.Address;
import de.rat.model.common.Date;
import de.rat.model.common.Person;
import de.rat.model.customer.Customer;
import de.rat.storage.repository.AccountRepository;
import de.rat.storage.repository.AddressRepository;
import de.rat.storage.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
    //Ausgabe auf Browserebene
    @PostMapping("/register")
    public String submitForm(@ModelAttribute("newCustomer") Customer newCustomer){
        return  "register_success";
    }
    //save in DB
    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute("newCustomer") Customer newCustomer,@ModelAttribute("userAccount") Account userAccount,@ModelAttribute("userAddress") Address userAddress) {
        repositoryCustomer.save(newCustomer);
        repositoryAccount.save(userAccount);
        repositoryAddress.save(userAddress);
        return "redirect:/";
    }
}
