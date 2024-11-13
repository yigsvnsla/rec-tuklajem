
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
 *         <element name="BillPaymentResponse" type="{http://tempuri.org/}BillPaymentResponse" minOccurs="0"/>
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
    "billPaymentResponse"
})
@XmlRootElement(name = "BillPaymentRs")
public class BillPaymentRs {

    @XmlElement(name = "BillPaymentResponse")
    protected BillPaymentResponse billPaymentResponse;

    /**
     * Obtiene el valor de la propiedad billPaymentResponse.
     * 
     * @return
     *     possible object is
     *     {@link BillPaymentResponse }
     *     
     */
    public BillPaymentResponse getBillPaymentResponse() {
        return billPaymentResponse;
    }

    /**
     * Define el valor de la propiedad billPaymentResponse.
     * 
     * @param value
     *     allowed object is
     *     {@link BillPaymentResponse }
     *     
     */
    public void setBillPaymentResponse(BillPaymentResponse value) {
        this.billPaymentResponse = value;
    }

}
