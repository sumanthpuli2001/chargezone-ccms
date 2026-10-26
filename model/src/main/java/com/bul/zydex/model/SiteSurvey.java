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
public class SiteSurvey {

    private int id;
    private String siteName;
    private String siteAddress;
    private String description;
    private String startDate;
    private String endDate;
    private String vendor;
    private String formFillType;
    private String createdBy;
    private int flagStatus;
    private String location;
    private String typeOfCharge;
    private String noOfCharges;
    private String googleCoordinates;
    private String surveyDocumentNo;
    private String remark;
    private String nameofLocationPartner;
    private String mobileNoLocationPartner;

    public SiteSurvey() {
    }

    public SiteSurvey(int id, String siteName, String siteAddress, String description, String startDate, String endDate, String vendor, String formFillType, String createdBy, int flagStatus, String location, String typeOfCharge, String noOfCharges, String googleCoordinates, String surveyDocumentNo, String remark, String nameofLocationPartner, String mobileNoLocationPartner) {
        this.id = id;
        this.siteName = siteName;
        this.siteAddress = siteAddress;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.vendor = vendor;
        this.formFillType = formFillType;
        this.createdBy = createdBy;
        this.flagStatus = flagStatus;
        this.location = location;
        this.typeOfCharge = typeOfCharge;
        this.noOfCharges = noOfCharges;
        this.googleCoordinates = googleCoordinates;
        this.surveyDocumentNo = surveyDocumentNo;
        this.remark = remark;
        this.nameofLocationPartner = nameofLocationPartner;
        this.mobileNoLocationPartner = mobileNoLocationPartner;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteAddress() {
        return siteAddress;
    }

    public void setSiteAddress(String siteAddress) {
        this.siteAddress = siteAddress;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getFormFillType() {
        return formFillType;
    }

    public void setFormFillType(String formFillType) {
        this.formFillType = formFillType;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public int getFlagStatus() {
        return flagStatus;
    }

    public void setFlagStatus(int flagStatus) {
        this.flagStatus = flagStatus;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTypeOfCharge() {
        return typeOfCharge;
    }

    public void setTypeOfCharge(String typeOfCharge) {
        this.typeOfCharge = typeOfCharge;
    }

    public String getNoOfCharges() {
        return noOfCharges;
    }

    public void setNoOfCharges(String noOfCharges) {
        this.noOfCharges = noOfCharges;
    }

    public String getGoogleCoordinates() {
        return googleCoordinates;
    }

    public void setGoogleCoordinates(String googleCoordinates) {
        this.googleCoordinates = googleCoordinates;
    }

    public String getSurveyDocumentNo() {
        return surveyDocumentNo;
    }

    public void setSurveyDocumentNo(String surveyDocumentNo) {
        this.surveyDocumentNo = surveyDocumentNo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getNameofLocationPartner() {
        return nameofLocationPartner;
    }

    public void setNameofLocationPartner(String nameofLocationPartner) {
        this.nameofLocationPartner = nameofLocationPartner;
    }

    public String getMobileNoLocationPartner() {
        return mobileNoLocationPartner;
    }

    public void setMobileNoLocationPartner(String mobileNoLocationPartner) {
        this.mobileNoLocationPartner = mobileNoLocationPartner;
    }

}
