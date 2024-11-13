package com.bolivariano.microservice.tuklajem.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.auth0.jwt.JWT;
import com.bolivariano.microservice.tuklajem.dtos.DebtRequestDTO;
import com.bolivariano.microservice.tuklajem.dtos.DebtResponseDTO;
import com.bolivariano.microservice.tuklajem.dtos.PaymentRequestDTO;
import com.bolivariano.microservice.tuklajem.dtos.PaymentResponse;
import com.bolivariano.microservice.tuklajem.dtos.RevertPaymentRequestDTO;
import com.bolivariano.microservice.tuklajem.dtos.RevertPaymentResponseDTO;
import com.bolivariano.microservice.tuklajem.dtos.SingInDTO;
import com.bolivariano.microservice.tuklajem.dtos.TokenDTO;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ProviderService {

    private TokenDTO token;

    @Autowired
    private RestClient restClient;

    private String user = "DevCalt2024";
    private String password = "Calt2024";

    private String getToken() {
        if (this.token == null || JWT.decode(token.getAccess_token()).getExpiresAt().before(new Date())) {

            SingInDTO singInDTO = new SingInDTO();

            singInDTO.setUserName(this.user);
            singInDTO.setPassword(this.password);

            log.info("GENERANDO TOKEN EN EL PROVEEDOR");

            this.token = this.restClient.post()
                    .uri("/api/bc/token")
                    .body(singInDTO)
                    .retrieve()
                    .toEntity(TokenDTO.class)
                    .getBody();
        }

        log.info("TOKEN GENERADO");

        return this.token.getAccess_token();
    }

    public DebtResponseDTO getDebt(DebtRequestDTO debtRequest) {
        
        log.info("REALIZANDO CONSULTA A PROVEEDOR");
        
        return this.restClient.post()
                .uri("/api/bc/ConsultaDeuda")
                .header(HttpHeaders.AUTHORIZATION, String.format("Bearer %s", this.getToken()))
                .body(debtRequest)
                .retrieve()
                .toEntity(DebtResponseDTO.class)
                .getBody();
    }

    public PaymentResponse payment(PaymentRequestDTO paymentRequest) {
        
        log.info("REALIZANDO PAGO A PROVEEDOR");

        return this.restClient.post()
                .uri("/api/bc/InformarPago")
                .header(HttpHeaders.AUTHORIZATION, String.format("Bearer %s", this.getToken()))
                .body(paymentRequest)
                .retrieve()
                .toEntity(PaymentResponse.class)
                .getBody();
    }

    public RevertPaymentResponseDTO revertPayment(RevertPaymentRequestDTO revertPayment) {
        
        log.info("REALIZANDO REVERSO A PROVEEDOR");

        return this.restClient.post()
                .uri("/api/bc/ReversarPago")
                .header(HttpHeaders.AUTHORIZATION, String.format("Bearer %s", this.getToken()))
                .body(revertPayment)
                .retrieve()
                .toEntity(RevertPaymentResponseDTO.class)
                .getBody();
    }
}