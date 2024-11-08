package com.bolivariano.microservice.agrocalidad.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.stereotype.Service;

import com.bolivariano.microservice.agrocalidad.dtos.MessageInputProcessDTO;
import com.bolivariano.microservice.agrocalidad.interfaces.Recaudation;
import com.bolivariano.microservice.agrocalidad.jms.JmsConfigProducer;


@Service
public class ConsumerService implements Recaudation {

    @Autowired
    private JmsConfigProducer jmsConfigProducer;

    public void payment() {
        throw new UnsupportedOperationException("Unimplemented method 'payment'");
    }

    public void revertPayment() {
        throw new UnsupportedOperationException("Unimplemented method 'revertPayment'");
    }

    public void consulting(MessageInputProcessDTO messageInputProcess) throws JmsException {
        System.out.println(messageInputProcess.toString());

        jmsConfigProducer.sendMessage("DEV.QUEUE.1", "Hello World!", "1010");
    }
}
