package com.bolivariano.microservice.agrocalidad.interfaces;

import org.springframework.jms.JmsException;

import com.bolivariano.microservice.agrocalidad.dtos.MessageInputProcessDTO;

public interface Recaudation {

    public void consulting(MessageInputProcessDTO messageInputProcess) throws JmsException;

    public void payment();

    public void revertPayment();

}