package com.bolivariano.microservice.agrocalidad.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MessageProcessAditionalDataDTO {


    protected transient MessageAditionalDataDTO[] datoAdicional;
    
}