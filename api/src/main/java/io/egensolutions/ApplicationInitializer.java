package io.egensolutions;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
   // @Qualifier()

    protected Class<?>[] getRootConfigClasses() {

        Class[] c ={Application.class,AlertsJPAConfiguration.class,VehicleJPAConfiguration.class,ReadingsJPAConfiguration.class};
        System.out.println("Hello");
        return c;
    }


    protected Class<?>[] getServletConfigClasses() {
        return new Class[0];
    }

    protected String[] getServletMappings() {
        return new String[]{"/api/*"};
    }
}
