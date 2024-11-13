package com.bolivariano.microservice.agrocalidad.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PaymentRequestDTO {
  
    private String cod_cliente;
    private String terminal;
    private String fecha;
    private String hora;
    private Integer importe;
      
}
