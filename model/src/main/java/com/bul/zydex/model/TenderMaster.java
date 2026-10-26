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
public class TenderMaster {

    private int id;
    private String refNo;
    private String title;
    private String projectId;
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
    private String deliveryLocation;
    private String deliveryPeriod;
    private String termsOfPayment;
    private String validityPeriod;
    private String modeOfTransport;
    private String incoTerms;
    private String insurance;
    private String freight;
    private String poNumber;
    private int closeFlag;
    private String comments;
    private int auditFlag;
    private String auditComments;
    private String plantName;
    private String endUserName;
    private String endUserNumber;
    private int openBidStatus;
    private String prItemNo;
    private String auditFile;
    private int techBidOpenFlag;
    private String technicalContactName;
    private String technicalContactNo;
    private String address1;
    private String address2;
    private String state;
    private String city;
    private String pincode;
    private String quotes;
    private String businessType;
    private String projectType;
    private String termsCondition;

    private String authorizedBuyerFlag;

    public TenderMaster() {
    }

    public TenderMaster(int id, String refNo, String title, String projectId, String categoryId, String subCategoryId, String value, String emd, String docCost, String type, String contactPerson, String location, String announceDate, String portalDate, String collectionLastdate, String submitLastdate, String openingDate, String workDesc, String prequalification, String prebidDate, String prebidAddress, String tenderDocument, String tenderBidDocument, String tenderTechDocument, String tenderRemark, int vendorCode, String tenderAdmin, String tenderAdminContactNumber, String tenderAuthorizePerson, String tenderAuthorizeContactNo, int authorizeFlag, String tenderAuthorizeUserName, int reAuthoFlag, int isInAuthoTable, int vendorFlag, int itemFlag, int emailFlag, String authorizeDate, int returnFlag, String returnText, int deleteFlag, String deleteRemark, int tenderPhase, int openBidFlag, String department, String prNo, String tenderType, String deliveryLocation, String deliveryPeriod, String termsOfPayment, String validityPeriod, String modeOfTransport, String incoTerms, String insurance, String freight, String poNumber, int closeFlag, String comments, int auditFlag, String auditComments, String plantName, String endUserName, String endUserNumber, int openBidStatus, String prItemNo, String auditFile, int techBidOpenFlag, String technicalContactName, String technicalContactNo, String address1, String address2, String state, String city, String pincode, String quotes, String businessType, String projectType) {
        this.id = id;
        this.refNo = refNo;
        this.title = title;
        this.projectId = projectId;
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
        this.deliveryLocation = deliveryLocation;
        this.deliveryPeriod = deliveryPeriod;
        this.termsOfPayment = termsOfPayment;
        this.validityPeriod = validityPeriod;
        this.modeOfTransport = modeOfTransport;
        this.incoTerms = incoTerms;
        this.insurance = insurance;
        this.freight = freight;
        this.poNumber = poNumber;
        this.closeFlag = closeFlag;
        this.comments = comments;
        this.auditFlag = auditFlag;
        this.auditComments = auditComments;
        this.plantName = plantName;
        this.endUserName = endUserName;
        this.endUserNumber = endUserNumber;
        this.openBidStatus = openBidStatus;
        this.prItemNo = prItemNo;
        this.auditFile = auditFile;
        this.techBidOpenFlag = techBidOpenFlag;
        this.technicalContactName = technicalContactName;
        this.technicalContactNo = technicalContactNo;
        this.address1 = address1;
        this.address2 = address2;
        this.state = state;
        this.city = city;
        this.pincode = pincode;
        this.quotes = quotes;
        this.businessType = businessType;
        this.projectType = projectType;
    }

    public TenderMaster(String termsCondition, String authorizedBuyerFlag) {
        this.termsCondition = termsCondition;
        this.authorizedBuyerFlag = authorizedBuyerFlag;
    }

    public int getId() {
        return id;
    }

    public TenderMaster setId(int id) {
        this.id = id;
        return this;
    }

    public String getRefNo() {
        return refNo;
    }

