package com.bolivariano.microservice.agrocalidad.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bolivariano.microservice.agrocalidad.dtos.MessageInputProcessDTO;

import com.bolivariano.microservice.agrocalidad.services.ConsumerService;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private ConsumerService consumerService;

    @PostMapping("/consult")
    public void consulting(@RequestBody MessageInputProcessDTO messageInputProcess) {
        this.consumerService.consulting(messageInputProcess);
    }

    public void payment() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'payment'");
    }

    public void revertPayment() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'revertPayment'");
    }

}
