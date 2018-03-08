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
public class MprApproval implements java.io.Serializable{
    
    private Integer id;
    private MprMaster mprMaster;
    private EmployeeMaster employeeMaster;
    private Integer level;
    private String comment;
    private Integer createdBy;
    private String createdDate;
    private Integer status;
    
    public MprApproval(){
        
    }

    public MprApproval(Integer id, MprMaster mprMaster, EmployeeMaster employeeMaster, Integer level, String comment, Integer createdBy, String createdDate, Integer status) {
        this.id = id;
        this.mprMaster = mprMaster;
        this.employeeMaster = employeeMaster;
        this.level = level;
        this.comment = comment;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MprMaster getMprMaster() {
        return mprMaster;
    }

    public void setMprMaster(MprMaster mprMaster) {
        this.mprMaster = mprMaster;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    
    
    
}
