
package com.bolivariano.microservice.agrocalidad.wsdl;

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
 *         <element name="BillInquiryRequest" type="{http://tempuri.org/}BillInquiryRequest" minOccurs="0"/>
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
    "billInquiryRequest"
})
@XmlRootElement(name = "BillInquiryRq")
public class BillInquiryRq {

    @XmlElement(name = "BillInquiryRequest")
    protected BillInquiryRequest billInquiryRequest;

    /**
     * Obtiene el valor de la propiedad billInquiryRequest.
     * 
     * @return
     *     possible object is
     *     {@link BillInquiryRequest }
     *     
     */
    public BillInquiryRequest getBillInquiryRequest() {
        return billInquiryRequest;
    }

    /**
     * Define el valor de la propiedad billInquiryRequest.
     * 
     * @param value
     *     allowed object is
     *     {@link BillInquiryRequest }
     *     
     */
    public void setBillInquiryRequest(BillInquiryRequest value) {
        this.billInquiryRequest = value;
    }

}
