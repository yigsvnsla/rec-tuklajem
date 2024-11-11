package com.bolivariano.microservice.agrocalidad.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.auth0.jwt.JWT;
import com.bolivariano.microservice.agrocalidad.dtos.DebtRequestDTO;
import com.bolivariano.microservice.agrocalidad.dtos.DebtResponseDTO;
import com.bolivariano.microservice.agrocalidad.dtos.SingInDTO;
import com.bolivariano.microservice.agrocalidad.dtos.TokenDTO;

@Service
public class ProviderService {

    private TokenDTO token;

    @Autowired
    private RestClient restClient;

    private String user = "DevCalt2024";
    private String password = "Calt2024";

    private String getToken() {

        if (this.token == null)
            this.token = this.genToken();
        if (this.token != null && JWT.decode(token.getAccess_token()).getExpiresAt().before(new Date())) {
            this.token = this.genToken();
        }

        return this.token.getAccess_token();

    }

    private TokenDTO genToken() {
        SingInDTO singInDTO = new SingInDTO();

        singInDTO.setUserName(this.user);
        singInDTO.setPassword(this.password);

        return this.restClient.post()
                .uri("/api/bc/token")
                .body(singInDTO)
                .retrieve()
                .toEntity(TokenDTO.class)
                .getBody();
    }

    public void payment() {
        throw new UnsupportedOperationException("Unimplemented method 'payment'");
    }

    public void revertPayment() {
        throw new UnsupportedOperationException("Unimplemented method 'revertPayment'");
    }

    public DebtResponseDTO getDebt(DebtRequestDTO debtDTO) {

        String token = this.getToken();

        return this.restClient.post()
                .uri("/api/bc/ConsultaDeuda")
                .header(HttpHeaders.AUTHORIZATION, String.format("Bearer %s", token))
                .body(debtDTO)
                .retrieve()
                .toEntity(DebtResponseDTO.class)
                .getBody();
    }

}