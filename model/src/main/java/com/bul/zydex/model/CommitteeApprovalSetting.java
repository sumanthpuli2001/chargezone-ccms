/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author Bulwark-4
 */
public class CommitteeApprovalSetting {
    
    private int id;
    private String approvalName;

    public CommitteeApprovalSetting() {
    }

    public CommitteeApprovalSetting(int id, String approvalName) {
        this.id = id;
        this.approvalName = approvalName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApprovalName() {
        return approvalName;
    }

    public void setApprovalName(String approvalName) {
        this.approvalName = approvalName;
    }
    
    
    
}
