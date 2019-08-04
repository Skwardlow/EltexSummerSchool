package com.example.demo.configuration;

import com.example.demo.service.ServiceMail;
import com.example.demo.service.ServiceSender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseConfiguration {
    @Bean
    public ServiceSender serviceSender(){
        return new ServiceSender();
    }

}
