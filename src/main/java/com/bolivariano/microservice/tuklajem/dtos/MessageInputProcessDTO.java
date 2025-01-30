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

    private transient MessageInputConsultDTO mensajeEntradaConsultarDeuda;
    private transient MessageInputPaymentDTO mensajeEntradaEjecutarPago;
    private transient MessageInputRevertPaymentDTO mensajeEntradaEjecutarReverso;

}
