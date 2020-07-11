package de.rat.controller;

import de.rat.model.logistics.Manufacturer;
import de.rat.model.logistics.Tool;
import de.rat.storage.repository.ToolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.Arrays;
import java.util.List;

@Controller
public class ToolController {
    @Autowired
    ToolRepository repositoryTool;
    private static final Logger log = LoggerFactory.getLogger(ToolController.class);

    @RequestMapping(path="/toolManagement")
    public String listAllTools(Model model)
    {
        List<Tool> listTools= (List<Tool>) repositoryTool.findAll();

        model.addAttribute("listTools", listTools);

        return "toolManagement";
    }

    @RequestMapping(path="/tools")
    public String listAllTool(Model model)
    {
        List<Tool> listTools= (List<Tool>) repositoryTool.findAll();

        model.addAttribute("listTools", listTools);

        return "tools";
    }

    @PostMapping("/addTool")
    public String addTool(@ModelAttribute("tool") Tool aTool)
    {

        repositoryTool.save(aTool);
        return "redirect:/toolManagement";
    }

    @PostMapping("/updateTool")
    public String editTool(@ModelAttribute("tool") Tool aTool, @ModelAttribute("id") int id)
    {
        Tool oldTool = repositoryTool.findById(id);
        oldTool.setDescription(aTool.getDescription());
        oldTool.setRentPrice(aTool.getRentPrice());
        repositoryTool.save(oldTool);
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

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditToolPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("editTool");
        Tool tool = repositoryTool.findById(id);
        mav.addObject("tool", tool);
        mav.addObject("id", tool.getId());

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteTool(@PathVariable(name = "id") int id) {
        repositoryTool.deleteById(id);
        return "redirect:/tools";
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
