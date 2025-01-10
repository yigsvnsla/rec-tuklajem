package com.bolivariano.microservice.tuklajem.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MessageProcessAditionalDataDTO {


    protected MessageAditionalDataDTO[] datoAdicional;
    
}