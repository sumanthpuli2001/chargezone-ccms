/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author Administrator
 */
public class AuditorMaster {

    private int id;
    private String auditorCode;
    private String auditorName;
    private String auditorAddress;
    private String auditorEmail;
    private String auditorMobileNo;
    private String auditorStatus;
    private String auditorRemark;
    private String auditorRole;

    public AuditorMaster() {
    }

    public AuditorMaster(int id, String auditorCode, String auditorName, String auditorAddress, String auditorEmail, String auditorMobileNo, String auditorStatus, String auditorRemark, String auditorRole) {
        this.id = id;
        this.auditorCode = auditorCode;
        this.auditorName = auditorName;
        this.auditorAddress = auditorAddress;
        this.auditorEmail = auditorEmail;
        this.auditorMobileNo = auditorMobileNo;
        this.auditorStatus = auditorStatus;
        this.auditorRemark = auditorRemark;
        this.auditorRole = auditorRole;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuditorCode() {
        return auditorCode;
    }

    public void setAuditorCode(String auditorCode) {
        this.auditorCode = auditorCode;
    }

    public String getAuditorName() {
        return auditorName;
    }

    public void setAuditorName(String auditorName) {
        this.auditorName = auditorName;
    }

    public String getAuditorAddress() {
        return auditorAddress;
    }

    public void setAuditorAddress(String auditorAddress) {
        this.auditorAddress = auditorAddress;
    }

    public String getAuditorEmail() {
        return auditorEmail;
    }

    public void setAuditorEmail(String auditorEmail) {
        this.auditorEmail = auditorEmail;
    }

    public String getAuditorMobileNo() {
        return auditorMobileNo;
    }

    public void setAuditorMobileNo(String auditorMobileNo) {
        this.auditorMobileNo = auditorMobileNo;
    }

    public String getAuditorStatus() {
        return auditorStatus;
    }

    public void setAuditorStatus(String auditorStatus) {
        this.auditorStatus = auditorStatus;
    }

    public String getAuditorRemark() {
        return auditorRemark;
    }

    public void setAuditorRemark(String auditorRemark) {
        this.auditorRemark = auditorRemark;
    }

    public String getAuditorRole() {
        return auditorRole;
    }

    public void setAuditorRole(String auditorRole) {
        this.auditorRole = auditorRole;
    }

}
