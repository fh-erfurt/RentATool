package de.rat.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    protected static final String HEALTH_RESPONSE = "Yep, I'am here!";

    @RequestMapping("/") //Index
    public String welcome() {
        return "index";
    }

    @GetMapping("/health") //Index
    public String areYouAlive() {
        return HEALTH_RESPONSE;
    }

}
