package com.bolivariano.microservice.agrocalidad.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TokenDTO {

    private String access_token;
    private Number expires_in;
    private Number cod_respuesta;
    private String msg_respuesta;
      
}
