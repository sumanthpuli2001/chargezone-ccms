package com.bul.zydex.model;

import com.bul.zydex.model.EmployeeMaster;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author BlackBull
 */
public class PmpFormStatusMaster implements java.io.Serializable {

    private Integer id;
    private EmployeeMaster employeeMaster;
    private Boolean startYearStatus;
    private Boolean midYearStatus;
    private Boolean endYearStatus;
    private Boolean managerSide;
    private Boolean employeeSide;
    private Boolean compentencyStartYearStatus;
    private Boolean compentencyMidYearStatus;
    private Boolean compentencyEndYearStatus;
    private Boolean compentencyManagerSide;
    private Boolean compentencyEmployeeSide;

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

    public Boolean getStartYearStatus() {
        return startYearStatus;
    }

    public void setStartYearStatus(Boolean startYearStatus) {
        this.startYearStatus = startYearStatus;
    }

    public Boolean getMidYearStatus() {
        return midYearStatus;
    }

    public void setMidYearStatus(Boolean midYearStatus) {
        this.midYearStatus = midYearStatus;
    }

    public Boolean getEndYearStatus() {
        return endYearStatus;
    }

    public void setEndYearStatus(Boolean endYearStatus) {
        this.endYearStatus = endYearStatus;
    }

    public Boolean getManagerSide() {
        return managerSide;
    }

    public void setManagerSide(Boolean managerSide) {
        this.managerSide = managerSide;
    }

    public Boolean getEmployeeSide() {
        return employeeSide;
    }

    public void setEmployeeSide(Boolean employeeSide) {
        this.employeeSide = employeeSide;
    }

    public Boolean getCompentencyStartYearStatus() {
        return compentencyStartYearStatus;
    }

    public void setCompentencyStartYearStatus(Boolean compentencyStartYearStatus) {
        this.compentencyStartYearStatus = compentencyStartYearStatus;
    }

    public Boolean getCompentencyMidYearStatus() {
        return compentencyMidYearStatus;
    }

    public void setCompentencyMidYearStatus(Boolean compentencyMidYearStatus) {
        this.compentencyMidYearStatus = compentencyMidYearStatus;
    }

    public Boolean getCompentencyEndYearStatus() {
        return compentencyEndYearStatus;
    }

    public void setCompentencyEndYearStatus(Boolean compentencyEndYearStatus) {
        this.compentencyEndYearStatus = compentencyEndYearStatus;
    }

    public Boolean getCompentencyManagerSide() {
        return compentencyManagerSide;
    }

    public void setCompentencyManagerSide(Boolean compentencyManagerSide) {
        this.compentencyManagerSide = compentencyManagerSide;
    }

    public Boolean getCompentencyEmployeeSide() {
        return compentencyEmployeeSide;
    }

    public void setCompentencyEmployeeSide(Boolean compentencyEmployeeSide) {
        this.compentencyEmployeeSide = compentencyEmployeeSide;
    }

}
