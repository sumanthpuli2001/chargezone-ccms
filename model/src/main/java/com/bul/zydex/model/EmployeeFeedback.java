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
public class EmployeeFeedback {

    private Integer id;
    private EmployeeMaster employeeMaster;
    private TrainingFeedback trainingFeedback;
    private TrainingMaster trainingMaster;
    private String description;
    private String dateTime;

    public EmployeeFeedback() {
    }

    public EmployeeFeedback(EmployeeMaster employeeMaster, TrainingFeedback trainingFeedback, TrainingMaster trainingMaster) {
        this.employeeMaster = employeeMaster;
        this.trainingFeedback = trainingFeedback;
        this.trainingMaster = trainingMaster;
    }

    public EmployeeFeedback(Integer id, EmployeeMaster employeeMaster, TrainingFeedback trainingFeedback, TrainingMaster trainingMaster, String description, String dateTime) {
        this.id = id;
        this.employeeMaster = employeeMaster;
        this.trainingFeedback = trainingFeedback;
        this.trainingMaster = trainingMaster;
        this.description = description;
        this.dateTime = dateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EmployeeMaster getEmployeeMaster() {
        return employeeMaster;
    }

    public void setEmployeeMaster(EmployeeMaster employeeMaster) {
        this.employeeMaster = employeeMaster;
    }

    public TrainingFeedback getTrainingFeedback() {
        return trainingFeedback;
    }

    public void setTrainingFeedback(TrainingFeedback trainingFeedback) {
        this.trainingFeedback = trainingFeedback;
    }

    public TrainingMaster getTrainingMaster() {
        return trainingMaster;
    }

    public void setTrainingMaster(TrainingMaster trainingMaster) {
        this.trainingMaster = trainingMaster;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

}
