package de.rat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/** Controller for all pages they are handle with the Error
 * sets parameter and generate the data for the views

 * @author Marco Petzold, Christian König, Danny Steinbrecher
 */
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
