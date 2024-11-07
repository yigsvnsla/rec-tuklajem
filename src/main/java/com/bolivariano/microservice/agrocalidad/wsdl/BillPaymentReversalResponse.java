
package com.bolivariano.microservice.agrocalidad.wsdl;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BillPaymentReversalResponse complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="BillPaymentReversalResponse">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="SwitchAuditNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="ResultCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="ErrorMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="ResponseData" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="BillerCutoverDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="SequenceAcquire" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="StandIN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BillPaymentReversalResponse", propOrder = {
    "switchAuditNumber",
    "resultCode",
    "errorMessage",
    "responseData",
    "billerCutoverDate",
    "sequenceAcquire",
    "standIN"
})
public class BillPaymentReversalResponse {

    @XmlElement(name = "SwitchAuditNumber")
    protected String switchAuditNumber;
    @XmlElement(name = "ResultCode")
    protected String resultCode;
    @XmlElement(name = "ErrorMessage")
    protected String errorMessage;
    @XmlElement(name = "ResponseData")
    protected String responseData;
    @XmlElement(name = "BillerCutoverDate")
    protected String billerCutoverDate;
    @XmlElement(name = "SequenceAcquire")
    protected String sequenceAcquire;
    @XmlElement(name = "StandIN")
    protected String standIN;

    /**
     * Gets the value of the switchAuditNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSwitchAuditNumber() {
        return switchAuditNumber;
    }

    /**
     * Sets the value of the switchAuditNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSwitchAuditNumber(String value) {
        this.switchAuditNumber = value;
    }

    /**
     * Gets the value of the resultCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResultCode() {
        return resultCode;
    }

    /**
     * Sets the value of the resultCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResultCode(String value) {
        this.resultCode = value;
    }

    /**
     * Gets the value of the errorMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Sets the value of the errorMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorMessage(String value) {
        this.errorMessage = value;
    }

    /**
     * Gets the value of the responseData property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponseData() {
        return responseData;
    }

    /**
     * Sets the value of the responseData property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponseData(String value) {
        this.responseData = value;
    }

    /**
     * Gets the value of the billerCutoverDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillerCutoverDate() {
        return billerCutoverDate;
    }

    /**
     * Sets the value of the billerCutoverDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillerCutoverDate(String value) {
        this.billerCutoverDate = value;
    }

    /**
     * Gets the value of the sequenceAcquire property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSequenceAcquire() {
        return sequenceAcquire;
    }

    /**
     * Sets the value of the sequenceAcquire property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSequenceAcquire(String value) {
        this.sequenceAcquire = value;
    }

    /**
     * Gets the value of the standIN property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStandIN() {
        return standIN;
    }

    /**
     * Sets the value of the standIN property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStandIN(String value) {
        this.standIN = value;
    }

}
