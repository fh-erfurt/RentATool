package de.rat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/** Controller for all pages they are handle with the Index
 * sets parameter and generate the data for the views

 * @author Marco Petzold, Christian König, Danny Steinbrecher
 */
@Controller
public class MainController {

    /**
     * @return  index
     * redirect to index.html
     */
    @GetMapping("/") //Index
    public String welcome() {
        return "index";
    }
}
