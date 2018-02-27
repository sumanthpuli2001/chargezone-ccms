/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bul.zydex.model;

/**
 *
 * @author Rishi
 */
public class ThoughtMaster  implements java.io.Serializable {


     private Integer id;
     private String thought;
     private String date;
     private Integer createdBy;
     private String createdDate;
     private Integer updatedBy;
     private String updatedDate;

    public ThoughtMaster() {
    }

	
    public ThoughtMaster(String date) {
        this.date = date;
    }
    public ThoughtMaster(String thought, String date, Integer createdBy, String createdDate, Integer updatedBy, String updatedDate) {
       this.thought = thought;
       this.date = date;
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
    public String getThought() {
        return this.thought;
    }
    
    public void setThought(String thought) {
        this.thought = thought;
    }
    public String getDate() {
        return this.date;
    }
    
    public void setDate(String date) {
        this.date = date;
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

