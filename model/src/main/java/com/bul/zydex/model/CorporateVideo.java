package com.bul.zydex.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vinit
 */
public class CorporateVideo  implements java.io.Serializable {


     private Integer id;
     private String corporateVideoPath;
     private String disc;
     private Integer createdBy;
     private String createdDate;
     private Integer updatedBy;
     private String updatedDate;

    public CorporateVideo() {
    }

    public CorporateVideo(String corporateVideoPath, String disc, Integer createdBy, String createdDate, Integer updatedBy, String updatedDate) {
       this.corporateVideoPath = corporateVideoPath;
       this.disc = disc;
       this.createdBy = createdBy;
       this.createdDate = createdDate;
       this.updatedBy = updatedBy;
       this.updatedDate = updatedDate;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getCorporateVideoPath() {
        return this.corporateVideoPath;
    }
    
    public void setCorporateVideoPath(String corporateVideoPath) {
        this.corporateVideoPath = corporateVideoPath;
    }
    public String getDisc() {
        return this.disc;
    }
    
    public void setDisc(String disc) {
        this.disc = disc;
    }
    public Integer getCreatedBy() {
        return this.createdBy;
    }
    
    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }
    public String getCreatedDate() {
        return this.createdDate;
    }
    
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
    public Integer getUpdatedBy() {
        return this.updatedBy;
    }
    
    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }
    public String getUpdatedDate() {
        return this.updatedDate;
    }
    
    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }




}
