/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author Admin
 */
public class InvoiceAttachment {

    private int id;
    private String invoiceAttachment;
    private int poId;  // This is PO ID
    private String documentNo;
    private String poNo;
    private String tenderNo;
    private String invoiceAmount;
    private String otherDocumentNo;
    private String documentType;
    private String vendorCode;
    private String vendorName;
    private int status;
    private String buyerAttachment;
    private String buyerComment;
    private String vendorComment;
    private int grnStatus;
    private String grnComment;
    private String grnAttachment;
    private String grnNumber;
    private int financialStatus;
    private String financialComment;
    private String financialAttachment;
    private String grnExectiveCode;
    private String financialPersonCode;

    public InvoiceAttachment() {
    }

    public InvoiceAttachment(int id, String invoiceAttachment, int poId, String documentNo, String poNo, String tenderNo, String invoiceAmount, String otherDocumentNo, String documentType, String vendorCode, String vendorName, int status, String buyerAttachment, String buyerComment, String vendorComment, int grnStatus, String grnComment, String grnAttachment, String grnNumber, int financialStatus, String financialComment, String financialAttachment, String grnExectiveCode, String financialPersonCode) {
        this.id = id;
        this.invoiceAttachment = invoiceAttachment;
        this.poId = poId;
        this.documentNo = documentNo;
        this.poNo = poNo;
        this.tenderNo = tenderNo;
        this.invoiceAmount = invoiceAmount;
        this.otherDocumentNo = otherDocumentNo;
        this.documentType = documentType;
        this.vendorCode = vendorCode;
        this.vendorName = vendorName;
        this.status = status;
        this.buyerAttachment = buyerAttachment;
        this.buyerComment = buyerComment;
        this.vendorComment = vendorComment;
        this.grnStatus = grnStatus;
        this.grnComment = grnComment;
        this.grnAttachment = grnAttachment;
        this.grnNumber = grnNumber;
        this.financialStatus = financialStatus;
        this.financialComment = financialComment;
        this.financialAttachment = financialAttachment;
        this.grnExectiveCode = grnExectiveCode;
        this.financialPersonCode = financialPersonCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInvoiceAttachment() {
        return invoiceAttachment;
    }

    public void setInvoiceAttachment(String invoiceAttachment) {
        this.invoiceAttachment = invoiceAttachment;
    }

    public int getPoId() {
        return poId;
    }

    public void setPoId(int poId) {
        this.poId = poId;
    }

    public String getDocumentNo() {
        return documentNo;
    }

    public void setDocumentNo(String documentNo) {
        this.documentNo = documentNo;
    }

    public String getPoNo() {
        return poNo;
    }

    public void setPoNo(String poNo) {
        this.poNo = poNo;
    }

    public String getTenderNo() {
        return tenderNo;
    }

    public void setTenderNo(String tenderNo) {
        this.tenderNo = tenderNo;
    }

    public String getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(String invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public String getOtherDocumentNo() {
        return otherDocumentNo;
    }

    public void setOtherDocumentNo(String otherDocumentNo) {
        this.otherDocumentNo = otherDocumentNo;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getBuyerAttachment() {
        return buyerAttachment;
    }

    public void setBuyerAttachment(String buyerAttachment) {
        this.buyerAttachment = buyerAttachment;
    }

    public String getBuyerComment() {
        return buyerComment;
    }

    public void setBuyerComment(String buyerComment) {
        this.buyerComment = buyerComment;
    }

    public String getVendorComment() {
        return vendorComment;
    }

    public void setVendorComment(String vendorComment) {
        this.vendorComment = vendorComment;
    }

    public int getGrnStatus() {
        return grnStatus;
    }

    public void setGrnStatus(int grnStatus) {
        this.grnStatus = grnStatus;
    }

    public String getGrnComment() {
        return grnComment;
    }

    public void setGrnComment(String grnComment) {
        this.grnComment = grnComment;
    }

    public String getGrnAttachment() {
        return grnAttachment;
    }

    public void setGrnAttachment(String grnAttachment) {
        this.grnAttachment = grnAttachment;
    }

    public String getGrnNumber() {
        return grnNumber;
    }

    public void setGrnNumber(String grnNumber) {
        this.grnNumber = grnNumber;
    }

    public int getFinancialStatus() {
        return financialStatus;
    }

    public void setFinancialStatus(int financialStatus) {
        this.financialStatus = financialStatus;
    }

    public String getFinancialComment() {
        return financialComment;
    }

    public void setFinancialComment(String financialComment) {
        this.financialComment = financialComment;
    }

    public String getFinancialAttachment() {
        return financialAttachment;
    }

    public void setFinancialAttachment(String financialAttachment) {
        this.financialAttachment = financialAttachment;
    }

    public String getGrnExectiveCode() {
        return grnExectiveCode;
    }

    public void setGrnExectiveCode(String grnExectiveCode) {
        this.grnExectiveCode = grnExectiveCode;
    }

    public String getFinancialPersonCode() {
        return financialPersonCode;
    }

    public void setFinancialPersonCode(String financialPersonCode) {
        this.financialPersonCode = financialPersonCode;
    }

}
