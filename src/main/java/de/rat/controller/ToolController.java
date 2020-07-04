package de.rat.controller;

import de.rat.model.User;
import de.rat.model.logistics.Tool;
import de.rat.storage.repository.ToolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ToolController {
    @Autowired
    ToolRepository repo;

    @RequestMapping(path="/tools")
    public String listAllTools(Model model)
    {
        List<Tool> listTools= (List<Tool>) repo.findAll();
        model.addAttribute("listTools", listTools);
        return "showTool";
    }

    @PostMapping("/addTool")
    public String addTool(@ModelAttribute("tool") Tool aTool)
    {
        repo.save(aTool);
        return "redirect:/tools";
    }

    @RequestMapping("/new")
    public String showNewProductPage(Model model) {
        Tool tool = new Tool();
        model.addAttribute("tool", tool);

        return "addTool";
    }
    @RequestMapping("/getTool")
    public ModelAndView getTool(@RequestParam int id)
    {
        ModelAndView mv=new ModelAndView("showTool");
        Tool tool= repo.findById(id);
        mv.addObject(tool);
        return mv;
    }

}
