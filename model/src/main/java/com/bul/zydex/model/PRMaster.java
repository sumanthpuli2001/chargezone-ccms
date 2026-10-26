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
public class PRMaster {

    private int id;
    private String prNo;
    private String title;
    private String projectId;
    private String categoryId;
    private String value;
    private String type;
    private String contactPerson;
    private String location;
    private String announceDate;
    private String workDesc;
    private String prRemark;
    private String prAdmin;
    private String prAdminContactNumber;
    private int authorizeFlag;
    private String authorizeDate;
    private String department;
    private String billingLocation;
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
    private String tenderCreaterId;
    private int tenderFlag;
    private String deliveryPeriod;
    private String technicalCommittee;
    private String priceCommittee;
    private String prAuthorizeUser;
    private String prAuthorizeDate;
    private String tenderAssignUser;
    private String tenderAssignDate;
    private String tenderCreaterUser;
    private String tenderCreaterDate;
    private String techBidOpenUser;
    private String techBidOpenDate;
    private String techBidApproveUser;
    private String techBidApproveDate;
    private String priceBidOpenUser;
    private String priceBidOpenDate;
    private String priceBidStartUser;
    private String priceBidStartDate;
    private String finalCloseUser;
    private String finalCloseDate;
    private String tenderAwardUser;
    private String tenderAwardDate;
    private String tenderAcceptUser;
    private String tenderAcceptDate;
    private String plant;
    private String gst;
    private String purchaseOrganization;
    private String address;
    private String locationName;
    private String locationAddress;
    private String remarks;
    private String prReworkBy;
    private String prReworkDate;
    private String prComment;
    private int singleQuoteFlag;
    private String singleQuoteAttachment;
    private String nameofLocationPartner;
    private String mobileNoLocationPartner;

    private String projectIdUpdateDate;
    private String budgetAmountUpdateDate;
    private String currency;

    public PRMaster() {
    }

