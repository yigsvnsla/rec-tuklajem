package com.bolivariano.microservice.tuklajem.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DebtResponseDTO {
    @JsonProperty("cod_cliente") 
    private String codCliente;

    @JsonProperty("nom_cliente") 
    private String nombreCliente;

    private String Fecha;

    private String hora;

    @JsonProperty("msg_respuesta") 
    private String msgRespuesta;

    @JsonProperty("identificador_deuda") 
    private String identificadorDeuda;

    private Integer importe;

    @JsonProperty("cod_respuesta") 
    private Integer codRespuesta;

    @JsonProperty("monto_abierto")
    private Boolean montoAbierto;

    @JsonProperty("valor_minimo")
    private Integer valorMinimo;

    @JsonProperty("valor_maximo")
    private Integer valorMaximo;
}
