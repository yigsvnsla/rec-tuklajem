package com.bolivariano.microservice.tuklajem;

import com.bolivariano.microservice.tuklajem.config.MqConfig;
import com.bolivariano.microservice.tuklajem.services.JmsService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.annotation.EnableJms;


import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootApplication()
@EnableConfigurationProperties()
@EnableJms
public class TuklajemApplication {
    public static void main(String... args) {
        ApplicationContext ctx = SpringApplication.run(TuklajemApplication.class, args);

        // Obtén el servicio desde el contexto
        JmsService jmsService = ctx.getBean(JmsService.class);

        //jmsService.testMessage(MqConfig.CHANNEL_RESPONSE,"0000000000000");
        log.info("📦 MicroService running");
    }
}