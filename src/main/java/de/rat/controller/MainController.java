package de.rat.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {


    @GetMapping("/") //Index
    public String welcome() {
        return "index";
    }


    @GetMapping("/health")
    public ResponseEntity<String> areYouAlive() {
            return new ResponseEntity<String>("Yep, I'am here!Everything is fine", HttpStatus.OK);
    }

}
