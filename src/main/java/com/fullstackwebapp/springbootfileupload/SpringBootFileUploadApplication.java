package com.fullstackwebapp.springbootfileupload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class SpringBootFileUploadApplication {
    @Bean
    public ServletRegistrationBean getServletRegistrationBean() {
        ServletRegistrationBean servletBean = new ServletRegistrationBean(new HelloServlet());
        servletBean.addUrlMappings("/helloServlet");
        return servletBean;
    }

    /// Register Filter.
    @Bean
    public FilterRegistrationBean getFilterRegistrationBean() {
        FilterRegistrationBean filterBean = new FilterRegistrationBean(new HelloFilter());
        // Add filter path
        filterBean.addUrlPatterns("/helloServlet");
        return filterBean;
    }

    @Bean
    public ServletListenerRegistrationBean<HelloListener> getServletListenerRegistrationBean() {
        ServletListenerRegistrationBean listenerBean =
                new ServletListenerRegistrationBean(new HelloListener());
        return listenerBean;
    }

    public static void main(String[] args) {
        /// Register Servlet.

        SpringApplication.run(SpringBootFileUploadApplication.class, args);

    }

}
