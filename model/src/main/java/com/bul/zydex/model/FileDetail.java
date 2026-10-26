/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author admin
 */
public class FileDetail {
    
    private int id;
    private String tenderNo;
    private String title;
    private String fileName;
    private String serType;
    private String taxReq;
    private String totReq;
    private String negativeAmount;
    private String allowance;
    private String uniformTrainingCost;
    private String serviceCharge;
    private String dateWise;
    private String toDate;
    private String fromDate;
    private String allowReg;
    private String refNo;
    
    public FileDetail() {
    }
    
    public FileDetail(int id, String tenderNo, String title, String fileName, String serType, String taxReq, String totReq, String negativeAmount, String allowance, String uniformTrainingCost, String serviceCharge, String dateWise, String toDate, String fromDate, String allowReg, String refNo) {
        this.id = id;
        this.tenderNo = tenderNo;
        this.title = title;
        this.fileName = fileName;
        this.serType = serType;
        this.taxReq = taxReq;
        this.totReq = totReq;
        this.negativeAmount = negativeAmount;
        this.allowance = allowance;
        this.uniformTrainingCost = uniformTrainingCost;
        this.serviceCharge = serviceCharge;
        this.dateWise = dateWise;
        this.toDate = toDate;
        this.fromDate = fromDate;
        this.allowReg = allowReg;
        this.refNo = refNo;
    }

    public int getId() {
        return id;
    }

    public FileDetail setId(int id) {
        this.id = id;
        return this;
    }

    public String getTenderNo() {
        return tenderNo;
    }

    public FileDetail setTenderNo(String tenderNo) {
        this.tenderNo = tenderNo;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public FileDetail setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getFileName() {
        return fileName;
    }

    public FileDetail setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public String getSerType() {
        return serType;
    }

    public FileDetail setSerType(String serType) {
        this.serType = serType;
        return this;
    }

    public String getTaxReq() {
        return taxReq;
    }

    public FileDetail setTaxReq(String taxReq) {
        this.taxReq = taxReq;
        return this;
    }

    public String getTotReq() {
        return totReq;
    }

    public FileDetail setTotReq(String totReq) {
        this.totReq = totReq;
        return this;
    }

    public String getNegativeAmount() {
        return negativeAmount;
    }

    public FileDetail setNegativeAmount(String negativeAmount) {
        this.negativeAmount = negativeAmount;
        return this;
    }

    public String getAllowance() {
        return allowance;
    }

    public FileDetail setAllowance(String allowance) {
        this.allowance = allowance;
        return this;
    }

    public String getUniformTrainingCost() {
        return uniformTrainingCost;
    }

    public FileDetail setUniformTrainingCost(String uniformTrainingCost) {
        this.uniformTrainingCost = uniformTrainingCost;
        return this;
    }

    public String getServiceCharge() {
        return serviceCharge;
    }

    public FileDetail setServiceCharge(String serviceCharge) {
        this.serviceCharge = serviceCharge;
        return this;
    }

    public String getDateWise() {
        return dateWise;
    }

    public FileDetail setDateWise(String dateWise) {
        this.dateWise = dateWise;
        return this;
    }

    public String getToDate() {
        return toDate;
    }

    public FileDetail setToDate(String toDate) {
        this.toDate = toDate;
        return this;
    }

    public String getFromDate() {
        return fromDate;
    }

    public FileDetail setFromDate(String fromDate) {
        this.fromDate = fromDate;
        return this;
    }

    public String getAllowReg() {
        return allowReg;
    }

    public FileDetail setAllowReg(String allowReg) {
        this.allowReg = allowReg;
        return this;
    }

    public String getRefNo() {
        return refNo;
    }

    public FileDetail setRefNo(String refNo) {
        this.refNo = refNo;
        return this;
    }
    
    
}
