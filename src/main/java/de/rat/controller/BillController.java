package de.rat.controller;

import de.rat.model.billing.Bill;
import de.rat.model.billing.BillStatus;
import de.rat.model.billing.Billing;
import de.rat.model.customer.Customer;
import de.rat.model.customer.RentProcess;
import de.rat.repositories.BillRepository;
import de.rat.repositories.CustomerRepository;
import de.rat.repositories.RentProcessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.logging.Logger;
import java.time.LocalDate;
import java.util.List;

/** Controller for all pages they are handle with the Bill
 * sets parameter and generate the data for the views

 * @author Marco Petzold, Christian König, Danny Steinbrecher
 */
@Controller
public class BillController {
    private static final Logger log = Logger.getLogger("LOGGER");

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    BillRepository billRepository;


    /**
     * @param model Model
     * @return  billView
     * adds all Bills from the customer to the Model
     * redirect to billView.html
     */
    @RequestMapping(path="/billView")
    public String listOfCustomerBills(Model model)
    {

        NameControllerAdvice nameControllerAdvice = new NameControllerAdvice();
        int AccountId1  = nameControllerAdvice.getAuthUser();
        Customer customer1 = customerRepository.findByAccount_id(AccountId1);

        List<Bill> listOfBills = new ArrayList<Bill>();

        for(Bill bill : billRepository.findByCustomerId(customer1.getId())) {
            if (bill.getBillStatus() == BillStatus.CLOSED) {
                listOfBills.add(bill);
            }
        }

        if(listOfBills != null) {
            model.addAttribute("listOfBills", listOfBills);
        }
        return "billView";
    }

    /**
     * @param id int
     * @return  mav
     * generate a BillView for the selected Bill with all Tools
     */
    @RequestMapping(path="/bill/{id}")
    public ModelAndView showBill(@PathVariable(name = "id") int id)
    {
        ModelAndView mav = new ModelAndView("billForm");
        NameControllerAdvice nameControllerAdvice = new NameControllerAdvice();
        int AccountId  = nameControllerAdvice.getAuthUser();
        Customer customer = customerRepository.findByAccount_id(AccountId);
        for(Bill bill : billRepository.findAll()) {
            if (bill.getBillNumber() == id && bill.getBillStatus() == BillStatus.CLOSED) {
                mav.addObject("customerBill", bill);
                List<RentProcess> listOfRentprocess = bill.getListOfRentProcesses();
                mav.addObject("listOfRentprocess", listOfRentprocess);
            }
        }
        mav.addObject("authUserFirstName", customer.getFirstname());
        mav.addObject("authUserLastName", customer.getLastname());
        mav.addObject("authUserAddressStreet", customer.getAddress().getStreet());
        mav.addObject("authUserAddressHnr", customer.getAddress().getHouseNr());
        mav.addObject("authUserAddressCity", customer.getAddress().getCity());
        mav.addObject("authUserAddressZip", customer.getAddress().getZip());
        mav.addObject("authUserAddressCountry", customer.getAddress().getCountry());
        mav.addObject("authUserPhone", customer.getPhoneNumber());
        mav.addObject("localDate", LocalDate.now());

        return mav;
    }
}
