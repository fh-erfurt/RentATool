package de.rat.model.controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = {"/"},method = RequestMethod.GET)
public class MainController {

    @GetMapping("") //Index
    public String welcome() {
        return "home";
    }

}
