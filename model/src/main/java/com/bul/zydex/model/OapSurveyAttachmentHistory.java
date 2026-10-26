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
public class OapSurveyAttachmentHistory {

    private int id;
    private int oapId;
    private String surveyNo;
    private String history;
    private String dateTime;
    private int oapSurveyAttachmentId;
     private int oapFormHistoryId;

    public OapSurveyAttachmentHistory() {
    }

    public OapSurveyAttachmentHistory(int id, int oapId, String surveyNo, String history, String dateTime, int oapSurveyAttachmentId, int oapFormHistoryId) {
        this.id = id;
        this.oapId = oapId;
        this.surveyNo = surveyNo;
        this.history = history;
        this.dateTime = dateTime;
        this.oapSurveyAttachmentId = oapSurveyAttachmentId;
        this.oapFormHistoryId = oapFormHistoryId;
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

    public int getOapSurveyAttachmentId() {
        return oapSurveyAttachmentId;
    }

    public void setOapSurveyAttachmentId(int oapSurveyAttachmentId) {
        this.oapSurveyAttachmentId = oapSurveyAttachmentId;
    }

    public int getOapFormHistoryId() {
        return oapFormHistoryId;
    }

    public void setOapFormHistoryId(int oapFormHistoryId) {
        this.oapFormHistoryId = oapFormHistoryId;
    }

   
}
