
package com.bolivariano.microservice.agrocalidad.wsdl;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BillPaymentReversalRequest complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="BillPaymentReversalRequest">
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
 *         <element name="SwitchAuditNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="SequenceAcquire" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="BillerCutoverDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="Medio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="BranchId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="AccountId1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="Amount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="FormaPago" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="IndicatorReversal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="Trazabilidad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="Unicidad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "BillPaymentReversalRequest", propOrder = {
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
    "switchAuditNumber",
    "sequenceAcquire",
    "billerCutoverDate",
    "medio",
    "branchId",
    "accountId1",
    "amount",
    "formaPago",
    "indicatorReversal",
    "trazabilidad",
    "unicidad",
    "aditionalData"
})
public class BillPaymentReversalRequest {

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
    @XmlElement(name = "SwitchAuditNumber")
    protected String switchAuditNumber;
    @XmlElement(name = "SequenceAcquire")
    protected String sequenceAcquire;
    @XmlElement(name = "BillerCutoverDate")
    protected String billerCutoverDate;
    @XmlElement(name = "Medio")
    protected String medio;
    @XmlElement(name = "BranchId")
    protected String branchId;
    @XmlElement(name = "AccountId1")
    protected String accountId1;
    @XmlElement(name = "Amount")
    protected String amount;
    @XmlElement(name = "FormaPago")
    protected String formaPago;
    @XmlElement(name = "IndicatorReversal")
    protected String indicatorReversal;
    @XmlElement(name = "Trazabilidad")
    protected String trazabilidad;
    @XmlElement(name = "Unicidad")
    protected String unicidad;
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
     * Gets the value of the accountId1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountId1() {
        return accountId1;
    }

    /**
     * Sets the value of the accountId1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountId1(String value) {
        this.accountId1 = value;
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
     * Gets the value of the formaPago property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormaPago() {
        return formaPago;
    }

    /**
     * Sets the value of the formaPago property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormaPago(String value) {
        this.formaPago = value;
    }

    /**
     * Gets the value of the indicatorReversal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndicatorReversal() {
        return indicatorReversal;
    }

    /**
     * Sets the value of the indicatorReversal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndicatorReversal(String value) {
        this.indicatorReversal = value;
    }

    /**
     * Gets the value of the trazabilidad property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrazabilidad() {
        return trazabilidad;
    }

    /**
     * Sets the value of the trazabilidad property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrazabilidad(String value) {
        this.trazabilidad = value;
    }

    /**
     * Gets the value of the unicidad property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnicidad() {
        return unicidad;
    }

    /**
     * Sets the value of the unicidad property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnicidad(String value) {
        this.unicidad = value;
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
