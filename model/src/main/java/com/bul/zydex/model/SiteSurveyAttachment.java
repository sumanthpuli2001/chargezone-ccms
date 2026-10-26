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
public class SiteSurveyAttachment {
    
    
    private int id;
    private int siteSurveyId;
    private String attachment;
    private String description;

    public SiteSurveyAttachment() {
    }

    public SiteSurveyAttachment(int id, int siteSurveyId, String attachment, String description) {
        this.id = id;
        this.siteSurveyId = siteSurveyId;
        this.attachment = attachment;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSiteSurveyId() {
        return siteSurveyId;
    }

    public void setSiteSurveyId(int siteSurveyId) {
        this.siteSurveyId = siteSurveyId;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
}
