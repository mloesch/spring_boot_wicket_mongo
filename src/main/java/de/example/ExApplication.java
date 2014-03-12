package de.example;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.springframework.context.ApplicationContext;

public class ExApplication extends WebApplication {

    protected ApplicationContext context;

    public ExApplication(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public Class<? extends Page> getHomePage() {
        return Homepage.class;
    }
}
