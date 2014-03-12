package de.example;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * This class can be used to start the Application with an embedded server, as
 * opposed to deploying it as a WAR to a running server.
 */
public class AppStarter {

    /**
     * this main is only called when the application is run stand-alone.
     */
    public static void main(String[] args) {
        SpringApplicationBuilder applicationBuilder = new SpringApplicationBuilder();
        ConfigurableApplicationContext appContext = applicationBuilder.sources(ApplicationConfig.class).run(args);
    }

}
