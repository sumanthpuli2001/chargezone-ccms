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
public class AocSurveyAttachmentHistory {
    
    private int id;
    private int aocId;
    private String surveyNo;
    private String history;
    private String dateTime;
    private int aocSurveyAttachmentId;
    private int aocFormHistoryId;

    public AocSurveyAttachmentHistory() {
    }

    public AocSurveyAttachmentHistory(int id, int aocId, String surveyNo, String history, String dateTime, int aocSurveyAttachmentId, int aocFormHistoryId) {
        this.id = id;
        this.aocId = aocId;
        this.surveyNo = surveyNo;
        this.history = history;
        this.dateTime = dateTime;
        this.aocSurveyAttachmentId = aocSurveyAttachmentId;
        this.aocFormHistoryId = aocFormHistoryId;
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

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public int getAocSurveyAttachmentId() {
        return aocSurveyAttachmentId;
    }

    public void setAocSurveyAttachmentId(int aocSurveyAttachmentId) {
        this.aocSurveyAttachmentId = aocSurveyAttachmentId;
    }

    public int getAocFormHistoryId() {
        return aocFormHistoryId;
    }

    public void setAocFormHistoryId(int aocFormHistoryId) {
        this.aocFormHistoryId = aocFormHistoryId;
    }

   
    
}
