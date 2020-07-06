package de.rat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler(
//                "/webjars/**",
//                "/img/**",
//                "/css/**",
//                "/js/**")
//                .addResourceLocations(
//                        "classpath:/META-INF/resources/webjars/",
//                        "classpath:/static/img/",
//                        "classpath:/static/css/",
//                        "classpath:/static/js/");
//    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/*", "/js/**", "/css/**", "/images/**").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
////                .loginPage("")
//                .permitAll()
//                .and()
//                .logout();
//
//    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password(passwordEncoder().encode("password")).roles("ADMIN").and()

                .withUser("employee")
                .password(passwordEncoder().encode("password")).roles("EMPLOYEE").and()

                .withUser("customer")
                .password(passwordEncoder().encode("password")).roles("CUSTOMER");;
    }



    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // level administrator
        http.authorizeRequests()
                .antMatchers("/ADMIN").hasRole("ADMIN")
                .and().formLogin().permitAll();

        // level employee
        http.authorizeRequests()
                .antMatchers("/EMPLOYEE").hasAnyRole("EMPLOYEE", "ADMIN")
                .and().formLogin().permitAll();

        // level customer
        http.authorizeRequests()
                .antMatchers("/CUSTOMER").hasAnyRole("CUSTOMER","EMPLOYEE", "ADMIN")
                .and().formLogin().permitAll();

        // level unknown user
        http.authorizeRequests()
                .antMatchers("/", "/home", "/START").permitAll();

        // logout
        http.logout().logoutUrl("/logout")
                .logoutSuccessUrl("/START");
    }




}
