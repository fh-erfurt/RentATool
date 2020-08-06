package de.rat.controller;

import de.rat.model.logistics.Manufacturer;
import de.rat.model.logistics.Tool;
import de.rat.model.logistics.ToolStatus;
import de.rat.model.logistics.Warehouse;
import de.rat.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.Arrays;
import java.util.List;

/** Controller for all pages they are handle with the Tools
 * sets parameter and generate the data for the views

 * @author Marco Petzold, Christian König, Danny Steinbrecher
 */
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


    /**
     * @return  toolManagement
     * gets all tools
     * add all attributes to the model
     * redirect to toolManagement.html
     */
    @RequestMapping(path="/toolManagement")
    public String listAllTools(Model model)
    {
        List<Tool> listTools= (List<Tool>) toolRepository.findAll();
        model.addAttribute("listTools", listTools);
        return "toolManagement";
    }

    /**
     * @return  tools
     * gets all tools
     * add all attributes to the model
     * redirect to tools.html
     */
    @RequestMapping(path="/tools")
    public String listAllTool(Model model)
    {
        List<Tool> listTools= (List<Tool>) toolRepository.findAll();
        model.addAttribute("listTools", listTools);
        return "tools";
    }

    /**
     * @return  toolManagement
     * @param aTool Tool
     * save the Tool in the Database
     * redirect to toolManagement.html
     */
    @PostMapping("/addTool")
    public String addTool(@ModelAttribute("tool") Tool aTool)
    {
        Warehouse mainWarehouse = warehouseRepository.findById(10000);
        if(aTool.getToolStatus() == ToolStatus.AVAILABLE) {
            mainWarehouse.putToolInWarehouse(aTool);
        }
        toolRepository.save(aTool);

        return "redirect:/toolManagement";
    }

    /**
     * @return  mav
     * @param id int
     * shows the Tool which will be edit
     */
    @RequestMapping("/editTool/{id}")
    public ModelAndView showEditToolPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("editTool");
        Tool tool = toolRepository.findById(id);
        mav.addObject("tool", tool);
        mav.addObject("id", tool.getId());

        return mav;
    }

    /**
     * @return  toolManagement
     * @param aTool Tool
     * @param id int
     * update the Tool in the Database
     * redirect to toolManagement.html
     */
    @PostMapping("/updateTool")
    public String editTool(@ModelAttribute("tool") Tool aTool, @ModelAttribute("id") int id)
    {
        Tool oldTool = toolRepository.findById(id);
        oldTool.setDescription(aTool.getDescription());
        oldTool.setRentPrice(aTool.getRentPrice());
        toolRepository.save(oldTool);
        return "redirect:/toolManagement";
    }


    /**
     * @return  addTool
     * @param model Model
     * @param manufacturer Manufacturer
     * create a new Tool in the Database
     * redirect to addTool.html
     */
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


    /* TODO: create Method to make a tool inactive


       /**
         * @return  toolManagement
         * @param id int
         * delete a new Tool from the Database
         * redirect to toolManagement.html
         /
        @RequestMapping("/delete/{id}")
        public String deleteTool(@PathVariable(name = "id") int id) {
            toolRepository.deleteById(id);
            return "redirect:/toolManagement";
        }

    */


    /**
     * deliver toolId to next view
     */
    @PostMapping("/addToInventory/{id}")
    public String addToInventory(@PathVariable(name = "id") int id){

        // just neccessary to deliver toolId to next view
       return"chooseStation";
    }

    /**
     * deliver toolId to next view
     */
    @PostMapping("/returnTool/{id}")
    public String returnTool(@PathVariable(name = "id") int id){

        return"returnStation";
    }
}
