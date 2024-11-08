package com.bolivariano.microservice.agrocalidad.dtos;

import com.bolivariano.microservice.agrocalidad.enums.FlowType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageInputProcessDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private FlowType tipoFlujo;


    private MessageInputConsult mensajeEntradaConsultarDeuda;
    // private MensajeEntradaEjecutarReverso mensajeEntradaEjecutarReverso;
    // private MensajeEntradaEjecutarPago mensajeEntradaEjecutarPago;

}
