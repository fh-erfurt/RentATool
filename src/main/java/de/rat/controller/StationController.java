package de.rat.controller;

import de.rat.model.Rental;
import de.rat.model.billing.Bill;
import de.rat.model.billing.Billing;
import de.rat.model.customer.Customer;
import de.rat.model.customer.RentProcess;
import de.rat.model.logistics.*;
import de.rat.storage.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.List;

@Controller
public class StationController {
    @Autowired
    StationRepository stationRepository;
    @Autowired
    ToolRepository toolRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    WarehouseRepository warehouseRepository;
    @Autowired
    RentProcessRepository rentProcessRepository;
    @Autowired
    BillRepository billRepository;
    @Autowired
    BillingRepository billingRepository;





    private static final Logger log = LoggerFactory.getLogger(ToolController.class);

    @RequestMapping(path="/chooseStation/{id}")
    public String listAllTools(@PathVariable(name = "id") int id,Model model)
    {

        Tool rentedTool = toolRepository.findById(id);
        List<Station> listStation= (List<Station>) stationRepository.findAll();

        model.addAttribute("listStation", listStation);
        model.addAttribute(rentedTool);

        return "chooseStation";
    }


    @PostMapping("/setStation/{toolId}/{stationId}")
    public String rentATool(@PathVariable("toolId") int toolId,@PathVariable("stationId") int stationId)
    {
        //init object for renting
        Station rentStation = stationRepository.findById(stationId);
        Tool rentedTool = toolRepository.findById(toolId);
        NameControllerAdvice nameControllerAdvice = new NameControllerAdvice();
        int AccountId  = nameControllerAdvice.getAuthUser();
        Customer lendingCustomer = customerRepository.findByAccount_id(AccountId);
        Warehouse mainWarehouse = warehouseRepository.findById(1);

        List<Bill> billinglist = (List<Bill>) billRepository.findAll();
        if(Billing.getOpenBills().size()==0&&Billing.getCheckBills().size()==0&&Billing.getClosedBills().size()==0) {

            for (Bill bill : billinglist) {
                switch (bill.getBillStatus()) {
                    case OPEN:
                        Billing.getOpenBills().add(bill);
                    case CHECKED:
                        Billing.getCheckBills().add(bill);
                    case CLOSED:
                        Billing.getClosedBills().add(bill);
                    default:
                }

            }
        }
        // rent a tool
        Rental.rentATool(rentedTool,rentStation,lendingCustomer,mainWarehouse);

        // save data
        toolRepository.save(rentedTool);
        lendingCustomer.putToolInInventory(rentedTool);
        customerRepository.save(lendingCustomer);
        stationRepository.save(rentStation);
        warehouseRepository.save(mainWarehouse);

        //find data in java logik to save
        Bill rentBill = Billing.findOpenBillFromCustomer(lendingCustomer);
        RentProcess rentProcess = rentBill.findRentProcess(rentedTool);
        rentProcessRepository.save(rentProcess);
        billRepository.save(rentBill);

        return "rentSuccessful";
    }

    @RequestMapping(path="/returnStation/{id}")
    public String listrentedTools(@PathVariable(name = "id") int id,Model model)
    {

        Tool rentedTool = toolRepository.findById(id);
        List<Station> listStation= (List<Station>) stationRepository.findAll();

        model.addAttribute("listStation", listStation);
        model.addAttribute(rentedTool);

        return "returnStation";
    }

    @PostMapping("/setReturnStation/{toolId}/{stationId}")
    public String returnATool(@PathVariable("toolId") int toolId,@PathVariable("stationId") int stationId)
    {
        //init object for return tool
        Station returnStation = stationRepository.findById(stationId);
        Tool renturnedTool = toolRepository.findById(toolId);
        NameControllerAdvice nameControllerAdvice = new NameControllerAdvice();
        int AccountId  = nameControllerAdvice.getAuthUser();
        Customer lendingCustomer = customerRepository.findByAccount_id(AccountId);
        Warehouse mainWarehouse = warehouseRepository.findById(1);

        // return tool method
        Rental.returnTool(renturnedTool,returnStation,lendingCustomer,mainWarehouse);

        // save data
        toolRepository.save(renturnedTool);
        lendingCustomer.getToolFromInventory(renturnedTool);
        //mainWarehouse.putToolInWarehouse(renturnedTool);
        customerRepository.save(lendingCustomer);
        stationRepository.save(returnStation);
        warehouseRepository.save(mainWarehouse);

        //find data in java logik to save
        Bill rentBill = Billing.findOpenBillFromCustomer(lendingCustomer);
        RentProcess rentProcess = rentBill.findRentProcess(renturnedTool);
        rentProcessRepository.save(rentProcess);
        billRepository.save(rentBill);


        return "rentSuccessful";
    }

}
