package de.rat.controller;

import de.rat.model.customer.Customer;
import de.rat.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
public class BillController {
@Autowired
    CustomerRepository customerRepository;

    @RequestMapping(path="/bill")
    public String listBill(Model model)
    {
        NameControllerAdvice nameControllerAdvice = new NameControllerAdvice();
        int AccountId  = nameControllerAdvice.getAuthUser();
        Customer customer = customerRepository.findByAccount_id(AccountId);
        model.addAttribute("authUserFirstName", customer.getFirstname());
        model.addAttribute("authUserLastName", customer.getLastname());
        model.addAttribute("authUserAddressStreet", customer.getAddress().getStreet());
        model.addAttribute("authUserAddressHnr", customer.getAddress().getHouseNr());
        model.addAttribute("authUserAddressCity", customer.getAddress().getCity());
        model.addAttribute("authUserAddressZip", customer.getAddress().getZip());
        model.addAttribute("authUserAddressCountry", customer.getAddress().getCountry());
        model.addAttribute("authUserPhone", customer.getPhoneNumber());
        model.addAttribute("localDate", LocalDate.now());

        return "billForm";
    }
}
