/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author Vikas
 */
public class ApprovalUser implements java.io.Serializable {

    private Integer id;
    private ApprovalMaster approvalMaster;
    private EmployeeMaster employeeMaster;
    private Integer level;
    private Integer createdBy;
    private String createdDate;
    private Integer updatedBy;
    private String updatedDate;
    private Integer status;

    public ApprovalUser() {

    }

//    public ApprovalUser(Integer id, ApprovalMaster approvalMaster, Integer userId, Integer level, Integer createdBy, String createdDate, Integer updatedBy, String updatedDate, Integer status) {
//        this.id = id;
//        this.approvalMaster = approvalMaster;
//        this.userId = userId;
//        this.level = level;
//        this.createdBy = createdBy;
//        this.createdDate = createdDate;
//        this.updatedBy = updatedBy;
//        this.updatedDate = updatedDate;
//        this.status = status;
//    }

  

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ApprovalMaster getApprovalMaster() {
        return approvalMaster;
    }

    public void setApprovalMaster(ApprovalMaster approvalMaster) {
        this.approvalMaster = approvalMaster;
    }

    public EmployeeMaster getEmployeeMaster() {
        return employeeMaster;
    }

    public void setEmployeeMaster(EmployeeMaster employeeMaster) {
        this.employeeMaster = employeeMaster;
    }
   

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    
    

}
