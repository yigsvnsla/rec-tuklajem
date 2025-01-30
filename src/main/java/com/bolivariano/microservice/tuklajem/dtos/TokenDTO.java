package com.bolivariano.microservice.tuklajem.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TokenDTO {

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("expires_in")
    private Number expiresIn;

    @JsonProperty("cod_respuesta")
    private Number codRespuesta;

    @JsonProperty("msg_respuesta")
    private String msgRespuesta;

}
