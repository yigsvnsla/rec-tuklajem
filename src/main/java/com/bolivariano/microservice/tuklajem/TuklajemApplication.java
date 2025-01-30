package com.bolivariano.microservice.tuklajem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.jms.annotation.EnableJms;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootApplication()
@EnableConfigurationProperties()
@EnableJms
public class TuklajemApplication {
    public static void main(String... args) {
        // Deshabilitar los logs de IBM MQ
        System.setProperty("com.ibm.msg.client.commonservices.log.disable", "true");
        System.setProperty("com.ibm.msg.client.commonservices.log.status", "OFF");
        
        SpringApplication.run(TuklajemApplication.class, args);
        
        log.info("📦 MicroService running");
    }
}