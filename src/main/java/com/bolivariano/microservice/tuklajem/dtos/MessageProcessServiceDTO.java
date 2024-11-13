package com.bolivariano.microservice.tuklajem.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MessageProcessServiceDTO {

    private String codTipoServicio;
    private String codigoConvenio;
    private String codigoEmpresa;
    private String codigoTipoBanca;
    private String codigoTipoIdentificador;
    private String identificador;

    private MessageProcessAditionalDataDTO datosAdicionales;

}
