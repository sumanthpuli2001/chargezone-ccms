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
public class VendorBlockList {

    private int id;
    private int vendorInfoId;
    private String comments;
    private String attchment;
    private String userName;
    private String dateTime;
    private int flagStatus;

    public VendorBlockList() {
    }

    public VendorBlockList(int id, int vendorInfoId, String comments, String attchment, String userName, String dateTime, int flagStatus) {
        this.id = id;
        this.vendorInfoId = vendorInfoId;
        this.comments = comments;
        this.attchment = attchment;
        this.userName = userName;
        this.dateTime = dateTime;
        this.flagStatus = flagStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVendorInfoId() {
        return vendorInfoId;
    }

    public void setVendorInfoId(int vendorInfoId) {
        this.vendorInfoId = vendorInfoId;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getAttchment() {
        return attchment;
    }

    public void setAttchment(String attchment) {
        this.attchment = attchment;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public int getFlagStatus() {
        return flagStatus;
    }

    public void setFlagStatus(int flagStatus) {
        this.flagStatus = flagStatus;
    }

}
