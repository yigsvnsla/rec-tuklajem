package com.bolivariano.microservice.tuklajem.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientResponseException;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.bolivariano.microservice.tuklajem.dtos.DebtRequestDTO;
import com.bolivariano.microservice.tuklajem.dtos.DebtResponseDTO;
import com.bolivariano.microservice.tuklajem.dtos.PaymentRequestDTO;
import com.bolivariano.microservice.tuklajem.dtos.PaymentResponse;
import com.bolivariano.microservice.tuklajem.dtos.RevertPaymentRequestDTO;
import com.bolivariano.microservice.tuklajem.dtos.RevertPaymentResponseDTO;
import com.bolivariano.microservice.tuklajem.dtos.SingInDTO;
import com.bolivariano.microservice.tuklajem.dtos.TokenDTO;
import com.bolivariano.microservice.tuklajem.exception.ResponseExecption;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ProviderService {

    private TokenDTO token;

    @Autowired
    private RestClient restClient;

    private String user = "DevCalt2024";
    private String password = "Calt2024";

    private String getToken() throws JWTDecodeException, RestClientResponseException, HttpServerErrorException {

        if (this.token == null || JWT.decode(token.getAccess_token()).getExpiresAt().before(new Date())) {

            SingInDTO singInDTO = new SingInDTO();

            singInDTO.setUserName(this.user);
            singInDTO.setPassword(this.password);

            log.info("🔄 GENERANDO TOKEN EN EL PROVEEDOR");

            this.token = this.restClient
                    .post()
                    .uri("/api/bc/token")
                    .body(singInDTO)
                    .retrieve()
                    .toEntity(TokenDTO.class)
                    .getBody();
        }

        log.info("🔄 TOKEN GENERADO");

        return this.token.getAccess_token();
    }

    public DebtResponseDTO getDebt(DebtRequestDTO debtRequest) throws ResponseExecption {

        log.info("🌐 REALIZANDO CONSULTA A PROVEEDOR");

        return this.restClient
                .post()
                .uri("/api/bc/ConsultaDeuda")
                .header(HttpHeaders.AUTHORIZATION, String.format("Bearer %s", this.getToken()))
                .body(debtRequest)
                .retrieve()
                .onStatus(HttpStatusCode::is2xxSuccessful, (request, response) -> {
                    log.info("🟢 RESPUESTA DE PROVEEDOR");
                })
                .onStatus(HttpStatusCode::is4xxClientError, (request, response) -> {
                    log.error("🛑 ERROR DE PROVEEDOR");
                    throw new ResponseExecption(HttpStatus.valueOf(response.getStatusText()), "ERROR DE PROVEEDOR");
                })
                .onStatus(HttpStatusCode::is5xxServerError, (request, response) -> {
                    log.warn("⚠️ ERROR CONSULTA A PROVEEDOR");
                    throw new ResponseExecption(HttpStatus.valueOf(response.getStatusText()), "ERROR CONSULTA A PROVEEDOR");
                })
                .toEntity(DebtResponseDTO.class)
                .getBody();
    }

    public PaymentResponse payment(PaymentRequestDTO paymentRequest) throws ResponseExecption {

        log.info("🌐 REALIZANDO PAGO A PROVEEDOR");

        return this.restClient.post()
                .uri("/api/bc/InformarPago")
                .header(HttpHeaders.AUTHORIZATION, String.format("Bearer %s", this.getToken()))
                .body(paymentRequest)
                .retrieve()
                .onStatus(HttpStatusCode::is2xxSuccessful, (request, response) -> {
                    log.info("🟢 RESPUESTA DE PROVEEDOR");
                })
                .onStatus(HttpStatusCode::is4xxClientError, (request, response) -> {
                    log.error("🛑 ERROR DE PROVEEDOR");
                    throw new ResponseExecption(HttpStatus.valueOf(response.getStatusText()), "ERROR DE PROVEEDOR");
                })
                .onStatus(HttpStatusCode::is5xxServerError, (request, response) -> {
                    log.warn("⚠️ ERROR CONSULTA A PROVEEDOR");
                    throw new ResponseExecption(HttpStatus.valueOf(response.getStatusText()), "ERROR CONSULTA A PROVEEDOR");
                })
                .toEntity(PaymentResponse.class)
                .getBody();
    }

    public RevertPaymentResponseDTO revertPayment(RevertPaymentRequestDTO revertPayment) throws ResponseExecption {

        log.info("🌐 REALIZANDO REVERSO A PROVEEDOR");

        return this.restClient.post()
                .uri("/api/bc/ReversarPago")
                .header(HttpHeaders.AUTHORIZATION, String.format("Bearer %s", this.getToken()))
                .body(revertPayment)
                .retrieve()
                .onStatus(HttpStatusCode::is2xxSuccessful, (request, response) -> {
                    log.info("🟢 RESPUESTA DE PROVEEDOR");
                })
                .onStatus(HttpStatusCode::is4xxClientError, (request, response) -> {
                    log.error("🛑 ERROR DE PROVEEDOR");
                    throw new ResponseExecption(HttpStatus.valueOf(response.getStatusText()), "ERROR DE PROVEEDOR");
                })
                .onStatus(HttpStatusCode::is5xxServerError, (request, response) -> {
                    log.warn("⚠️ ERROR CONSULTA A PROVEEDOR");
                    throw new ResponseExecption(HttpStatus.valueOf(response.getStatusText()), "ERROR CONSULTA A PROVEEDOR");
                })
                .toEntity(RevertPaymentResponseDTO.class)
                .getBody();
    }
}