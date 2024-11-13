package com.bolivariano.microservice.tuklajem.controllers;


import org.springframework.http.HttpStatus;
// import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
// import org.springframework.jms.JmsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
// import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bolivariano.microservice.tuklajem.dtos.ErrorResponseDTO;

// import jakarta.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class ControllerAdvice {

    // @ModelAttribute
    // public void setResponseContentType(HttpServletResponse response) {
    //     response.setContentType(MediaType.APPLICATION_JSON_VALUE);
    // }

    @ResponseStatus()
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ErrorResponseDTO> handlerRuntimeException(RuntimeException ex) {

        ErrorResponseDTO errorResponseDto = new ErrorResponseDTO();
        errorResponseDto.setCause(ex.getClass().getName());
        errorResponseDto.setMessage(ex.getMessage());
        errorResponseDto.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.name());
        errorResponseDto.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponseDto);
    }
}