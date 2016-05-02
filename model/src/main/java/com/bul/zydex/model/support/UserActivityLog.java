/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model.support;

/**
 *
 * @author Administrator
 */
public class UserActivityLog implements java.io.Serializable {

    private String userName;
    private String ipAddress;
    private String dateTimeFrom;
    private String dateTimeTo;
    private String actionType;

    public UserActivityLog() {
    }

    public UserActivityLog(String userName, String ipAddress,
            String dateTimeFrom, String dateTimeTo, String actionType) {
        this.userName = userName;
        this.ipAddress = ipAddress;
        this.dateTimeFrom = dateTimeFrom;
        this.dateTimeTo = dateTimeTo;
        this.actionType = actionType;
    }

    public String getActionType() {
        return actionType;
    }

    public String getDateTimeFrom() {
        return dateTimeFrom;
    }

    public String getDateTimeTo() {
        return dateTimeTo;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getUserName() {
        return userName;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public void setDateTimeFrom(String dateTimeFrom) {
        this.dateTimeFrom = dateTimeFrom;
    }

    public void setDateTimeTo(String dateTimeTo) {
        this.dateTimeTo = dateTimeTo;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
