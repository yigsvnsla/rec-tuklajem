
package com.bolivariano.microservice.tuklajem.wsdl;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para BillPaymentResponse complex type.</p>
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.</p>
 * 
 * <pre>{@code
 * <complexType name="BillPaymentResponse">
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
@XmlType(name = "BillPaymentResponse", propOrder = {
    "switchAuditNumber",
    "resultCode",
    "errorMessage",
    "responseData",
    "billerCutoverDate",
    "sequenceAcquire",
    "standIN"
})
public class BillPaymentResponse {

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
     * Obtiene el valor de la propiedad switchAuditNumber.
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
     * Define el valor de la propiedad switchAuditNumber.
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
     * Obtiene el valor de la propiedad resultCode.
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
     * Define el valor de la propiedad resultCode.
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
     * Obtiene el valor de la propiedad errorMessage.
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
     * Define el valor de la propiedad errorMessage.
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
     * Obtiene el valor de la propiedad responseData.
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
     * Define el valor de la propiedad responseData.
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
     * Obtiene el valor de la propiedad billerCutoverDate.
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
     * Define el valor de la propiedad billerCutoverDate.
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
     * Obtiene el valor de la propiedad sequenceAcquire.
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
     * Define el valor de la propiedad sequenceAcquire.
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
     * Obtiene el valor de la propiedad standIN.
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
     * Define el valor de la propiedad standIN.
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
