/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bul.zydex.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author admin
 */
public class PaymentTypeMaster {
   
     private Integer id;
     private Integer typeOfPayment;

     private String partyCode;
     private String nameOfParty;
     private String gstNo;
     private String panNo;
     private String emailId;
     private String phoneNo;
     private String mobileNo;
     private String address;
     private int location;
     private String paymentAmount;
     private String additionalRemarks;
     private Integer paymentMode;

     private String status;

     
     public PaymentTypeMaster() {
         
     }
     
    public PaymentTypeMaster(Integer id, Integer typeOfPayment, String partyCode, String nameOfParty, String gstNo, String panNo, String emailId, String phoneNo, String mobileNo, String address, int location, String paymentAmount, String additionalRemarks, Integer paymentMode, String status) {
        this.id = id;
        this.typeOfPayment = typeOfPayment;
        this.partyCode = partyCode;
        this.nameOfParty = nameOfParty;
        this.gstNo = gstNo;
        this.panNo = panNo;
        this.emailId = emailId;
        this.phoneNo = phoneNo;
        this.mobileNo = mobileNo;
        this.address = address;
        this.location = location;
        this.paymentAmount = paymentAmount;
        this.additionalRemarks = additionalRemarks;
        this.paymentMode = paymentMode;
        this.status = status;
    }
    
    
    public Integer getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(Integer paymentMode) {
        this.paymentMode = paymentMode;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTypeOfPayment() {
        return typeOfPayment;
    }

    public void setTypeOfPayment(Integer typeOfPayment) {
        this.typeOfPayment = typeOfPayment;
    }
    
    public String getPartyCode() {
        return partyCode;
    }

    public void setPartyCode(String partyCode) {
        this.partyCode = partyCode;
    }

    public String getNameOfParty() {
        return nameOfParty;
    }

    public void setNameOfParty(String nameOfParty) {
        this.nameOfParty = nameOfParty;
    }

    public String getGstNo() {
        return gstNo;
    }

    public void setGstNo(String gstNo) {
        this.gstNo = gstNo;
    }

    public String getPanNo() {
        return panNo;
    }

    public void setPanNo(String panNo) {
        this.panNo = panNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public String getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(String paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getAdditionalRemarks() {
        return additionalRemarks;
    }

    public void setAdditionalRemarks(String additionalRemarks) {
        this.additionalRemarks = additionalRemarks;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
