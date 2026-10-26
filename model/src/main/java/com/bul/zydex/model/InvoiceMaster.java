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
public class InvoiceMaster {

    private int id;
    private String invoiceNo;
    private String poNumber;
    private String poType;
    private String grnNumber;
    private String vendorCode;
    private String vendorName;
    private String invoiceDate;
    private String invoiceAmount;
    private int status;
    private String vendorComment;
    private String buyerComment;
    private int grnFlag;
    private String tenderNo;
    private String grnDate;
    private String grnComment;
    private String bookingNo;
    private String bookingDate;
    private String financialComment;

    private int financialFlag;
    private int buyerStatus;
    private int poId;
    private String grnExectiveCode;
    private String financialPersonCode;

    public InvoiceMaster() {
    }

    public InvoiceMaster(int id, String invoiceNo, String poNumber, String poType, String grnNumber, String vendorCode, String vendorName, String invoiceDate, String invoiceAmount, int status, String vendorComment, String buyerComment, int grnFlag, String tenderNo, String grnDate, String grnComment, String bookingNo, String bookingDate, String financialComment, int financialFlag, int buyerStatus, int poId, String grnExectiveCode, String financialPersonCode) {
        this.id = id;
        this.invoiceNo = invoiceNo;
        this.poNumber = poNumber;
        this.poType = poType;
        this.grnNumber = grnNumber;
        this.vendorCode = vendorCode;
        this.vendorName = vendorName;
        this.invoiceDate = invoiceDate;
        this.invoiceAmount = invoiceAmount;
        this.status = status;
        this.vendorComment = vendorComment;
        this.buyerComment = buyerComment;
        this.grnFlag = grnFlag;
        this.tenderNo = tenderNo;
        this.grnDate = grnDate;
        this.grnComment = grnComment;
        this.bookingNo = bookingNo;
        this.bookingDate = bookingDate;
        this.financialComment = financialComment;
        this.financialFlag = financialFlag;
        this.buyerStatus = buyerStatus;
        this.poId = poId;
        this.grnExectiveCode = grnExectiveCode;
        this.financialPersonCode = financialPersonCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public String getPoType() {
        return poType;
    }

    public void setPoType(String poType) {
        this.poType = poType;
    }

    public String getGrnNumber() {
        return grnNumber;
    }

    public void setGrnNumber(String grnNumber) {
        this.grnNumber = grnNumber;
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

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(String invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getVendorComment() {
        return vendorComment;
    }

    public void setVendorComment(String vendorComment) {
        this.vendorComment = vendorComment;
    }

    public String getBuyerComment() {
        return buyerComment;
    }

    public void setBuyerComment(String buyerComment) {
        this.buyerComment = buyerComment;
    }

    public int getGrnFlag() {
        return grnFlag;
    }

    public void setGrnFlag(int grnFlag) {
        this.grnFlag = grnFlag;
    }

    public String getTenderNo() {
        return tenderNo;
    }

    public void setTenderNo(String tenderNo) {
        this.tenderNo = tenderNo;
    }

    public String getGrnDate() {
        return grnDate;
    }

    public void setGrnDate(String grnDate) {
        this.grnDate = grnDate;
    }

    public String getGrnComment() {
        return grnComment;
    }

    public void setGrnComment(String grnComment) {
        this.grnComment = grnComment;
    }

    public String getBookingNo() {
        return bookingNo;
    }

    public void setBookingNo(String bookingNo) {
        this.bookingNo = bookingNo;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getFinancialComment() {
        return financialComment;
    }

    public void setFinancialComment(String financialComment) {
        this.financialComment = financialComment;
    }

    public int getFinancialFlag() {
        return financialFlag;
    }

    public void setFinancialFlag(int financialFlag) {
        this.financialFlag = financialFlag;
    }

    public int getBuyerStatus() {
        return buyerStatus;
    }

    public void setBuyerStatus(int buyerStatus) {
        this.buyerStatus = buyerStatus;
    }

    public int getPoId() {
        return poId;
    }

    public void setPoId(int poId) {
        this.poId = poId;
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
