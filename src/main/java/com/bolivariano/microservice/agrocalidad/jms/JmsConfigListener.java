package com.bolivariano.microservice.agrocalidad.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.TextMessage;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class JmsConfigListener {

  @JmsListener(destination = "DEV.QUEUE.1")
  public void receiveMessage(Message message) throws JMSException {

    String correlationId = message.getJMSCorrelationID(); // Obtener el Correlation ID
    String msgText = ((TextMessage) message).getText(); // Obtener el Contenido del mensaje
    
    log.info("========================================");
    log.info("Correlation ID: " + correlationId);
    log.info("========================================");
    log.info("Received message is: " + msgText);
    log.info("========================================");

  }
}
