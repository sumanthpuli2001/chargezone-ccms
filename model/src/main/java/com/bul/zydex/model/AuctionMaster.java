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
public class AuctionMaster {
 
    private int id;
    private String auctionNo;
    private String title;
    private String categoryId;
    private String subCategoryId;
    private String value;
    private String emd;
    private String docCost;
    private String type;    
    private String contactPerson;    
    private String location;    
    private String biddingStartdate;
    private String portalDate;
    private String collectionLastdate;
    private String biddingEnddate;
    private String workDesc;
    private String auctionRemark;
    private String auctionAdmin;
    private String auctionAdminContactNumber;
    private String auctionAuthorizePerson;
    private String auctionAuthorizeContactNo;
    private int authorizeFlag;
    private String auctionAuthorizeUserName;
    private int emailFlag;
    private String authorizeDate;
    private int returnFlag;
    private String returnText;
    private int deleteFlag;
    private String deleteRemark;
    private String department;
    private String prNo;
    private String auctionType;
    private String lastBiddingTime;
    private String extendTime;
    private String extendTimeNo;
    private String bidding;
    private String biddingDisplay;
    private String autoDecIncAmount;
    private String currency;
    private String refreshRate;
    private String biddingType;
    private String auctionBy;
    private String auctionAmount;
    
    
    public AuctionMaster() {
    }
    
    public AuctionMaster(int id, String auctionNo, String title, String categoryId, String subCategoryId, String value, String emd, String docCost, String type, String contactPerson, String location, String biddingStartdate, String portalDate, String collectionLastdate, String biddingEnddate, String workDesc, String auctionRemark, String auctionAdmin, String auctionAdminContactNumber, String auctionAuthorizePerson, String auctionAuthorizeContactNo, int authorizeFlag, String auctionAuthorizeUserName, int emailFlag, String authorizeDate, int returnFlag, String returnText, int deleteFlag, String deleteRemark, String department, String prNo, String auctionType, String lastBiddingTime, String extendTime, String extendTimeNo, String bidding, String biddingDisplay, String autoDecIncAmount, String currency, String refreshRate, String auctionBy, String auctionAmount) {
        
        this.id = id;
        this.auctionNo = auctionNo;    
        this.title = title;    
        this.categoryId = categoryId;    
        this.subCategoryId = subCategoryId;    
        this.value = value;    
        this.emd = emd;    
        this.docCost = docCost;    
        this.type = type;    
        this.contactPerson = contactPerson;    
        this.location = location;    
        this.biddingStartdate = biddingStartdate;
        this.portalDate = portalDate;
        this.collectionLastdate = collectionLastdate;
        this.biddingEnddate = biddingEnddate;
        this.workDesc = workDesc;
        this.auctionRemark = auctionRemark;
        this.auctionAdmin = auctionAdmin;
        this.auctionAdminContactNumber = auctionAdminContactNumber;
        this.auctionAuthorizePerson = auctionAuthorizePerson;
        this.auctionAuthorizeContactNo = auctionAuthorizeContactNo;
        this.authorizeFlag = authorizeFlag;
        this.auctionAuthorizeUserName = auctionAuthorizeUserName;
        this.emailFlag = emailFlag;
        this.authorizeDate = authorizeDate;
        this.returnFlag = returnFlag;
        this.returnText = returnText;
        this.deleteFlag = deleteFlag;
        this.deleteRemark = deleteRemark;
        this.department = department;
        this.prNo = prNo;
        this.auctionType = auctionType;
        this.lastBiddingTime = lastBiddingTime;
        this.extendTime = extendTime;
        this.extendTimeNo = extendTimeNo;
        this.bidding = bidding;
        this.biddingDisplay = biddingDisplay;
        this.autoDecIncAmount = autoDecIncAmount;
        this.currency = currency;
        this.refreshRate = refreshRate;
        this.auctionBy = auctionBy;
        this.auctionAmount = auctionAmount;

    }

