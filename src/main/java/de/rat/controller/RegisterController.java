package de.rat.controller;

import de.rat.model.tesrUser;
import de.rat.storage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class RegisterController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/register")
    public String showForm(Model model) {
        tesrUser tesrUser = new tesrUser();
        model.addAttribute("user", tesrUser);

        List<String> professionList = Arrays.asList("Developer","Designer", "Student");
        model.addAttribute("professionList",professionList);
        return "register_form";
    }
    //Ausgabe auf Browserebene
    @PostMapping("/register")
    public String submitForm(@ModelAttribute("user") tesrUser tesrUser){
        return  "register_success";
    }
    //save in DB
    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("user") tesrUser tesrUser) {
        repository.save(tesrUser);

        return "redirect:/";
    }
}
