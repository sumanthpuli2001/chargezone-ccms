/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author Aman Bahukhandi
 */
public class ApprenticesMaster {

    private String apprenticeCode;
    private String name;
    private String department;
    private String shiftType;
    private String duration;
    private String rightName;
    private String startDate;
    private String endDate;
    private String dRow;
    private String rfId;

    public ApprenticesMaster() {
    }

    public ApprenticesMaster(String apprenticeCode, String name, String department, String shiftType, String duration, String rightName, String startDate, String endDate, String dRow, String rfId) {
        this.apprenticeCode = apprenticeCode;
        this.name = name;
        this.department = department;
        this.shiftType = shiftType;
        this.duration = duration;
        this.rightName = rightName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.dRow = dRow;
        this.rfId = rfId;
    }

    public String getApprenticeCode() {
        return apprenticeCode;
    }

    public ApprenticesMaster setApprenticeCode(String apprenticeCode) {
        this.apprenticeCode = apprenticeCode;
        return this;
    }

    public String getName() {
        return name;
    }

    public ApprenticesMaster setName(String name) {
        this.name = name;
        return this;
    }

    public String getDepartment() {
        return department;
    }

    public ApprenticesMaster setDepartment(String department) {
        this.department = department;
        return this;
    }

    public String getShiftType() {
        return shiftType;
    }

    public ApprenticesMaster setShiftType(String shiftType) {
        this.shiftType = shiftType;
        return this;
    }

    public String getDuration() {
        return duration;
    }

    public ApprenticesMaster setDuration(String duration) {
        this.duration = duration;
        return this;
    }

    public String getRightName() {
        return rightName;
    }

    public ApprenticesMaster setRightName(String rightName) {
        this.rightName = rightName;
        return this;
    }

    public String getStartDate() {
        return startDate;
    }

    public ApprenticesMaster setStartDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    public String getEndDate() {
        return endDate;
    }

    public ApprenticesMaster setEndDate(String endDate) {
        this.endDate = endDate;
        return this;

    }

    public String getdRow() {
        return dRow;
    }

    public ApprenticesMaster setdRow(String dRow) {
        this.dRow = dRow;
        return this;
    }

    public String getRfId() {
        return rfId;
    }

    public ApprenticesMaster setRfId(String rfId) {
        this.rfId = rfId;
        return this;
    }

}
