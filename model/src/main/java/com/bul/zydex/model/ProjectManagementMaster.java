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
public class ProjectManagementMaster  implements java.io.Serializable {


     private Integer id;
     private String name;
     private String plannedDate;
     private String deadline;
     private String manager;
     private String client;
     private String state;
     private String priority;
     private String workLocation;
     private String riskImpact;
     private String riskProbability;
     private String potentialCost;
     private String mitigationCost;
     private String mitigationPlan;
     private String projectFinishDate;

    public ProjectManagementMaster() {
    }

    public ProjectManagementMaster(String name, String plannedDate, String deadline, String manager, String client, String state, String priority, String workLocation, String riskImpact, String riskProbability, String potentialCost, String mitigationCost, String mitigationPlan, String projectFinishDate) {
       this.name = name;
       this.plannedDate = plannedDate;
       this.deadline = deadline;
       this.manager = manager;
       this.client = client;
       this.state = state;
       this.priority = priority;
       this.workLocation = workLocation;
       this.riskImpact = riskImpact;
       this.riskProbability = riskProbability;
       this.potentialCost = potentialCost;
       this.mitigationCost = mitigationCost;
       this.mitigationPlan = mitigationPlan;
       this.projectFinishDate = projectFinishDate;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getPlannedDate() {
        return this.plannedDate;
    }
    
    public void setPlannedDate(String plannedDate) {
        this.plannedDate = plannedDate;
    }
    public String getDeadline() {
        return this.deadline;
    }
    
    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
    public String getManager() {
        return this.manager;
    }
    
    public void setManager(String manager) {
        this.manager = manager;
    }
    public String getClient() {
        return this.client;
    }
    
    public void setClient(String client) {
        this.client = client;
    }
    public String getState() {
        return this.state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    public String getPriority() {
        return this.priority;
    }
    
    public void setPriority(String priority) {
        this.priority = priority;
    }
    public String getWorkLocation() {
        return this.workLocation;
    }
    
    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }
    public String getRiskImpact() {
        return this.riskImpact;
    }
    
    public void setRiskImpact(String riskImpact) {
        this.riskImpact = riskImpact;
    }
    public String getRiskProbability() {
        return this.riskProbability;
    }
    
    public void setRiskProbability(String riskProbability) {
        this.riskProbability = riskProbability;
    }
    public String getPotentialCost() {
        return this.potentialCost;
    }
    
    public void setPotentialCost(String potentialCost) {
        this.potentialCost = potentialCost;
    }
    public String getMitigationCost() {
        return this.mitigationCost;
    }
    
    public void setMitigationCost(String mitigationCost) {
        this.mitigationCost = mitigationCost;
    }
    public String getMitigationPlan() {
        return this.mitigationPlan;
    }
    
    public void setMitigationPlan(String mitigationPlan) {
        this.mitigationPlan = mitigationPlan;
    }
    public String getProjectFinishDate() {
        return this.projectFinishDate;
    }
    
    public void setProjectFinishDate(String projectFinishDate) {
        this.projectFinishDate = projectFinishDate;
    }




}

