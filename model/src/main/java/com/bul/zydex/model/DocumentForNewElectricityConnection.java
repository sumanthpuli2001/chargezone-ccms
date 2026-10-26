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
public class DocumentForNewElectricityConnection {

    private int id;
    private String pointToBeNoted;
    private String description;
    private String remarks;
    private String guidelines;
    private int surveyMasterId;

    public DocumentForNewElectricityConnection() {
    }

    public DocumentForNewElectricityConnection(int id, String pointToBeNoted, String description, String remarks, String guidelines, int surveyMasterId) {
        this.id = id;
        this.pointToBeNoted = pointToBeNoted;
        this.description = description;
        this.remarks = remarks;
        this.guidelines = guidelines;
        this.surveyMasterId = surveyMasterId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPointToBeNoted() {
        return pointToBeNoted;
    }

    public void setPointToBeNoted(String pointToBeNoted) {
        this.pointToBeNoted = pointToBeNoted;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public int getSurveyMasterId() {
        return surveyMasterId;
    }

    public void setSurveyMasterId(int surveyMasterId) {
        this.surveyMasterId = surveyMasterId;
    }

   
}
