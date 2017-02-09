package com.dbs.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by aiqbal on 12/30/2016.
 */
@Configuration
@EnableWebMvc
//@EnableSpringDataWebSupport
//@ComponentScan("com.dbs.web.controller")
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void configureDefaultServletHandling(
        DefaultServletHandlerConfigurer configurer) {

        System.out.println("configureDefaultServletHandling called");
        configurer.enable();
    }

}
