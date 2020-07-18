package de.rat.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.ServletException;

/** managed the web security
 * generate the access to the pages
 * has a password hash method

 * @author Marco Petzold, Christian König, Danny Steinbrecher
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService accountDetailsService;

    /**
     * @return   HttpSessionEventPublisher
     */
    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher() {
        return new HttpSessionEventPublisher();
    }

    /**
     * @return   CustomAccessDeniedHandler
     */
    @Bean
    public AccessDeniedHandler accessDeniedHandler(){
        return new CustomAccessDeniedHandler();
    }

    /**
     * @return   BCryptPasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(accountDetailsService);
    }

    /**
     * @param  http HttpSecurity
     * @throws Exception Exception
     * configure the ccess to the pages
     * configure the login
     * configure the logout
     * configure the accessDeniedHandler
     * configure the SessionCreationPolicy
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                    .antMatchers("/", "/home", "/START", "/logout", "h2-console/**").permitAll()
                    .antMatchers("/userManagement").hasRole("ADMIN")
                    .antMatchers("/EMPLOYEE").hasAnyRole("EMPLOYEE", "ADMIN")
                    .antMatchers("/CUSTOMER", "/tools/*").hasAnyRole("CUSTOMER","EMPLOYEE", "ADMIN")
                    .and()

                .formLogin()
                    .loginPage("/login")
                    .failureUrl("/login?error")
                    .usernameParameter("username").passwordParameter("password")
                    .defaultSuccessUrl("/loginSuccessfull",true)
                    .permitAll()
                    .and()

                .logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/login?logout")
                    .and()

                .exceptionHandling()
                    .accessDeniedHandler(accessDeniedHandler()).and()

                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);

        http.csrf().disable();
        http.headers().frameOptions().disable();
    }
}
