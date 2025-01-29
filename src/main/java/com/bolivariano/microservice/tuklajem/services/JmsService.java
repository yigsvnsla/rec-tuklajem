package com.bolivariano.microservice.tuklajem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.bolivariano.microservice.tuklajem.dtos.MessageOutputProcessDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.jms.TextMessage;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class JmsService {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public void sendResponseMessage(String destination, MessageOutputProcessDTO messageContent, String correlationId)
            throws JsonProcessingException {

        String messageSerialized = this.objectMapper.writeValueAsString(messageContent); // Serialización

        String spaccer = "========================================";
        String spaccerTitle = "                RESPONSE                ";
        
        log.info(spaccer);
        log.info(spaccerTitle);
        log.info(spaccer);
        log.info("Correlation ID: " + correlationId);
        log.info(spaccer);
        log.info("Received message is: " + messageSerialized);
        log.info(spaccer);
    

        

        jmsTemplate.send(destination, session -> {
            TextMessage message = session.createTextMessage(messageSerialized); // Crear un mensaje de texto
            message.setJMSCorrelationID(correlationId); // Establecer el Correlation ID
            return message;
        });
    }

    public void sendRequestMessage(String destination, String messageContent, String correlationId) {
        jmsTemplate.send(destination, session -> {
            TextMessage message = session.createTextMessage(messageContent); // Crear un mensaje de texto
            message.setJMSCorrelationID(correlationId); // Establecer el Correlation ID
            return message;
        });
    }
}
