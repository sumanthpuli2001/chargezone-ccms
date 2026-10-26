/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author Administrator
 */
public class ClosePr {
    
    private int id;
    private String tenderNo;
    private String vendorDetail;
    private String attachment;
    private String remark;
    private int prMasterId;
    private String closedBy;
    private String dateTime;
    
    

    public ClosePr() {
    }

    public ClosePr(int id, String tenderNo, String vendorDetail, String attachment, String remark, int prMasterId, String closedBy, String dateTime) {
        this.id = id;
        this.tenderNo = tenderNo;
        this.vendorDetail = vendorDetail;
        this.attachment = attachment;
        this.remark = remark;
        this.prMasterId = prMasterId;
        this.closedBy = closedBy;
        this.dateTime = dateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenderNo() {
        return tenderNo;
    }

    public void setTenderNo(String tenderNo) {
        this.tenderNo = tenderNo;
    }

    public String getVendorDetail() {
        return vendorDetail;
    }

    public void setVendorDetail(String vendorDetail) {
        this.vendorDetail = vendorDetail;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getPrMasterId() {
        return prMasterId;
    }

    public void setPrMasterId(int prMasterId) {
        this.prMasterId = prMasterId;
    }

    public String getClosedBy() {
        return closedBy;
    }

    public void setClosedBy(String closedBy) {
        this.closedBy = closedBy;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

  
    
    
    
}
