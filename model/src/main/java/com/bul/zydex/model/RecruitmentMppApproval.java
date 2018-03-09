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
public class RecruitmentMppApproval implements java.io.Serializable {

    private Integer id;
    private RecruitmentMaster recruitmentMaster;
    private EmployeeMaster employeeMaster;
    private Integer level;
    private String comment;
    private Integer createdBy;
    private String createdDate;
    private Integer status;
    
    public RecruitmentMppApproval(){
        
    }

    public RecruitmentMppApproval(Integer id, RecruitmentMaster recruitmentMaster, EmployeeMaster employeeMaster, Integer level, String comment, Integer createdBy, String createdDate, Integer status) {
        this.id = id;
        this.recruitmentMaster = recruitmentMaster;
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

    public RecruitmentMaster getRecruitmentMaster() {
        return recruitmentMaster;
    }

    public void setRecruitmentMaster(RecruitmentMaster recruitmentMaster) {
        this.recruitmentMaster = recruitmentMaster;
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
