/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

import java.io.Serializable;

/**
 *
 * @author admin
 */
public class VendorInvitation implements java.io.Serializable {

    private int id;
    private String vendorEmailId;
    private String companyName;
    private String contactName;
    private String invitedDateTime;
    private String invitedBy;
    private String inviteStatus;
    private int approvalSettingId;
    private String vendorCode;
    private String linkExpireDateTime;
    private String encryText;
    private String bpGroup;
    private String vendorTypes;
    private String groupCategory;
    private String groupSubCategory;
    private String technicalName;
    private String finanicailName;
    private String hrName;
    private String safetyName;
    private String riskCategory;
    private String vendorInviteSource;
    private String auditorName;

    private String vendorContactNo;

    public VendorInvitation() {
    }

    public VendorInvitation(int id, String vendorEmailId, String companyName, String contactName, String invitedDateTime, String invitedBy, String inviteStatus, int approvalSettingId, String vendorCode, String linkExpireDateTime, String encryText, String bpGroup, String vendorTypes, String groupCategory, String groupSubCategory, String riskCategory, String vendorInviteSource, String technicalName, String finanicailName, String hrName, String safetyName, String auditorName, String vendorContactNo) {
        this.id = id;
        this.vendorEmailId = vendorEmailId;
        this.companyName = companyName;
        this.contactName = contactName;
        this.invitedDateTime = invitedDateTime;
        this.invitedBy = invitedBy;
        this.inviteStatus = inviteStatus;
        this.approvalSettingId = approvalSettingId;
        this.vendorCode = vendorCode;
        this.linkExpireDateTime = linkExpireDateTime;
        this.encryText = encryText;
        this.bpGroup = bpGroup;
        this.vendorTypes = vendorTypes;
        this.groupCategory = groupCategory;
        this.groupSubCategory = groupSubCategory;
        this.riskCategory = riskCategory;
        this.vendorInviteSource = vendorInviteSource;
        this.technicalName = technicalName;
        this.finanicailName = finanicailName;
        this.hrName = hrName;
        this.safetyName = safetyName;
        this.auditorName = auditorName;
        this.vendorContactNo = vendorContactNo;
    }

    public int getId() {
        return id;
    }

    public VendorInvitation setId(int id) {
        this.id = id;
        return this;
    }

    public String getVendorEmailId() {
        return vendorEmailId;
    }

    public VendorInvitation setVendorEmailId(String vendorEmailId) {
        this.vendorEmailId = vendorEmailId;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public VendorInvitation setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public String getContactName() {
        return contactName;
    }

    public VendorInvitation setContactName(String contactName) {
        this.contactName = contactName;
        return this;
    }

    public String getInvitedDateTime() {
        return invitedDateTime;
    }

    public VendorInvitation setInvitedDateTime(String invitedDateTime) {
        this.invitedDateTime = invitedDateTime;
        return this;
    }

    public String getInvitedBy() {
        return invitedBy;
    }

    public VendorInvitation setInvitedBy(String invitedBy) {
        this.invitedBy = invitedBy;
        return this;
    }

    public String getInviteStatus() {
        return inviteStatus;
    }

    public VendorInvitation setInviteStatus(String inviteStatus) {
        this.inviteStatus = inviteStatus;
        return this;
    }

    public int getApprovalSettingId() {
        return approvalSettingId;
    }

    public VendorInvitation setApprovalSettingId(int approvalSettingId) {
        this.approvalSettingId = approvalSettingId;
        return this;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public VendorInvitation setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
        return this;
    }

    public String getLinkExpireDateTime() {
        return linkExpireDateTime;
    }

    public VendorInvitation setLinkExpireDateTime(String linkExpireDateTime) {
        this.linkExpireDateTime = linkExpireDateTime;
        return this;
    }

    public String getEncryText() {
        return encryText;
    }

    public VendorInvitation setEncryText(String encryText) {
        this.encryText = encryText;
        return this;
    }

    public String getBpGroup() {
        return bpGroup;
    }

    public void setBpGroup(String bpGroup) {
        this.bpGroup = bpGroup;
    }

    public String getVendorTypes() {
        return vendorTypes;
    }

    public void setVendorTypes(String vendorTypes) {
        this.vendorTypes = vendorTypes;
    }

    public String getGroupCategory() {
        return groupCategory;
    }

    public void setGroupCategory(String groupCategory) {
        this.groupCategory = groupCategory;
    }

    public String getGroupSubCategory() {
        return groupSubCategory;
    }

    public void setGroupSubCategory(String groupSubCategory) {
        this.groupSubCategory = groupSubCategory;
    }

    public String getTechnicalName() {
        return technicalName;
    }

    public void setTechnicalName(String technicalName) {
        this.technicalName = technicalName;
    }

    public String getFinanicailName() {
        return finanicailName;
    }

    public void setFinanicailName(String finanicailName) {
        this.finanicailName = finanicailName;
    }

    public String getHrName() {
        return hrName;
    }

    public void setHrName(String hrName) {
        this.hrName = hrName;
    }

    public String getSafetyName() {
        return safetyName;
    }

    public void setSafetyName(String safetyName) {
        this.safetyName = safetyName;
    }

    public String getRiskCategory() {
        return riskCategory;
    }

    public void setRiskCategory(String riskCategory) {
        this.riskCategory = riskCategory;
    }

    public String getVendorInviteSource() {
        return vendorInviteSource;
    }

    public void setVendorInviteSource(String vendorInviteSource) {
        this.vendorInviteSource = vendorInviteSource;
    }

    public String getAuditorName() {
        return auditorName;
    }

    public void setAuditorName(String auditorName) {
        this.auditorName = auditorName;
    }

    public String getVendorContactNo() {
        return vendorContactNo;
    }

    public void setVendorContactNo(String vendorContactNo) {
        this.vendorContactNo = vendorContactNo;
    }

}
