package com.bolivariano.microservice.agrocalidad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.jms.annotation.EnableJms;


import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootApplication()
@EnableConfigurationProperties()
@EnableJms
public class AgrocalidadApplication {


    public static void main(String... args) {
        SpringApplication.run(AgrocalidadApplication.class, args);
        log.info("📦 MicroService running");
    }

}

// DATOS PARA LAS PRUEBAS:

// Número   Contrato Nombre

// 22004422 Byron Suarez

// 22004455 Sebastian Rosado

// 22004466 Ramon Cedeño

// 22004477 Gonzalo Fienco