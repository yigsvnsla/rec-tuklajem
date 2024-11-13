
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
 *         <element name="BillPaymentReversalRequest" type="{http://tempuri.org/}BillPaymentReversalRequest" minOccurs="0"/>
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
    "billPaymentReversalRequest"
})
@XmlRootElement(name = "BillPaymentReversalRq")
public class BillPaymentReversalRq {

    @XmlElement(name = "BillPaymentReversalRequest")
    protected BillPaymentReversalRequest billPaymentReversalRequest;

    /**
     * Obtiene el valor de la propiedad billPaymentReversalRequest.
     * 
     * @return
     *     possible object is
     *     {@link BillPaymentReversalRequest }
     *     
     */
    public BillPaymentReversalRequest getBillPaymentReversalRequest() {
        return billPaymentReversalRequest;
    }

    /**
     * Define el valor de la propiedad billPaymentReversalRequest.
     * 
     * @param value
     *     allowed object is
     *     {@link BillPaymentReversalRequest }
     *     
     */
    public void setBillPaymentReversalRequest(BillPaymentReversalRequest value) {
        this.billPaymentReversalRequest = value;
    }

}
