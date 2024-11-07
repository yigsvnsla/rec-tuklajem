
package com.bolivariano.microservice.agrocalidad.wsdl;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
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
     * Gets the value of the billPaymentRequest property.
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
     * Sets the value of the billPaymentRequest property.
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
