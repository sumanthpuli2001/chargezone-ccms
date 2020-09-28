/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

import java.io.Serializable;

/**
 *
 * @author aman.bahukhandi
 */
public class LogsMaster implements Serializable {

    private Long srNoValue;
    private String lDate;
    private String time;
    private String userName;
    private String ip;
    private String action;
    private String drow;

    public LogsMaster() {
    }

    public LogsMaster(Long srNoValue, String lDate, String time, String userName, String ip, String action, String drow) {
        this.srNoValue = srNoValue;
        this.lDate = lDate;
        this.time = time;
        this.userName = userName;
        this.ip = ip;
        this.action = action;
        this.drow = drow;
    }

    public Long getSrNoValue() {
        return srNoValue;
    }

    public LogsMaster setSrNoValue(Long srNoValue) {
        this.srNoValue = srNoValue;
        return this;
    }

    public String getlDate() {
        return lDate;
    }

    public LogsMaster setlDate(String lDate) {
        this.lDate = lDate;
        return this;
    }

    public String getTime() {
        return time;
    }

    public LogsMaster setTime(String time) {
        this.time = time;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public LogsMaster setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getIp() {
        return ip;
    }

    public LogsMaster setIp(String ip) {
        this.ip = ip;
        return this;
    }

    public String getAction() {
        return action;
    }

    public LogsMaster setAction(String action) {
        this.action = action;
        return this;
    }

    public String getDrow() {
        return drow;
    }

    public LogsMaster setDrow(String drow) {
        this.drow = drow;
        return this;
    }

}
