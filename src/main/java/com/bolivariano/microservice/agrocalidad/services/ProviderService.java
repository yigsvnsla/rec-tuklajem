package com.bolivariano.microservice.agrocalidad.services;

import org.springframework.jms.JmsException;
import org.springframework.stereotype.Service;

import com.bolivariano.microservice.agrocalidad.dtos.MessageInputProcessDTO;
import com.bolivariano.microservice.agrocalidad.interfaces.Recaudation;

@Service
public class ProviderService implements Recaudation {

    @Override
    public void payment() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'payment'");
    }

    @Override
    public void revertPayment() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'revertPayment'");
    }

    @Override
    public void consulting(MessageInputProcessDTO messageInputProcess) throws JmsException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'consulting'");
    }

}