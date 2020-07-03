package de.rat.controller;

import de.rat.model.Dummy;

import de.rat.storage.exceptions.DummyNotFoundException;
import de.rat.storage.repository.DummyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class DummyController {
    @Autowired
    DummyRepository repository;
//
//    @GetMapping("/dummies")
//    List<Dummy> all() {
//        return (List<Dummy>) repository.findAll();
//    }
//
//    @PostMapping("/dummies")
//    Dummy newEmployee(@RequestBody Dummy newDummy) {
//        return repository.save(newDummy);
//    }
//
//    // Single item
//
//    @GetMapping("/dummies/{id}")
//    Dummy one(@PathVariable Long id) {
//
//        return repository.findById(id)
//                .orElseThrow(() -> new DummyNotFoundException(id));
//    }
//
//    @PutMapping("/dummies/{id}")
//    Dummy replaceEmployee(@RequestBody Dummy newDummy, @PathVariable Long id) {
//
//        return repository.findById(id)
//                .map(employee -> {
//                    employee.setName(newDummy.getName());
//                    return repository.save(newDummy);
//                })
//                .orElseGet(() -> {
//                    newDummy.setId(id);
//                    return repository.save(newDummy);
//                });
//    }
//    @DeleteMapping("/dummies/{id}")
//    void deleteDummy(@PathVariable Long id) {
//        repository.deleteById(id);
//    }

    @GetMapping("/dummy")
    public String welcomeDummy() {
        return "addDummy";
    }

    @GetMapping("/addDummy")
    public String addDummy(Dummy aDummy) {
        repository.save(aDummy);
        return "addDummy";
    }

    @RequestMapping(path="/getDummy")
    public ModelAndView getDummy(@RequestParam int id) {
        ModelAndView mv = new ModelAndView("showDummy");
        Dummy aDummy = repository.findById(id);
        mv.addObject(aDummy);
        return mv;
    }
}