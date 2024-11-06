package com.bolivariano.microservice.agrocalidad.services;

import org.springframework.stereotype.Service;

import com.bolivariano.microservice.agrocalidad.interfaces.Recaudation;

@Service
public class ProviderServiceImpl  implements Recaudation {
    

    @Override
    public void consulting() {
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