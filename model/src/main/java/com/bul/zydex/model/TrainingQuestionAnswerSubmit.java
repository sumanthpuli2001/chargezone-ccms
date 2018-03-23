/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author Aman
 */
public class TrainingQuestionAnswerSubmit  implements java.io.Serializable {


     private Integer id;
     private QuestionAns questionAns;
     private QuestionLibrary questionLibrary;
     private TrainingAssessment trainingAssessment;
     private String description;
     private Integer ansStatus;
     private Double obtainMarks;

    public TrainingQuestionAnswerSubmit() {
    }

    public TrainingQuestionAnswerSubmit(QuestionAns questionAns, QuestionLibrary questionLibrary, TrainingAssessment trainingAssessment, String description, Integer ansStatus, Double obtainMarks) {
       this.questionAns = questionAns;
       this.questionLibrary = questionLibrary;
       this.trainingAssessment = trainingAssessment;
       this.description = description;
       this.ansStatus = ansStatus;
       this.obtainMarks = obtainMarks;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public QuestionAns getQuestionAns() {
        return this.questionAns;
    }
    
    public void setQuestionAns(QuestionAns questionAns) {
        this.questionAns = questionAns;
    }
    public QuestionLibrary getQuestionLibrary() {
        return this.questionLibrary;
    }
    
    public void setQuestionLibrary(QuestionLibrary questionLibrary) {
        this.questionLibrary = questionLibrary;
    }
    public TrainingAssessment getTrainingAssessment() {
        return this.trainingAssessment;
    }
    
    public void setTrainingAssessment(TrainingAssessment trainingAssessment) {
        this.trainingAssessment = trainingAssessment;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getAnsStatus() {
        return this.ansStatus;
    }
    
    public void setAnsStatus(Integer ansStatus) {
        this.ansStatus = ansStatus;
    }
    public Double getObtainMarks() {
        return this.obtainMarks;
    }
    
    public void setObtainMarks(Double obtainMarks) {
        this.obtainMarks = obtainMarks;
    }




}
