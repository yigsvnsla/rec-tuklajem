package com.bolivariano.microservice.tuklajem.dtos;


import lombok.Data;

@Data
public class ErrorResponseDTO {
    private Integer code;
    private String status;
    private String message;
    private String cause;
}