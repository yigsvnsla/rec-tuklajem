package com.bolivariano.microservice.tuklajem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.bolivariano.microservice.tuklajem.exception.ResponseExecption;
import com.bolivariano.microservice.tuklajem.services.ConsumerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.TextMessage;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class JmsController {

  @Autowired
  private ConsumerService consumerService;

  @JmsListener(destination = "${mq.config.request_queue}")
  public void receiveMessage(Message message) throws JMSException, JsonMappingException, JmsException, JsonProcessingException, ResponseExecption {
    String correlationId = message.getJMSCorrelationID(); // Obtener el Correlation ID
    String msgText = ((TextMessage) message).getText(); // Obtener el Contenido del mensaje
    
    log.info("========================================");
    log.info("                REQUEST                 ");
    log.info("========================================");
    log.info("Correlation ID: " + correlationId);
    log.info("========================================");
    log.info("Received message is: " + msgText);
    log.info("========================================");

    this.consumerService.stage(msgText);
  }


  @JmsListener(destination = "${mq.config.response_queue}")
  public void responseMessage(Message message) throws JMSException {

    String correlationId = message.getJMSCorrelationID(); // Obtener el Correlation ID
    String msgText = ((TextMessage) message).getText(); // Obtener el Contenido del mensaje
    
    log.info("========================================");
    log.info("                RESPONSE                ");
    log.info("========================================");
    log.info("Correlation ID: " + correlationId);
    log.info("========================================");
    log.info("Received message is: " + msgText);
    log.info("========================================");

  }
}