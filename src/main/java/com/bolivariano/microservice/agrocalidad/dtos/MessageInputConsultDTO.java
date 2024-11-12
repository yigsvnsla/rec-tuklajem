package com.bolivariano.microservice.agrocalidad.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MessageInputConsultDTO {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss",timezone = "America/Guayaquil")
    private String fecha;

    private String canal;
    private String depuracion;
    private String oficina;
    private String secuencial;
    private String transaccion;
    private String usuario;

    private MessageProcessServiceDTO servicio;

}