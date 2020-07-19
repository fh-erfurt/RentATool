package de.rat.controller;

import de.rat.model.Rental;
import de.rat.model.billing.Bill;
import de.rat.model.billing.Billing;
import de.rat.model.customer.Customer;
import de.rat.model.customer.RentProcess;
import de.rat.model.logistics.*;
import de.rat.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

/** Controller for all pages they are handle with the Registration
 * sets parameter and generate the data for the views

 * @author Marco Petzold, Christian König, Danny Steinbrecher
 */
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

    private int WarehouseId = 100000;

    /**
     * @return  registerForm
     * gets all user information
     * add all attributes to the model
     * redirect to chooseStation.html
     */
    @RequestMapping(path="/chooseStation/{id}")
    public String listAllStations(@PathVariable(name = "id") int id,Model model)
    {
        Tool rentedTool = toolRepository.findById(id);
        List<Station> listStation= (List<Station>) stationRepository.findAll();

        model.addAttribute("listStation", listStation);
        model.addAttribute(rentedTool);

        return "chooseStation";
    }


    /**
     * @return  rentSuccessful
     * controller with all necessary methods to rent a tool
     * save data in the database
     * creates a bill
     * redirect to rentSuccessful.html
     */
    @PostMapping("/setStation/{toolId}/{stationId}")
    public String rentATool(@PathVariable("toolId") int toolId,@PathVariable("stationId") int stationId)
    {

        //init object for renting
        Station rentStation = stationRepository.findById(stationId);
        Tool rentedTool = toolRepository.findById(toolId);
        NameControllerAdvice nameControllerAdvice = new NameControllerAdvice();
        int AccountId  = nameControllerAdvice.getAuthUser();
        Customer lendingCustomer = customerRepository.findByAccount_id(AccountId);
        Warehouse mainWarehouse = warehouseRepository.findById(WarehouseId);

        // rent a tool
        Rental.rentATool(rentedTool,rentStation,lendingCustomer,mainWarehouse);
        // save data
        toolRepository.save(rentedTool);
        rentStation.removeToolFromBox(rentedTool);
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


    /**
     * @return  returnStation
     * TODO: JavaDocs
     * redirect to returnStation.html
     */
    @RequestMapping(path="/returnStation/{id}")
    public String listrentedTools(@PathVariable(name = "id") int id,Model model)
    {

        Tool rentedTool = toolRepository.findById(id);
        List<Station> listStation= (List<Station>) stationRepository.findAll();

        model.addAttribute("listStation", listStation);
        model.addAttribute(rentedTool);

        return "returnStation";
    }


    /**
     * @return  returnSuccessful
     * controller with all necessary methods to return a tool
     * finish the bill, when all tools are returned for this bill
     * redirect to returnSuccessful.html
     */
    @PostMapping("/setReturnStation/{toolId}/{stationId}")
    public String returnATool(@PathVariable("toolId") int toolId,@PathVariable("stationId") int stationId)
    {
        //init object for return tool
        Station returnStation = stationRepository.findById(stationId);
        Tool renturnedTool = toolRepository.findById(toolId);
        NameControllerAdvice nameControllerAdvice = new NameControllerAdvice();
        int AccountId  = nameControllerAdvice.getAuthUser();
        Customer lendingCustomer = customerRepository.findByAccount_id(AccountId);
        Warehouse mainWarehouse = warehouseRepository.findById(WarehouseId);
        returnStation.addToolToBox(renturnedTool);
        // return tool method
        Rental.returnTool(renturnedTool,returnStation,lendingCustomer,mainWarehouse);

        // save data
        toolRepository.save(renturnedTool);
        lendingCustomer.getToolFromInventory(renturnedTool);
        //mainWarehouse.putToolInWarehouse(renturnedTool);
        customerRepository.save(lendingCustomer);
        stationRepository.save(returnStation);
        warehouseRepository.save(mainWarehouse);
        // make a difference if bill process is finished or not
        // par example with two tools the process is not finished when jut one tool is returned
        Bill finishedBill = Billing.findCheckedBillFromCustomer(lendingCustomer);
        if(finishedBill != null){
            RentProcess rentProcess = finishedBill.findRentProcess(renturnedTool);
            Billing.moveFromCheckToClosed(finishedBill);
            rentProcessRepository.save(rentProcess);
            billRepository.save(finishedBill);
        }
        else {
            Bill alreadyOpenBill = Billing.findOpenBillFromCustomer(lendingCustomer);
            RentProcess rentProcess = alreadyOpenBill.findRentProcess(renturnedTool);
            rentProcessRepository.save(rentProcess);
            billRepository.save(alreadyOpenBill);
        }

        //TODO: Delete???

//        final String baseDir = System.getProperty("user.dir");
//        System.out.println("About to convert html to pdf");
//        File output = new File(baseDir + "\\output.pdf");
//        ITextRenderer renderer = new ITextRenderer();
//
//        renderer.getSharedContext()
//                .setUserAgentCallback(new CustomOpenPdfUserAgent(renderer.getOutputDevice()));
//
//        renderer.setDocument("templates/billForm.html");
//        renderer.layout();
//        OutputStream outputStream = new FileOutputStream(output);
//        renderer.createPDF(outputStream);
//        outputStream.close();
//        System.out.println("Done");

        return "returnSuccessful";
    }

}
