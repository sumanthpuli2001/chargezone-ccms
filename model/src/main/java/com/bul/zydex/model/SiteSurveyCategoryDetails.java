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
public class SiteSurveyCategoryDetails {
    private int id;
    private int surveyMasterId;
    private String subCategory;
    private String categoryName;
    private String discription;
    private String remarks;
    private String guidelines;

    public SiteSurveyCategoryDetails() {
    }

    public SiteSurveyCategoryDetails(int id, int surveyMasterId, String subCategory, String categoryName, String discription, String remarks, String guidelines) {
        this.id = id;
        this.surveyMasterId = surveyMasterId;
        this.subCategory = subCategory;
        this.categoryName = categoryName;
        this.discription = discription;
        this.remarks = remarks;
        this.guidelines = guidelines;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSurveyMasterId() {
        return surveyMasterId;
    }

    public void setSurveyMasterId(int surveyMasterId) {
        this.surveyMasterId = surveyMasterId;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getGuidelines() {
        return guidelines;
    }

    public void setGuidelines(String guidelines) {
        this.guidelines = guidelines;
    }

  
    
    
}
