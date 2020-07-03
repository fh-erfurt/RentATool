package de.rat.controller;

import de.rat.model.logistics.Tool;
import de.rat.storage.repository.ToolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ToolController {
    @Autowired
    ToolRepository repo;

    @RequestMapping(path="/tool")
    public String welcomeTool()
    {
        return "addTool";
    }
    @RequestMapping(path="/addTool")
    public String addTool(Tool aTool)
    {
        repo.save(aTool);
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
    @RequestMapping("/deleteTool")
    public String deleteTool(@PathVariable int id){

        repo.deleteToolById(id);
        return "deleteTool";
    }

//ToDO

}
