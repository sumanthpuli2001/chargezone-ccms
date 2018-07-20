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
public class CreateTask implements java.io.Serializable {

    private Integer id;
    private PriorityMaster priorityMaster;
    private ProjectManagementMaster projectManagementMaster;
    private String name;
    private String plannedStart;
    private String plannedFinish;
    private Boolean manuallySchedule;
    private String duration;
    private String plannedEffort;
    private String taskCompleted;
    private Boolean timeLogging;
    private String actualStart;
    private String actualFinish;
    private String budget;
    private String plannedLabourCost;
    private String plannedFixedCost;
    private String billingType;

    public CreateTask() {
    }

    public CreateTask(PriorityMaster priorityMaster, ProjectManagementMaster projectManagementMaster, String name, String plannedStart, String plannedFinish, Boolean manuallySchedule, String duration, String plannedEffort, String taskCompleted, Boolean timeLogging, String actualStart, String actualFinish, String budget, String plannedLabourCost, String plannedFixedCost, String billingType) {
        this.priorityMaster = priorityMaster;
        this.projectManagementMaster = projectManagementMaster;
        this.name = name;
        this.plannedStart = plannedStart;
        this.plannedFinish = plannedFinish;
        this.manuallySchedule = manuallySchedule;
        this.duration = duration;
        this.plannedEffort = plannedEffort;
        this.taskCompleted = taskCompleted;
        this.timeLogging = timeLogging;
        this.actualStart = actualStart;
        this.actualFinish = actualFinish;
        this.budget = budget;
        this.plannedLabourCost = plannedLabourCost;
        this.plannedFixedCost = plannedFixedCost;
        this.billingType = billingType;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PriorityMaster getPriorityMaster() {
        return this.priorityMaster;
    }

    public void setPriorityMaster(PriorityMaster priorityMaster) {
        this.priorityMaster = priorityMaster;
    }

    public ProjectManagementMaster getProjectManagementMaster() {
        return this.projectManagementMaster;
    }

    public void setProjectManagementMaster(ProjectManagementMaster projectManagementMaster) {
        this.projectManagementMaster = projectManagementMaster;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlannedStart() {
        return this.plannedStart;
    }

    public void setPlannedStart(String plannedStart) {
        this.plannedStart = plannedStart;
    }

    public String getPlannedFinish() {
        return this.plannedFinish;
    }

    public void setPlannedFinish(String plannedFinish) {
        this.plannedFinish = plannedFinish;
    }

    public Boolean getManuallySchedule() {
        return this.manuallySchedule;
    }

    public void setManuallySchedule(Boolean manuallySchedule) {
        this.manuallySchedule = manuallySchedule;
    }

    public String getDuration() {
        return this.duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPlannedEffort() {
        return this.plannedEffort;
    }

    public void setPlannedEffort(String plannedEffort) {
        this.plannedEffort = plannedEffort;
    }

    public String getTaskCompleted() {
        return this.taskCompleted;
    }

    public void setTaskCompleted(String taskCompleted) {
        this.taskCompleted = taskCompleted;
    }

    public Boolean getTimeLogging() {
        return this.timeLogging;
    }

    public void setTimeLogging(Boolean timeLogging) {
        this.timeLogging = timeLogging;
    }

    public String getActualStart() {
        return this.actualStart;
    }

    public void setActualStart(String actualStart) {
        this.actualStart = actualStart;
    }

    public String getActualFinish() {
        return this.actualFinish;
    }

    public void setActualFinish(String actualFinish) {
        this.actualFinish = actualFinish;
    }

    public String getBudget() {
        return this.budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getPlannedLabourCost() {
        return this.plannedLabourCost;
    }

    public void setPlannedLabourCost(String plannedLabourCost) {
        this.plannedLabourCost = plannedLabourCost;
    }

    public String getPlannedFixedCost() {
        return this.plannedFixedCost;
    }

    public void setPlannedFixedCost(String plannedFixedCost) {
        this.plannedFixedCost = plannedFixedCost;
    }

    public String getBillingType() {
        return this.billingType;
    }

    public void setBillingType(String billingType) {
        this.billingType = billingType;
    }

}
