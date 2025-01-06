package com.bolivariano.microservice.tuklajem.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RevertRequestDTO {

    @JsonFormat(pattern = "yyyyMMdd")
    private String fecha;
    @JsonFormat(pattern = "HHmmsss")
    private String hora;

    private String cod_trx;
    private String cod_cliente;
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
        DateTimeFormatter formatOriginal = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatNew = DateTimeFormatter.ofPattern("HHmmss");
        LocalDate localDate = LocalDate.parse(date, formatOriginal);
        // ! HAY QUE CAMBIAR ESTO TENEMOS QUE JALAR ESTE CAMBIO DESDE LOS ARCHIVOS DE TRANSFORMACION ( XSLT )
        LocalDateTime correct = localDate.atStartOfDay();
        String formatDate = correct.format(formatNew);
        this.hora = formatDate;
    }

}