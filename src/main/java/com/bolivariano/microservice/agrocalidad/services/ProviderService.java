package com.bolivariano.microservice.agrocalidad.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.bolivariano.microservice.agrocalidad.dtos.MessageInputProcessDTO;
import com.bolivariano.microservice.agrocalidad.dtos.SingInDTO;
import com.bolivariano.microservice.agrocalidad.dtos.TokenDTO;
import com.bolivariano.microservice.agrocalidad.interfaces.Recaudation;

@Service
public class ProviderService implements Recaudation {

    TokenDTO token;

    @Autowired
    private RestClient restClient;

    private String user = "DevCalt2024";
    private String password = "Calt2024";


    public TokenDTO singIn() {

        SingInDTO singInDTO = new SingInDTO();

        singInDTO.setUserName(this.user);
        singInDTO.setPassword(this.password);


        this.token = this.restClient.post()
                .body(singInDTO)
                .retrieve()
                .toEntity(TokenDTO.class)
                .getBody();

        return null;
    }

    public void payment() {
        throw new UnsupportedOperationException("Unimplemented method 'payment'");
    }

    public void revertPayment() {
        throw new UnsupportedOperationException("Unimplemented method 'revertPayment'");
    }

    public void consulting(MessageInputProcessDTO messageInputProcess) throws JmsException {
        throw new UnsupportedOperationException("Unimplemented method 'consulting'");
    }

}