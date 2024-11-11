package com.bolivariano.microservice.agrocalidad.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bolivariano.microservice.agrocalidad.dtos.MessageInputProcessDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.bolivariano.microservice.agrocalidad.services.ConsumerService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private ConsumerService consumerService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/consult")
    public void consulting(@RequestBody MessageInputProcessDTO messageInputProcess) throws JsonProcessingException{
        String messageSerialized = this.objectMapper.writeValueAsString(messageInputProcess); // Serialización
        this.consumerService.stage(messageSerialized);
    }
    
    public void payment() {
        throw new UnsupportedOperationException("Unimplemented method 'payment'");
    }

    public void revertPayment() {
        throw new UnsupportedOperationException("Unimplemented method 'revertPayment'");
    }

}
