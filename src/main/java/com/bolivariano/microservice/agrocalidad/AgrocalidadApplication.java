package com.bolivariano.microservice.agrocalidad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.jms.annotation.EnableJms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication()
@EnableConfigurationProperties()
@EnableJms
public class AgrocalidadApplication {

    static final Logger logger = LoggerFactory.getLogger(AgrocalidadApplication.class);

    public static void main(String... args) {
        SpringApplication.run(AgrocalidadApplication.class, args);
        logger.info("📦 MicroService running");
    }

}