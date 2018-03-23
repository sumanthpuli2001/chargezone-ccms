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
public class TrainingAssessment  implements java.io.Serializable {


     private Integer id;
     private EmployeeMaster employeeMaster;
     private QuestionPaper questionPaper;
     private TrainingMaster trainingMaster;
     private Integer status;
     private Double passingPercentage;
     private String validityFrom;
     private String validityTo;
     private String duration;
     private Integer noOfAttampt;
     private Integer noOfQue;
     private Double totalMarks;
     private Integer createdBy;
     private String createdDate;
     private Integer updatedBy;
     private String udatedDate;
     private String StartTimeNow;

    public TrainingAssessment() {
    }

	
    public TrainingAssessment(EmployeeMaster employeeMaster, QuestionPaper questionPaper, TrainingMaster trainingMaster) {
        this.employeeMaster = employeeMaster;
        this.questionPaper = questionPaper;
        this.trainingMaster = trainingMaster;
    }
    public TrainingAssessment(EmployeeMaster employeeMaster, QuestionPaper questionPaper, TrainingMaster trainingMaster, Integer status, Double passingPercentage, String validityFrom, String validityTo, String duration, Integer noOfAttampt, Integer noOfQue, Double totalMarks, Integer createdBy, String createdDate, Integer updatedBy, String udatedDate,String StartTimeNow) {
       this.employeeMaster = employeeMaster;
       this.questionPaper = questionPaper;
       this.trainingMaster = trainingMaster;
       this.status = status;
       this.passingPercentage = passingPercentage;
       this.validityFrom = validityFrom;
       this.validityTo = validityTo;
       this.duration = duration;
       this.noOfAttampt = noOfAttampt;
       this.noOfQue = noOfQue;
       this.totalMarks = totalMarks;
       this.createdBy = createdBy;
       this.createdDate = createdDate;
       this.updatedBy = updatedBy;
       this.udatedDate = udatedDate;
       this.StartTimeNow = StartTimeNow;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public EmployeeMaster getEmployeeMaster() {
        return this.employeeMaster;
    }
    
    public void setEmployeeMaster(EmployeeMaster employeeMaster) {
        this.employeeMaster = employeeMaster;
    }
    public QuestionPaper getQuestionPaper() {
        return this.questionPaper;
    }
    
    public void setQuestionPaper(QuestionPaper questionPaper) {
        this.questionPaper = questionPaper;
    }
    public TrainingMaster getTrainingMaster() {
        return this.trainingMaster;
    }
    
    public void setTrainingMaster(TrainingMaster trainingMaster) {
        this.trainingMaster = trainingMaster;
    }
    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }
    public Double getPassingPercentage() {
        return this.passingPercentage;
    }
    
    public void setPassingPercentage(Double passingPercentage) {
        this.passingPercentage = passingPercentage;
    }
    public String getValidityFrom() {
        return this.validityFrom;
    }
    
    public void setValidityFrom(String validityFrom) {
        this.validityFrom = validityFrom;
    }
    public String getValidityTo() {
        return this.validityTo;
    }
    
    public void setValidityTo(String validityTo) {
        this.validityTo = validityTo;
    }
    public String getDuration() {
        return this.duration;
    }
    
    public void setDuration(String duration) {
        this.duration = duration;
    }
    public Integer getNoOfAttampt() {
        return this.noOfAttampt;
    }
    
    public void setNoOfAttampt(Integer noOfAttampt) {
        this.noOfAttampt = noOfAttampt;
    }
    public Integer getNoOfQue() {
        return this.noOfQue;
    }
    
    public void setNoOfQue(Integer noOfQue) {
        this.noOfQue = noOfQue;
    }
    public Double getTotalMarks() {
        return this.totalMarks;
    }
    
    public void setTotalMarks(Double totalMarks) {
        this.totalMarks = totalMarks;
    }
    public Integer getCreatedBy() {
        return this.createdBy;
    }
    
    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }
    public String getCreatedDate() {
        return this.createdDate;
    }
    
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
    public Integer getUpdatedBy() {
        return this.updatedBy;
    }
    
    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }
    public String getUdatedDate() {
        return this.udatedDate;
    }
    
    public void setUdatedDate(String udatedDate) {
        this.udatedDate = udatedDate;
    }

    public String getStartTimeNow() {
        return StartTimeNow;
    }

    public void setStartTimeNow(String StartTimeNow) {
        this.StartTimeNow = StartTimeNow;
    }




}