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
public class AuthTenderMaster {
 
    private int id;
    private String refNo;    
    private String title;    
    private String categoryId;    
    private String subCategoryId;    
    private String value;    
    private String emd;    
    private String docCost;    
    private String type;    
    private String contactPerson;    
    private String location;    
    private String announceDate;    
    private String portalDate;
    private String collectionLastdate;    
    private String submitLastdate;    
    private String openingDate;    
    private String workDesc;    
    private String prequalification;    
    private String prebidDate;    
    private String prebidAddress;    
    private String tenderDocument;    
    private String tenderBidDocument;    
    private String tenderTechDocument;    
    private String tenderRemark;    
    private int vendorCode;
    private String tenderAdmin;    
    private String tenderAdminContactNumber;    
    private String tenderAuthorizePerson;    
    private String tenderAuthorizeContactNo;    
    private int authorizeFlag;
    private String tenderAuthorizeUserName;    
    private int reAuthoFlag;
    private int isInAuthoTable;
    private int vendorFlag;
    private int itemFlag;
    private int emailFlag;
    private String authorizeDate;    
    private int returnFlag;
    private String returnText;    
    private int deleteFlag;
    private String deleteRemark;    
    private int tenderPhase;
    private int openBidFlag;
    private String department;    
    private String prNo;
    private String tenderType;
    
    public AuthTenderMaster() {
    }

    public AuthTenderMaster(int id, String refNo, String title, String categoryId, String subCategoryId, String value, String emd, String docCost, String type, String contactPerson, String location, String announceDate, String portalDate, String collectionLastdate, String submitLastdate, String openingDate,String workDesc, String prequalification, String prebidDate, String prebidAddress, String tenderDocument, String tenderBidDocument, String tenderTechDocument, String tenderRemark, int vendorCode, String tenderAdmin, String tenderAdminContactNumber, String tenderAuthorizePerson, String tenderAuthorizeContactNo, int authorizeFlag, String tenderAuthorizeUserName, int reAuthoFlag, int isInAuthoTable, int vendorFlag, int itemFlag, int emailFlag, String authorizeDate, int returnFlag, String returnText, int deleteFlag, String deleteRemark, int tenderPhase, int openBidFlag, String department, String prNo, String tenderType) {
        this.id = id;
        this.refNo = refNo;    
        this.title = title;    
        this.categoryId = categoryId;    
        this.subCategoryId = subCategoryId;    
        this.value = value;    
        this.emd = emd;    
        this.docCost = docCost;    
        this.type = type;    
        this.contactPerson = contactPerson;    
        this.location = location;    
        this.announceDate = announceDate;    
        this.portalDate = portalDate;
        this.collectionLastdate = collectionLastdate;    
        this.submitLastdate = submitLastdate;    
        this.openingDate = openingDate;    
        this.workDesc = workDesc;    
        this.prequalification = prequalification;    
        this.prebidDate = prebidDate;    
        this.prebidAddress = prebidAddress;    
        this.tenderDocument = tenderDocument;    
        this.tenderBidDocument = tenderBidDocument;    
        this.tenderTechDocument = tenderTechDocument;    
        this.tenderRemark = tenderRemark;    
        this.vendorCode = vendorCode;
        this.tenderAdmin = tenderAdmin;    
        this.tenderAdminContactNumber = tenderAdminContactNumber;    
        this.tenderAuthorizePerson = tenderAuthorizePerson;    
        this.tenderAuthorizeContactNo = tenderAuthorizeContactNo;    
        this.authorizeFlag = authorizeFlag;
        this.tenderAuthorizeUserName = tenderAuthorizeUserName;    
        this.reAuthoFlag = reAuthoFlag;
        this.isInAuthoTable = isInAuthoTable;
        this.vendorFlag = vendorFlag;
        this.itemFlag = itemFlag;
        this.emailFlag = emailFlag;
        this.authorizeDate = authorizeDate;    
        this.returnFlag = returnFlag;
        this.returnText = returnText;    
        this.deleteFlag = deleteFlag;
        this.deleteRemark = deleteRemark;    
        this.tenderPhase = tenderPhase;
        this.openBidFlag = openBidFlag;
        this.department = department;    
        this.prNo = prNo;
        this.tenderType = tenderType;
    
    }

    public int getId() {
        return id;
    }

