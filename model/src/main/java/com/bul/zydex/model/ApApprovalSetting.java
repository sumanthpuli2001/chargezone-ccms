/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author admin
 */
public class ApApprovalSetting {
    
    private int id;
    private String approvalName;
    
    public ApApprovalSetting() {
    }
    
    public ApApprovalSetting(int id, String approvalName) {
        this.id = id;
        this.approvalName = approvalName;
        
    }

    public int getId() {
        return id;
    }

    public ApApprovalSetting setId(int id) {
        this.id = id;
        return this;
    }

    public String getApprovalName() {
        return approvalName;
    }

    public ApApprovalSetting setApprovalName(String approvalName) {
        this.approvalName = approvalName;
        return this;
    }
    
    
    
}