    public PRMaster(int id, String prNo, String title, String projectId, String categoryId, String value, String type, String contactPerson, String location, String announceDate, String workDesc, String prRemark, String prAdmin, String prAdminContactNumber, int authorizeFlag, String authorizeDate, String department, String billingLocation, String technicalContactName, String technicalContactNo, String address1, String address2, String state, String city, String pincode, String quotes, String businessType, String projectType, String tenderCreaterId, int tenderFlag, String deliveryPeriod, String technicalCommittee, String priceCommittee, String prAuthorizeUser, String prAuthorizeDate, String tenderAssignUser, String tenderAssignDate, String tenderCreaterUser, String tenderCreaterDate, String techBidOpenUser, String techBidOpenDate, String techBidApproveUser, String techBidApproveDate, String priceBidOpenUser, String priceBidOpenDate, String priceBidStartUser, String priceBidStartDate, String finalCloseUser, String finalCloseDate, String tenderAwardUser, String tenderAwardDate, String tenderAcceptUser, String tenderAcceptDate, String plant, String gst, String purchaseOrganization, String address, String locationName, String locationAddress, String remarks, String prReworkBy, String prReworkDate, String prComment, int singleQuoteFlag, String singleQuoteAttachment, String nameofLocationPartner, String mobileNoLocationPartner, String projectIdUpdateDate, String budgetAmountUpdateDate, String currency) {
        this.id = id;
        this.prNo = prNo;
        this.title = title;
        this.projectId = projectId;
        this.categoryId = categoryId;
        this.value = value;
        this.type = type;
        this.contactPerson = contactPerson;
        this.location = location;
        this.announceDate = announceDate;
        this.workDesc = workDesc;
        this.prRemark = prRemark;
        this.prAdmin = prAdmin;
        this.prAdminContactNumber = prAdminContactNumber;
        this.authorizeFlag = authorizeFlag;
        this.authorizeDate = authorizeDate;
        this.department = department;
        this.billingLocation = billingLocation;
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
        this.tenderCreaterId = tenderCreaterId;
        this.tenderFlag = tenderFlag;
        this.deliveryPeriod = deliveryPeriod;
        this.technicalCommittee = technicalCommittee;
        this.priceCommittee = priceCommittee;
        this.prAuthorizeUser = prAuthorizeUser;
        this.prAuthorizeDate = prAuthorizeDate;
        this.tenderAssignUser = tenderAssignUser;
        this.tenderAssignDate = tenderAssignDate;
        this.tenderCreaterUser = tenderCreaterUser;
        this.tenderCreaterDate = tenderCreaterDate;
        this.techBidOpenUser = techBidOpenUser;
        this.techBidOpenDate = techBidOpenDate;
        this.techBidApproveUser = techBidApproveUser;
        this.techBidApproveDate = techBidApproveDate;
        this.priceBidOpenUser = priceBidOpenUser;
        this.priceBidOpenDate = priceBidOpenDate;
        this.priceBidStartUser = priceBidStartUser;
        this.priceBidStartDate = priceBidStartDate;
        this.finalCloseUser = finalCloseUser;
        this.finalCloseDate = finalCloseDate;
        this.tenderAwardUser = tenderAwardUser;
        this.tenderAwardDate = tenderAwardDate;
        this.tenderAcceptUser = tenderAcceptUser;
        this.tenderAcceptDate = tenderAcceptDate;
        this.plant = plant;
        this.gst = gst;
        this.purchaseOrganization = purchaseOrganization;
        this.address = address;
        this.locationName = locationName;
        this.locationAddress = locationAddress;
        this.remarks = remarks;
        this.prReworkBy = prReworkBy;
        this.prReworkDate = prReworkDate;
        this.prComment = prComment;
        this.singleQuoteFlag = singleQuoteFlag;
        this.singleQuoteAttachment = singleQuoteAttachment;
        this.nameofLocationPartner = nameofLocationPartner;
        this.mobileNoLocationPartner = mobileNoLocationPartner;

        this.projectIdUpdateDate = projectIdUpdateDate;
        this.budgetAmountUpdateDate = budgetAmountUpdateDate;
        this.currency = currency;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrNo() {
        return prNo;
    }

    public void setPrNo(String prNo) {
        this.prNo = prNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getprojectId() {
        return projectId;
    }

    public void setprojectId(String projectId) {
        this.projectId = projectId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAnnounceDate() {
        return announceDate;
    }

    public void setAnnounceDate(String announceDate) {
        this.announceDate = announceDate;
    }

    public String getWorkDesc() {
        return workDesc;
    }

    public void setWorkDesc(String workDesc) {
        this.workDesc = workDesc;
    }

    public String getPrRemark() {
        return prRemark;
    }

    public void setPrRemark(String prRemark) {
        this.prRemark = prRemark;
    }

    public String getPrAdmin() {
        return prAdmin;
    }

    public void setPrAdmin(String prAdmin) {
        this.prAdmin = prAdmin;
    }

    public String getPrAdminContactNumber() {
        return prAdminContactNumber;
    }

    public void setPrAdminContactNumber(String prAdminContactNumber) {
        this.prAdminContactNumber = prAdminContactNumber;
    }

    public int getAuthorizeFlag() {
        return authorizeFlag;
    }

    public void setAuthorizeFlag(int authorizeFlag) {
        this.authorizeFlag = authorizeFlag;
    }

    public String getAuthorizeDate() {
        return authorizeDate;
    }

    public void setAuthorizeDate(String authorizeDate) {
        this.authorizeDate = authorizeDate;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getBillingLocation() {
        return billingLocation;
    }

    public void setBillingLocation(String billingLocation) {
        this.billingLocation = billingLocation;
    }

    public String getTechnicalContactName() {
        return technicalContactName;
    }

    public void setTechnicalContactName(String technicalContactName) {
        this.technicalContactName = technicalContactName;
    }

    public String getTechnicalContactNo() {
        return technicalContactNo;
    }

    public void setTechnicalContactNo(String technicalContactNo) {
        this.technicalContactNo = technicalContactNo;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getQuotes() {
        return quotes;
    }

    public void setQuotes(String quotes) {
        this.quotes = quotes;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getTenderCreaterId() {
        return tenderCreaterId;
    }

    public void setTenderCreaterId(String tenderCreaterId) {
        this.tenderCreaterId = tenderCreaterId;
    }

    public int getTenderFlag() {
        return tenderFlag;
    }

    public void setTenderFlag(int tenderFlag) {
        this.tenderFlag = tenderFlag;
    }

    public String getDeliveryPeriod() {
        return deliveryPeriod;
    }

    public void setDeliveryPeriod(String deliveryPeriod) {
        this.deliveryPeriod = deliveryPeriod;
    }

    public String getTechnicalCommittee() {
        return technicalCommittee;
    }

    public void setTechnicalCommittee(String technicalCommittee) {
        this.technicalCommittee = technicalCommittee;
    }

    public String getPriceCommittee() {
        return priceCommittee;
    }

    public void setPriceCommittee(String priceCommittee) {
        this.priceCommittee = priceCommittee;
    }

    public String getPrAuthorizeUser() {
        return prAuthorizeUser;
    }

    public void setPrAuthorizeUser(String prAuthorizeUser) {
        this.prAuthorizeUser = prAuthorizeUser;
    }

    public String getPrAuthorizeDate() {
        return prAuthorizeDate;
    }

    public void setPrAuthorizeDate(String prAuthorizeDate) {
        this.prAuthorizeDate = prAuthorizeDate;
    }

    public String getTenderAssignUser() {
        return tenderAssignUser;
    }

    public void setTenderAssignUser(String tenderAssignUser) {
        this.tenderAssignUser = tenderAssignUser;
    }

    public String getTenderAssignDate() {
        return tenderAssignDate;
    }

    public void setTenderAssignDate(String tenderAssignDate) {
        this.tenderAssignDate = tenderAssignDate;
    }

    public String getTenderCreaterUser() {
        return tenderCreaterUser;
    }

    public void setTenderCreaterUser(String tenderCreaterUser) {
        this.tenderCreaterUser = tenderCreaterUser;
    }

    public String getTenderCreaterDate() {
        return tenderCreaterDate;
    }

    public void setTenderCreaterDate(String tenderCreaterDate) {
        this.tenderCreaterDate = tenderCreaterDate;
    }

    public String getTechBidOpenUser() {
        return techBidOpenUser;
    }

    public void setTechBidOpenUser(String techBidOpenUser) {
        this.techBidOpenUser = techBidOpenUser;
    }

    public String getTechBidOpenDate() {
        return techBidOpenDate;
    }

    public void setTechBidOpenDate(String techBidOpenDate) {
        this.techBidOpenDate = techBidOpenDate;
    }

    public String getTechBidApproveUser() {
        return techBidApproveUser;
    }

    public void setTechBidApproveUser(String techBidApproveUser) {
        this.techBidApproveUser = techBidApproveUser;
    }

    public String getTechBidApproveDate() {
        return techBidApproveDate;
    }

    public void setTechBidApproveDate(String techBidApproveDate) {
        this.techBidApproveDate = techBidApproveDate;
    }

    public String getPriceBidOpenUser() {
        return priceBidOpenUser;
    }

    public void setPriceBidOpenUser(String priceBidOpenUser) {
        this.priceBidOpenUser = priceBidOpenUser;
    }

    public String getPriceBidOpenDate() {
        return priceBidOpenDate;
    }

    public void setPriceBidOpenDate(String priceBidOpenDate) {
        this.priceBidOpenDate = priceBidOpenDate;
    }

    public String getPriceBidStartUser() {
        return priceBidStartUser;
    }

    public void setPriceBidStartUser(String priceBidStartUser) {
        this.priceBidStartUser = priceBidStartUser;
    }

    public String getPriceBidStartDate() {
        return priceBidStartDate;
    }

    public void setPriceBidStartDate(String priceBidStartDate) {
        this.priceBidStartDate = priceBidStartDate;
    }

    public String getFinalCloseUser() {
        return finalCloseUser;
    }

    public void setFinalCloseUser(String finalCloseUser) {
        this.finalCloseUser = finalCloseUser;
    }

    public String getFinalCloseDate() {
        return finalCloseDate;
    }

    public void setFinalCloseDate(String finalCloseDate) {
        this.finalCloseDate = finalCloseDate;
    }

    public String getTenderAwardUser() {
        return tenderAwardUser;
    }

    public void setTenderAwardUser(String tenderAwardUser) {
        this.tenderAwardUser = tenderAwardUser;
    }

    public String getTenderAwardDate() {
        return tenderAwardDate;
    }

    public void setTenderAwardDate(String tenderAwardDate) {
        this.tenderAwardDate = tenderAwardDate;
    }

    public String getTenderAcceptUser() {
        return tenderAcceptUser;
    }

    public void setTenderAcceptUser(String tenderAcceptUser) {
        this.tenderAcceptUser = tenderAcceptUser;
    }

    public String getTenderAcceptDate() {
        return tenderAcceptDate;
    }

    public void setTenderAcceptDate(String tenderAcceptDate) {
        this.tenderAcceptDate = tenderAcceptDate;
    }

    public String getPlant() {
        return plant;
    }

    public void setPlant(String plant) {
        this.plant = plant;
    }

    public String getGst() {
        return gst;
    }

    public void setGst(String gst) {
        this.gst = gst;
    }

    public String getPurchaseOrganization() {
        return purchaseOrganization;
    }

    public void setPurchaseOrganization(String purchaseOrganization) {
        this.purchaseOrganization = purchaseOrganization;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationAddress() {
        return locationAddress;
    }

    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getPrReworkBy() {
        return prReworkBy;
    }

    public void setPrReworkBy(String prReworkBy) {
        this.prReworkBy = prReworkBy;
    }

    public String getPrReworkDate() {
        return prReworkDate;
    }

    public void setPrReworkDate(String prReworkDate) {
        this.prReworkDate = prReworkDate;
    }

    public int getSingleQuoteFlag() {
        return singleQuoteFlag;
    }

    public void setSingleQuoteFlag(int singleQuoteFlag) {
        this.singleQuoteFlag = singleQuoteFlag;
    }

    public String getSingleQuoteAttachment() {
        return singleQuoteAttachment;
    }

    public void setSingleQuoteAttachment(String singleQuoteAttachment) {
        this.singleQuoteAttachment = singleQuoteAttachment;
    }

    public String getPrComment() {
        return prComment;
    }

    public void setPrComment(String prComment) {
        this.prComment = prComment;
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

    public String getProjectIdUpdateDate() {
        return projectIdUpdateDate;
    }

    public void setProjectIdUpdateDate(String projectIdUpdateDate) {
        this.projectIdUpdateDate = projectIdUpdateDate;
    }

    public String getBudgetAmountUpdateDate() {
        return budgetAmountUpdateDate;
    }

    public void setBudgetAmountUpdateDate(String budgetAmountUpdateDate) {
        this.budgetAmountUpdateDate = budgetAmountUpdateDate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

}
