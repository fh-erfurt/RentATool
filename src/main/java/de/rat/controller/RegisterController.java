package de.rat.controller;

import de.rat.model.common.*;
import de.rat.model.customer.Customer;
import de.rat.storage.repository.AccountRepository;
import de.rat.storage.repository.AddressRepository;
import de.rat.storage.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Controller
public class RegisterController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomerRepository repositoryCustomer;
    private AccountRepository repositoryAccount;
    private AddressRepository repositoryAddress;
    private static final Logger log = LoggerFactory.getLogger(RegisterController.class);
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
        return "registerForm";
    }

    @PostMapping("/save")
    public String saveCustomer(@Valid @ModelAttribute("newCustomer") Customer newCustomer,BindingResult bindingResultCustomer,@Valid @ModelAttribute("userAccount") Account userAccount,BindingResult bindingResultAccount,@Valid @ModelAttribute("userAddress") Address userAddress,BindingResult bindingResultAddress) {
        userAccount.setRole(Role.CUSTOMER);
        Optional<Account> checkAccount = repositoryAccount.findByEmail(userAccount.getEmail());


        if(checkAccount.isPresent())
        {
            bindingResultAccount.rejectValue("email", "error.userAccount","An account already exists for this email.");
            return "registerForm";
        }

        while (bindingResultAccount.hasErrors() ||bindingResultCustomer.hasErrors()||bindingResultAddress.hasErrors())
        {
            return "registerForm";
        }

        String encodedPassword = passwordEncoder.encode(userAccount.getPassword());
        userAccount.setPassword(encodedPassword);



        repositoryAccount.save(userAccount);
        Address checkAddress = repositoryAddress.findByStreetnameHouseNumberCity(userAddress.getStreet(),userAddress.getHouseNr(),userAddress.getCity());
        if (checkAddress == null ) {
            repositoryAddress.save(userAddress);
            newCustomer.setAddress(userAddress);
        } else {
            newCustomer.setAddress(checkAddress);
        }
        newCustomer.setAccount(userAccount);
        repositoryCustomer.save(newCustomer);
        return "registrationSuccessful";
    }




}
