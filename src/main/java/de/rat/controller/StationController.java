package de.rat.controller;

import de.rat.model.logistics.*;
import de.rat.storage.repository.StationRepository;
import de.rat.storage.repository.ToolRepository;
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
        Station rentStation = stationRepository.findById(stationId);
        Tool rentedTool = toolRepository.findById(toolId);


        return "rentSuccessful";
    }
}
