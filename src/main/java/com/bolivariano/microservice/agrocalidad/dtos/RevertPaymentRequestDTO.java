package com.bolivariano.microservice.agrocalidad.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RevertPaymentRequestDTO {
    private String cod_cliente;
    private String terminal;
    private String fecha;
    private String hora;
    private String cod_trx;
    private Integer importe;
}
