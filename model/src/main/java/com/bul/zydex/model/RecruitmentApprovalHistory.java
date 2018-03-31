/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author Rishi
 */
public class RecruitmentApprovalHistory implements java.io.Serializable {

    private Integer id;
    private String approvalUserName;
    private Integer approvalUserId;
    private String comment;
    private Integer status;
    private String statusMessage;
    private String createDate;
    private Integer createdBy;
    
    public RecruitmentApprovalHistory(){
        
    }

    public RecruitmentApprovalHistory(Integer id, String approvalUserName, Integer approvalUserId, String comment, Integer status, String statusMessage, String createDate, Integer createdBy) {
        this.id = id;
        this.approvalUserName = approvalUserName;
        this.approvalUserId = approvalUserId;
        this.comment = comment;
        this.status = status;
        this.statusMessage = statusMessage;
        this.createDate = createDate;
        this.createdBy = createdBy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApprovalUserName() {
        return approvalUserName;
    }

    public void setApprovalUserName(String approvalUserName) {
        this.approvalUserName = approvalUserName;
    }

    public Integer getApprovalUserId() {
        return approvalUserId;
    }

    public void setApprovalUserId(Integer approvalUserId) {
        this.approvalUserId = approvalUserId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }
    
    

}
