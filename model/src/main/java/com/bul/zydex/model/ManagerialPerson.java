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
public class ManagerialPerson {

    private int id;
    private int vendorInvitationId;
    private String name;
    private String designation;
    private String phoneNo;
    private String emailId;
    private String countryCode;

    public ManagerialPerson() {
    }

    public ManagerialPerson(int id, int vendorInvitationId, String name, String designation, String phoneNo, String emailId, String countryCode) {
        this.id = id;
        this.vendorInvitationId = vendorInvitationId;
        this.name = name;
        this.designation = designation;
        this.phoneNo = phoneNo;
        this.emailId = emailId;
        this.countryCode = countryCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVendorInvitationId() {
        return vendorInvitationId;
    }

    public void setVendorInvitationId(int vendorInvitationId) {
        this.vendorInvitationId = vendorInvitationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

}
