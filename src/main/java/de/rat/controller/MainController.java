package de.rat.controller;
import de.rat.model.User;
import de.rat.storage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

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
