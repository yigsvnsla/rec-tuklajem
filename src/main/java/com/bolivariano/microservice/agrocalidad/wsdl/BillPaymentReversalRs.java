
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
 *         <element name="BillPaymentReversalResponse" type="{http://tempuri.org/}BillPaymentReversalResponse" minOccurs="0"/>
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
    "billPaymentReversalResponse"
})
@XmlRootElement(name = "BillPaymentReversalRs")
public class BillPaymentReversalRs {

    @XmlElement(name = "BillPaymentReversalResponse")
    protected BillPaymentReversalResponse billPaymentReversalResponse;

    /**
     * Gets the value of the billPaymentReversalResponse property.
     * 
     * @return
     *     possible object is
     *     {@link BillPaymentReversalResponse }
     *     
     */
    public BillPaymentReversalResponse getBillPaymentReversalResponse() {
        return billPaymentReversalResponse;
    }

    /**
     * Sets the value of the billPaymentReversalResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link BillPaymentReversalResponse }
     *     
     */
    public void setBillPaymentReversalResponse(BillPaymentReversalResponse value) {
        this.billPaymentReversalResponse = value;
    }

}
