package de.rat.controller;

import de.rat.model.common.*;
import de.rat.model.customer.Customer;
import de.rat.repositories.AccountRepository;
import de.rat.repositories.AddressRepository;
import de.rat.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Controller for all pages they are handle with the Registration
 * sets parameter and generate the data for the views
 *
 * @author Marco Petzold, Christian König, Danny Steinbrecher
 */
@Controller
public class RegisterController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomerRepository repositoryCustomer;
    private AccountRepository repositoryAccount;
    private AddressRepository repositoryAddress;

    public RegisterController(AccountRepository accRepo, AddressRepository repositoryAddress) {
        this.repositoryAccount = accRepo;
        this.repositoryAddress = repositoryAddress;
    }

    /**
     * @return registerForm
     * gets all user information
     * add all attributes to the model
     * redirect to registerForm.html
     */
    @GetMapping("/register")
    public String showForm(Model model) {

        Customer newCustomer = new Customer();
        Account userAccount = new Account();
        Address userAddress = new Address();
        Date newDate = new Date();

        model.addAttribute("newCustomer", newCustomer);
        model.addAttribute("userAccount", userAccount);
        model.addAttribute("userAddress", userAddress);
        model.addAttribute("newDate", newDate);

        List<String> roleList = Arrays.asList("CUSTOMER");
        model.addAttribute("roleList", roleList);
        return "registerForm";
    }

    /**
     * @param newCustomer           Customer
     * @param bindingResultCustomer BindingResult
     * @param userAccount           Account
     * @param bindingResultAccount  BindingResult
     * @param userAddress           Address
     * @param bindingResultAddress  BindingResult
     *                              <p>
     *                              check the if the user is already exists
     *                              adds a error message if the user is existing
     *                              generate a password hash
     *                              save all user information
     *                              redirect to registerForm.html
     * @return registrationSuccessful
     */
    @PostMapping("/save")
    public String saveCustomer(@Valid @ModelAttribute("newCustomer") Customer newCustomer,
                               BindingResult bindingResultCustomer,
                               @Valid @ModelAttribute("userAccount") Account userAccount,
                               BindingResult bindingResultAccount,
                               @Valid @ModelAttribute("userAddress") Address userAddress,
                               BindingResult bindingResultAddress) {
        userAccount.setRole(Role.CUSTOMER);
        Optional<Account> checkAccount = repositoryAccount.findByEmail(userAccount.getEmail());

        if (checkAccount.isPresent()) {
            bindingResultAccount.rejectValue("email", "error.userAccount", "An account already exists for this email.");
            return "registerForm";
        }

        while (bindingResultAccount.hasErrors() || bindingResultCustomer.hasErrors() || bindingResultAddress.hasErrors()) {
            return "registerForm";
        }

        String encodedPassword = passwordEncoder.encode(userAccount.getPassword());
        userAccount.setPassword(encodedPassword);

        repositoryAccount.save(userAccount);
        Address checkAddress = repositoryAddress.findByStreetnameHouseNumberCity(userAddress.getStreet(), userAddress.getHouseNr(), userAddress.getCity());
        if (checkAddress == null) {
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
