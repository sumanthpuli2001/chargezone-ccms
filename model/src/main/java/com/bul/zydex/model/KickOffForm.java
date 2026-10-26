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
public class KickOffForm {

    private int id;
    private String hubLocation;
    private String dateTime;
    private String projectName;
    private String minutues;
    private String designBasic;
    private String boq;
    private String laoLoi;
    private String agreement;
    private String approvedLayout;
    private String agendas;
    private String issues;
    private String decisions;
    private String planLayout;
    private String projectBudget;
    private String projectTimeLine;
    private String comments;
    private String designBasicReport;
    private String approvedLayoutDrawings;
    private String boqNo;
    private String deliverableReleaseDate;
    private String reviewsComments;
    private String newRevisonNo;
    private String preparedBy;
    private String designation;
    private String signatureDate;
    private OapMaster oapMaster;
    private int flagStatus;
    private AocForm aocForm;
    private String userId;
    private String documentNo;

    public KickOffForm() {
    }

    public KickOffForm(int id, String hubLocation, String dateTime, String projectName, String minutues, String designBasic, String boq, String laoLoi, String agreement, String approvedLayout, String agendas, String issues, String decisions, String planLayout, String projectBudget, String projectTimeLine, String comments, String designBasicReport, String approvedLayoutDrawings, String boqNo, String deliverableReleaseDate, String reviewsComments, String newRevisonNo, String preparedBy, String designation, String signatureDate, OapMaster oapMaster, int flagStatus, AocForm aocForm, String userId, String documentNo) {
	this.id = id;
	this.hubLocation = hubLocation;
	this.dateTime = dateTime;
	this.projectName = projectName;
	this.minutues = minutues;
	this.designBasic = designBasic;
	this.boq = boq;
	this.laoLoi = laoLoi;
	this.agreement = agreement;
	this.approvedLayout = approvedLayout;
	this.agendas = agendas;
	this.issues = issues;
	this.decisions = decisions;
	this.planLayout = planLayout;
	this.projectBudget = projectBudget;
	this.projectTimeLine = projectTimeLine;
	this.comments = comments;
	this.designBasicReport = designBasicReport;
	this.approvedLayoutDrawings = approvedLayoutDrawings;
	this.boqNo = boqNo;
	this.deliverableReleaseDate = deliverableReleaseDate;
	this.reviewsComments = reviewsComments;
	this.newRevisonNo = newRevisonNo;
	this.preparedBy = preparedBy;
	this.designation = designation;
	this.signatureDate = signatureDate;
	this.oapMaster = oapMaster;
	this.flagStatus = flagStatus;
	this.aocForm = aocForm;
	this.userId = userId;
	this.documentNo = documentNo;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getHubLocation() {
	return hubLocation;
    }

    public void setHubLocation(String hubLocation) {
	this.hubLocation = hubLocation;
    }

    public String getDateTime() {
	return dateTime;
    }

    public void setDateTime(String dateTime) {
	this.dateTime = dateTime;
    }

    public String getProjectName() {
	return projectName;
    }

    public void setProjectName(String projectName) {
	this.projectName = projectName;
    }

    public String getMinutues() {
	return minutues;
    }

    public void setMinutues(String minutues) {
	this.minutues = minutues;
    }

    public String getDesignBasic() {
	return designBasic;
    }

    public void setDesignBasic(String designBasic) {
	this.designBasic = designBasic;
    }

    public String getBoq() {
	return boq;
    }

    public void setBoq(String boq) {
	this.boq = boq;
    }

    public String getLaoLoi() {
	return laoLoi;
    }

    public void setLaoLoi(String laoLoi) {
	this.laoLoi = laoLoi;
    }

    public String getAgreement() {
	return agreement;
    }

    public void setAgreement(String agreement) {
	this.agreement = agreement;
    }

    public String getApprovedLayout() {
	return approvedLayout;
    }

    public void setApprovedLayout(String approvedLayout) {
	this.approvedLayout = approvedLayout;
    }

    public String getAgendas() {
	return agendas;
    }

    public void setAgendas(String agendas) {
	this.agendas = agendas;
    }

    public String getIssues() {
	return issues;
    }

    public void setIssues(String issues) {
	this.issues = issues;
    }

    public String getDecisions() {
	return decisions;
    }

    public void setDecisions(String decisions) {
	this.decisions = decisions;
    }

    public String getPlanLayout() {
	return planLayout;
    }

    public void setPlanLayout(String planLayout) {
	this.planLayout = planLayout;
    }

    public String getProjectBudget() {
	return projectBudget;
    }

    public void setProjectBudget(String projectBudget) {
	this.projectBudget = projectBudget;
    }

    public String getProjectTimeLine() {
	return projectTimeLine;
    }

    public void setProjectTimeLine(String projectTimeLine) {
	this.projectTimeLine = projectTimeLine;
    }

    public String getComments() {
	return comments;
    }

    public void setComments(String comments) {
	this.comments = comments;
    }

    public String getDesignBasicReport() {
	return designBasicReport;
    }

    public void setDesignBasicReport(String designBasicReport) {
	this.designBasicReport = designBasicReport;
    }

    public String getApprovedLayoutDrawings() {
	return approvedLayoutDrawings;
    }

    public void setApprovedLayoutDrawings(String approvedLayoutDrawings) {
	this.approvedLayoutDrawings = approvedLayoutDrawings;
    }

    public String getBoqNo() {
	return boqNo;
    }

    public void setBoqNo(String boqNo) {
	this.boqNo = boqNo;
    }

    public String getDeliverableReleaseDate() {
	return deliverableReleaseDate;
    }

    public void setDeliverableReleaseDate(String deliverableReleaseDate) {
	this.deliverableReleaseDate = deliverableReleaseDate;
    }

    public String getReviewsComments() {
	return reviewsComments;
    }

    public void setReviewsComments(String reviewsComments) {
	this.reviewsComments = reviewsComments;
    }

    public String getNewRevisonNo() {
	return newRevisonNo;
    }

    public void setNewRevisonNo(String newRevisonNo) {
	this.newRevisonNo = newRevisonNo;
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

    public String getSignatureDate() {
	return signatureDate;
    }

    public void setSignatureDate(String signatureDate) {
	this.signatureDate = signatureDate;
    }

    public OapMaster getOapMaster() {
	return oapMaster;
    }

    public void setOapMaster(OapMaster oapMaster) {
	this.oapMaster = oapMaster;
    }

    public int getFlagStatus() {
	return flagStatus;
    }

    public void setFlagStatus(int flagStatus) {
	this.flagStatus = flagStatus;
    }

    public AocForm getAocForm() {
	return aocForm;
    }

    public void setAocForm(AocForm aocForm) {
	this.aocForm = aocForm;
    }

    public String getUserId() {
	return userId;
    }

    public void setUserId(String userId) {
	this.userId = userId;
    }

    public String getDocumentNo() {
	return documentNo;
    }

    public void setDocumentNo(String documentNo) {
	this.documentNo = documentNo;
    }

   
    
    
    
    
    
}
