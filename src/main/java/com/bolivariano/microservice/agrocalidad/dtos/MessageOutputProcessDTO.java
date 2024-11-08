package com.bolivariano.microservice.agrocalidad.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class MessageOutputProcessDTO implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigo;
    private String mensajeUsuario;
    private String estado;
    // private transient MensajeSalidaEjecutarPago mensajeSalidaEjecutarPago;
    // private transient MensajeSalidaConsultarDeuda mensajeSalidaConsultarDeuda;
}