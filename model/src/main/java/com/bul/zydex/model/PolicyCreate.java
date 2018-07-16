/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author Rishi
 */
public class PolicyCreate implements java.io.Serializable {

    private Integer id;
    private String name;
    private PolicyDropDown policyDropDown;
    private String attachment;
    private Integer status;
    private String createdDate;
    private String createdBy;
    private String updatedDate;
    private String updatedBy;
    private Integer acceptPolicy;
    private String readDate;
    private String readBy;
    private String acceptPolicyTime;

    public PolicyCreate() {

    }

    public PolicyCreate(Integer id, String name, PolicyDropDown policyDropDown, String attachment, Integer status, String createdDate, String createdBy, String updatedDate, String updatedBy, Integer acceptPolicy, String readDate, String readBy, String acceptPolicyTime) {
        this.id = id;
        this.name = name;
        this.policyDropDown = policyDropDown;
        this.attachment = attachment;
        this.status = status;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.updatedDate = updatedDate;
        this.updatedBy = updatedBy;
        this.acceptPolicy = acceptPolicy;
        this.readDate = readDate;
        this.readBy = readBy;
        this.acceptPolicyTime = acceptPolicyTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PolicyDropDown getPolicyDropDown() {
        return policyDropDown;
    }

    public void setPolicyDropDown(PolicyDropDown policyDropDown) {
        this.policyDropDown = policyDropDown;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Integer getAcceptPolicy() {
        return acceptPolicy;
    }

    public void setAcceptPolicy(Integer acceptPolicy) {
        this.acceptPolicy = acceptPolicy;
    }

    public String getReadDate() {
        return readDate;
    }

    public void setReadDate(String readDate) {
        this.readDate = readDate;
    }

    public String getReadBy() {
        return readBy;
    }

    public void setReadBy(String readBy) {
        this.readBy = readBy;
    }

    public String getAcceptPolicyTime() {
        return acceptPolicyTime;
    }

    public void setAcceptPolicyTime(String acceptPolicyTime) {
        this.acceptPolicyTime = acceptPolicyTime;
    }

    
}
