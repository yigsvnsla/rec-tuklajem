
package com.bolivariano.microservice.agrocalidad.wsdl;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BillInquiryRequest complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
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
     * Gets the value of the channel property.
     * 
     */
    public int getChannel() {
        return channel;
    }

    /**
     * Sets the value of the channel property.
     * 
     */
    public void setChannel(int value) {
        this.channel = value;
    }

    /**
     * Gets the value of the primaryAcctNumber property.
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
     * Sets the value of the primaryAcctNumber property.
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
     * Gets the value of the txCode property.
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
     * Sets the value of the txCode property.
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
     * Gets the value of the acquirerAuditNumber property.
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
     * Sets the value of the acquirerAuditNumber property.
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
     * Gets the value of the transactionTime property.
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
     * Sets the value of the transactionTime property.
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
     * Gets the value of the transactionDate property.
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
     * Sets the value of the transactionDate property.
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
     * Gets the value of the acquirerInstitutionID property.
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
     * Sets the value of the acquirerInstitutionID property.
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
     * Gets the value of the track2 property.
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
     * Sets the value of the track2 property.
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
     * Gets the value of the terminalID property.
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
     * Sets the value of the terminalID property.
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
     * Gets the value of the currencyCode property.
     * 
     */
    public int getCurrencyCode() {
        return currencyCode;
    }

    /**
     * Sets the value of the currencyCode property.
     * 
     */
    public void setCurrencyCode(int value) {
        this.currencyCode = value;
    }

    /**
     * Gets the value of the billReference property.
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
     * Sets the value of the billReference property.
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
     * Gets the value of the billServiceCode property.
     * 
     */
    public int getBillServiceCode() {
        return billServiceCode;
    }

    /**
     * Sets the value of the billServiceCode property.
     * 
     */
    public void setBillServiceCode(int value) {
        this.billServiceCode = value;
    }

    /**
     * Gets the value of the billCompanyCode property.
     * 
     */
    public int getBillCompanyCode() {
        return billCompanyCode;
    }

    /**
     * Sets the value of the billCompanyCode property.
     * 
     */
    public void setBillCompanyCode(int value) {
        this.billCompanyCode = value;
    }

    /**
     * Gets the value of the medio property.
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
     * Sets the value of the medio property.
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
     * Gets the value of the branchId property.
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
     * Sets the value of the branchId property.
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
     * Gets the value of the aditionalData property.
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
     * Sets the value of the aditionalData property.
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
