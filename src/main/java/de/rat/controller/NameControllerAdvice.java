//package de.rat.controller;
//
//import de.rat.account.details.AccountDetails;
//import de.rat.account.details.AccountDetailsService;
//import de.rat.account.details.PersonDetails;
//import de.rat.model.common.Account;
//import org.apache.catalina.Manager;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ModelAttribute;
//
//@ControllerAdvice
//public class NameControllerAdvice {
//
//    @ModelAttribute
//    public void addBugetToModel(Model model) {
//
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth != null) {
//            Object principal = auth.getPrincipal();
//            if (principal instanceof PersonDetails) {
//                PersonDetails person = (PersonDetails) principal;
//                String username1 = person.ge;
//                model.addAttribute("authUserName", username1);
//
//            }
//        }
//
//    }
//}