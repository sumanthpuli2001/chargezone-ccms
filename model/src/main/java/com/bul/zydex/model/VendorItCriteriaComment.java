/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author bulwarks-2
 */
public class VendorItCriteriaComment {

    private int id;
    private int vendorCriteriaMasterId;
    private String criteriaName;
    private String criteriaDescription;
    private String comment;
    private String attachement;
    private String vendorInformationId;
    private Integer accept;
    private String remark;
    private String score;
    private String itComment;
    private String compulsaryFlag;

    public VendorItCriteriaComment() {
    }

    public VendorItCriteriaComment(int id, int vendorCriteriaMasterId, String criteriaName, String criteriaDescription, String comment, String attachement, String vendorInformationId, Integer accept, String remark, String score, String itComment, String compulsaryFlag) {
        this.id = id;
        this.vendorCriteriaMasterId = vendorCriteriaMasterId;
        this.criteriaName = criteriaName;
        this.criteriaDescription = criteriaDescription;
        this.comment = comment;
        this.attachement = attachement;
        this.vendorInformationId = vendorInformationId;
        this.accept = accept;
        this.remark = remark;
        this.score = score;
        this.itComment = itComment;
        this.compulsaryFlag = compulsaryFlag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVendorCriteriaMasterId() {
        return vendorCriteriaMasterId;
    }

    public void setVendorCriteriaMasterId(int vendorCriteriaMasterId) {
        this.vendorCriteriaMasterId = vendorCriteriaMasterId;
    }

    public String getCriteriaName() {
        return criteriaName;
    }

    public void setCriteriaName(String criteriaName) {
        this.criteriaName = criteriaName;
    }

    public String getCriteriaDescription() {
        return criteriaDescription;
    }

    public void setCriteriaDescription(String criteriaDescription) {
        this.criteriaDescription = criteriaDescription;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAttachement() {
        return attachement;
    }

    public void setAttachement(String attachement) {
        this.attachement = attachement;
    }

    public String getVendorInformationId() {
        return vendorInformationId;
    }

    public void setVendorInformationId(String vendorInformationId) {
        this.vendorInformationId = vendorInformationId;
    }

    public Integer getAccept() {
        return accept;
    }

    public void setAccept(Integer accept) {
        this.accept = accept;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getItComment() {
        return itComment;
    }

    public void setItComment(String itComment) {
        this.itComment = itComment;
    }

    public String getCompulsaryFlag() {
        return compulsaryFlag;
    }

    public void setCompulsaryFlag(String compulsaryFlag) {
        this.compulsaryFlag = compulsaryFlag;
    }

}
