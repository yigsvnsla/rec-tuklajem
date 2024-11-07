package com.bolivariano.microservice.agrocalidad.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.bolivariano.microservice.agrocalidad.exception.ResponseExecption;
import com.bolivariano.microservice.agrocalidad.interfaces.Recaudation;

@Service
public class ConsumerService implements Recaudation {

    @Autowired
    private JmsTemplate jmsTemplate;

    public String consulting(String message) throws JmsException {
        jmsTemplate.convertAndSend("DEV.QUEUE.1", "Hello World!");

        Object receivedMessage = jmsTemplate.receiveAndConvert("DEV.QUEUE.1");

        if (receivedMessage == null)
            throw new ResponseExecption(HttpStatus.NOT_ACCEPTABLE, "Received Message is NULL");

        return receivedMessage.toString();
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
