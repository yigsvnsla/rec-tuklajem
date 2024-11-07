
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
     * Gets the value of the billInquiryRequest property.
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
     * Sets the value of the billInquiryRequest property.
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
