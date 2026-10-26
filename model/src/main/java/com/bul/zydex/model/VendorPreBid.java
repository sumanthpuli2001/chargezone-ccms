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
public class VendorPreBid {
    
    private int id;
    private String refNo;
    private String vendorCode;
    private String preBidDeviation;
    private String preBidRemark;
    private String bidOpenDate;
    private String bidOpenBy;
    private String bidOpenById;
    private String bidOpenFlag;
    private String bidApproveDate;
    private String bidApproveBy;
    private String bidApproveById;
    private String bidApproveFlag;
    
    public VendorPreBid() {
    }

    public VendorPreBid(int id, String refNo, String vendorCode, String preBidDeviation, String preBidRemark, String bidOpenDate, String bidOpenBy, String bidOpenById, String bidOpenFlag, String bidApproveDate, String bidApproveBy, String bidApproveById, String bidApproveFlag) {
        this.id = id;
        this.refNo = refNo;
        this.vendorCode = vendorCode;
        this.preBidDeviation = preBidDeviation;
        this.preBidRemark = preBidRemark;
        this.bidOpenDate = bidOpenDate;
        this.bidOpenBy = bidOpenBy;
        this.bidOpenById = bidOpenById;
        this.bidOpenFlag = bidOpenFlag;
        this.bidApproveDate = bidApproveDate;
        this.bidApproveBy = bidApproveBy;
        this.bidApproveById = bidApproveById;
        this.bidApproveFlag = bidApproveFlag;
    }

    public int getId() {
        return id;
    }

    public VendorPreBid setId(int id) {
        this.id = id;
        return this;
    }

    public String getRefNo() {
        return refNo;
    }

    public VendorPreBid setRefNo(String refNo) {
        this.refNo = refNo;
        return this;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public VendorPreBid setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
        return this;
    }

    public String getPreBidDeviation() {
        return preBidDeviation;
    }

    public VendorPreBid setPreBidDeviation(String preBidDeviation) {
        this.preBidDeviation = preBidDeviation;
        return this;
    }

    public String getPreBidRemark() {
        return preBidRemark;
    }

    public VendorPreBid setPreBidRemark(String preBidRemark) {
        this.preBidRemark = preBidRemark;
        return this;
    }

    public String getBidOpenDate() {
        return bidOpenDate;
    }

    public VendorPreBid setBidOpenDate(String bidOpenDate) {
        this.bidOpenDate = bidOpenDate;
        return this;
    }

    public String getBidOpenBy() {
        return bidOpenBy;
    }

    public VendorPreBid setBidOpenBy(String bidOpenBy) {
        this.bidOpenBy = bidOpenBy;
        return this;
    }

    public String getBidOpenById() {
        return bidOpenById;
    }

    public VendorPreBid setBidOpenById(String bidOpenById) {
        this.bidOpenById = bidOpenById;
        return this;
    }

    public String getBidOpenFlag() {
        return bidOpenFlag;
    }

    public VendorPreBid setBidOpenFlag(String bidOpenFlag) {
        this.bidOpenFlag = bidOpenFlag;
        return this;
    }

    public String getBidApproveDate() {
        return bidApproveDate;
    }

    public VendorPreBid setBidApproveDate(String bidApproveDate) {
        this.bidApproveDate = bidApproveDate;
        return this;
    }

    public String getBidApproveBy() {
        return bidApproveBy;
    }

    public VendorPreBid setBidApproveBy(String bidApproveBy) {
        this.bidApproveBy = bidApproveBy;
        return this;
    }

    public String getBidApproveById() {
        return bidApproveById;
    }

    public VendorPreBid setBidApproveById(String bidApproveById) {
        this.bidApproveById = bidApproveById;
        return this;
    }

    public String getBidApproveFlag() {
        return bidApproveFlag;
    }

    public VendorPreBid setBidApproveFlag(String bidApproveFlag) {
        this.bidApproveFlag = bidApproveFlag;
        return this;
    }
    
    
}