    public TenderMaster setRefNo(String refNo) {
        this.refNo = refNo;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public TenderMaster setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public TenderMaster setCategoryId(String categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public String getSubCategoryId() {
        return subCategoryId;
    }

    public TenderMaster setSubCategoryId(String subCategoryId) {
        this.subCategoryId = subCategoryId;
        return this;
    }

    public String getValue() {
        return value;
    }

    public TenderMaster setValue(String value) {
        this.value = value;
        return this;
    }

    public String getEmd() {
        return emd;
    }

    public TenderMaster setEmd(String emd) {
        this.emd = emd;
        return this;
    }

    public String getDocCost() {
        return docCost;
    }

    public TenderMaster setDocCost(String docCost) {
        this.docCost = docCost;
        return this;
    }

    public String getType() {
        return type;
    }

    public TenderMaster setType(String type) {
        this.type = type;
        return this;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public TenderMaster setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public TenderMaster setLocation(String location) {
        this.location = location;
        return this;
    }

    public String getAnnounceDate() {
        return announceDate;
    }

    public TenderMaster setAnnounceDate(String announceDate) {
        this.announceDate = announceDate;
        return this;
    }

    public String getPortalDate() {
        return portalDate;
    }

    public TenderMaster setPortalDate(String portalDate) {
        this.portalDate = portalDate;
        return this;
    }

    public String getCollectionLastdate() {
        return collectionLastdate;
    }

    public TenderMaster setCollectionLastdate(String collectionLastdate) {
        this.collectionLastdate = collectionLastdate;
        return this;
    }

    public String getSubmitLastdate() {
        return submitLastdate;
    }

    public TenderMaster setSubmitLastdate(String submitLastdate) {
        this.submitLastdate = submitLastdate;
        return this;
    }

    public String getOpeningDate() {
        return openingDate;
    }

    public TenderMaster setOpeningDate(String openingDate) {
        this.openingDate = openingDate;
        return this;
    }

    public String getWorkDesc() {
        return workDesc;
    }

    public TenderMaster setWorkDesc(String workDesc) {
        this.workDesc = workDesc;
        return this;
    }

    public String getPrequalification() {
        return prequalification;
    }

    public TenderMaster setPrequalification(String prequalification) {
        this.prequalification = prequalification;
        return this;
    }

    public String getPrebidDate() {
        return prebidDate;
    }

    public TenderMaster setPrebidDate(String prebidDate) {
        this.prebidDate = prebidDate;
        return this;
    }

    public String getPrebidAddress() {
        return prebidAddress;
    }

    public TenderMaster setPrebidAddress(String prebidAddress) {
        this.prebidAddress = prebidAddress;
        return this;
    }

    public String getTenderDocument() {
        return tenderDocument;
    }

    public TenderMaster setTenderDocument(String tenderDocument) {
        this.tenderDocument = tenderDocument;
        return this;
    }

    public String getTenderBidDocument() {
        return tenderBidDocument;
    }

    public TenderMaster setTenderBidDocument(String tenderBidDocument) {
        this.tenderBidDocument = tenderBidDocument;
        return this;
    }

    public String getTenderTechDocument() {
        return tenderTechDocument;
    }

    public TenderMaster setTenderTechDocument(String tenderTechDocument) {
        this.tenderTechDocument = tenderTechDocument;
        return this;
    }

    public String getTenderRemark() {
        return tenderRemark;
    }

    public TenderMaster setTenderRemark(String tenderRemark) {
        this.tenderRemark = tenderRemark;
        return this;
    }

    public int getVendorCode() {
        return vendorCode;
    }

    public TenderMaster setVendorCode(int vendorCode) {
        this.vendorCode = vendorCode;
        return this;
    }

    public String getTenderAdmin() {
        return tenderAdmin;
    }

    public TenderMaster setTenderAdmin(String tenderAdmin) {
        this.tenderAdmin = tenderAdmin;
        return this;
    }

    public String getTenderAdminContactNumber() {
        return tenderAdminContactNumber;
    }

    public TenderMaster setTenderAdminContactNumber(String tenderAdminContactNumber) {
        this.tenderAdminContactNumber = tenderAdminContactNumber;
        return this;
    }

    public String getTenderAuthorizePerson() {
        return tenderAuthorizePerson;
    }

    public TenderMaster setTenderAuthorizePerson(String tenderAuthorizePerson) {
        this.tenderAuthorizePerson = tenderAuthorizePerson;
        return this;
    }

    public String getTenderAuthorizeContactNo() {
        return tenderAuthorizeContactNo;
    }

    public TenderMaster setTenderAuthorizeContactNo(String tenderAuthorizeContactNo) {
        this.tenderAuthorizeContactNo = tenderAuthorizeContactNo;
        return this;
    }

    public int getAuthorizeFlag() {
        return authorizeFlag;
    }

    public TenderMaster setAuthorizeFlag(int authorizeFlag) {
        this.authorizeFlag = authorizeFlag;
        return this;
    }

    public String getTenderAuthorizeUserName() {
        return tenderAuthorizeUserName;
    }

    public TenderMaster setTenderAuthorizeUserName(String tenderAuthorizeUserName) {
        this.tenderAuthorizeUserName = tenderAuthorizeUserName;
        return this;
    }

    public int getReAuthoFlag() {
        return reAuthoFlag;
    }

    public TenderMaster setReAuthoFlag(int reAuthoFlag) {
        this.reAuthoFlag = reAuthoFlag;
        return this;
    }

    public int getIsInAuthoTable() {
        return isInAuthoTable;
    }

    public TenderMaster setIsInAuthoTable(int isInAuthoTable) {
        this.isInAuthoTable = isInAuthoTable;
        return this;
    }

    public int getVendorFlag() {
        return vendorFlag;
    }

    public TenderMaster setVendorFlag(int vendorFlag) {
        this.vendorFlag = vendorFlag;
        return this;
    }

    public int getItemFlag() {
        return itemFlag;
    }

    public TenderMaster setItemFlag(int itemFlag) {
        this.itemFlag = itemFlag;
        return this;
    }

    public int getEmailFlag() {
        return emailFlag;
    }

    public TenderMaster setEmailFlag(int emailFlag) {
        this.emailFlag = emailFlag;
        return this;
    }

    public String getAuthorizeDate() {
        return authorizeDate;
    }

    public TenderMaster setAuthorizeDate(String authorizeDate) {
        this.authorizeDate = authorizeDate;
        return this;
    }

    public int getReturnFlag() {
        return returnFlag;
    }

    public TenderMaster setReturnFlag(int returnFlag) {
        this.returnFlag = returnFlag;
        return this;
    }

    public String getReturnText() {
        return returnText;
    }

    public TenderMaster setReturnText(String returnText) {
        this.returnText = returnText;
        return this;
    }

    public int getDeleteFlag() {
        return deleteFlag;
    }

    public TenderMaster setDeleteFlag(int deleteFlag) {
        this.deleteFlag = deleteFlag;
        return this;
    }

    public String getDeleteRemark() {
        return deleteRemark;
    }

    public TenderMaster setDeleteRemark(String deleteRemark) {
        this.deleteRemark = deleteRemark;
        return this;
    }

    public int getTenderPhase() {
        return tenderPhase;
    }

    public TenderMaster setTenderPhase(int tenderPhase) {
        this.tenderPhase = tenderPhase;
        return this;
    }

    public int getOpenBidFlag() {
        return openBidFlag;
    }

    public TenderMaster setOpenBidFlag(int openBidFlag) {
        this.openBidFlag = openBidFlag;
        return this;
    }

    public String getDepartment() {
        return department;
    }

    public TenderMaster setDepartment(String department) {
        this.department = department;
        return this;
    }

    public String getPrNo() {
        return prNo;
    }

    public TenderMaster setPrNo(String prNo) {
        this.prNo = prNo;
        return this;
    }

    public String getTenderType() {
        return tenderType;
    }

    public TenderMaster setTenderType(String tenderType) {
        this.tenderType = tenderType;
        return this;
    }

    public String getDeliveryLocation() {
        return deliveryLocation;
    }

    public TenderMaster setDeliveryLocation(String deliveryLocation) {
        this.deliveryLocation = deliveryLocation;
        return this;
    }

    public String getDeliveryPeriod() {
        return deliveryPeriod;
    }

    public TenderMaster setDeliveryPeriod(String deliveryPeriod) {
        this.deliveryPeriod = deliveryPeriod;
        return this;
    }

    public String getTermsOfPayment() {
        return termsOfPayment;
    }

    public TenderMaster setTermsOfPayment(String termsOfPayment) {
        this.termsOfPayment = termsOfPayment;
        return this;
    }

    public String getValidityPeriod() {
        return validityPeriod;
    }

    public TenderMaster setValidityPeriod(String validityPeriod) {
        this.validityPeriod = validityPeriod;
        return this;
    }

    public String getModeOfTransport() {
        return modeOfTransport;
    }

    public TenderMaster setModeOfTransport(String modeOfTransport) {
        this.modeOfTransport = modeOfTransport;
        return this;
    }

    public String getIncoTerms() {
        return incoTerms;
    }

    public TenderMaster setIncoTerms(String incoTerms) {
        this.incoTerms = incoTerms;
        return this;
    }

    public String getInsurance() {
        return insurance;
    }

    public TenderMaster setInsurance(String insurance) {
        this.insurance = insurance;
        return this;
    }

    public String getFreight() {
        return freight;
    }

    public TenderMaster setFreight(String freight) {
        this.freight = freight;
        return this;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public TenderMaster setPoNumber(String poNumber) {
        this.poNumber = poNumber;
        return this;
    }

    public int getCloseFlag() {
        return closeFlag;
    }

    public TenderMaster setCloseFlag(int closeFlag) {
        this.closeFlag = closeFlag;
        return this;
    }

    public String getComments() {
        return comments;
    }

    public TenderMaster setComments(String comments) {
        this.comments = comments;
        return this;
    }

    public int getAuditFlag() {
        return auditFlag;
    }

    public TenderMaster setAuditFlag(int auditFlag) {
        this.auditFlag = auditFlag;
        return this;
    }

    public String getAuditComments() {
        return auditComments;
    }

    public TenderMaster setAuditComments(String auditComments) {
        this.auditComments = auditComments;
        return this;
    }

    public String getPlantName() {
        return plantName;
    }

    public TenderMaster setPlantName(String plantName) {
        this.plantName = plantName;
        return this;
    }

    public String getEndUserName() {
        return endUserName;
    }

    public TenderMaster setEndUserName(String endUserName) {
        this.endUserName = endUserName;
        return this;
    }

    public String getEndUserNumber() {
        return endUserNumber;
    }

    public TenderMaster setEndUserNumber(String endUserNumber) {
        this.endUserNumber = endUserNumber;
        return this;
    }

    public int getOpenBidStatus() {
        return openBidStatus;
    }

    public TenderMaster setOpenBidStatus(int openBidStatus) {
        this.openBidStatus = openBidStatus;
        return this;
    }

    public String getPrItemNo() {
        return prItemNo;
    }

    public TenderMaster setPrItemNo(String prItemNo) {
        this.prItemNo = prItemNo;
        return this;
    }

    public String getAuditFile() {
        return auditFile;
    }

    public TenderMaster setAuditFile(String auditFile) {
        this.auditFile = auditFile;
        return this;
    }

    public int getTechBidOpenFlag() {
        return techBidOpenFlag;
    }

    public TenderMaster setTechBidOpenFlag(int techBidOpenFlag) {
        this.techBidOpenFlag = techBidOpenFlag;
        return this;
    }

    public String getTechnicalContactName() {
        return technicalContactName;
    }

    public TenderMaster setTechnicalContactName(String technicalContactName) {
        this.technicalContactName = technicalContactName;
        return this;
    }

    public String getTechnicalContactNo() {
        return technicalContactNo;
    }

    public TenderMaster setTechnicalContactNo(String technicalContactNo) {
        this.technicalContactNo = technicalContactNo;
        return this;
    }

    public String getAddress1() {
        return address1;
    }

    public TenderMaster setAddress1(String address1) {
        this.address1 = address1;
        return this;
    }

    public String getAddress2() {
        return address2;
    }

    public TenderMaster setAddress2(String address2) {
        this.address2 = address2;
        return this;
    }

    public String getState() {
        return state;
    }

    public TenderMaster setState(String state) {
        this.state = state;
        return this;
    }

    public String getCity() {
        return city;
    }

    public TenderMaster setCity(String city) {
        this.city = city;
        return this;
    }

    public String getPincode() {
        return pincode;
    }

    public TenderMaster setPincode(String pincode) {
        this.pincode = pincode;
        return this;
    }

    public String getQuotes() {
        return quotes;
    }

    public TenderMaster setQuotes(String quotes) {
        this.quotes = quotes;
        return this;
    }

    public String getBusinessType() {
        return businessType;
    }

    public TenderMaster setBusinessType(String businessType) {
        this.businessType = businessType;
        return this;
    }

    public String getProjectType() {
        return projectType;
    }

    public TenderMaster setProjectType(String projectType) {
        this.projectType = projectType;
        return this;
    }

    public String getTermsCondition() {
        return termsCondition;
    }

    public void setTermsCondition(String termsCondition) {
        this.termsCondition = termsCondition;
    }

    public String getAuthorizedBuyerFlag() {
        return authorizedBuyerFlag;
    }

    public void setAuthorizedBuyerFlag(String authorizedBuyerFlag) {
        this.authorizedBuyerFlag = authorizedBuyerFlag;
    }

}
