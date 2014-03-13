package de.example;

import org.apache.wicket.protocol.http.WicketFilter;
import org.springframework.beans.BeansException;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
// Autoconfiguration creates missing spring beans if necessary
@EnableAutoConfiguration
@Import({
        ServiceConfig.class
})
public class ApplicationConfig implements ApplicationContextAware {

    protected ApplicationContext context;

    protected ApplicationContext getContext() {
        return context;
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    @Bean
    public FilterRegistrationBean wicketFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        WicketFilter filter = new WicketFilter(new ExApplication(context));
        filter.setFilterPath("");
        bean.setFilter(filter);
        bean.addUrlPatterns("/*");
        return bean;
    }


    @Bean
    public DispatcherServlet getDispatcherServlet() {
        return new DispatcherServlet();
    }

    @Bean
    public ServletRegistrationBean dispatcherRegistration(DispatcherServlet dispatcherServlet) {
        ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet);
        registration.addUrlMappings("/rest/*");
        return registration;
    }

}
