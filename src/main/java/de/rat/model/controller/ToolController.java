package de.rat.model.controller;

import de.rat.model.logistics.Tool;
import de.rat.storage.repository.ToolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path="/tool")
public class ToolController {
    @Autowired
    ToolRepository repo;

    @RequestMapping(path="/tool")
    public String home()
    {
        return "home.jsp";
    }
    @RequestMapping(path="/addTool")
    public String addTool(Tool aTool)
    {
        repo.save(aTool);
        return "home.jsp";
    }
    @RequestMapping("/getTool")
    public ModelAndView getDummy(@RequestParam int id)
    {
        ModelAndView mv=new ModelAndView("showTool.jsp");
        Tool tool= repo.findById(id);
        mv.addObject(tool);
        return mv;
    }



}
