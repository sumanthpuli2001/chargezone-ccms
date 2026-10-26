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
public class VendorTechnicalCriteria {

    private int id;
    private int groupMasterId;
    private int groupCategoryId;
    private int groupSubCategoryId;
    private String criteriaName;
    private String criteriaDescription;
    private String mandatory;
    private String compulsaryFlag;

    public VendorTechnicalCriteria() {
    }

    public VendorTechnicalCriteria(int id, int groupMasterId, int groupCategoryId, int groupSubCategoryId, String criteriaName, String criteriaDescription, String mandatory, String compulsaryFlag) {
        this.id = id;
        this.groupMasterId = groupMasterId;
        this.groupCategoryId = groupCategoryId;
        this.groupSubCategoryId = groupSubCategoryId;
        this.criteriaName = criteriaName;
        this.criteriaDescription = criteriaDescription;
        this.mandatory = mandatory;
        this.compulsaryFlag = compulsaryFlag;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGroupMasterId() {
        return groupMasterId;
    }

    public void setGroupMasterId(int groupMasterId) {
        this.groupMasterId = groupMasterId;
    }

    public int getGroupCategoryId() {
        return groupCategoryId;
    }

    public void setGroupCategoryId(int groupCategoryId) {
        this.groupCategoryId = groupCategoryId;
    }

    public int getGroupSubCategoryId() {
        return groupSubCategoryId;
    }

    public void setGroupSubCategoryId(int groupSubCategoryId) {
        this.groupSubCategoryId = groupSubCategoryId;
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
