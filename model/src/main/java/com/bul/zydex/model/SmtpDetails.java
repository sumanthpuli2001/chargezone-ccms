/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author Admin
 */
public class SmtpDetails {
     private int id;
    private String port;
    private String userName;
    private String userPassword;
    private String sslApply;
    private String ip;

    public SmtpDetails() {
    }

    public SmtpDetails(int id, String port, String userName, String userPassword, String sslApply, String ip) {
        this.id = id;
        this.port = port;
        this.userName = userName;
        this.userPassword = userPassword;
        this.sslApply = sslApply;
        this.ip = ip;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getSslApply() {
        return sslApply;
    }

    public void setSslApply(String sslApply) {
        this.sslApply = sslApply;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

  
   
}