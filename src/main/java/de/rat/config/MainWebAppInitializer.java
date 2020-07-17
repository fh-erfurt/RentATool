package de.rat.config;

import org.springframework.web.WebApplicationInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/** Session Cookie Configuration
 * sets some safety configurations for the session cookie

 * @author Marco Petzold, Christian König, Danny Steinbrecher
 */
public class MainWebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext sc) throws ServletException {
        sc.getSessionCookieConfig().setHttpOnly(true);
        sc.getSessionCookieConfig().setSecure(true);
    }
}
