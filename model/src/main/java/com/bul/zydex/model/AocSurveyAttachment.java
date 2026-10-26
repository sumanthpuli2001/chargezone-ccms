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
public class AocSurveyAttachment {
    
    private int id;
    private int aocId;
    private String surveyNo;
    private String projectRepresentative;

    public AocSurveyAttachment() {
    }

    public AocSurveyAttachment(int id, int aocId, String surveyNo, String projectRepresentative) {
        this.id = id;
        this.aocId = aocId;
        this.surveyNo = surveyNo;
        this.projectRepresentative = projectRepresentative;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAocId() {
        return aocId;
    }

    public void setAocId(int aocId) {
        this.aocId = aocId;
    }

    public String getSurveyNo() {
        return surveyNo;
    }

    public void setSurveyNo(String surveyNo) {
        this.surveyNo = surveyNo;
    }

    public String getProjectRepresentative() {
        return projectRepresentative;
    }

    public void setProjectRepresentative(String projectRepresentative) {
        this.projectRepresentative = projectRepresentative;
    }
    
    
    
}
