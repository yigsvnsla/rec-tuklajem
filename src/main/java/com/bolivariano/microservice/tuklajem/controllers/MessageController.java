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

import java.security.SecureRandom;
import java.util.Random;

@Log4j2
@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MqConfig mqConfig;

    @Autowired
    private JmsService jmsService;

    @Autowired
    private ObjectMapper objectMapper;

    private Random rand = new SecureRandom();

    @PostMapping("/consult")
    public void consulting(@RequestBody MessageInputProcessDTO messageInputProcess) throws JsonProcessingException {
        String messageSerialized = this.objectMapper.writeValueAsString(messageInputProcess);
        Integer randomId = rand.nextInt(32);
        jmsService.sendRequestMessage(mqConfig.getRequest_queue(), messageSerialized, String.format("%s", randomId));
    }

    public void payment() {
        throw new UnsupportedOperationException("Unimplemented method 'payment'");
    }

    public void revertPayment() {
        throw new UnsupportedOperationException("Unimplemented method 'revertPayment'");
    }

}
