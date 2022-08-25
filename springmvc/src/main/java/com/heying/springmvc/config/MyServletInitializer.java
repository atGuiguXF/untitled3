package com.heying.springmvc.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * web.xml
 */
public class MyServletInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        FilterRegistration.Dynamic characterEncodingFilter = servletContext.addFilter("characterEncodingFilter",
                CharacterEncodingFilter.class);
        characterEncodingFilter.setInitParameter("encoding", "utf-8");
        characterEncodingFilter.addMappingForUrlPatterns(null, false, "/*");
    }

}
