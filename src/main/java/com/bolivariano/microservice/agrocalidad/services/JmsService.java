package com.bolivariano.microservice.agrocalidad.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.bolivariano.microservice.agrocalidad.dtos.MessageOutputProcessDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.jms.TextMessage;

@Service
public class JmsService {
    
    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public void sendMessage(String destination, MessageOutputProcessDTO messageContent, String correlationId) throws JsonProcessingException {

        String messageSerialized = this.objectMapper.writeValueAsString(messageContent); // Serialización

        jmsTemplate.send(destination, session -> {
            TextMessage message = session.createTextMessage(messageSerialized); // Crear un mensaje de texto
            message.setJMSCorrelationID(correlationId); // Establecer el Correlation ID
            return message;
        });
    }
}
