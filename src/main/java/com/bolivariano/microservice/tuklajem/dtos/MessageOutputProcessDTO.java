package com.bolivariano.microservice.tuklajem.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class MessageOutputProcessDTO implements Serializable {

	private String codigo;
    private String mensajeUsuario;
    private String estado;
    // private transient MensajeSalidaEjecutarPago mensajeSalidaEjecutarPago;
    private MessageOutputConsultDTO mensajeSalidaConsultarDeuda;


    
}