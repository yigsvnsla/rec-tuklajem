
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
     * Gets the value of the billPaymentResponse property.
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
     * Sets the value of the billPaymentResponse property.
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
