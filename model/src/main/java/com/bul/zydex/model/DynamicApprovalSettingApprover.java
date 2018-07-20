/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author Admin
 */
public class DynamicApprovalSettingApprover implements java.io.Serializable {

    private Integer id;
    private EmployeeMaster employeeMaster;
    private DynamicApprovalSetting dynamicApprovalSettingId;
    private String approverName;

    public DynamicApprovalSettingApprover() {
    }

    public DynamicApprovalSettingApprover(EmployeeMaster employeeMaster, DynamicApprovalSetting dynamicApprovalSettingId) {
        this.employeeMaster = employeeMaster;
        this.dynamicApprovalSettingId = dynamicApprovalSettingId;
    }

    public DynamicApprovalSettingApprover(String approverName) {
        this.approverName = approverName;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EmployeeMaster getEmployeeMaster() {
        return this.employeeMaster;
    }

    public void setEmployeeMaster(EmployeeMaster employeeMaster) {
        this.employeeMaster = employeeMaster;
    }

    public String getApproverName() {
        return approverName;
    }

    public void setApproverName(String approverName) {
        this.approverName = approverName;
    }

    public DynamicApprovalSetting getDynamicApprovalSettingId() {
        return dynamicApprovalSettingId;
    }

    public void setDynamicApprovalSettingId(DynamicApprovalSetting dynamicApprovalSettingId) {
        this.dynamicApprovalSettingId = dynamicApprovalSettingId;
    }
    
    

}

