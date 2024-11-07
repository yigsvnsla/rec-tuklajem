
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
     * Gets the value of the billPaymentReversalRequest property.
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
     * Sets the value of the billPaymentReversalRequest property.
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
