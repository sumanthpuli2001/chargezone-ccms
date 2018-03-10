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
public class TrainingIdentification {
    
    private Integer id;
    private EmployeeMaster employeeMaster;
    private TrainingMaster trainingMaster;
    private Integer status;
    private String description;
    
   public TrainingIdentification(){
       
   } 

    public TrainingIdentification(Integer id, EmployeeMaster employeeMaster, TrainingMaster trainingMaster, Integer status, String description) {
        this.id = id;
        this.employeeMaster = employeeMaster;
        this.trainingMaster = trainingMaster;
        this.status = status;
        this.description = description;
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

    public TrainingMaster getTrainingMaster() {
        return trainingMaster;
    }

    public void setTrainingMaster(TrainingMaster trainingMaster) {
        this.trainingMaster = trainingMaster;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
    
}
