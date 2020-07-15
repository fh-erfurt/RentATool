package de.rat.controller;

import de.rat.model.Rental;
import de.rat.model.billing.Bill;
import de.rat.model.billing.Billing;
import de.rat.model.customer.Customer;
import de.rat.model.customer.RentProcess;
import de.rat.model.logistics.Manufacturer;
import de.rat.model.logistics.Station;
import de.rat.model.logistics.Tool;
import de.rat.model.logistics.Warehouse;
import de.rat.storage.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
public class ToolController {

    @Autowired
    ToolRepository toolRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    WarehouseRepository warehouseRepository;
    @Autowired
    StationRepository stationRepository;
    @Autowired
    RentProcessRepository rentProcessRepository;
    @Autowired
    BillRepository billRepository;
    @Autowired
    BillingRepository billingRepository;

    private static final Logger log = LoggerFactory.getLogger(ToolController.class);

    @RequestMapping(path="/toolManagement")
    public String listAllTools(Model model)
    {
        List<Tool> listTools= (List<Tool>) toolRepository.findAll();

        model.addAttribute("listTools", listTools);

        return "toolManagement";
    }

    @RequestMapping(path="/tools")
    public String listAllTool(Model model)
    {
        List<Tool> listTools= (List<Tool>) toolRepository.findAll();
        List<Station> stationList= (List<Station>) stationRepository.findAll();

        Station station1 = stationRepository.findById(1);
        Station station2 = stationRepository.findById(2);
        Station station3 = stationRepository.findById(3);
        model.addAttribute("station",station1);
        model.addAttribute("station",station2);
        model.addAttribute("station",station3);
        model.addAttribute("stationList", stationList);
        model.addAttribute("listTools", listTools);
        return "tools";
    }




    @PostMapping("/addTool")
    public String addTool(@ModelAttribute("tool") Tool aTool)
    {

        toolRepository.save(aTool);
        return "redirect:/toolManagement";
    }

    @PostMapping("/updateTool")
    public String editTool(@ModelAttribute("tool") Tool aTool, @ModelAttribute("id") int id)
    {

        Tool oldTool = toolRepository.findById(id);
        oldTool.setDescription(aTool.getDescription());
        oldTool.setRentPrice(aTool.getRentPrice());
        toolRepository.save(oldTool);
        return "redirect:/toolManagement";
    }


    @RequestMapping("/newTool")
    public String showNewProductPage(Model model,@ModelAttribute Manufacturer manufacturer) {
        Tool tool = new Tool();
        List<String> categoryList = Arrays.asList("ELECTRICALTOOL", "ACCUTOOL", "HANDTOOL", "GARDENTOOL");
        List<String> statusList = Arrays.asList("AVAILABLE", "ISRENTED", "ISBROKEN", "ISINREPAIR");
        List<String> manuList = Arrays.asList("Bosch", "Makita", "DeWalt", "Parkside");
        model.addAttribute("categoryList",categoryList);
        model.addAttribute("statusList",statusList);
        model.addAttribute("tool", tool);
        model.addAttribute("manuList",manuList);

        return "addTool";
    }

    @RequestMapping("/editTool/{id}")
    public ModelAndView showEditToolPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("editTool");
        Tool tool = toolRepository.findById(id);
        mav.addObject("tool", tool);
        mav.addObject("id", tool.getId());

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteTool(@PathVariable(name = "id") int id) {
        toolRepository.deleteById(id);
        return "redirect:/toolManagement";
    }

    @PostMapping("/rentTool/{id}/{stationId}")
    public String addToCart(@PathVariable(name = "id") int id,@PathVariable(name = "stationId") int stationId){


       NameControllerAdvice nameControllerAdvice = new NameControllerAdvice();
       int AccountId  = nameControllerAdvice.getAuthUser();

       Customer customer = customerRepository.findByAccount_id(AccountId);
       Tool reservedTool = toolRepository.findById(id);
       Warehouse warehouse = warehouseRepository.findById(1);
       warehouse.putToolInWarehouse(reservedTool);
       Station rentStation = stationRepository.findById(stationId);

       customer.putToolInInventory(reservedTool);

       Rental.rentATool(reservedTool,rentStation,customer,warehouse);
       toolRepository.save(reservedTool);
       customerRepository.save(customer);
       stationRepository.save(rentStation);
       warehouseRepository.save(warehouse);

       Bill custBill = Billing.findOrCreateBill(customer,rentStation);
       //ToDo save an optional class repository
//       if(custBill.getBillNumber() == 0) {
//           RentProcess custRentProcess = custBill.findRentProcess(reservedTool);
//           rentProcessRepository.save(custRentProcess);
//           billRepository.save(custBill);
//       }else {
//           Bill existingCustBill = billRepository.findById(custBill.getBillNumber());
//           RentProcess custRentProcess = custBill.findRentProcess(reservedTool);
//           rentProcessRepository.save(custRentProcess);
//           final S save = billRepository.save(existingCustBill);
//       }



       return"rentSuccessful";
    }


//    @RequestMapping("/getTool")
//    public ModelAndView getTool(@RequestParam int id)
//    {
//        ModelAndView mv=new ModelAndView("showTool");
//        Tool tool= repo.findById(id);
//        mv.addObject(tool);
//        return mv;
//    }

}