    public AuctionMaster(String biddingType) {
        this.biddingType = biddingType;
    }


    public int getId() {
        return id;
    }

    public AuctionMaster setId(int id) {
        this.id = id;
        return this;
    }

    public String getAuctionNo() {
        return auctionNo;
    }

    public AuctionMaster setAuctionNo(String auctionNo) {
        this.auctionNo = auctionNo;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public AuctionMaster setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public AuctionMaster setCategoryId(String categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public String getSubCategoryId() {
        return subCategoryId;
    }

    public AuctionMaster setSubCategoryId(String subCategoryId) {
        this.subCategoryId = subCategoryId;
        return this;
    }

    public String getValue() {
        return value;
    }

    public AuctionMaster setValue(String value) {
        this.value = value;
        return this;
    }

    public String getEmd() {
        return emd;
    }

    public AuctionMaster setEmd(String emd) {
        this.emd = emd;
        return this;
    }

    public String getDocCost() {
        return docCost;
    }

    public AuctionMaster setDocCost(String docCost) {
        this.docCost = docCost;
        return this;
    }

    public String getType() {
        return type;
    }

    public AuctionMaster setType(String type) {
        this.type = type;
        return this;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public AuctionMaster setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public AuctionMaster setLocation(String location) {
        this.location = location;
        return this;
    }

    public String getBiddingStartdate() {
        return biddingStartdate;
    }

    public AuctionMaster setBiddingStartdate(String biddingStartdate) {
        this.biddingStartdate = biddingStartdate;
        return this;
    }

    public String getPortalDate() {
        return portalDate;
    }

    public AuctionMaster setPortalDate(String portalDate) {
        this.portalDate = portalDate;
        return this;
    }

    public String getCollectionLastdate() {
        return collectionLastdate;
    }

    public AuctionMaster setCollectionLastdate(String collectionLastdate) {
        this.collectionLastdate = collectionLastdate;
        return this;
    }

    public String getBiddingEnddate() {
        return biddingEnddate;
    }

    public AuctionMaster setBiddingEnddate(String biddingEnddate) {
        this.biddingEnddate = biddingEnddate;
        return this;
    }

    public String getWorkDesc() {
        return workDesc;
    }

    public AuctionMaster setWorkDesc(String workDesc) {
        this.workDesc = workDesc;
        return this;
    }

    public String getAuctionRemark() {
        return auctionRemark;
    }

    public AuctionMaster setAuctionRemark(String auctionRemark) {
        this.auctionRemark = auctionRemark;
        return this;
    }

    public String getAuctionAdmin() {
        return auctionAdmin;
    }

    public AuctionMaster setAuctionAdmin(String auctionAdmin) {
        this.auctionAdmin = auctionAdmin;
        return this;
    }

    public String getAuctionAdminContactNumber() {
        return auctionAdminContactNumber;
    }

    public AuctionMaster setAuctionAdminContactNumber(String auctionAdminContactNumber) {
        this.auctionAdminContactNumber = auctionAdminContactNumber;
        return this;
    }

    public String getAuctionAuthorizePerson() {
        return auctionAuthorizePerson;
    }

    public AuctionMaster setAuctionAuthorizePerson(String auctionAuthorizePerson) {
        this.auctionAuthorizePerson = auctionAuthorizePerson;
        return this;
    }

    public String getAuctionAuthorizeContactNo() {
        return auctionAuthorizeContactNo;
    }

    public AuctionMaster setAuctionAuthorizeContactNo(String auctionAuthorizeContactNo) {
        this.auctionAuthorizeContactNo = auctionAuthorizeContactNo;
        return this;
    }

    public int getAuthorizeFlag() {
        return authorizeFlag;
    }

    public AuctionMaster setAuthorizeFlag(int authorizeFlag) {
        this.authorizeFlag = authorizeFlag;
        return this;
    }

    public String getAuctionAuthorizeUserName() {
        return auctionAuthorizeUserName;
    }

    public AuctionMaster setAuctionAuthorizeUserName(String auctionAuthorizeUserName) {
        this.auctionAuthorizeUserName = auctionAuthorizeUserName;
        return this;
    }

    public int getEmailFlag() {
        return emailFlag;
    }

    public AuctionMaster setEmailFlag(int emailFlag) {
        this.emailFlag = emailFlag;
        return this;
    }

    public String getAuthorizeDate() {
        return authorizeDate;
    }

    public AuctionMaster setAuthorizeDate(String authorizeDate) {
        this.authorizeDate = authorizeDate;
        return this;
    }

    public int getReturnFlag() {
        return returnFlag;
    }

    public AuctionMaster setReturnFlag(int returnFlag) {
        this.returnFlag = returnFlag;
        return this;
    }

    public String getReturnText() {
        return returnText;
    }

    public AuctionMaster setReturnText(String returnText) {
        this.returnText = returnText;
        return this;
    }

    public int getDeleteFlag() {
        return deleteFlag;
    }

    public AuctionMaster setDeleteFlag(int deleteFlag) {
        this.deleteFlag = deleteFlag;
        return this;
    }

    public String getDeleteRemark() {
        return deleteRemark;
    }

    public AuctionMaster setDeleteRemark(String deleteRemark) {
        this.deleteRemark = deleteRemark;
        return this;
    }

    public String getDepartment() {
        return department;
    }

    public AuctionMaster setDepartment(String department) {
        this.department = department;
        return this;
    }

    public String getPrNo() {
        return prNo;
    }

    public AuctionMaster setPrNo(String prNo) {
        this.prNo = prNo;
        return this;
    }

    public String getAuctionType() {
        return auctionType;
    }

    public AuctionMaster setAuctionType(String auctionType) {
        this.auctionType = auctionType;
        return this;
    }

    public String getLastBiddingTime() {
        return lastBiddingTime;
    }

    public AuctionMaster setLastBiddingTime(String lastBiddingTime) {
        this.lastBiddingTime = lastBiddingTime;
        return this;
    }

    public String getExtendTime() {
        return extendTime;
    }

    public AuctionMaster setExtendTime(String extendTime) {
        this.extendTime = extendTime;
        return this;
    }

    public String getExtendTimeNo() {
        return extendTimeNo;
    }

    public AuctionMaster setExtendTimeNo(String extendTimeNo) {
        this.extendTimeNo = extendTimeNo;
        return this;
    }

    public String getBidding() {
        return bidding;
    }

    public AuctionMaster setBidding(String bidding) {
        this.bidding = bidding;
        return this;
    }

    public String getBiddingDisplay() {
        return biddingDisplay;
    }

    public AuctionMaster setBiddingDisplay(String biddingDisplay) {
        this.biddingDisplay = biddingDisplay;
        return this;
    }

    public String getAutoDecIncAmount() {
        return autoDecIncAmount;
    }

    public AuctionMaster setAutoDecIncAmount(String autoDecIncAmount) {
        this.autoDecIncAmount = autoDecIncAmount;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public AuctionMaster setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public String getRefreshRate() {
        return refreshRate;
    }

    public AuctionMaster setRefreshRate(String refreshRate) {
        this.refreshRate = refreshRate;
        return this;
    }
    
    public String getBiddingType() {
        return biddingType;
    }

    public AuctionMaster setBiddingType(String biddingType) {
        this.biddingType = biddingType;
        return this;
    }

    public String getAuctionBy() {
        return auctionBy;
    }

    public AuctionMaster setAuctionBy(String auctionBy) {
        this.auctionBy = auctionBy;
        return this;
    }

    public String getAuctionAmount() {
        return auctionAmount;
    }

    public AuctionMaster setAuctionAmount(String auctionAmount) {
        this.auctionAmount = auctionAmount;
        return this;
    }
    
    
}
