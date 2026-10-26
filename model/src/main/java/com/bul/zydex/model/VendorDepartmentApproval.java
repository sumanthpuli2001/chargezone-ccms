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
public class VendorDepartmentApproval {
    private Integer id;
    private String departmentId;
    private String approvalName;

    public VendorDepartmentApproval() {
    }

    public VendorDepartmentApproval(Integer id, String departmentId, String approvalName) {
        this.id = id;
        this.departmentId = departmentId;
        this.approvalName = approvalName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getApprovalName() {
        return approvalName;
    }

    public void setApprovalName(String approvalName) {
        this.approvalName = approvalName;
    }
    
    
}
