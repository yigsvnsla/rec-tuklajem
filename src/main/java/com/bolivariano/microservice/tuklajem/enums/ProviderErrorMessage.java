package com.bolivariano.microservice.tuklajem.enums;

public enum ProviderErrorMessage {
    TRANSACCION_ACEPTADA("TRANSACCION ACEPTADA"),
    ERROR_DB("ERROR  DB"),
    CLAVE_DUPLICADA("CLAVE DUPLICADA"),
    TRANSACCION_YA_REVERSADA("TRANSACCION YA REVERSADA"),
    NO_EXISTE_PAGO("NO_EXISTE_PAGO"), // cuando se quiere reversar una transaccion que no existe
    NO_EXISTE_REGISTRO("NO_EXISTE_REGISTRO"), // el cliente existe pero no tiene deuda
    CLIENTE_NO_EXISTE("CLIENTE_NO_EXISTE"),
    ERROR_DE_VALIDACION_CAMPO_BUSQUEDA("ERROR_DE_VALIDACION_CAMPO_BUSQUEDA"),
    PARAMETROS_INCORRECTOS("ERROR INTERNO"),
    ERROR_INTERNO("ERROR INTERNO"),
    TRANSACCION_FUERA_DE_HORARIO("TRANSACCION_FUERA_DE_HORARIO");

    private String message;

    ProviderErrorMessage(String msg) {
        this.message = msg;

    }

    public String getMessage() {
        return this.message;
    }
}
