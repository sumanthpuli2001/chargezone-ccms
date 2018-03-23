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
public class TrainingResultStatus  implements java.io.Serializable {


     private Integer id;
     private TrainingAssessment trainingAssessment;
     private Double obtainPercentage;
     private Double obtainTotal;
     private String resultStatus;

    public TrainingResultStatus() {
    }

	
    public TrainingResultStatus(TrainingAssessment trainingAssessment) {
        this.trainingAssessment = trainingAssessment;
    }
    public TrainingResultStatus(TrainingAssessment trainingAssessment, Double obtainPercentage, Double obtainTotal, String resultStatus) {
       this.trainingAssessment = trainingAssessment;
       this.obtainPercentage = obtainPercentage;
       this.obtainTotal = obtainTotal;
       this.resultStatus = resultStatus;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public TrainingAssessment getTrainingAssessment() {
        return this.trainingAssessment;
    }
    
    public void setTrainingAssessment(TrainingAssessment trainingAssessment) {
        this.trainingAssessment = trainingAssessment;
    }
    public Double getObtainPercentage() {
        return this.obtainPercentage;
    }
    
    public void setObtainPercentage(Double obtainPercentage) {
        this.obtainPercentage = obtainPercentage;
    }
    public Double getObtainTotal() {
        return this.obtainTotal;
    }
    
    public void setObtainTotal(Double obtainTotal) {
        this.obtainTotal = obtainTotal;
    }
    public String getResultStatus() {
        return this.resultStatus;
    }
    
    public void setResultStatus(String resultStatus) {
        this.resultStatus = resultStatus;
    }




}