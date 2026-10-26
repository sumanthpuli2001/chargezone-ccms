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
public class ServiceDetail3 {
    
    private int id;
    private double srNo;
    private String particular;
    private String scheduledAmount;
    private String fileName;
    private String negativeAmount;
    private String tenderNo;
    private String refNo;
    
    public ServiceDetail3() {
    }
    
    public ServiceDetail3(int id, double srNo, String particular, String scheduledAmount, String fileName, String negativeAmount, String tenderNo, String refNo) {
        this.id = id;
        this.srNo = srNo;
        this.particular = particular;
        this.scheduledAmount = scheduledAmount;
        this.fileName = fileName;
        this.negativeAmount = negativeAmount;
        this.tenderNo = tenderNo;
        this.refNo = refNo;
    }

    public int getId() {
        return id;
    }

    public ServiceDetail3 setId(int id) {
        this.id = id;
        return this;
    }

    public double getSrNo() {
        return srNo;
    }

    public ServiceDetail3 setSrNo(double srNo) {
        this.srNo = srNo;
        return this;
    }

    public String getParticular() {
        return particular;
    }

    public ServiceDetail3 setParticular(String particular) {
        this.particular = particular;
        return this;
    }

    public String getScheduledAmount() {
        return scheduledAmount;
    }

    public ServiceDetail3 setScheduledAmount(String scheduledAmount) {
        this.scheduledAmount = scheduledAmount;
        return this;
    }

    public String getFileName() {
        return fileName;
    }

    public ServiceDetail3 setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public String getNegativeAmount() {
        return negativeAmount;
    }

    public ServiceDetail3 setNegativeAmount(String negativeAmount) {
        this.negativeAmount = negativeAmount;
        return this;
    }

    public String getTenderNo() {
        return tenderNo;
    }

    public ServiceDetail3 setTenderNo(String tenderNo) {
        this.tenderNo = tenderNo;
        return this;
    }

    public String getRefNo() {
        return refNo;
    }

    public ServiceDetail3 setRefNo(String refNo) {
        this.refNo = refNo;
        return this;
    }
    
    
}
