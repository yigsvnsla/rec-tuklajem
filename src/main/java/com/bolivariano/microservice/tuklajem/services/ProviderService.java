package com.bolivariano.microservice.tuklajem.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClient;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.bolivariano.microservice.tuklajem.dtos.DebtRequestDTO;
import com.bolivariano.microservice.tuklajem.dtos.DebtResponseDTO;
import com.bolivariano.microservice.tuklajem.dtos.PaymentRequestDTO;
import com.bolivariano.microservice.tuklajem.dtos.PaymentResponseDTO;
import com.bolivariano.microservice.tuklajem.dtos.RevertResponseDTO;
import com.bolivariano.microservice.tuklajem.dtos.RevertRequestDTO;
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

    private String getToken() throws JWTDecodeException, ResourceAccessException {
        if (this.token == null || JWT.decode(token.getAccess_token()).getExpiresAt().before(new Date())) {

            SingInDTO singInDTO = new SingInDTO();

            singInDTO.setUserName(this.user);
            singInDTO.setPassword(this.password);

            log.info("🔵 GENERANDO TOKEN EN EL PROVEEDOR");

            this.token = this.restClient
                    .post()
                    .uri("/api/bc/token")
                    .body(singInDTO)
                    .retrieve()
                    .onStatus(HttpStatusCode::is2xxSuccessful, (request, response) -> {
                        log.info("🟢 RESPUESTA DE PROVEEDOR");
                    })
                    .onStatus(HttpStatusCode::is4xxClientError, (request, response) -> {
                        log.error("🔴 ERROR DE PROVEEDOR");
                        throw new ResponseExecption(HttpStatus.valueOf(response.getStatusText()),
                                "ERROR DE PROVEEDOR");
                    })
                    .onStatus(HttpStatusCode::is5xxServerError, (request, response) -> {
                        log.warn("🟡 ERROR CONSULTA A PROVEEDOR");
                        throw new ResponseExecption(HttpStatus.valueOf(response.getStatusText()),
                                "ERROR CONSULTA A PROVEEDOR");
                    })
                    .toEntity(TokenDTO.class)

                    .getBody();
        }
        log.info("🔵 TOKEN GENERADO");
        return this.token.getAccess_token();
    }

    public DebtResponseDTO getDebt(DebtRequestDTO debtRequest) throws ResponseExecption, ResourceAccessException {
        log.info("🔵 REALIZANDO CONSULTA A PROVEEDOR");

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
                    log.error("🔴 ERROR DE PROVEEDOR");
                    throw new ResponseExecption(HttpStatus.valueOf(response.getStatusText()), "ERROR DE PROVEEDOR");
                })
                .onStatus(HttpStatusCode::is5xxServerError, (request, response) -> {
                    log.warn("🟡 ERROR CONSULTA A PROVEEDOR");
                    throw new ResponseExecption(HttpStatus.valueOf(response.getStatusText()),
                            "ERROR CONSULTA A PROVEEDOR");
                })
                .toEntity(DebtResponseDTO.class)
                .getBody();
    }

    public PaymentResponseDTO setPayment(PaymentRequestDTO paymentRequest) throws ResponseExecption {
        log.info("🔵 REALIZANDO CONSULTA A PROVEEDOR");
        return this.restClient
                .post()
                .uri("/api/bc/InformarPago")
                .header(HttpHeaders.AUTHORIZATION, String.format("Bearer %s", this.getToken()))
                .body(paymentRequest)
                .retrieve()
                .onStatus(HttpStatusCode::is2xxSuccessful, (request, response) -> {
                    log.info("🟢 RESPUESTA DE PROVEEDOR");
                })
                .onStatus(HttpStatusCode::is4xxClientError, (request, response) -> {
                    log.error("🔴 ERROR DE PROVEEDOR");
                    throw new ResponseExecption(HttpStatus.valueOf(response.getStatusText()), "ERROR DE PROVEEDOR");
                })
                .onStatus(HttpStatusCode::is5xxServerError, (request, response) -> {
                    log.warn("🟡 ERROR CONSULTA A PROVEEDOR");
                    throw new ResponseExecption(HttpStatus.valueOf(response.getStatusText()),
                            "ERROR CONSULTA A PROVEEDOR");
                })
                .toEntity(PaymentResponseDTO.class)
                .getBody();
    }

    public RevertResponseDTO setRevert(RevertRequestDTO revertPayment) throws ResponseExecption {

        log.info("🔵 REALIZANDO REVERSO A PROVEEDOR");
        ResponseEntity<RevertResponseDTO> _response = this.restClient
                .post()
                .uri("/api/bc/ReversarPago")
                .header(HttpHeaders.AUTHORIZATION, String.format("Bearer %s", this.getToken()))
                .body(revertPayment)
                .retrieve()
                
                .onStatus(HttpStatusCode::is2xxSuccessful, (request, response) -> {
                    log.info("🟢 RESPUESTA DE PROVEEDOR");
                })
                .onStatus(HttpStatusCode::is4xxClientError, (request, response) -> {
                    log.error("🔴 ERROR DE PROVEEDOR");
                    throw new ResponseExecption(HttpStatus.valueOf(response.getStatusText()), "ERROR DE PROVEEDOR");
                })
                .onStatus(HttpStatusCode::is5xxServerError, (request, response) -> {
                    log.warn("🟡 ERROR CONSULTA A PROVEEDOR");
                    throw new ResponseExecption(HttpStatus.valueOf(response.getStatusText()),
                            "ERROR CONSULTA A PROVEEDOR");
                })
                .onStatus(HttpStatusCode::isError,(request, response) -> {
                    log.error("🔴 ERROR DE PROVEEDOR");
                    throw new ResponseExecption(HttpStatus.valueOf(response.getStatusText()), "ERROR DE PROVEEDOR");
                })
                .toEntity(RevertResponseDTO.class);

                

                return _response.getBody();
    }

    // DATA BURN
    public DebtResponseDTO getDebtMock(DebtRequestDTO debtRequest) {

        DebtResponseDTO debResponse = new DebtResponseDTO();

        debResponse.setNom_cliente("Gonzalo Fienco");
        debResponse.setCod_cliente("22004477");
        debResponse.setCod_respuesta("0");
        debResponse.setMsg_respuesta("Transacción aceptada");
        debResponse.setFecha("20241203");
        debResponse.setHora("152553");
        debResponse.setIdentificador_deuda("4");
        debResponse.setImporte(376150);
        debResponse.setMonto_abierto(false);

        return debResponse;
    }

    public PaymentResponseDTO setPaymentMock(PaymentRequestDTO paymentRequest) {

        PaymentResponseDTO paymentResponse = new PaymentResponseDTO();

        paymentResponse.setTerminal("D00561");
        paymentResponse.setFecha("20241203");
        paymentResponse.setHora("163919");
        paymentResponse.setCod_trx("000000001");
        paymentResponse.setCod_respuesta("0");
        paymentResponse.setMsg_respuesta("Transaccion aceptada");

        return paymentResponse;
    }
}