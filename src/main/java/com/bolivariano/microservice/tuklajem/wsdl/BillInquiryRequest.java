
package com.bolivariano.microservice.tuklajem.wsdl;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para BillInquiryRequest complex type.</p>
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.</p>
 * 
 * <pre>{@code
 * <complexType name="BillInquiryRequest">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="Channel" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="PrimaryAcctNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="TxCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="AcquirerAuditNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="TransactionTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="TransactionDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="AcquirerInstitutionID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="Track2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="TerminalID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="CurrencyCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="BillReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="BillServiceCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="BillCompanyCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="Medio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="BranchId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="AditionalData" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BillInquiryRequest", propOrder = {
    "channel",
    "primaryAcctNumber",
    "txCode",
    "acquirerAuditNumber",
    "transactionTime",
    "transactionDate",
    "acquirerInstitutionID",
    "track2",
    "terminalID",
    "currencyCode",
    "billReference",
    "billServiceCode",
    "billCompanyCode",
    "medio",
    "branchId",
    "aditionalData"
})
public class BillInquiryRequest {

    @XmlElement(name = "Channel")
    protected int channel;
    @XmlElement(name = "PrimaryAcctNumber")
    protected String primaryAcctNumber;
    @XmlElement(name = "TxCode")
    protected String txCode;
    @XmlElement(name = "AcquirerAuditNumber")
    protected String acquirerAuditNumber;
    @XmlElement(name = "TransactionTime")
    protected String transactionTime;
    @XmlElement(name = "TransactionDate")
    protected String transactionDate;
    @XmlElement(name = "AcquirerInstitutionID")
    protected String acquirerInstitutionID;
    @XmlElement(name = "Track2")
    protected String track2;
    @XmlElement(name = "TerminalID")
    protected String terminalID;
    @XmlElement(name = "CurrencyCode")
    protected int currencyCode;
    @XmlElement(name = "BillReference")
    protected String billReference;
    @XmlElement(name = "BillServiceCode")
    protected int billServiceCode;
    @XmlElement(name = "BillCompanyCode")
    protected int billCompanyCode;
    @XmlElement(name = "Medio")
    protected String medio;
    @XmlElement(name = "BranchId")
    protected String branchId;
    @XmlElement(name = "AditionalData")
    protected String aditionalData;

    /**
     * Obtiene el valor de la propiedad channel.
     * 
     */
    public int getChannel() {
        return channel;
    }

    /**
     * Define el valor de la propiedad channel.
     * 
     */
    public void setChannel(int value) {
        this.channel = value;
    }

    /**
     * Obtiene el valor de la propiedad primaryAcctNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrimaryAcctNumber() {
        return primaryAcctNumber;
    }

    /**
     * Define el valor de la propiedad primaryAcctNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrimaryAcctNumber(String value) {
        this.primaryAcctNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad txCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTxCode() {
        return txCode;
    }

    /**
     * Define el valor de la propiedad txCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTxCode(String value) {
        this.txCode = value;
    }

    /**
     * Obtiene el valor de la propiedad acquirerAuditNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcquirerAuditNumber() {
        return acquirerAuditNumber;
    }

    /**
     * Define el valor de la propiedad acquirerAuditNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcquirerAuditNumber(String value) {
        this.acquirerAuditNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad transactionTime.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionTime() {
        return transactionTime;
    }

    /**
     * Define el valor de la propiedad transactionTime.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionTime(String value) {
        this.transactionTime = value;
    }

    /**
     * Obtiene el valor de la propiedad transactionDate.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionDate() {
        return transactionDate;
    }

    /**
     * Define el valor de la propiedad transactionDate.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionDate(String value) {
        this.transactionDate = value;
    }

    /**
     * Obtiene el valor de la propiedad acquirerInstitutionID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcquirerInstitutionID() {
        return acquirerInstitutionID;
    }

    /**
     * Define el valor de la propiedad acquirerInstitutionID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcquirerInstitutionID(String value) {
        this.acquirerInstitutionID = value;
    }

    /**
     * Obtiene el valor de la propiedad track2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrack2() {
        return track2;
    }

    /**
     * Define el valor de la propiedad track2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrack2(String value) {
        this.track2 = value;
    }

    /**
     * Obtiene el valor de la propiedad terminalID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTerminalID() {
        return terminalID;
    }

    /**
     * Define el valor de la propiedad terminalID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTerminalID(String value) {
        this.terminalID = value;
    }

    /**
     * Obtiene el valor de la propiedad currencyCode.
     * 
     */
    public int getCurrencyCode() {
        return currencyCode;
    }

    /**
     * Define el valor de la propiedad currencyCode.
     * 
     */
    public void setCurrencyCode(int value) {
        this.currencyCode = value;
    }

    /**
     * Obtiene el valor de la propiedad billReference.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillReference() {
        return billReference;
    }

    /**
     * Define el valor de la propiedad billReference.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillReference(String value) {
        this.billReference = value;
    }

    /**
     * Obtiene el valor de la propiedad billServiceCode.
     * 
     */
    public int getBillServiceCode() {
        return billServiceCode;
    }

    /**
     * Define el valor de la propiedad billServiceCode.
     * 
     */
    public void setBillServiceCode(int value) {
        this.billServiceCode = value;
    }

    /**
     * Obtiene el valor de la propiedad billCompanyCode.
     * 
     */
    public int getBillCompanyCode() {
        return billCompanyCode;
    }

    /**
     * Define el valor de la propiedad billCompanyCode.
     * 
     */
    public void setBillCompanyCode(int value) {
        this.billCompanyCode = value;
    }

    /**
     * Obtiene el valor de la propiedad medio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMedio() {
        return medio;
    }

    /**
     * Define el valor de la propiedad medio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMedio(String value) {
        this.medio = value;
    }

    /**
     * Obtiene el valor de la propiedad branchId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBranchId() {
        return branchId;
    }

    /**
     * Define el valor de la propiedad branchId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBranchId(String value) {
        this.branchId = value;
    }

    /**
     * Obtiene el valor de la propiedad aditionalData.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAditionalData() {
        return aditionalData;
    }

    /**
     * Define el valor de la propiedad aditionalData.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAditionalData(String value) {
        this.aditionalData = value;
    }

}
