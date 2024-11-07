
package com.bolivariano.microservice.agrocalidad.wsdl;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BillInquiryResponse complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="BillInquiryResponse">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="SwitchAuditNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="ResultCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="ErrorMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="Amount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="ResponseData" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="CommissionsClient" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="CommissionsComerce" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="BillerCutoverDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="PartialPayment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BillInquiryResponse", propOrder = {
    "switchAuditNumber",
    "resultCode",
    "errorMessage",
    "amount",
    "responseData",
    "commissionsClient",
    "commissionsComerce",
    "billerCutoverDate",
    "partialPayment"
})
public class BillInquiryResponse {

    @XmlElement(name = "SwitchAuditNumber")
    protected String switchAuditNumber;
    @XmlElement(name = "ResultCode")
    protected String resultCode;
    @XmlElement(name = "ErrorMessage")
    protected String errorMessage;
    @XmlElement(name = "Amount")
    protected String amount;
    @XmlElement(name = "ResponseData")
    protected String responseData;
    @XmlElement(name = "CommissionsClient")
    protected String commissionsClient;
    @XmlElement(name = "CommissionsComerce")
    protected String commissionsComerce;
    @XmlElement(name = "BillerCutoverDate")
    protected String billerCutoverDate;
    @XmlElement(name = "PartialPayment")
    protected String partialPayment;

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
     * Gets the value of the amount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmount(String value) {
        this.amount = value;
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
     * Gets the value of the commissionsClient property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommissionsClient() {
        return commissionsClient;
    }

    /**
     * Sets the value of the commissionsClient property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommissionsClient(String value) {
        this.commissionsClient = value;
    }

    /**
     * Gets the value of the commissionsComerce property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommissionsComerce() {
        return commissionsComerce;
    }

    /**
     * Sets the value of the commissionsComerce property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommissionsComerce(String value) {
        this.commissionsComerce = value;
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
     * Gets the value of the partialPayment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPartialPayment() {
        return partialPayment;
    }

    /**
     * Sets the value of the partialPayment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPartialPayment(String value) {
        this.partialPayment = value;
    }

}
