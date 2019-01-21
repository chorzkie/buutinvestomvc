package com.buutcamp.configuration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebMvcInit implements WebApplicationInitializer {

    public void onStartup (ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext webctx = new AnnotationConfigWebApplicationContext();
        webctx.register(WebMvcConfig.class);

        ServletRegistration.Dynamic regs = servletContext.addServlet("springmvchibernate", new DispatcherServlet(webctx));
        servletContext.addListener(new SessionListener());
        regs.addMapping("/");
        regs.setLoadOnStartup(1);
    }

}
