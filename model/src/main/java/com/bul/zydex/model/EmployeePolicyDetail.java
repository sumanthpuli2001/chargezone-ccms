/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

import java.util.Set;

/**
 *
 * @author OptiPlex
 */
public class EmployeePolicyDetail implements java.io.Serializable {

    private Integer id;
    private EmployeeMaster employeeMaster;
    private PolicyMaster policyMaster;
    private Double amount;
    private String policyNum;

    public EmployeePolicyDetail() {
    }

    public EmployeePolicyDetail(EmployeeMaster employeeMaster, PolicyMaster policyMaster, Double amount ,String policyNum) {
        this.employeeMaster = employeeMaster;
        this.policyMaster = policyMaster;
        this.amount = amount;
        this.policyNum = policyNum;
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

    public PolicyMaster getPolicyMaster() {
        return this.policyMaster;
    }

    public void setPolicyMaster(PolicyMaster policyMaster) {
        this.policyMaster = policyMaster;
    }

    public Double getAmount() {
        return this.amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getPolicyNum() {
        return policyNum;
    }

    public void setPolicyNum(String policyNum) {
        this.policyNum = policyNum;
    }
    

}
