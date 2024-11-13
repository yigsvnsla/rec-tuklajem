package com.bolivariano.microservice.tuklajem.dtos;

import javax.xml.datatype.XMLGregorianCalendar;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MessageOutputConsultDTO {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss",timezone = "America/Guayaquil")
    private XMLGregorianCalendar fechaVencimiento;
    
    private String codigoError;
    private String formaPago;
    private String formaPagoRecibos;
    private String identificadorDeuda;
    private Double limiteMontoMaximo;
    private Double limiteMontoMinimo;
    private String mensajeUsuario;
    private String mensajeSistema;
    private Double montoMinimo;
    private Double montoTotal;
    private String nombreCliente;
    private String textoAyuda;

    private MessageProcessServiceDTO recibos;
    private MessageProcessAditionalDataDTO datosAdicionales;
}
