package com.dbs.web.controller;

import com.dbs.common.util.DateFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by aiqbal on 1/3/2017.
 */
@RestController
@RequestMapping(path = "/welcomeController")
public class WelcomeController {

    private static final Logger logger = LoggerFactory.getLogger(WelcomeController.class);

    @RequestMapping(
        produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public String welcome() {

        System.out.println("welcome called");

        logger.debug("Current date is: ", DateFactory.getCurrentDate());

        //logger.error("This is Error message", new Exception("Testing"));

        //model.addAttribute("msg", "Hello Spring MVC + Logback");
        return "welcome";

    }

}
