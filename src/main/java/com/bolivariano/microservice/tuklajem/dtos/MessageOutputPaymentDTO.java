package com.bolivariano.microservice.tuklajem.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class MessageOutputPaymentDTO {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "America/Guayaquil")
    private String fechaDebito;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "America/Guayaquil")
    private String fechaPago;

    private String codigoError;
    private String mensajeUsuario;
    private String mensajeSistema;
    private Double montoTotal;
    private String referencia;
    private Boolean banderaOffline;

    private MessageProcessAditionalDataDTO datosAdicionales;
}
