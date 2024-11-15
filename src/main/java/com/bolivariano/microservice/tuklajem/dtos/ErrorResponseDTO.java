package com.bolivariano.microservice.tuklajem.dtos;


import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ErrorResponseDTO {
    private Integer code;
    private HttpStatus status;
    private String message;
    private String cause;
}