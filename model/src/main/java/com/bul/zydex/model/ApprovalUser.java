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
public class ApprovalUser implements java.io.Serializable{
    
    private Integer id;
    private ApprovalMaster approvalMaster;
    private Integer userId;
    
    public  ApprovalUser(){
        
    }

    public ApprovalUser(Integer id, ApprovalMaster approvalMaster, Integer userId) {
        this.id = id;
        this.approvalMaster = approvalMaster;
        this.userId = userId;
    }

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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    
    
}
