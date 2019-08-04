package com.example.demo.configuration;

import com.example.demo.service.ServiceMail;
import com.example.demo.service.ServiceSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(BaseConfiguration.class)
@Configuration
public class ChildConfig {
    @Autowired
    private ServiceSender serviceSender;

    @Bean
    public ServiceMail serviceMail() {
        return new ServiceMail(serviceSender);
    }
}
