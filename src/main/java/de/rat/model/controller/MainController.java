package de.rat.model.controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class MainController {

    protected static final String HEALTH_RESPONSE = "Yep, I'am here!";

    @RequestMapping("/test") //Index
    public String welcome() {
        return "indes.html";
    }

    @GetMapping("/health") //Index
    public String areYouAlive() {
        return HEALTH_RESPONSE;
    }

}
