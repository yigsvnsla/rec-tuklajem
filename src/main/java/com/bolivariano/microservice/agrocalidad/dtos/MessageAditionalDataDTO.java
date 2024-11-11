package com.bolivariano.microservice.agrocalidad.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MessageAditionalDataDTO {
    private String codigo;
    private String etiqueta;
    private Boolean editable;
    private String formato;
    private String longitud;
    private String mascara;
    private String regexp;
    private String tipo;
    private String valor;
    private Boolean visible;

    private MessageSelectProcessDTO listasSeleccion;
}
