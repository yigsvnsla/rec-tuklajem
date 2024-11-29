package com.bolivariano.microservice.tuklajem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bolivariano.microservice.tuklajem.config.MqConfig;
import com.bolivariano.microservice.tuklajem.dtos.MessageInputProcessDTO;
import com.bolivariano.microservice.tuklajem.services.JmsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.log4j.Log4j2;

import org.springframework.web.bind.annotation.PostMapping;

@Log4j2
@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private JmsService jmsService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/consult")
    public void consulting(@RequestBody MessageInputProcessDTO messageInputProcess) throws JsonProcessingException {
        String messageSerialized = this.objectMapper.writeValueAsString(messageInputProcess); // Serialización para
                                                                                              // probar el micro
        Integer randomId = (int) (Math.random() * 1000);
        jmsService.sendRequestMessage(MqConfig.CHANNEL_REQUEST, messageSerialized, String.format("%s", randomId));
    }

    public void payment() {
        throw new UnsupportedOperationException("Unimplemented method 'payment'");
    }

    public void revertPayment() {
        throw new UnsupportedOperationException("Unimplemented method 'revertPayment'");
    }

}
