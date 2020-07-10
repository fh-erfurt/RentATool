package de.rat.controller;

import de.rat.model.common.*;
import de.rat.model.customer.Customer;
import de.rat.storage.repository.AccountRepository;
import de.rat.storage.repository.AddressRepository;
import de.rat.storage.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String saveCustomer(@Valid @ModelAttribute("newCustomer") Customer newCustomer,BindingResult bindingResultCustomer,@Valid @ModelAttribute("userAccount") Account userAccount,BindingResult bindingResultAccount,@Valid @ModelAttribute("userAddress") Address userAddress,BindingResult bindingResultAddress) {
        userAccount.setRole(Role.CUSTOMER);
if(repositoryAccount.findAll().equals(userAccount.getEmail()))
{
    return "register_form";
}
        while (bindingResultAccount.hasErrors() ||bindingResultCustomer.hasErrors()||bindingResultAddress.hasErrors())
{
    return "register_form";
}

        repositoryAccount.save(userAccount);
        repositoryAddress.save(userAddress);
        newCustomer.setAddress(userAddress);
        newCustomer.setAccount(userAccount);
        repositoryCustomer.save(newCustomer);
        return "/registrationSuccessfull";
    }




}
