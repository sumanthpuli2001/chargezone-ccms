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
public class TrainingAttendance {

    private Integer id;
    private Trainer trainer;
    private TrainingMaster trainingMaster;
    private EmployeeMaster employeeMaster;
    private String trainingDate;
    private Integer status;

    public TrainingAttendance() {

    }

    public TrainingAttendance(Integer id, Trainer trainer, TrainingMaster trainingMaster, EmployeeMaster employeeMaster, String trainingDate, Integer status) {
        this.id = id;
        this.trainer = trainer;
        this.trainingMaster = trainingMaster;
        this.employeeMaster = employeeMaster;
        this.trainingDate = trainingDate;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public TrainingMaster getTrainingMaster() {
        return trainingMaster;
    }

    public void setTrainingMaster(TrainingMaster trainingMaster) {
        this.trainingMaster = trainingMaster;
    }

    public EmployeeMaster getEmployeeMaster() {
        return employeeMaster;
    }

    public void setEmployeeMaster(EmployeeMaster employeeMaster) {
        this.employeeMaster = employeeMaster;
    }


    public String getTrainingDate() {
        return trainingDate;
    }

    public void setTrainingDate(String trainingDate) {
        this.trainingDate = trainingDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    
    
    

}
