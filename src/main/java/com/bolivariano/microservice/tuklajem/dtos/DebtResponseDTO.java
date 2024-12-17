package com.bolivariano.microservice.tuklajem.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DebtResponseDTO {
    private String cod_cliente;
    private String nom_cliente;
    private String Fecha;
    private String hora;
    private String cod_respuesta;
    private String msg_respuesta;
    private String identificador_deuda;
    private Integer importe;
    private Boolean monto_abierto;
    private Integer valor_minimo;
    private Integer valor_maximo;
}
