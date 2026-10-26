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
public class VendorApprovalSetting {
    private Integer id;
    private String approvalName;

    public VendorApprovalSetting() {
    }

    public VendorApprovalSetting(Integer id, String approvalName) {
        this.id = id;
        this.approvalName = approvalName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApprovalName() {
        return approvalName;
    }

    public void setApprovalName(String approvalName) {
        this.approvalName = approvalName;
    }
    
    
}
