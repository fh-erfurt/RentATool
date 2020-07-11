package de.rat.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class LoginController {


    @GetMapping("/login") //Index
    public String welcome() {
        return "loginForm";
    }

    @GetMapping(value = "/loginSuccessfull")
    public String currentUserName(Authentication authentication) {
        return "redirect:/";
    }
    }
