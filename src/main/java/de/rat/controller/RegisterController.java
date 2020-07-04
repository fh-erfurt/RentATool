package de.rat.controller;

import de.rat.model.User;
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
        User user= new User();
        model.addAttribute("user",user);

        List<String> professionList = Arrays.asList("Developer","Designer", "Student");
        model.addAttribute("professionList",professionList);
        return "register_form";
    }
    //Ausgabe auf Browserebene
    @PostMapping("/register")
    public String submitForm(@ModelAttribute("user")User user){
        return  "register_success";
    }
    //save in DB
    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("user") User user) {
        repository.save(user);

        return "redirect:/";
    }
}
