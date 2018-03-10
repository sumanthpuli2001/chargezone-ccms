/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;
// Generated Mar 7, 2018 12:10:09 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Aman
 */
public class Trainer implements java.io.Serializable{
    
    private Integer id;
    private String trainerName;
    private String userName;
    private String passwrod;
    private String emailId;
    private String status;
    private Integer createdBy;
    private String createdDate;
    private Integer updatedBy;
    private String updatedate;

    public Trainer(){
        
    }
    public Trainer(Integer id,String trainerName, String userName, String passwrod, String emailId, String status, Integer createdBy, String createdDate, Integer updatedBy, String updatedate) {
        this.id = id;
        this.trainerName = trainerName;
        this.userName = userName;
        this.passwrod = passwrod;
        this.emailId = emailId;
        this.status = status;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.updatedBy = updatedBy;
        this.updatedate = updatedate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswrod() {
        return passwrod;
    }

    public void setPasswrod(String passwrod) {
        this.passwrod = passwrod;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(String updatedate) {
        this.updatedate = updatedate;
    }
    
    
    
}
