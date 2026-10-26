/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author Sumanth
 */
public class LastWorkExpDeatils {

    private int id;
    private int vendorInformationId;
    private String companyName;
    private String contactPersonName;
    private String designation;
    private String mobileNumber;
    private String email;
    private String attchment;
    private String countryCode;

    private String statuss;
    private String remarkk;
    private String response;

    public LastWorkExpDeatils() {
    }

    public LastWorkExpDeatils(int id, int vendorInformationId, String companyName, String contactPersonName, String designation, String mobileNumber, String email, String attchment, String countryCode, String statuss, String remarkk, String response) {
        this.id = id;
        this.vendorInformationId = vendorInformationId;
        this.companyName = companyName;
        this.contactPersonName = contactPersonName;
        this.designation = designation;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.attchment = attchment;
        this.countryCode = countryCode;
        this.statuss = statuss;
        this.remarkk = remarkk;
        this.response = response;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVendorInformationId() {
        return vendorInformationId;
    }

    public void setVendorInformationId(int vendorInformationId) {
        this.vendorInformationId = vendorInformationId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactPersonName() {
        return contactPersonName;
    }

    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAttchment() {
        return attchment;
    }

    public void setAttchment(String attchment) {
        this.attchment = attchment;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getStatuss() {
        return statuss;
    }

    public void setStatuss(String statuss) {
        this.statuss = statuss;
    }

    public String getRemarkk() {
        return remarkk;
    }

    public void setRemarkk(String remarkk) {
        this.remarkk = remarkk;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

}
