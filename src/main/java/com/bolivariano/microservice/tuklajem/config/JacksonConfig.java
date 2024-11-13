package com.bolivariano.microservice.tuklajem.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfig {

    @Bean
    ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        // Configuración personalizada
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT); // Formato de salida legible
        objectMapper.registerModule(new JavaTimeModule()); 
        // objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS); // Fecha como ISO en vez de timestamps
        return objectMapper;
    }
}
