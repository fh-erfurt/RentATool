package de.rat.controller;

import de.rat.model.logistics.Station;
import de.rat.model.logistics.Tool;
import de.rat.storage.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class StationController {
    @Autowired
    StationRepository stationRepository;

    @RequestMapping(path="/setStation")
    public String listAllTools(Model model)
    {
        List<Station> listStation= (List<Station>) stationRepository.findAll();

        model.addAttribute("listStation", listStation);

        return "chooseStation";
    }
}
