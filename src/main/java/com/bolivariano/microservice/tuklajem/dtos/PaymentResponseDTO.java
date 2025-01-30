package com.bolivariano.microservice.tuklajem.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PaymentResponseDTO {
    @JsonProperty("cod_respuesta")
    private Integer codRespuesta;

    @JsonProperty("cod_trx")
    private String codTrx;
    
    @JsonProperty("msg_respuesta")
    private String msgRespuesta;

    private String terminal;

    private String fecha;

    private String hora;

    private String secuencial;
}
