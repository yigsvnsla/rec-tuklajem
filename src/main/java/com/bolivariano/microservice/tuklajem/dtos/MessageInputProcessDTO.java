package com.bolivariano.microservice.tuklajem.dtos;

import com.bolivariano.microservice.tuklajem.enums.FlowType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageInputProcessDTO implements Serializable {

    private FlowType tipoFlujo;

    private MessageInputConsultDTO mensajeEntradaConsultarDeuda;
    private MessageInputPaymentDTO mensajeEntradaEjecutarPago;
    private MessageInputRevertPaymentDTO mensajeEntradaEjecutarReverso;

}
