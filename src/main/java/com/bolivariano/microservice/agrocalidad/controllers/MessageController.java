package com.bolivariano.microservice.agrocalidad.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bolivariano.microservice.agrocalidad.services.ConsumerService;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    ConsumerService consumerService;

    @GetMapping("")
    public String getMessage() {

        return null;
    }

}
