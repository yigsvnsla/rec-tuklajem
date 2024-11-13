
package com.bolivariano.microservice.tuklajem.wsdl;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.</p>
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.</p>
 * 
 * <pre>{@code
 * <complexType>
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="BillPaymentRequest" type="{http://tempuri.org/}BillPaymentRequest" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "billPaymentRequest"
})
@XmlRootElement(name = "BillPaymentRq")
public class BillPaymentRq {

    @XmlElement(name = "BillPaymentRequest")
    protected BillPaymentRequest billPaymentRequest;

    /**
     * Obtiene el valor de la propiedad billPaymentRequest.
     * 
     * @return
     *     possible object is
     *     {@link BillPaymentRequest }
     *     
     */
    public BillPaymentRequest getBillPaymentRequest() {
        return billPaymentRequest;
    }

    /**
     * Define el valor de la propiedad billPaymentRequest.
     * 
     * @param value
     *     allowed object is
     *     {@link BillPaymentRequest }
     *     
     */
    public void setBillPaymentRequest(BillPaymentRequest value) {
        this.billPaymentRequest = value;
    }

}
