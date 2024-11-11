package com.bolivariano.microservice.agrocalidad.dtos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MessageInputConsultDTO {


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss",timezone = "America/Guayaquil")
    private String fecha;

    private String canal;
    private String depuracion;
    private String oficina;
    private String secuencial;
    private String transaccion;
    private String usuario;

    private MessageProcessServiceDTO servicio;

}


// package com.bolivariano.microservice.reclaganga.core.domain.mensajeotc;

// import com.bolivariano.microservice.reclaganga.core.domain.servicio.Servicio;
// import com.fasterxml.jackson.annotation.JsonFormat;

// import jakarta.xml.bind.annotation.*;
// import javax.xml.datatype.XMLGregorianCalendar;
// import java.io.Serial;
// import java.io.Serializable;


// /**
//  * <p>Java class for mensajeEntradaConsultarDeuda complex type.
//  *
//  * <p>The following schema fragment specifies the expected content contained within this class.
//  *
//  * <pre>
//  * &lt;complexType name="mensajeEntradaConsultarDeuda"&gt;
//  *   &lt;complexContent&gt;
//  *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
//  *       &lt;sequence&gt;
//  *         &lt;element name="canal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
//  *         &lt;element name="depuracion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
//  *         &lt;element name="fecha" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
//  *         &lt;element name="oficina" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
//  *         &lt;element name="secuencial" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
//  *         &lt;element name="servicio" type="{http://www.bolivariano.com/dominio/Servicio}servicio" minOccurs="0"/&gt;
//  *         &lt;element name="transaccion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
//  *         &lt;element name="usuario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
//  *       &lt;/sequence&gt;
//  *     &lt;/restriction&gt;
//  *   &lt;/complexContent&gt;
//  * &lt;/complexType&gt;
//  * </pre>
//  *
//  *
//  */
// @XmlAccessorType(XmlAccessType.FIELD)
// @XmlType(name = "entradaConsultarDeuda", propOrder = {
//         "canal",
//         "depuracion",
//         "fecha",
//         "oficina",
//         "secuencial",
//         "servicio",
//         "transaccion",
//         "usuario"
// })
// @XmlRootElement(name = "entradaConsultarDeuda")
// public class MensajeEntradaConsultarDeuda implements Serializable {

//     @Serial
//     private static final long serialVersionUID = 1L;

//     protected String canal;
//     protected String depuracion;
//     @XmlSchemaType(name = "dateTime")
//     @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss",timezone = "America/Guayaquil")
//     protected transient XMLGregorianCalendar fecha;
//     protected String oficina;
//     protected String secuencial;
//     protected Servicio servicio;
//     protected String transaccion;
//     protected String usuario;

//     /**
//      * Gets the value of the canal property.
//      *
//      * @return
//      *     possible object is
//      *     {@link String }
//      *
//      */
//     public String getCanal() {
//         return canal;
//     }

//     /**
//      * Sets the value of the canal property.
//      *
//      * @param value
//      *     allowed object is
//      *     {@link String }
//      *
//      */
//     public void setCanal(String value) {
//         this.canal = value;
//     }

//     /**
//      * Gets the value of the depuracion property.
//      *
//      * @return
//      *     possible object is
//      *     {@link String }
//      *
//      */
//     public String getDepuracion() {
//         return depuracion;
//     }

//     /**
//      * Sets the value of the depuracion property.
//      *
//      * @param value
//      *     allowed object is
//      *     {@link String }
//      *
//      */
//     public void setDepuracion(String value) {
//         this.depuracion = value;
//     }

//     /**
//      * Gets the value of the fecha property.
//      *
//      * @return
//      *     possible object is
//      *     {@link XMLGregorianCalendar }
//      *
//      */
//     public XMLGregorianCalendar getFecha() {
//         return fecha;
//     }

//     /**
//      * Sets the value of the fecha property.
//      *
//      * @param value
//      *     allowed object is
//      *     {@link XMLGregorianCalendar }
//      *
//      */
//     public void setFecha(XMLGregorianCalendar value) {
//         this.fecha = value;
//     }

//     /**
//      * Gets the value of the oficina property.
//      *
//      * @return
//      *     possible object is
//      *     {@link String }
//      *
//      */
//     public String getOficina() {
//         return oficina;
//     }

//     /**
//      * Sets the value of the oficina property.
//      *
//      * @param value
//      *     allowed object is
//      *     {@link String }
//      *
//      */
//     public void setOficina(String value) {
//         this.oficina = value;
//     }

//     /**
//      * Gets the value of the secuencial property.
//      *
//      * @return
//      *     possible object is
//      *     {@link String }
//      *
//      */
//     public String getSecuencial() {
//         return secuencial;
//     }

//     /**
//      * Sets the value of the secuencial property.
//      *
//      * @param value
//      *     allowed object is
//      *     {@link String }
//      *
//      */
//     public void setSecuencial(String value) {
//         this.secuencial = value;
//     }

//     /**
//      * Gets the value of the servicio property.
//      *
//      * @return
//      *     possible object is
//      *     {@link Servicio }
//      *
//      */
//     public Servicio getServicio() {
//         return servicio;
//     }

//     /**
//      * Sets the value of the servicio property.
//      *
//      * @param value
//      *     allowed object is
//      *     {@link Servicio }
//      *
//      */
//     public void setServicio(Servicio value) {
//         this.servicio = value;
//     }

//     /**
//      * Gets the value of the transaccion property.
//      *
//      * @return
//      *     possible object is
//      *     {@link String }
//      *
//      */
//     public String getTransaccion() {
//         return transaccion;
//     }

//     /**
//      * Sets the value of the transaccion property.
//      *
//      * @param value
//      *     allowed object is
//      *     {@link String }
//      *
//      */
//     public void setTransaccion(String value) {
//         this.transaccion = value;
//     }

//     /**
//      * Gets the value of the usuario property.
//      *
//      * @return
//      *     possible object is
//      *     {@link String }
//      *
//      */
//     public String getUsuario() {
//         return usuario;
//     }

//     /**
//      * Sets the value of the usuario property.
//      *
//      * @param value
//      *     allowed object is
//      *     {@link String }
//      *
//      */
//     public void setUsuario(String value) {
//         this.usuario = value;
//     }

// }
