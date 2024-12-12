package com.bolivariano.microservice.tuklajem.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MessageInputRevertPaymentDTO {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd",timezone = "America/Guayaquil")
    private String fechaPago;

    private String canal;
    private String cuenta;
    private String depuracion;
    private String esquemaFirma;
    private String moneda;
    private String nombreCliente;
    private String oficina;
    private String secuencial;
    private String tipoCuenta;
    private String transaccion;
    private String usuario;
    private Double valorComision;
    private Double valorPago;
    
    private MessageProcessReceiptDTO recibos;
    private MessageProcessServiceDTO servicio;
    private MessageProcessAditionalDataDTO datosAdicionales; 

}
