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
public class OapSurveyAttachment {

    private int id;
    private int oapId;
    private String surveyNo;
    private String projectRepresentative;

    public OapSurveyAttachment() {
    }

    public OapSurveyAttachment(int id, int oapId, String surveyNo, String projectRepresentative) {
        this.id = id;
        this.oapId = oapId;
        this.surveyNo = surveyNo;
        this.projectRepresentative = projectRepresentative;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOapId() {
        return oapId;
    }

    public void setOapId(int oapId) {
        this.oapId = oapId;
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
