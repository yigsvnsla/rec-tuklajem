package com.bolivariano.microservice.tuklajem.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
// import org.springframework.jms.JmsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bolivariano.microservice.tuklajem.dtos.ErrorResponseDTO;
import com.bolivariano.microservice.tuklajem.exception.ResponseExecption;


@RestControllerAdvice
public class ControllerAdvice {



    @ResponseStatus()
    @ExceptionHandler(value = ResponseExecption.class)
    public ResponseEntity<ErrorResponseDTO> handlerResponseExecption(ResponseExecption ex) {

        ErrorResponseDTO errorResponseDto = new ErrorResponseDTO();
        errorResponseDto.setCause(ex.getClass().getName());
        errorResponseDto.setMessage(ex.getMessage());
        errorResponseDto.setStatus(ex.getStatus());
        errorResponseDto.setCode(ex.getStatus().value());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponseDto);
    }
}

