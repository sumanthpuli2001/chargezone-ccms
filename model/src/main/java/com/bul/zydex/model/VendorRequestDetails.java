/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

import java.util.List;

/**
 *
 * @author bulwarks-2
 */
public class VendorRequestDetails {

    private Integer id;
    private String contactaName;
    private String email;
    private String address;
    private String description;
    private String phoneNo;
    private String company;
    private Integer flagStatus;
    private Integer vendorApprovalSetting;
    private String createdBy;

    public VendorRequestDetails() {
    }

    public VendorRequestDetails(Integer id, String contactaName, String email, String address, String description, String phoneNo, String company, Integer flagStatus, Integer vendorApprovalSetting, String createdBy) {
        this.id = id;
        this.contactaName = contactaName;
        this.email = email;
        this.address = address;
        this.description = description;
        this.phoneNo = phoneNo;
        this.company = company;
        this.flagStatus = flagStatus;
        this.vendorApprovalSetting = vendorApprovalSetting;
        this.createdBy = createdBy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContactaName() {
        return contactaName;
    }

    public void setContactaName(String contactaName) {
        this.contactaName = contactaName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getFlagStatus() {
        return flagStatus;
    }

    public void setFlagStatus(Integer flagStatus) {
        this.flagStatus = flagStatus;
    }

    public Integer getVendorApprovalSetting() {
        return vendorApprovalSetting;
    }

    public void setVendorApprovalSetting(Integer vendorApprovalSetting) {
        this.vendorApprovalSetting = vendorApprovalSetting;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

}
