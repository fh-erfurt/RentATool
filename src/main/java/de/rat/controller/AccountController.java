package de.rat.controller;

import de.rat.model.customer.Customer;
import de.rat.model.logistics.Tool;
import de.rat.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

/** Controller for all pages they are handle with the Account
 * sets parameter and generate the data for the views

 * @author Marco Petzold, Christian König, Danny Steinbrecher
 */
@Controller
public class AccountController {

    @Autowired
    CustomerRepository customerRepository;


    @RequestMapping(path="/accountView")
    public String listAllrentedTool()
    {

        return "accountView";
    }
    /**
     * @param  Model model
     * @return  rentedToolView
     * listed all rented Tools
     */
    @RequestMapping(path="/rentedToolView")
    public String rentedToolView(Model model)
    {
        NameControllerAdvice nameControllerAdvice = new NameControllerAdvice();
        int AccountId  = nameControllerAdvice.getAuthUser();
        Customer customer = customerRepository.findByAccount_id(AccountId);
        List<Tool> listTools= (List<Tool>) customer.getInventory();
        model.addAttribute("listTools", listTools);
        return "rentedToolView";
    }
//    @RequestMapping(path="/billView")
//    public String billView()
//    {
//        return "billView";
//    }


}
