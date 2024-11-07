package com.bolivariano.microservice.agrocalidad.services;

import org.springframework.stereotype.Service;

import com.bolivariano.microservice.agrocalidad.interfaces.Recaudation;

@Service
public class ProviderService implements Recaudation {

    @Override
    public String consulting(String message) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'consulting'");
    }

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
    


}