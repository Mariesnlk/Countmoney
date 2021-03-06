package com.mariia.syne.splitwise.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/ui/create").setViewName("create");
        registry.addViewController("/ui/list").setViewName("list");
        registry.addViewController("/ui/read").setViewName("read");
        registry.addViewController("/ui/update").setViewName("update");
        registry.addViewController("/about").setViewName("about");
        registry.addViewController("/contacts").setViewName("contacts");


    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(
                "/static/images/**",
                "/static/css/**",
                "/static/js/**")
                .addResourceLocations(
                        "classpath:/static/images/",
                        "classpath:/static/css/",
                        "classpath:/static/js/");
    }
}