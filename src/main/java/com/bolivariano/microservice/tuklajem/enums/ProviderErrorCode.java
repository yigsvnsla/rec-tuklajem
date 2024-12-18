package com.bolivariano.microservice.tuklajem.enums;

public enum ProviderErrorCode {
    TRANSACCION_ACEPTADA("0"),
    ERROR_DB("1"),
    CLAVE_DUPLICADA("2"),
    TRANSACCION_YA_REVERSADA("3"),
    NO_EXISTE_PAGO("4"), // cuando se quiere reversar una transaccion que no existe
    NO_EXISTE_REGISTRO("6"), // el cliente existe pero no tiene deuda
    CLIENTE_NO_EXISTE("7"),
    ERROR_DE_VALIDACION_CAMPO_BUSQUEDA("8"),
    PARAMETROS_INCORRECTOS("9"),
    ERROR_INTERNO("10"),
    TRANSACCION_FUERA_DE_HORARIO("13");

    private String _code;

    ProviderErrorCode(String code) {
        this._code = code;

    }

    public String getcode() {
        return this._code;
    }
}
