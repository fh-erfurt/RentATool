package de.rat.controller;

import de.rat.model.billing.Bill;
import de.rat.model.customer.Customer;
import de.rat.model.customer.RentProcess;
import de.rat.model.logistics.Tool;
import de.rat.storage.repository.BillRepository;
import de.rat.storage.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
public class BillController {
@Autowired
    CustomerRepository customerRepository;
BillRepository billRepository;

    @RequestMapping(path="/bill")
    public String listBill(Model model)
    {
        NameControllerAdvice nameControllerAdvice = new NameControllerAdvice();
        int AccountId  = nameControllerAdvice.getAuthUser();
        Customer customer = customerRepository.findByAccount_id(AccountId);
        List<Bill> listCustomerBill=billRepository.findByCustomer(customer.getLastname());
        List<RentProcess> listRentProcesses= listCustomerBill.get(0).getListOfRentProcesses();
        for(RentProcess rentProcess:listRentProcesses)
        {
            model.addAttribute("getRentedTool",rentProcess.getRentedTool());
        }
        model.addAttribute("listCustomerBill",listCustomerBill);

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
