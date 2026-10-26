/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author admin
 */
public class VendorHrCriteria {
    
    private int id;
    private String criteriaName;
    private String criteriaDescription;
    private String groupId;
     private String groupCategery;
    private String mandatory;
    private String compulsaryFlag;
    

    public VendorHrCriteria() {
    }

    public VendorHrCriteria(int id, String criteriaName, String criteriaDescription, String groupId, String groupCategery,String mandatory, String compulsaryFlag) {
        this.id = id;
        this.criteriaName = criteriaName;
        this.criteriaDescription = criteriaDescription;
        this.groupId = groupId;
        this.groupCategery = groupCategery;
        this.mandatory = mandatory;
        this.compulsaryFlag = compulsaryFlag;
    }

  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCriteriaName() {
        return criteriaName;
    }

    public void setCriteriaName(String criteriaName) {
        this.criteriaName = criteriaName;
    }

    public String getCriteriaDescription() {
        return criteriaDescription;
    }

    public void setCriteriaDescription(String criteriaDescription) {
        this.criteriaDescription = criteriaDescription;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupCategery() {
        return groupCategery;
    }

    public void setGroupCategery(String groupCategery) {
        this.groupCategery = groupCategery;
    }

    public String getMandatory() {
        return mandatory;
    }

    public void setMandatory(String mandatory) {
        this.mandatory = mandatory;
    }

    public String getCompulsaryFlag() {
        return compulsaryFlag;
    }

    public void setCompulsaryFlag(String compulsaryFlag) {
        this.compulsaryFlag = compulsaryFlag;
    }

    
  
    
}
