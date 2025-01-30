package com.bolivariano.microservice.tuklajem.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientResponseException;

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

    private String getToken()
            throws JWTDecodeException, ResourceAccessException, RestClientResponseException {
        if (this.token == null || JWT.decode(token.getAccessToken()).getExpiresAt().before(new Date())) {

            SingInDTO singInDTO = new SingInDTO();

            singInDTO.setUserName(this.user);
            singInDTO.setPassword(this.password);

            log.info("🔵 GENERANDO TOKEN EN EL PROVEEDOR");

            this.token = this.restClient
                    .post()
                    .uri("/api/bc/token")
                    .body(singInDTO)
                    .retrieve()
                    .toEntity(TokenDTO.class)
                    .getBody();
        }
        log.info("🔵 TOKEN GENERADO");
        return String.format("Bearer %s", this.token.getAccessToken());
    }

    public DebtResponseDTO getDebt(DebtRequestDTO debtRequest)
            throws ResponseExecption, ResourceAccessException, RestClientResponseException {
        log.info("🔵 REALIZANDO CONSULTA A PROVEEDOR");
        return this.restClient
                .post()
                .uri("/api/bc/ConsultaDeuda")
                .header(HttpHeaders.AUTHORIZATION, this.getToken())
                .body(debtRequest)
                .retrieve()
                .toEntity(DebtResponseDTO.class)
                .getBody();
    }

    public PaymentResponseDTO setPayment(PaymentRequestDTO paymentRequest)
    throws ResponseExecption, ResourceAccessException, RestClientResponseException {
        log.info("🔵 REALIZANDO CONSULTA A PROVEEDOR");
        return this.restClient
                .post()
                .uri("/api/bc/InformarPago")
                .header(HttpHeaders.AUTHORIZATION, this.getToken())
                .body(paymentRequest)
                .retrieve()
                .toEntity(PaymentResponseDTO.class)
                .getBody();
    }

    public RevertResponseDTO setRevert(RevertRequestDTO revertPayment)
            throws ResponseExecption, ResourceAccessException, RestClientResponseException {

        log.info("🔵 REALIZANDO REVERSO A PROVEEDOR");
        return this.restClient
                .post()
                .uri("/api/bc/ReversarPago")
                .header(HttpHeaders.AUTHORIZATION, this.getToken())
                .body(revertPayment)
                .retrieve()
                .toEntity(RevertResponseDTO.class)
                .getBody();
    }

    public DebtResponseDTO getDebtMock(DebtRequestDTO debtRequest) {
        log.debug(debtRequest);

        DebtResponseDTO debResponse = new DebtResponseDTO();

        debResponse.setNombreCliente("Gonzalo Fienco");
        debResponse.setCodCliente("22004477");
        debResponse.setCodRespuesta(0);
        debResponse.setMsgRespuesta("Transacción aceptada");
        debResponse.setFecha("20241203");
        debResponse.setHora("152553");
        debResponse.setIdentificadorDeuda("4");
        debResponse.setImporte(376150);
        debResponse.setMontoAbierto(false);
        debResponse.setValorMinimo(20);
        debResponse.setValorMaximo(1000);
        return debResponse;
    }

    public PaymentResponseDTO setPaymentMock(PaymentRequestDTO paymentRequest) {
        log.debug(paymentRequest);

        PaymentResponseDTO paymentResponse = new PaymentResponseDTO();

        paymentResponse.setTerminal("D00561");
        paymentResponse.setFecha("20241203");
        paymentResponse.setHora("163919");
        paymentResponse.setCodTrx("B9DF593B-A7EB-4139-9A49-D9550090FA9A");
        paymentResponse.setSecuencial("42275263");
        paymentResponse.setCodRespuesta(0);
        paymentResponse.setMsgRespuesta("Transaccion aceptada");

        return paymentResponse;
    }

    public RevertResponseDTO setRevertMock(RevertRequestDTO revertRequestDTO){
        log.debug(revertRequestDTO);

        RevertResponseDTO revertResponse = new RevertResponseDTO();

        revertResponse.setTerminal("D00561");
        revertResponse.setFecha("20241203");
        revertResponse.setHora("163919");
        revertResponse.setCodTrx("B9DF593B-A7EB-4139-9A49-D9550090FA9A");
        revertResponse.setSecuencial("42275263");
        revertResponse.setCodRespuesta(0);
        revertResponse.setMsgRespuesta("Transaccion aceptada");

        return revertResponse;
    }

    public PaymentResponseDTO setPaymentTrowableMock ( PaymentRequestDTO paymentRequestDTO) throws ResponseExecption, InterruptedException{
        log.debug(paymentRequestDTO);
        Thread.sleep(5000);
        throw new ResponseExecption(HttpStatus.INTERNAL_SERVER_ERROR, "TEST SLEEP");
    }
}