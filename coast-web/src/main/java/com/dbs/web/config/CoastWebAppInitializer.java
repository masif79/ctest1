package com.dbs.web.config;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by aiqbal on 12/30/2016.
 */
public class CoastWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected String[] getServletMappings() {

        System.out.println("getServletMappings called");

        return new String[] { "/" };
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {

        System.out.println("getRootConfigClasses called");

        loadLogging();

        return new Class<?>[] { RootConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {

        System.out.println("getServletConfigClasses called");

//        return new Class<?>[] {
//
//            WebConfig.class
//        };
        return null;
    }

    private void loadLogging() {

        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();

        try {

            JoranConfigurator configurator = new JoranConfigurator();
            configurator.setContext(loggerContext);
            loggerContext.reset();
            configurator.doConfigure("\\coast\\logback.xml"); // loads logback file
        } catch (JoranException je) {
            // StatusPrinter will handle this
        } catch (Exception ex) {

            ex.printStackTrace(); // Just in case, so we see a stacktrace

        }
        StatusPrinter.printInCaseOfErrorsOrWarnings(loggerContext); // Internal status data is printed in case of warnings or errors.
    }
}
