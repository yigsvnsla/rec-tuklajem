package com.bolivariano.microservice.tuklajem.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PaymentResponseDTO {

    private String terminal;
    private String fecha;
    private String hora;
    private String cod_trx;
    private String msg_respuesta;
    private String cod_respuesta;

}
