package com.bolivariano.microservice.agrocalidad.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MessageProcessReceiptDTO {
    private String comprobante;
    private String concepto;
    private String cuota;
    private String dato1;
    private String dato2;
    private String dividendo;
    private String fecha;
    private String formaPago;
    private String identificador;
    private String impuesto;
    private Double interes;
    private Double interesesPagados;
    private Double interesesPendientes;
    private String numeroPredial;
    private Double pago;
    private String referencia;
    private String secuencia;
    private String tipoProceso;
    private Double totalAPagar;
    private Double valor;

    private MessageProcessAditionalDataDTO datosAdicionales;
}
