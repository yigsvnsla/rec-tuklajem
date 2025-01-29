package com.bolivariano.microservice.tuklajem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ResponseExecption extends RuntimeException {

    private final HttpStatus status;

    public ResponseExecption(@NonNull HttpStatus httpStatus, String message) {
        super(message);

        this.status = httpStatus == null ? HttpStatus.BAD_REQUEST : httpStatus;
    }

}