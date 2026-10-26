/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author Sumanth
 */
public class VendorFinancialDetailsHistory {

    private int id;
    private int vendorInfoId;
    private String dateTime;
    private String gsntNo;
    private String gstFile;
    private String panNo;
    private String panFile;
    private String msmeNo;
    private String msmeFile;
    private String msmeStatus;
    private String esicNo;
    private String esicFile;
    private String esicStatus;
    private String epfoNo;
    private String epfoFile;
    private String epfoStatus;
    private String iecNo;
    private String iecFile;
    private String iecStatus;
    private String accountNo;
    private String bankName;
    private String branchName;
    private String ifscCode;
    private String swiftCode;
    private String cancelCheck;
    private String finacialYearOne;
    private String finacialYearAmountOne;
    private String finacialYearFileOne;
    private String finacialYearTwo;
    private String finacialYearAmountTwo;
    private String finacialYearFileTwo;
    private String finacialYearThree;
    private String finacialYearAmountThree;
    private String finacialYearFileThree;
    private String historyComment;
    private String history;

   

    public VendorFinancialDetailsHistory() {
    }

    public VendorFinancialDetailsHistory(int id, int vendorInfoId, String dateTime, String gsntNo, String gstFile, String panNo, String panFile, String msmeNo, String msmeFile, String msmeStatus, String esicNo, String esicFile, String esicStatus, String epfoNo, String epfoFile, String epfoStatus, String iecNo, String iecFile, String iecStatus, String accountNo, String bankName, String branchName, String ifscCode, String swiftCode, String cancelCheck, String finacialYearOne, String finacialYearAmountOne, String finacialYearFileOne, String finacialYearTwo, String finacialYearAmountTwo, String finacialYearFileTwo, String finacialYearThree, String finacialYearAmountThree, String finacialYearFileThree, String historyComment, String history) {
        this.id = id;
        this.vendorInfoId = vendorInfoId;
        this.dateTime = dateTime;
        this.gsntNo = gsntNo;
        this.gstFile = gstFile;
        this.panNo = panNo;
        this.panFile = panFile;
        this.msmeNo = msmeNo;
        this.msmeFile = msmeFile;
        this.msmeStatus = msmeStatus;
        this.esicNo = esicNo;
        this.esicFile = esicFile;
        this.esicStatus = esicStatus;
        this.epfoNo = epfoNo;
        this.epfoFile = epfoFile;
        this.epfoStatus = epfoStatus;
        this.iecNo = iecNo;
        this.iecFile = iecFile;
        this.iecStatus = iecStatus;
        this.accountNo = accountNo;
        this.bankName = bankName;
        this.branchName = branchName;
        this.ifscCode = ifscCode;
        this.swiftCode = swiftCode;
        this.cancelCheck = cancelCheck;
        this.finacialYearOne = finacialYearOne;
        this.finacialYearAmountOne = finacialYearAmountOne;
        this.finacialYearFileOne = finacialYearFileOne;
        this.finacialYearTwo = finacialYearTwo;
        this.finacialYearAmountTwo = finacialYearAmountTwo;
        this.finacialYearFileTwo = finacialYearFileTwo;
        this.finacialYearThree = finacialYearThree;
        this.finacialYearAmountThree = finacialYearAmountThree;
        this.finacialYearFileThree = finacialYearFileThree;
        this.historyComment = historyComment;
        this.history = history;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVendorInfoId() {
        return vendorInfoId;
    }

    public void setVendorInfoId(int vendorInfoId) {
        this.vendorInfoId = vendorInfoId;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getGsntNo() {
        return gsntNo;
    }

    public void setGsntNo(String gsntNo) {
        this.gsntNo = gsntNo;
    }

    public String getGstFile() {
        return gstFile;
    }

    public void setGstFile(String gstFile) {
        this.gstFile = gstFile;
    }

    public String getPanNo() {
        return panNo;
    }

    public void setPanNo(String panNo) {
        this.panNo = panNo;
    }

    public String getPanFile() {
        return panFile;
    }

    public void setPanFile(String panFile) {
        this.panFile = panFile;
    }

    public String getMsmeNo() {
        return msmeNo;
    }

    public void setMsmeNo(String msmeNo) {
        this.msmeNo = msmeNo;
    }

    public String getMsmeFile() {
        return msmeFile;
    }

    public void setMsmeFile(String msmeFile) {
        this.msmeFile = msmeFile;
    }

    public String getMsmeStatus() {
        return msmeStatus;
    }

    public void setMsmeStatus(String msmeStatus) {
        this.msmeStatus = msmeStatus;
    }

    public String getEsicNo() {
        return esicNo;
    }

    public void setEsicNo(String esicNo) {
        this.esicNo = esicNo;
    }

    public String getEsicFile() {
        return esicFile;
    }

    public void setEsicFile(String esicFile) {
        this.esicFile = esicFile;
    }

    public String getEsicStatus() {
        return esicStatus;
    }

    public void setEsicStatus(String esicStatus) {
        this.esicStatus = esicStatus;
    }

    public String getEpfoNo() {
        return epfoNo;
    }

    public void setEpfoNo(String epfoNo) {
        this.epfoNo = epfoNo;
    }

    public String getEpfoFile() {
        return epfoFile;
    }

    public void setEpfoFile(String epfoFile) {
        this.epfoFile = epfoFile;
    }

    public String getEpfoStatus() {
        return epfoStatus;
    }

    public void setEpfoStatus(String epfoStatus) {
        this.epfoStatus = epfoStatus;
    }

    public String getIecNo() {
        return iecNo;
    }

    public void setIecNo(String iecNo) {
        this.iecNo = iecNo;
    }

    public String getIecFile() {
        return iecFile;
    }

    public void setIecFile(String iecFile) {
        this.iecFile = iecFile;
    }

    public String getIecStatus() {
        return iecStatus;
    }

    public void setIecStatus(String iecStatus) {
        this.iecStatus = iecStatus;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getSwiftCode() {
        return swiftCode;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }

    public String getCancelCheck() {
        return cancelCheck;
    }

    public void setCancelCheck(String cancelCheck) {
        this.cancelCheck = cancelCheck;
    }

    public String getFinacialYearOne() {
        return finacialYearOne;
    }

    public void setFinacialYearOne(String finacialYearOne) {
        this.finacialYearOne = finacialYearOne;
    }

    public String getFinacialYearAmountOne() {
        return finacialYearAmountOne;
    }

    public void setFinacialYearAmountOne(String finacialYearAmountOne) {
        this.finacialYearAmountOne = finacialYearAmountOne;
    }

    public String getFinacialYearFileOne() {
        return finacialYearFileOne;
    }

    public void setFinacialYearFileOne(String finacialYearFileOne) {
        this.finacialYearFileOne = finacialYearFileOne;
    }

    public String getFinacialYearTwo() {
        return finacialYearTwo;
    }

    public void setFinacialYearTwo(String finacialYearTwo) {
        this.finacialYearTwo = finacialYearTwo;
    }

    public String getFinacialYearAmountTwo() {
        return finacialYearAmountTwo;
    }

    public void setFinacialYearAmountTwo(String finacialYearAmountTwo) {
        this.finacialYearAmountTwo = finacialYearAmountTwo;
    }

    public String getFinacialYearFileTwo() {
        return finacialYearFileTwo;
    }

    public void setFinacialYearFileTwo(String finacialYearFileTwo) {
        this.finacialYearFileTwo = finacialYearFileTwo;
    }

    public String getFinacialYearThree() {
        return finacialYearThree;
    }

    public void setFinacialYearThree(String finacialYearThree) {
        this.finacialYearThree = finacialYearThree;
    }

    public String getFinacialYearAmountThree() {
        return finacialYearAmountThree;
    }

    public void setFinacialYearAmountThree(String finacialYearAmountThree) {
        this.finacialYearAmountThree = finacialYearAmountThree;
    }

    public String getFinacialYearFileThree() {
        return finacialYearFileThree;
    }

    public void setFinacialYearFileThree(String finacialYearFileThree) {
        this.finacialYearFileThree = finacialYearFileThree;
    }

    public String getHistoryComment() {
        return historyComment;
    }

    public void setHistoryComment(String historyComment) {
        this.historyComment = historyComment;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

   

    
    
    
    
    
}
