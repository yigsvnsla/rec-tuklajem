package com.bolivariano.microservice.tuklajem.interfaces;

import org.springframework.jms.JmsException;

import com.bolivariano.microservice.tuklajem.dtos.MessageInputProcessDTO;

public interface Recaudation {

    public void consulting(MessageInputProcessDTO messageInputProcess, String correlationId) throws JmsException;

    public void payment();

    public void revertPayment();

}