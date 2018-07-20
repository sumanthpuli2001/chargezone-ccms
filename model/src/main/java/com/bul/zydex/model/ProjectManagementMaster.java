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
     private ClientMaster clientMaster;
     private PriorityMaster priorityMaster;
     private StateMaster stateMaster;
     private ZydexLocationMaster zydexLocationMaster;
     private String projectCode;
     private String name;
     private String plannedDate;
     private String deadline;
     private String riskImpact;
     private String manager;
     private String finishDate;
     private String taskCompleted;
     private String budget;
     private String billingType;
     private String description;

    public ProjectManagementMaster() {
    }

	
    public ProjectManagementMaster(ClientMaster clientMaster, PriorityMaster priorityMaster, StateMaster stateMaster, ZydexLocationMaster zydexLocationMaster) {
        this.clientMaster = clientMaster;
        this.priorityMaster = priorityMaster;
        this.stateMaster = stateMaster;
        this.zydexLocationMaster = zydexLocationMaster;
    }
    public ProjectManagementMaster(ClientMaster clientMaster, PriorityMaster priorityMaster, StateMaster stateMaster, ZydexLocationMaster zydexLocationMaster, String projectCode, String name, String plannedDate, String deadline, String riskImpact, String manager, String finishDate, String taskCompleted, String budget, String billingType, String description) {
       this.clientMaster = clientMaster;
       this.priorityMaster = priorityMaster;
       this.stateMaster = stateMaster;
       this.zydexLocationMaster = zydexLocationMaster;
       this.projectCode = projectCode;
       this.name = name;
       this.plannedDate = plannedDate;
       this.deadline = deadline;
       this.riskImpact = riskImpact;
       this.manager = manager;
       this.finishDate = finishDate;
       this.taskCompleted = taskCompleted;
       this.budget = budget;
       this.billingType = billingType;
       this.description = description;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public ClientMaster getClientMaster() {
        return this.clientMaster;
    }
    
    public void setClientMaster(ClientMaster clientMaster) {
        this.clientMaster = clientMaster;
    }
    public PriorityMaster getPriorityMaster() {
        return this.priorityMaster;
    }
    
    public void setPriorityMaster(PriorityMaster priorityMaster) {
        this.priorityMaster = priorityMaster;
    }
    public StateMaster getStateMaster() {
        return this.stateMaster;
    }
    
    public void setStateMaster(StateMaster stateMaster) {
        this.stateMaster = stateMaster;
    }
    public ZydexLocationMaster getZydexLocationMaster() {
        return this.zydexLocationMaster;
    }
    
    public void setZydexLocationMaster(ZydexLocationMaster zydexLocationMaster) {
        this.zydexLocationMaster = zydexLocationMaster;
    }
    public String getProjectCode() {
        return this.projectCode;
    }
    
    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
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
    public String getRiskImpact() {
        return this.riskImpact;
    }
    
    public void setRiskImpact(String riskImpact) {
        this.riskImpact = riskImpact;
    }
    public String getManager() {
        return this.manager;
    }
    
    public void setManager(String manager) {
        this.manager = manager;
    }
    public String getFinishDate() {
        return this.finishDate;
    }
    
    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }
    public String getTaskCompleted() {
        return this.taskCompleted;
    }
    
    public void setTaskCompleted(String taskCompleted) {
        this.taskCompleted = taskCompleted;
    }
    public String getBudget() {
        return this.budget;
    }
    
    public void setBudget(String budget) {
        this.budget = budget;
    }
    public String getBillingType() {
        return this.billingType;
    }
    
    public void setBillingType(String billingType) {
        this.billingType = billingType;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }




}
