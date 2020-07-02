package de.rat.controller;

import de.rat.model.Dummy;
import de.rat.model.logistics.Tool;
import de.rat.storage.exceptions.DummyNotFoundException;
import de.rat.storage.exceptions.ToolNotFoundException;
import de.rat.storage.repository.DummyRepository;
import de.rat.storage.repository.ToolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class ToolController {
    @Autowired
    ToolRepository repository;

    @GetMapping("/tools")
    List<Tool> all() {
        return (List<Tool>) repository.findAll();
    }

    @PostMapping("/tools")
    Tool newTool(@RequestBody Tool newTool) {
        return repository.save(newTool);
    }

    // Single item

    @GetMapping("/tools/{id}")
    Tool one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new ToolNotFoundException(id));
    }

    @PutMapping("/tools/{id}")
    Tool replaceEmployee(@RequestBody Tool newTool, @PathVariable Long id) {

        return repository.findById(id)
                .map(Tool -> {
                    Tool.setDescription(newTool.getDescription());
                    return repository.save(newTool);
                })
                .orElseGet(() -> {
                    //newTool.setid);
                    return repository.save(newTool);
                });
    }
    @DeleteMapping("/tools/{id}")
    void deleteTool(@PathVariable Long id) {
        repository.deleteById(id);
    }


//    @Autowired
//    ToolRepository repository;
//
//    @GetMapping(path="/tool")
//    public String welcomeTool()
//    {
//        return "addTool";
//    }
//    @GetMapping(path="/addTool")
//    public String addTool(Tool aTool)
//    {
//        repository.save(aTool);
//        return "addTool";
//    }
//    @RequestMapping(path="/getTool")
//    public ModelAndView getTool(@RequestParam int id)
//    {
//        ModelAndView mv=new ModelAndView("showTool");
//        Tool tool= repository.findById(id);
//        mv.addObject(tool);
//        return mv;
//    }
//    @GetMapping("/deleteTool")
//    public String deleteTool(@PathVariable int id){
//
//        repository.deleteToolById(id);
//        return "deleteTool";
//    }



}
