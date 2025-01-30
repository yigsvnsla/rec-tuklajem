package com.bolivariano.microservice.tuklajem.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RevertRequestDTO {

    @JsonFormat(pattern = "yyyyMMdd")
    private String fecha;

    @JsonFormat(pattern = "HHmmsss")
    private String hora;

    @JsonProperty("cod_trx")
    private String codTrx;

    @JsonProperty("cod_cliente")
    private String codCliente;

    private String terminal;
    
    private String secuencial;
    
    private Integer importe;


    public void setFecha(String date){
        DateTimeFormatter formatOriginal = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatNew = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate localDate = LocalDate.parse(date, formatOriginal);
        String formatDate = localDate.format(formatNew);
        this.fecha = formatDate;
    }

    public void setHora(String date){
        LocalDateTime parsedDate = LocalDateTime.parse(date);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmmss");
        String formattedDate = parsedDate.format(formatter);
        this.hora = formattedDate;
    }

}