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
public class ServiceVendorTenderBidItem3 {
    
    private int id;
    private String tenderNo;
    private String vendorCode;
    private String fileName;
    private String srNo;    
    private String particular;    
    private String scheduledAmount;    
    private String percent;    
    private String percentRate;    
    private String amountTotal;    
    private String itemCode;    
    private String vendorRemark;    
    private String itemregret;    
    private String remark;    
        
    
    public ServiceVendorTenderBidItem3() {
    }
    
    public ServiceVendorTenderBidItem3(int id, String tenderNo, String vendorCode, String fileName, String srNo, String particular, String scheduledAmount, String percent, String percentRate, String amountTotal, String itemCode, String vendorRemark, String itemregret, String remark) {
        this.id = id;
        this.tenderNo = tenderNo;
        this.vendorCode = vendorCode;
        this.fileName = fileName;
        this.srNo = srNo;    
        this.particular = particular;    
        this.scheduledAmount = scheduledAmount;    
        this.percent = percent;    
        this.percentRate = percentRate;    
        this.amountTotal = amountTotal;    
        this.itemCode = itemCode;    
        this.vendorRemark = vendorRemark;    
        this.itemregret = itemregret;    
        this.remark = remark;
    }

    public int getId() {
        return id;
    }

    public ServiceVendorTenderBidItem3 setId(int id) {
        this.id = id;
        return this;
    }

    public String getTenderNo() {
        return tenderNo;
    }

    public ServiceVendorTenderBidItem3 setTenderNo(String tenderNo) {
        this.tenderNo = tenderNo;
        return this;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public ServiceVendorTenderBidItem3 setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
        return this;
    }

    public String getFileName() {
        return fileName;
    }

    public ServiceVendorTenderBidItem3 setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public String getSrNo() {
        return srNo;
    }

    public ServiceVendorTenderBidItem3 setSrNo(String srNo) {
        this.srNo = srNo;
        return this;
    }

    public String getParticular() {
        return particular;
    }

    public ServiceVendorTenderBidItem3 setParticular(String particular) {
        this.particular = particular;
        return this;
    }

    public String getScheduledAmount() {
        return scheduledAmount;
    }

    public ServiceVendorTenderBidItem3 setScheduledAmount(String scheduledAmount) {
        this.scheduledAmount = scheduledAmount;
        return this;
    }

    public String getPercent() {
        return percent;
    }

    public ServiceVendorTenderBidItem3 setPercent(String percent) {
        this.percent = percent;
        return this;
    }

    public String getPercentRate() {
        return percentRate;
    }

    public ServiceVendorTenderBidItem3 setPercentRate(String percentRate) {
        this.percentRate = percentRate;
        return this;
    }

    public String getAmountTotal() {
        return amountTotal;
    }

    public ServiceVendorTenderBidItem3 setAmountTotal(String amountTotal) {
        this.amountTotal = amountTotal;
        return this;
    }

    public String getItemCode() {
        return itemCode;
    }

    public ServiceVendorTenderBidItem3 setItemCode(String itemCode) {
        this.itemCode = itemCode;
        return this;
    }

    public String getVendorRemark() {
        return vendorRemark;
    }

    public ServiceVendorTenderBidItem3 setVendorRemark(String vendorRemark) {
        this.vendorRemark = vendorRemark;
        return this;
    }

    public String getItemregret() {
        return itemregret;
    }

    public ServiceVendorTenderBidItem3 setItemregret(String itemregret) {
        this.itemregret = itemregret;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public ServiceVendorTenderBidItem3 setRemark(String remark) {
        this.remark = remark;
        return this;
    }
    
    
}
