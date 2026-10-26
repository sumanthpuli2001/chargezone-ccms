/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author Hitesh
 */
public class CrcFormHistory {

    private int id;
    private String documentNo;
    private String pcsName;
    private String documentRevisionNo;
    private String oapNumber;
    private String siteSurveyAcceptance;
    private String aggrementAcceptance;
    private String landOwnerShipDocument;
    private String nocConsent;
    private String comment;
    private String planLayoutSigned;
    private String projectBudgetOap;
    private String projectTimelineOap;
    private String aaprovalComment;
    private String billMaterialNo;
    private String pcsDrawingNumber;
    private String scopeWork;
    private String deliverableReleaseDate;
    private String newRevisionNumber;
    private String reviewerComment;
    private String preparedBy;
    private String designation;
    private String projectEngineer;
    private String signatureDate;
    private int oapMaster;
    private int flagStatus;
    private int oapForm;
    private String userid;
    private String history;
    private String dateTime;
  
    private int crcId;

    public CrcFormHistory() {
    }

    public CrcFormHistory(int id, String documentNo, String pcsName, String documentRevisionNo, String oapNumber, String siteSurveyAcceptance, String aggrementAcceptance, String landOwnerShipDocument, String nocConsent, String comment, String planLayoutSigned, String projectBudgetOap, String projectTimelineOap, String aaprovalComment, String billMaterialNo, String pcsDrawingNumber, String scopeWork, String deliverableReleaseDate, String newRevisionNumber, String reviewerComment, String preparedBy, String designation, String projectEngineer, String signatureDate, int oapMaster, int flagStatus, int oapForm, String userid, String history, String dateTime, int crcId) {
	this.id = id;
	this.documentNo = documentNo;
	this.pcsName = pcsName;
	this.documentRevisionNo = documentRevisionNo;
	this.oapNumber = oapNumber;
	this.siteSurveyAcceptance = siteSurveyAcceptance;
	this.aggrementAcceptance = aggrementAcceptance;
	this.landOwnerShipDocument = landOwnerShipDocument;
	this.nocConsent = nocConsent;
	this.comment = comment;
	this.planLayoutSigned = planLayoutSigned;
	this.projectBudgetOap = projectBudgetOap;
	this.projectTimelineOap = projectTimelineOap;
	this.aaprovalComment = aaprovalComment;
	this.billMaterialNo = billMaterialNo;
	this.pcsDrawingNumber = pcsDrawingNumber;
	this.scopeWork = scopeWork;
	this.deliverableReleaseDate = deliverableReleaseDate;
	this.newRevisionNumber = newRevisionNumber;
	this.reviewerComment = reviewerComment;
	this.preparedBy = preparedBy;
	this.designation = designation;
	this.projectEngineer = projectEngineer;
	this.signatureDate = signatureDate;
	this.oapMaster = oapMaster;
	this.flagStatus = flagStatus;
	this.oapForm = oapForm;
	this.userid = userid;
	this.history = history;
	this.dateTime = dateTime;
	
	this.crcId=crcId;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getDocumentNo() {
	return documentNo;
    }

    public void setDocumentNo(String documentNo) {
	this.documentNo = documentNo;
    }

    public String getPcsName() {
	return pcsName;
    }

    public void setPcsName(String pcsName) {
	this.pcsName = pcsName;
    }

    public String getDocumentRevisionNo() {
	return documentRevisionNo;
    }

    public void setDocumentRevisionNo(String documentRevisionNo) {
	this.documentRevisionNo = documentRevisionNo;
    }

    public String getOapNumber() {
	return oapNumber;
    }

    public void setOapNumber(String oapNumber) {
	this.oapNumber = oapNumber;
    }

    public String getSiteSurveyAcceptance() {
	return siteSurveyAcceptance;
    }

    public void setSiteSurveyAcceptance(String siteSurveyAcceptance) {
	this.siteSurveyAcceptance = siteSurveyAcceptance;
    }

    public String getAggrementAcceptance() {
	return aggrementAcceptance;
    }

    public void setAggrementAcceptance(String aggrementAcceptance) {
	this.aggrementAcceptance = aggrementAcceptance;
    }

    public String getLandOwnerShipDocument() {
	return landOwnerShipDocument;
    }

    public void setLandOwnerShipDocument(String landOwnerShipDocument) {
	this.landOwnerShipDocument = landOwnerShipDocument;
    }

    public String getNocConsent() {
	return nocConsent;
    }

    public void setNocConsent(String nocConsent) {
	this.nocConsent = nocConsent;
    }

    public String getComment() {
	return comment;
    }

    public void setComment(String comment) {
	this.comment = comment;
    }

    public String getPlanLayoutSigned() {
	return planLayoutSigned;
    }

    public void setPlanLayoutSigned(String planLayoutSigned) {
	this.planLayoutSigned = planLayoutSigned;
    }

    public String getProjectBudgetOap() {
	return projectBudgetOap;
    }

    public void setProjectBudgetOap(String projectBudgetOap) {
	this.projectBudgetOap = projectBudgetOap;
    }

    public String getProjectTimelineOap() {
	return projectTimelineOap;
    }

    public void setProjectTimelineOap(String projectTimelineOap) {
	this.projectTimelineOap = projectTimelineOap;
    }

    public String getAaprovalComment() {
	return aaprovalComment;
    }

    public void setAaprovalComment(String aaprovalComment) {
	this.aaprovalComment = aaprovalComment;
    }

    public String getBillMaterialNo() {
	return billMaterialNo;
    }

    public void setBillMaterialNo(String billMaterialNo) {
	this.billMaterialNo = billMaterialNo;
    }

    public String getPcsDrawingNumber() {
	return pcsDrawingNumber;
    }

    public void setPcsDrawingNumber(String pcsDrawingNumber) {
	this.pcsDrawingNumber = pcsDrawingNumber;
    }

    public String getScopeWork() {
	return scopeWork;
    }

    public void setScopeWork(String scopeWork) {
	this.scopeWork = scopeWork;
    }

    public String getDeliverableReleaseDate() {
	return deliverableReleaseDate;
    }

    public void setDeliverableReleaseDate(String deliverableReleaseDate) {
	this.deliverableReleaseDate = deliverableReleaseDate;
    }

    public String getNewRevisionNumber() {
	return newRevisionNumber;
    }

    public void setNewRevisionNumber(String newRevisionNumber) {
	this.newRevisionNumber = newRevisionNumber;
    }

    public String getReviewerComment() {
	return reviewerComment;
    }

    public void setReviewerComment(String reviewerComment) {
	this.reviewerComment = reviewerComment;
    }

    public String getPreparedBy() {
	return preparedBy;
    }

    public void setPreparedBy(String preparedBy) {
	this.preparedBy = preparedBy;
    }

    public String getDesignation() {
	return designation;
    }

    public void setDesignation(String designation) {
	this.designation = designation;
    }

    public String getProjectEngineer() {
	return projectEngineer;
    }

    public void setProjectEngineer(String projectEngineer) {
	this.projectEngineer = projectEngineer;
    }

    public String getSignatureDate() {
	return signatureDate;
    }

    public void setSignatureDate(String signatureDate) {
	this.signatureDate = signatureDate;
    }

    public int getOapMaster() {
	return oapMaster;
    }

    public void setOapMaster(int oapMaster) {
	this.oapMaster = oapMaster;
    }

    public int getFlagStatus() {
	return flagStatus;
    }

    public void setFlagStatus(int flagStatus) {
	this.flagStatus = flagStatus;
    }

    public int getOapForm() {
	return oapForm;
    }

    public void setOapForm(int oapForm) {
	this.oapForm = oapForm;
    }

    public String getUserid() {
	return userid;
    }

    public void setUserid(String userid) {
	this.userid = userid;
    }

    public String getHistory() {
	return history;
    }

    public void setHistory(String history) {
	this.history = history;
    }

    public String getDateTime() {
	return dateTime;
    }

    public void setDateTime(String dateTime) {
	this.dateTime = dateTime;
    }

   

    public int getCrcId() {
	return crcId;
    }

    public void setCrcId(int crcId) {
	this.crcId = crcId;
    }

}
