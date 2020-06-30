package de.rat.controller;

import de.rat.model.Dummy;

import de.rat.storage.repository.DummyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class DummyController {
    @Autowired
    DummyRepository repo;

    @RequestMapping(path = "/dummy")
    public String welcomeDummy() {
        return "addDummy";
    }

    @RequestMapping(path = "/addDummy")
    public String addDummy(Dummy aDummy) {
        repo.save(aDummy);
        return "addDummy";
    }

    @RequestMapping("/getDummy")
    public ModelAndView getDummy(@RequestParam int id) {
        ModelAndView mv = new ModelAndView("showDummy");
        Dummy aDummy = repo.findById(id);
        mv.addObject(aDummy);
        return mv;
    }
}