package de.rat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {

    @GetMapping("/error")
    public String error() {
        return "error";
    }

    @GetMapping("/error403")
    public String error403() {
        return "error403";
    }
}
