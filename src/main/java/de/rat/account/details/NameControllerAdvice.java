package de.rat.account.details;

import de.rat.model.customer.Customer;
import de.rat.model.employee.Employee;
import de.rat.repositories.CustomerRepository;
import de.rat.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/** ControllerAdvice for the Authenticated User
 * generate some UserInformation
 * @author Marco Petzold, Christian König, Danny Steinbrecher
 */
@ControllerAdvice
public class NameControllerAdvice {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    /**
     * @param model Model
     * add the Firstname and Lastname from the Employee / Customer to the Model
     * redirect to employee.html
     */
    @ModelAttribute
    public void addAuthUserToModel(Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            Object principal = auth.getPrincipal();
            if (principal instanceof AccountDetails) {
                AccountDetails account = (AccountDetails) principal;
                Integer accountId = account.getId();

                Customer customer = customerRepository.findByAccount_id(accountId);
                Employee employee = employeeRepository.findByAccount_id(accountId);

                if(customer != null){
                    model.addAttribute("authUserFirstName", customer.getFirstname());
                    model.addAttribute("authUserLastName", customer.getLastname());
                }else{
                    model.addAttribute("authUserFirstName", employee.getFirstname());
                    model.addAttribute("authUserLastName", employee.getLastname());
                }
            }
        }
    }


    /**
     * @return  Account Id
     * generate the Account Id from the Authenticated User
     */
    public int getAuthUser() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            Object principal = auth.getPrincipal();
            if (principal instanceof AccountDetails) {
                AccountDetails account = (AccountDetails) principal;

                return account.getId();
            }
        }
        return 0;
    }
}