package de.rat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // TODO: delete this Config, because we route this in our controller
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/ADMIN").setViewName("ADMIN");
        registry.addViewController("/EMPLOYEE").setViewName("EMPLOYEE");
        registry.addViewController("/CUSTOMER").setViewName("CUSTOMER");
        registry.addViewController("/START").setViewName("START");

    }
}