/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author Vikas
 */
public class ApplayJobUserMaster implements java.io.Serializable {

    private Integer id;
    private String userName;
    private String password;
    private String createdDate;
    private Integer firstTime;
    private Integer profileSubmit;
    
    public ApplayJobUserMaster (){
        
    }

    public ApplayJobUserMaster(Integer id, String userName, String password, String createdDate, Integer firstTime) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.createdDate = createdDate;
        this.firstTime = firstTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getFirstTime() {
        return firstTime;
    }

    public void setFirstTime(Integer firstTime) {
        this.firstTime = firstTime;
    }

    public Integer getProfileSubmit() {
        return profileSubmit;
    }

    public void setProfileSubmit(Integer profileSubmit) {
        this.profileSubmit = profileSubmit;
    }
    

    
}
