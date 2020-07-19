package de.rat.controller;

import de.rat.model.billing.Bill;
import de.rat.model.billing.Billing;
import de.rat.model.customer.Customer;
import de.rat.model.customer.RentProcess;
import de.rat.model.logistics.Tool;
import de.rat.repositories.CustomerRepository;
import de.rat.repositories.BillRepository;
import de.rat.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.logging.Logger;

import java.time.LocalDate;
import java.util.List;

@Controller
public class BillController {
@Autowired
CustomerRepository customerRepository;
BillRepository  billRepository;

    private static final Logger log = Logger.getLogger("LOGGER");

    @RequestMapping(path="/billView")
    public String listOfCustomerBills(Model model)
    {
        NameControllerAdvice nameControllerAdvice = new NameControllerAdvice();
        int AccountId1  = nameControllerAdvice.getAuthUser();
        Customer customer1 = customerRepository.findByAccount_id(AccountId1);
        List <Bill> listOfBills = Billing.findClosedBillFromCustomer(customer1);

        if(listOfBills != null) {
            model.addAttribute("listOfBills", listOfBills);
        }
        return "billView";
    }

    @RequestMapping(path="/bill/{id}")
    public String listBill(Model model,@PathVariable(name = "id") int billNumber)
    {

        NameControllerAdvice nameControllerAdvice = new NameControllerAdvice();
        int AccountId  = nameControllerAdvice.getAuthUser();
        Customer customer = customerRepository.findByAccount_id(AccountId);
        Bill custBill = billRepository.findByBillNumber(billNumber);
        model.addAttribute("customerBill", custBill);
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