    public AuthTenderMaster setId(int id) {
        this.id = id;
        return this;
    }

    public String getRefNo() {
        return refNo;
    }

    public AuthTenderMaster setRefNo(String refNo) {
        this.refNo = refNo;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public AuthTenderMaster setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public AuthTenderMaster setCategoryId(String categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public String getSubCategoryId() {
        return subCategoryId;
    }

    public AuthTenderMaster setSubCategoryId(String subCategoryId) {
        this.subCategoryId = subCategoryId;
        return this;
    }

    public String getValue() {
        return value;
    }

    public AuthTenderMaster setValue(String value) {
        this.value = value;
        return this;
    }

    public String getEmd() {
        return emd;
    }

    public AuthTenderMaster setEmd(String emd) {
        this.emd = emd;
        return this;
    }

    public String getDocCost() {
        return docCost;
    }

    public AuthTenderMaster setDocCost(String docCost) {
        this.docCost = docCost;
        return this;
    }

    public String getType() {
        return type;
    }

    public AuthTenderMaster setType(String type) {
        this.type = type;
        return this;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public AuthTenderMaster setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public AuthTenderMaster setLocation(String location) {
        this.location = location;
        return this;
    }

    public String getAnnounceDate() {
        return announceDate;
    }

    public AuthTenderMaster setAnnounceDate(String announceDate) {
        this.announceDate = announceDate;
        return this;
    }

    public String getPortalDate() {
        return portalDate;
    }

    public AuthTenderMaster setPortalDate(String portalDate) {
        this.portalDate = portalDate;
        return this;
    }

    public String getCollectionLastdate() {
        return collectionLastdate;
    }

    public AuthTenderMaster setCollectionLastdate(String collectionLastdate) {
        this.collectionLastdate = collectionLastdate;
        return this;
    }

    public String getSubmitLastdate() {
        return submitLastdate;
    }

    public AuthTenderMaster setSubmitLastdate(String submitLastdate) {
        this.submitLastdate = submitLastdate;
        return this;
    }

    public String getOpeningDate() {
        return openingDate;
    }

    public AuthTenderMaster setOpeningDate(String openingDate) {
        this.openingDate = openingDate;
        return this;
    }

    public String getWorkDesc() {
        return workDesc;
    }

    public AuthTenderMaster setWorkDesc(String workDesc) {
        this.workDesc = workDesc;
        return this;
    }

    public String getPrequalification() {
        return prequalification;
    }

    public AuthTenderMaster setPrequalification(String prequalification) {
        this.prequalification = prequalification;
        return this;
    }

    public String getPrebidDate() {
        return prebidDate;
    }

    public AuthTenderMaster setPrebidDate(String prebidDate) {
        this.prebidDate = prebidDate;
        return this;
    }

    public String getPrebidAddress() {
        return prebidAddress;
    }

    public AuthTenderMaster setPrebidAddress(String prebidAddress) {
        this.prebidAddress = prebidAddress;
        return this;
    }

    public String getTenderDocument() {
        return tenderDocument;
    }

    public AuthTenderMaster setTenderDocument(String tenderDocument) {
        this.tenderDocument = tenderDocument;
        return this;
    }

    public String getTenderBidDocument() {
        return tenderBidDocument;
    }

    public AuthTenderMaster setTenderBidDocument(String tenderBidDocument) {
        this.tenderBidDocument = tenderBidDocument;
        return this;
    }

    public String getTenderTechDocument() {
        return tenderTechDocument;
    }

    public AuthTenderMaster setTenderTechDocument(String tenderTechDocument) {
        this.tenderTechDocument = tenderTechDocument;
        return this;
    }

    public String getTenderRemark() {
        return tenderRemark;
    }

    public AuthTenderMaster setTenderRemark(String tenderRemark) {
        this.tenderRemark = tenderRemark;
        return this;
    }

    public int getVendorCode() {
        return vendorCode;
    }

    public AuthTenderMaster setVendorCode(int vendorCode) {
        this.vendorCode = vendorCode;
        return this;
    }

    public String getTenderAdmin() {
        return tenderAdmin;
    }

    public AuthTenderMaster setTenderAdmin(String tenderAdmin) {
        this.tenderAdmin = tenderAdmin;
        return this;
    }

    public String getTenderAdminContactNumber() {
        return tenderAdminContactNumber;
    }

    public AuthTenderMaster setTenderAdminContactNumber(String tenderAdminContactNumber) {
        this.tenderAdminContactNumber = tenderAdminContactNumber;
        return this;
    }

    public String getTenderAuthorizePerson() {
        return tenderAuthorizePerson;
    }

    public AuthTenderMaster setTenderAuthorizePerson(String tenderAuthorizePerson) {
        this.tenderAuthorizePerson = tenderAuthorizePerson;
        return this;
    }

    public String getTenderAuthorizeContactNo() {
        return tenderAuthorizeContactNo;
    }

    public AuthTenderMaster setTenderAuthorizeContactNo(String tenderAuthorizeContactNo) {
        this.tenderAuthorizeContactNo = tenderAuthorizeContactNo;
        return this;
    }

    public int getAuthorizeFlag() {
        return authorizeFlag;
    }

    public AuthTenderMaster setAuthorizeFlag(int authorizeFlag) {
        this.authorizeFlag = authorizeFlag;
        return this;
    }

    public String getTenderAuthorizeUserName() {
        return tenderAuthorizeUserName;
    }

    public AuthTenderMaster setTenderAuthorizeUserName(String tenderAuthorizeUserName) {
        this.tenderAuthorizeUserName = tenderAuthorizeUserName;
        return this;
    }

    public int getReAuthoFlag() {
        return reAuthoFlag;
    }

    public AuthTenderMaster setReAuthoFlag(int reAuthoFlag) {
        this.reAuthoFlag = reAuthoFlag;
        return this;
    }

    public int getIsInAuthoTable() {
        return isInAuthoTable;
    }

    public AuthTenderMaster setIsInAuthoTable(int isInAuthoTable) {
        this.isInAuthoTable = isInAuthoTable;
        return this;
    }

    public int getVendorFlag() {
        return vendorFlag;
    }

    public AuthTenderMaster setVendorFlag(int vendorFlag) {
        this.vendorFlag = vendorFlag;
        return this;
    }

    public int getItemFlag() {
        return itemFlag;
    }

    public AuthTenderMaster setItemFlag(int itemFlag) {
        this.itemFlag = itemFlag;
        return this;
    }

    public int getEmailFlag() {
        return emailFlag;
    }

    public AuthTenderMaster setEmailFlag(int emailFlag) {
        this.emailFlag = emailFlag;
        return this;
    }

    public String getAuthorizeDate() {
        return authorizeDate;
    }

    public AuthTenderMaster setAuthorizeDate(String authorizeDate) {
        this.authorizeDate = authorizeDate;
        return this;
    }

    public int getReturnFlag() {
        return returnFlag;
    }

    public AuthTenderMaster setReturnFlag(int returnFlag) {
        this.returnFlag = returnFlag;
        return this;
    }

    public String getReturnText() {
        return returnText;
    }

    public AuthTenderMaster setReturnText(String returnText) {
        this.returnText = returnText;
        return this;
    }

    public int getDeleteFlag() {
        return deleteFlag;
    }

    public AuthTenderMaster setDeleteFlag(int deleteFlag) {
        this.deleteFlag = deleteFlag;
        return this;
    }

    public String getDeleteRemark() {
        return deleteRemark;
    }

    public AuthTenderMaster setDeleteRemark(String deleteRemark) {
        this.deleteRemark = deleteRemark;
        return this;
    }

    public int getTenderPhase() {
        return tenderPhase;
    }

    public AuthTenderMaster setTenderPhase(int tenderPhase) {
        this.tenderPhase = tenderPhase;
        return this;
    }

    public int getOpenBidFlag() {
        return openBidFlag;
    }

    public AuthTenderMaster setOpenBidFlag(int openBidFlag) {
        this.openBidFlag = openBidFlag;
        return this;
    }

    public String getDepartment() {
        return department;
    }

    public AuthTenderMaster setDepartment(String department) {
        this.department = department;
        return this;
    }

    public String getPrNo() {
        return prNo;
    }

    public AuthTenderMaster setPrNo(String prNo) {
        this.prNo = prNo;
        return this;
    }

    public String getTenderType() {
        return tenderType;
    }

    public AuthTenderMaster setTenderType(String tenderType) {
        this.tenderType = tenderType;
        return this;
    }
    
    
}
