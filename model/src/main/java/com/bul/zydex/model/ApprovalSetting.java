/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

import java.io.Serializable;

/**
 *
 * @author admin
 */
public class ApprovalSetting implements java.io.Serializable{
    
    private int id;
    private String approvalOne;
    private String approvalTwo;
    private String approvalThree;
    
    public ApprovalSetting() {
    }
    
    public ApprovalSetting(int id, String approvalOne, String approvalTwo, String approvalThree) {
        this.id = id;
        this.approvalOne = approvalOne;
        this.approvalTwo = approvalTwo;
        this.approvalThree = approvalThree;
    }

    public int getId() {
        return id;
    }

    public ApprovalSetting setId(int id) {
        this.id = id;
        return this;
    }

    public String getApprovalOne() {
        return approvalOne;
    }

    public ApprovalSetting setApprovalOne(String approvalOne) {
        this.approvalOne = approvalOne;
        return this;
    }

    public String getApprovalTwo() {
        return approvalTwo;
    }

    public ApprovalSetting setApprovalTwo(String approvalTwo) {
        this.approvalTwo = approvalTwo;
        return this;
    }
    
    public String getApprovalThree() {
        return approvalThree;
    }

    public ApprovalSetting setApprovalThree(String approvalThree) {
        this.approvalThree = approvalThree;
        return this;
    }
    
    
}
