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
public class VendorFinancialApprovalDetails {

    private int id;
    private int vendorInfoId;
    private String gstStatus;
    private String gstRemark;
    private String gstResponces;
    private String panStatus;
    private String panRemark;
    private String panResponces;
    private String msmeStatus;
    private String msmeRemark;
    private String msmeResponces;
    private String esicStatus;
    private String esicRemark;
    private String esicResponce;
    private String epfoStatus;
    private String epfoRemark;
    private String epfoResponces;
    private String iecStatus;
    private String iecRemark;
    private String iecReponces;
    private String firstYearStatus;
    private String firstYearRemark;
    private String firstYearResponces;
    private String secondYearStatus;
    private String secondYearRemark;
    private String secondYearResponces;
    private String thirdYearStatus;
    private String thirdYearRemark;
    private String thirdYearResponces;
    private String cancelCheckStatus;
    private String cancelCheckRemark;
    private String cancelCheckResponse;
    private String finacialComment;

    public VendorFinancialApprovalDetails() {
    }

    public VendorFinancialApprovalDetails(int id, int vendorInfoId, String gstStatus, String gstRemark, String gstResponces, String panStatus, String panRemark, String panResponces, String msmeStatus, String msmeRemark, String msmeResponces, String esicStatus, String esicRemark, String esicResponce, String epfoStatus, String epfoRemark, String epfoResponces, String iecStatus, String iecRemark, String iecReponces, String firstYearStatus, String firstYearRemark, String firstYearResponces, String secondYearStatus, String secondYearRemark, String secondYearResponces, String thirdYearStatus, String thirdYearRemark, String thirdYearResponces, String cancelCheckStatus, String cancelCheckRemark, String cancelCheckResponse, String finacialComment) {
        this.id = id;
        this.vendorInfoId = vendorInfoId;
        this.gstStatus = gstStatus;
        this.gstRemark = gstRemark;
        this.gstResponces = gstResponces;
        this.panStatus = panStatus;
        this.panRemark = panRemark;
        this.panResponces = panResponces;
        this.msmeStatus = msmeStatus;
        this.msmeRemark = msmeRemark;
        this.msmeResponces = msmeResponces;
        this.esicStatus = esicStatus;
        this.esicRemark = esicRemark;
        this.esicResponce = esicResponce;
        this.epfoStatus = epfoStatus;
        this.epfoRemark = epfoRemark;
        this.epfoResponces = epfoResponces;
        this.iecStatus = iecStatus;
        this.iecRemark = iecRemark;
        this.iecReponces = iecReponces;
        this.firstYearStatus = firstYearStatus;
        this.firstYearRemark = firstYearRemark;
        this.firstYearResponces = firstYearResponces;
        this.secondYearStatus = secondYearStatus;
        this.secondYearRemark = secondYearRemark;
        this.secondYearResponces = secondYearResponces;
        this.thirdYearStatus = thirdYearStatus;
        this.thirdYearRemark = thirdYearRemark;
        this.thirdYearResponces = thirdYearResponces;
        this.cancelCheckStatus = cancelCheckStatus;
        this.cancelCheckRemark = cancelCheckRemark;
        this.cancelCheckResponse = cancelCheckResponse;
        this.finacialComment = finacialComment;
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

    public String getGstStatus() {
        return gstStatus;
    }

    public void setGstStatus(String gstStatus) {
        this.gstStatus = gstStatus;
    }

    public String getGstRemark() {
        return gstRemark;
    }

    public void setGstRemark(String gstRemark) {
        this.gstRemark = gstRemark;
    }

    public String getGstResponces() {
        return gstResponces;
    }

    public void setGstResponces(String gstResponces) {
        this.gstResponces = gstResponces;
    }

    public String getPanStatus() {
        return panStatus;
    }

    public void setPanStatus(String panStatus) {
        this.panStatus = panStatus;
    }

    public String getPanRemark() {
        return panRemark;
    }

    public void setPanRemark(String panRemark) {
        this.panRemark = panRemark;
    }

    public String getPanResponces() {
        return panResponces;
    }

    public void setPanResponces(String panResponces) {
        this.panResponces = panResponces;
    }

    public String getMsmeStatus() {
        return msmeStatus;
    }

    public void setMsmeStatus(String msmeStatus) {
        this.msmeStatus = msmeStatus;
    }

    public String getMsmeRemark() {
        return msmeRemark;
    }

    public void setMsmeRemark(String msmeRemark) {
        this.msmeRemark = msmeRemark;
    }

    public String getMsmeResponces() {
        return msmeResponces;
    }

    public void setMsmeResponces(String msmeResponces) {
        this.msmeResponces = msmeResponces;
    }

    public String getEsicStatus() {
        return esicStatus;
    }

    public void setEsicStatus(String esicStatus) {
        this.esicStatus = esicStatus;
    }

    public String getEsicRemark() {
        return esicRemark;
    }

    public void setEsicRemark(String esicRemark) {
        this.esicRemark = esicRemark;
    }

    public String getEsicResponce() {
        return esicResponce;
    }

    public void setEsicResponce(String esicResponce) {
        this.esicResponce = esicResponce;
    }

    public String getEpfoStatus() {
        return epfoStatus;
    }

    public void setEpfoStatus(String epfoStatus) {
        this.epfoStatus = epfoStatus;
    }

    public String getEpfoRemark() {
        return epfoRemark;
    }

    public void setEpfoRemark(String epfoRemark) {
        this.epfoRemark = epfoRemark;
    }

    public String getEpfoResponces() {
        return epfoResponces;
    }

    public void setEpfoResponces(String epfoResponces) {
        this.epfoResponces = epfoResponces;
    }

    public String getIecStatus() {
        return iecStatus;
    }

    public void setIecStatus(String iecStatus) {
        this.iecStatus = iecStatus;
    }

    public String getIecRemark() {
        return iecRemark;
    }

    public void setIecRemark(String iecRemark) {
        this.iecRemark = iecRemark;
    }

    public String getIecReponces() {
        return iecReponces;
    }

    public void setIecReponces(String iecReponces) {
        this.iecReponces = iecReponces;
    }

    public String getFirstYearStatus() {
        return firstYearStatus;
    }

    public void setFirstYearStatus(String firstYearStatus) {
        this.firstYearStatus = firstYearStatus;
    }

    public String getFirstYearRemark() {
        return firstYearRemark;
    }

    public void setFirstYearRemark(String firstYearRemark) {
        this.firstYearRemark = firstYearRemark;
    }

    public String getFirstYearResponces() {
        return firstYearResponces;
    }

    public void setFirstYearResponces(String firstYearResponces) {
        this.firstYearResponces = firstYearResponces;
    }

    public String getSecondYearStatus() {
        return secondYearStatus;
    }

    public void setSecondYearStatus(String secondYearStatus) {
        this.secondYearStatus = secondYearStatus;
    }

    public String getSecondYearRemark() {
        return secondYearRemark;
    }

    public void setSecondYearRemark(String secondYearRemark) {
        this.secondYearRemark = secondYearRemark;
    }

    public String getSecondYearResponces() {
        return secondYearResponces;
    }

    public void setSecondYearResponces(String secondYearResponces) {
        this.secondYearResponces = secondYearResponces;
    }

    public String getThirdYearStatus() {
        return thirdYearStatus;
    }

    public void setThirdYearStatus(String thirdYearStatus) {
        this.thirdYearStatus = thirdYearStatus;
    }

    public String getThirdYearRemark() {
        return thirdYearRemark;
    }

    public void setThirdYearRemark(String thirdYearRemark) {
        this.thirdYearRemark = thirdYearRemark;
    }

    public String getThirdYearResponces() {
        return thirdYearResponces;
    }

    public void setThirdYearResponces(String thirdYearResponces) {
        this.thirdYearResponces = thirdYearResponces;
    }

    public String getCancelCheckStatus() {
        return cancelCheckStatus;
    }

    public void setCancelCheckStatus(String cancelCheckStatus) {
        this.cancelCheckStatus = cancelCheckStatus;
    }

    public String getCancelCheckRemark() {
        return cancelCheckRemark;
    }

    public void setCancelCheckRemark(String cancelCheckRemark) {
        this.cancelCheckRemark = cancelCheckRemark;
    }

    public String getCancelCheckResponse() {
        return cancelCheckResponse;
    }

    public void setCancelCheckResponse(String cancelCheckResponse) {
        this.cancelCheckResponse = cancelCheckResponse;
    }

    public String getFinacialComment() {
        return finacialComment;
    }

    public void setFinacialComment(String finacialComment) {
        this.finacialComment = finacialComment;
    }

}
