package com.bolivariano.microservice.tuklajem.dtos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DebtRequestDTO {

    @JsonFormat(pattern = "yyyyMMdd")
    private String fecha;

    @JsonFormat(pattern = "HHmmsss")
    private String hora;

    @JsonProperty("Identificador") 
    private String identificador;
    
    private String terminal;


    public void setFecha(String date){
        LocalDateTime parsedDate = LocalDateTime.parse(date);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String formattedDate = parsedDate.format(formatter);
        this.fecha = formattedDate;
    }

    public void setHora(String date){
        LocalDateTime parsedDate = LocalDateTime.parse(date);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmmss");
        String formattedDate = parsedDate.format(formatter);
        this.hora = formattedDate;
    }

}
