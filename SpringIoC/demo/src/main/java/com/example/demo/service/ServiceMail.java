package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;


public class ServiceMail implements InitializingBean, DisposableBean {
    public static final Logger logger = LoggerFactory.getLogger(ServiceMail.class);

    private final ServiceSender serviceSender;

    public ServiceMail(ServiceSender serviceSender) {
        this.serviceSender = serviceSender;
        logger.warn("Create def constructor");
    }

    @PostConstruct
    private void init() {
        logger.info("BROSAYU DYMCHATKU");
        serviceSender.sendEmail();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("Init bean");
        serviceSender.sendEmail();
    }

    @Override
    public void destroy() {
        logger.info("Destroy BEAN");
    }
}


