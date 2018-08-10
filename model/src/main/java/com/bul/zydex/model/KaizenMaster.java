/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author Aman
 */
public class KaizenMaster implements java.io.Serializable {

    private Integer id;
    private String srNo;
    private String teamName;
    private String department;
    private String teamLeader;
    private String ideaGenerator;
    private String teamMember;
    private String startDate;
    private String compiletionDate;
    private String budgetRequirement;
    private String problemDescription;
    private String beforePhoto;
    private String improvementDescription;
    private String afterPhoto;
    private String tangibleBenefit;
    private String intangibleBenefit;
    private String horizontalDeployment;
    private Integer productivity;
    private Integer quality;
    private Integer delivery;
    private Integer safety;
    private Integer cost;
    private Integer morale;
    private Integer createdBy;
    private String createdDate;
    private Integer updatedBy;
    private String updatedDate;
    private Integer status;
    private Integer reportingId;
    private Integer currentLevel;
    private Integer totalLevel;
    private String comment;

    public KaizenMaster() {
    }

    public KaizenMaster(String srNo, String teamName, String department, String teamLeader, String ideaGenerator, String teamMember, String startDate, String compiletionDate, String budgetRequirement, String problemDescription, String beforePhoto, String improvementDescription, String afterPhoto, String tangibleBenefit, String intangibleBenefit, String horizontalDeployment, Integer productivity, Integer quality, Integer delivery, Integer safety, Integer cost, Integer morale, Integer createdBy, String createdDate, Integer updatedBy, String updatedDate, Integer status, Integer reportingId, Integer currentLevel, Integer totalLevel, String comment) {
        this.srNo = srNo;
        this.teamName = teamName;
        this.department = department;
        this.teamLeader = teamLeader;
        this.ideaGenerator = ideaGenerator;
        this.teamMember = teamMember;
        this.startDate = startDate;
        this.compiletionDate = compiletionDate;
        this.budgetRequirement = budgetRequirement;
        this.problemDescription = problemDescription;
        this.beforePhoto = beforePhoto;
        this.improvementDescription = improvementDescription;
        this.afterPhoto = afterPhoto;
        this.tangibleBenefit = tangibleBenefit;
        this.intangibleBenefit = intangibleBenefit;
        this.horizontalDeployment = horizontalDeployment;
        this.productivity = productivity;
        this.quality = quality;
        this.delivery = delivery;
        this.safety = safety;
        this.cost = cost;
        this.morale = morale;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.updatedBy = updatedBy;
        this.updatedDate = updatedDate;
        this.status = status;
        this.reportingId = reportingId;
        this.currentLevel = currentLevel;
        this.totalLevel = totalLevel;
        this.comment = comment;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSrNo() {
        return this.srNo;
    }

    public void setSrNo(String srNo) {
        this.srNo = srNo;
    }

    public String getTeamName() {
        return this.teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTeamLeader() {
        return this.teamLeader;
    }

    public void setTeamLeader(String teamLeader) {
        this.teamLeader = teamLeader;
    }

    public String getIdeaGenerator() {
        return this.ideaGenerator;
    }

    public void setIdeaGenerator(String ideaGenerator) {
        this.ideaGenerator = ideaGenerator;
    }

    public String getTeamMember() {
        return this.teamMember;
    }

    public void setTeamMember(String teamMember) {
        this.teamMember = teamMember;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getCompiletionDate() {
        return this.compiletionDate;
    }

    public void setCompiletionDate(String compiletionDate) {
        this.compiletionDate = compiletionDate;
    }

    public String getBudgetRequirement() {
        return this.budgetRequirement;
    }

    public void setBudgetRequirement(String budgetRequirement) {
        this.budgetRequirement = budgetRequirement;
    }

    public String getProblemDescription() {
        return this.problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }

    public String getBeforePhoto() {
        return this.beforePhoto;
    }

    public void setBeforePhoto(String beforePhoto) {
        this.beforePhoto = beforePhoto;
    }

    public String getImprovementDescription() {
        return this.improvementDescription;
    }

    public void setImprovementDescription(String improvementDescription) {
        this.improvementDescription = improvementDescription;
    }

    public String getAfterPhoto() {
        return this.afterPhoto;
    }

    public void setAfterPhoto(String afterPhoto) {
        this.afterPhoto = afterPhoto;
    }

    public String getTangibleBenefit() {
        return this.tangibleBenefit;
    }

    public void setTangibleBenefit(String tangibleBenefit) {
        this.tangibleBenefit = tangibleBenefit;
    }

    public String getIntangibleBenefit() {
        return this.intangibleBenefit;
    }

    public void setIntangibleBenefit(String intangibleBenefit) {
        this.intangibleBenefit = intangibleBenefit;
    }

    public String getHorizontalDeployment() {
        return this.horizontalDeployment;
    }

    public void setHorizontalDeployment(String horizontalDeployment) {
        this.horizontalDeployment = horizontalDeployment;
    }

    public Integer getProductivity() {
        return this.productivity;
    }

    public void setProductivity(Integer productivity) {
        this.productivity = productivity;
    }

    public Integer getQuality() {
        return this.quality;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    public Integer getDelivery() {
        return this.delivery;
    }

    public void setDelivery(Integer delivery) {
        this.delivery = delivery;
    }

    public Integer getSafety() {
        return this.safety;
    }

    public void setSafety(Integer safety) {
        this.safety = safety;
    }

    public Integer getCost() {
        return this.cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getMorale() {
        return this.morale;
    }

    public void setMorale(Integer morale) {
        this.morale = morale;
    }

    public Integer getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getUpdatedBy() {
        return this.updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getUpdatedDate() {
        return this.updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getReportingId() {
        return reportingId;
    }

    public void setReportingId(Integer reportingId) {
        this.reportingId = reportingId;
    }

    public Integer getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(Integer currentLevel) {
        this.currentLevel = currentLevel;
    }

    public Integer getTotalLevel() {
        return totalLevel;
    }

    public void setTotalLevel(Integer totalLevel) {
        this.totalLevel = totalLevel;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
    
}
