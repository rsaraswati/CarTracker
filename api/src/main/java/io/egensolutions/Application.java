package io.egensolutions;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan

public class Application extends WebMvcConfigurerAdapter {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        try {
            //System.out.println("application");
                    registry.addMapping("/api/**/*")
                    .allowedOrigins("http://mocker.egen.io")
                    .allowedMethods("GET", "PUT", "POST", "DELETE", "OPTIONS")
                    .allowedHeaders("header1", "header2", "header3")
                    .exposedHeaders("header1", "header2")
                    .allowCredentials(false).maxAge(3600);
        }
        catch(Exception e){
             System.out.println("Error");
        }
    }
}
