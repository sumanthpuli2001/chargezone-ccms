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
public class VendorTechnicalBid {
    
    private int id;
    private String refNo;
    private String vendorCode;
    private String technicalDeviation;
    private String technicalRemark;
    private String bidOpenDate;
    private String bidOpenBy;
    private String bidOpenById;
    private String bidOpenFlag;
    private String bidApproveDate;
    private String bidApproveBy;
    private String bidApproveById;
    private String bidApproveFlag;
    private int reviseBidFlag;
    private String techPercentage;
    
    public VendorTechnicalBid() {
    }

    public VendorTechnicalBid(int id, String refNo, String vendorCode, String technicalDeviation, String technicalRemark, String bidOpenDate, String bidOpenBy, String bidOpenById, String bidOpenFlag, String bidApproveDate, String bidApproveBy, String bidApproveById, String bidApproveFlag, int reviseBidFlag, String techPercentage) {
        this.id = id;
        this.refNo = refNo;
        this.vendorCode = vendorCode;
        this.technicalDeviation = technicalDeviation;
        this.technicalRemark = technicalRemark;
        this.bidOpenDate = bidOpenDate;
        this.bidOpenBy = bidOpenBy;
        this.bidOpenById = bidOpenById;
        this.bidOpenFlag = bidOpenFlag;
        this.bidApproveDate = bidApproveDate;
        this.bidApproveBy = bidApproveBy;
        this.bidApproveById = bidApproveById;
        this.bidApproveFlag = bidApproveFlag;
        this.reviseBidFlag = reviseBidFlag;
        this.techPercentage = techPercentage;
    }

    public int getId() {
        return id;
    }

    public VendorTechnicalBid setId(int id) {
        this.id = id;
        return this;
    }

    public String getRefNo() {
        return refNo;
    }

    public VendorTechnicalBid setRefNo(String refNo) {
        this.refNo = refNo;
        return this;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public VendorTechnicalBid setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
        return this;
    }

    public String getTechnicalDeviation() {
        return technicalDeviation;
    }

    public VendorTechnicalBid setTechnicalDeviation(String technicalDeviation) {
        this.technicalDeviation = technicalDeviation;
        return this;
    }

    public String getTechnicalRemark() {
        return technicalRemark;
    }

    public VendorTechnicalBid setTechnicalRemark(String technicalRemark) {
        this.technicalRemark = technicalRemark;
        return this;
    }

    public String getBidOpenDate() {
        return bidOpenDate;
    }

    public VendorTechnicalBid setBidOpenDate(String bidOpenDate) {
        this.bidOpenDate = bidOpenDate;
        return this;
    }
    
    public String getBidOpenBy() {
        return bidOpenBy;
    }

    public VendorTechnicalBid setBidOpenBy(String bidOpenBy) {
        this.bidOpenBy = bidOpenBy;
        return this;
    }

    public String getBidOpenById() {
        return bidOpenById;
    }

    public VendorTechnicalBid setBidOpenById(String bidOpenById) {
        this.bidOpenById = bidOpenById;
        return this;
    }

    public String getBidOpenFlag() {
        return bidOpenFlag;
    }

    public VendorTechnicalBid setBidOpenFlag(String bidOpenFlag) {
        this.bidOpenFlag = bidOpenFlag;
        return this;
    }

    public String getBidApproveDate() {
        return bidApproveDate;
    }

    public VendorTechnicalBid setBidApproveDate(String bidApproveDate) {
        this.bidApproveDate = bidApproveDate;
        return this;
    }

    public String getBidApproveBy() {
        return bidApproveBy;
    }

    public VendorTechnicalBid setBidApproveBy(String bidApproveBy) {
        this.bidApproveBy = bidApproveBy;
        return this;
    }

    public String getBidApproveById() {
        return bidApproveById;
    }

    public VendorTechnicalBid setBidApproveById(String bidApproveById) {
        this.bidApproveById = bidApproveById;
        return this;
    }

    public String getBidApproveFlag() {
        return bidApproveFlag;
    }

    public VendorTechnicalBid setBidApproveFlag(String bidApproveFlag) {
        this.bidApproveFlag = bidApproveFlag;
        return this;
    }

    public int getReviseBidFlag() {
        return reviseBidFlag;
    }

    public VendorTechnicalBid setReviseBidFlag(int reviseBidFlag) {
        this.reviseBidFlag = reviseBidFlag;
        return this;
    }

    public String getTechPercentage() {
        return techPercentage;
    }

    public VendorTechnicalBid setTechPercentage(String techPercentage) {
        this.techPercentage = techPercentage;
        return this;
    }
    
}
