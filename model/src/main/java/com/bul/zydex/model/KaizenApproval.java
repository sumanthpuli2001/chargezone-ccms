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
public class KaizenApproval  implements java.io.Serializable {


     private int id;
     private EmployeeMaster employeeMaster;
     private KaizenMaster kaizenMaster;
     private Integer level;
     private String comment;
     private Integer createdBy;
     private String createdDate;
     private Integer status;

    public KaizenApproval() {
    }

	
    public KaizenApproval(int id, EmployeeMaster employeeMaster, KaizenMaster kaizenMaster) {
        this.id = id;
        this.employeeMaster = employeeMaster;
        this.kaizenMaster = kaizenMaster;
    }
    public KaizenApproval(int id, EmployeeMaster employeeMaster, KaizenMaster kaizenMaster, Integer level, String comment, Integer createdBy, String createdDate, Integer status) {
       this.id = id;
       this.employeeMaster = employeeMaster;
       this.kaizenMaster = kaizenMaster;
       this.level = level;
       this.comment = comment;
       this.createdBy = createdBy;
       this.createdDate = createdDate;
       this.status = status;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public EmployeeMaster getEmployeeMaster() {
        return this.employeeMaster;
    }
    
    public void setEmployeeMaster(EmployeeMaster employeeMaster) {
        this.employeeMaster = employeeMaster;
    }
    public KaizenMaster getKaizenMaster() {
        return this.kaizenMaster;
    }
    
    public void setKaizenMaster(KaizenMaster kaizenMaster) {
        this.kaizenMaster = kaizenMaster;
    }
    public Integer getLevel() {
        return this.level;
    }
    
    public void setLevel(Integer level) {
        this.level = level;
    }
    public String getComment() {
        return this.comment;
    }
    
    public void setComment(String comment) {
        this.comment = comment;
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
    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }




}