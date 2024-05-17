package com.example.tkb.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;


@Configuration
public class MyMultipartConfig {


    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        // Customize resolver properties if needed
        resolver.setMaxUploadSize(5242880); // Set maximum file size (5MB)
        return resolver;
    }
    
   
}
