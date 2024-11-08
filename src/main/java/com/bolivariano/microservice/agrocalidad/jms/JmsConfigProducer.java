package com.bolivariano.microservice.agrocalidad.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import jakarta.jms.TextMessage;

@Service
public class JmsConfigProducer {
    
    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMessage(String destination, String messageContent, String correlationId) {
        jmsTemplate.send(destination, session -> {
            TextMessage message = session.createTextMessage(messageContent); // Crear un mensaje de texto
            message.setJMSCorrelationID(correlationId); // Establecer el Correlation ID
            return message;
        });
    }
}
