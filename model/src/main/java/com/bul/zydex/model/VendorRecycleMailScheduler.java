/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author Bulwark-5
 */
public class VendorRecycleMailScheduler {

    private int id;
    private String vendorInfoId;
    private String approvalName;
    private String approvalStatus;
    private String dateTime;
    private String mailStatus;
    private String finacialDateTime;
    private String technicalDateTime;
    private String hrDateTime;
    private String hseDateTime;
    private String itDateTime;

    public VendorRecycleMailScheduler() {
    }

    public VendorRecycleMailScheduler(int id, String vendorInfoId, String approvalName, String approvalStatus, String dateTime, String mailStatus, String finacialDateTime, String technicalDateTime, String hrDateTime, String hseDateTime, String itDateTime) {
        this.id = id;
        this.vendorInfoId = vendorInfoId;
        this.approvalName = approvalName;
        this.approvalStatus = approvalStatus;
        this.dateTime = dateTime;
        this.mailStatus = mailStatus;
        this.finacialDateTime = finacialDateTime;
        this.technicalDateTime = technicalDateTime;
        this.hrDateTime = hrDateTime;
        this.hseDateTime = hseDateTime;
        this.itDateTime = itDateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVendorInfoId() {
        return vendorInfoId;
    }

    public void setVendorInfoId(String vendorInfoId) {
        this.vendorInfoId = vendorInfoId;
    }

    public String getApprovalName() {
        return approvalName;
    }

    public void setApprovalName(String approvalName) {
        this.approvalName = approvalName;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getMailStatus() {
        return mailStatus;
    }

    public void setMailStatus(String mailStatus) {
        this.mailStatus = mailStatus;
    }

    public String getFinacialDateTime() {
        return finacialDateTime;
    }

    public void setFinacialDateTime(String finacialDateTime) {
        this.finacialDateTime = finacialDateTime;
    }

    public String getTechnicalDateTime() {
        return technicalDateTime;
    }

    public void setTechnicalDateTime(String technicalDateTime) {
        this.technicalDateTime = technicalDateTime;
    }

    public String getHrDateTime() {
        return hrDateTime;
    }

    public void setHrDateTime(String hrDateTime) {
        this.hrDateTime = hrDateTime;
    }

    public String getHseDateTime() {
        return hseDateTime;
    }

    public void setHseDateTime(String hseDateTime) {
        this.hseDateTime = hseDateTime;
    }

    public String getItDateTime() {
        return itDateTime;
    }

    public void setItDateTime(String itDateTime) {
        this.itDateTime = itDateTime;
    }

}
