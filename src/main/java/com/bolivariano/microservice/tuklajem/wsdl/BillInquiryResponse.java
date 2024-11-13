
package com.bolivariano.microservice.tuklajem.wsdl;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para BillInquiryResponse complex type.</p>
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.</p>
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
     * Obtiene el valor de la propiedad amount.
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
     * Define el valor de la propiedad amount.
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
     * Obtiene el valor de la propiedad commissionsClient.
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
     * Define el valor de la propiedad commissionsClient.
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
     * Obtiene el valor de la propiedad commissionsComerce.
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
     * Define el valor de la propiedad commissionsComerce.
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
     * Obtiene el valor de la propiedad partialPayment.
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
     * Define el valor de la propiedad partialPayment.
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
