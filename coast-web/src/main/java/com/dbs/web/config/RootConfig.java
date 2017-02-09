package com.dbs.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by aiqbal on 12/30/2016.
 */
@Configuration
//@EnableWebMvc
@ComponentScan(basePackages = "com.dbs.web")
@Import({WebConfig.class})
public class RootConfig {

}
