package de.rat.model.controller;

import de.rat.model.Dummy;

import de.rat.storage.repository.DummyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(path="/dummy")
public class DummyController {
    @Autowired
    DummyRepository repo;

    @RequestMapping(path = "/dummy")
    public String home() {
        return "home.jsp";
    }

    @RequestMapping(path = "/addDummy")
    public String addTool(Dummy aDummy) {
        repo.save(aDummy);
        return "home.jsp";
    }

    @RequestMapping("/getDummy")
    public ModelAndView getDummy(@RequestParam int id) {
        ModelAndView mv = new ModelAndView("showTool.jsp");
        Dummy aDummy = repo.findById(id);
        mv.addObject(aDummy);
        return mv;
    }
}