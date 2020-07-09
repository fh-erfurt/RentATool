package de.rat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/").setViewName("index");
        registry.addViewController("/register").setViewName("register_form");
        registry.addViewController("/login").setViewName("login");

        registry.addViewController("/ADMIN").setViewName("ADMIN");
        registry.addViewController("/EMPLOYEE").setViewName("EMPLOYEE");
        registry.addViewController("/CUSTOMER").setViewName("CUSTOMER");
        registry.addViewController("/START").setViewName("START");
        registry.addViewController("/ERROR").setViewName("ERROR2");

    }


}