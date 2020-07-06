package de.rat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

        http
                .authorizeRequests()
                    .antMatchers("/", "/home", "/START", "/logout", "/ERROR","/404")
                    .permitAll()
                    .antMatchers("/ADMIN").hasRole("ADMIN")
                    .antMatchers("/EMPLOYEE").hasAnyRole("EMPLOYEE", "ADMIN")
                    .antMatchers("/CUSTOMER").hasAnyRole("CUSTOMER","EMPLOYEE", "ADMIN")
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .failureUrl("/login?error")
                    .defaultSuccessUrl("/START")
                    .permitAll()
                    .and()
                .logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/login?logout")
                    .and()
                .exceptionHandling()
                    .accessDeniedHandler(new CustomAccessDeniedHandler()).and()
                    .exceptionHandling().authenticationEntryPoint(new CustomHttp403ForbiddenEntryPoint())
                    .accessDeniedPage("/ERROR");;




//
//
//        // level administrator
//        http.authorizeRequests()
//                .antMatchers("/ADMIN").hasRole("ADMIN")
//                .and().formLogin().permitAll();
//
//        // level employee
//        http.authorizeRequests()
//                .antMatchers("/EMPLOYEE").hasAnyRole("EMPLOYEE", "ADMIN")
//                .and().formLogin().permitAll();
//
//        // level customer
//        http.authorizeRequests()
//                .antMatchers("/CUSTOMER").hasAnyRole("CUSTOMER","EMPLOYEE", "ADMIN")
//                .and().formLogin().permitAll();
//
//        // level unknown user
//        http.authorizeRequests()
//                .antMatchers("/", "/home", "/START", "/logout", "/ERROR").permitAll();
//
//        // deny accsecc to all other sites
//        http.authorizeRequests().antMatchers("/*").denyAll();
//
//
//        http.exceptionHandling()
//                .accessDeniedHandler(new CustomAccessDeniedHandler()).and()
//                .exceptionHandling().authenticationEntryPoint(new CustomHttp403ForbiddenEntryPoint())
//                .accessDeniedPage("/ERROR");;
//
//        // logout
//        http.logout().logoutUrl("/logout")
//                .logoutSuccessUrl("/START");

    }

    public static class CustomHttp403ForbiddenEntryPoint implements AuthenticationEntryPoint {

        @Override
        public void commence(HttpServletRequest request, HttpServletResponse response,
                             AuthenticationException authException) throws IOException {
            response.sendError(HttpServletResponse.SC_FORBIDDEN,"Access denied");
        }

    }

    public static class CustomAccessDeniedHandler implements AccessDeniedHandler {

        @Override
        public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException arg2) {}

    }




}
