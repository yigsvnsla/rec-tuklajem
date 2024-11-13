package com.bolivariano.microservice.agrocalidad.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RevertPaymentResponseDTO {
    private String terminal;
    private String fecha;
    private String hora;
    private String cod_trx;
    private String msg_respuesta;
    private Integer cod_respuesta;
}
