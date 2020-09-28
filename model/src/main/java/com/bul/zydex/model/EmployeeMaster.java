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
public class EmployeeMaster {

    private String employeeCode;
    private String name;
    private String department;
    private String designation;
    private String rightsName;
    private String dRow;
    private String rfId;
    private String rfIdDept;
    private String rfIdGuest;

    public EmployeeMaster() {
    }

    public EmployeeMaster(String employeeCode, String name, String department, String designation, String rightsName, String dRow, String rfId, String rfIdDept, String rfIdGuest) {
        this.employeeCode = employeeCode;
        this.name = name;
        this.department = department;
        this.designation = designation;
        this.rightsName = rightsName;
        this.dRow = dRow;
        this.rfId = rfId;
        this.rfIdDept = rfIdDept;
        this.rfIdGuest = rfIdGuest;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public EmployeeMaster setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
        return this;
    }

    public String getName() {
        return name;
    }

    public EmployeeMaster setName(String name) {
        this.name = name;
        return this;
    }

    public String getDepartment() {
        return department;
    }

    public EmployeeMaster setDepartment(String department) {
        this.department = department;
        return this;
    }

    public String getDesignation() {
        return designation;
    }

    public EmployeeMaster setDesignation(String designation) {
        this.designation = designation;
        return this;
    }

    public String getRightsName() {
        return rightsName;
    }

    public EmployeeMaster setRightsName(String rightsName) {
        this.rightsName = rightsName;
        return this;
    }

    public String getdRow() {
        return dRow;
    }

    public EmployeeMaster setdRow(String dRow) {
        this.dRow = dRow;
        return this;
    }

    public String getRfId() {
        return rfId;
    }

    public EmployeeMaster setRfId(String rfId) {
        this.rfId = rfId;
        return this;
    }

    public String getRfIdDept() {
        return rfIdDept;
    }

    public EmployeeMaster setRfIdDept(String rfIdDept) {
        this.rfIdDept = rfIdDept;
        return this;
    }

    public String getRfIdGuest() {
        return rfIdGuest;
    }

    public EmployeeMaster setRfIdGuest(String rfIdGuest) {
        this.rfIdGuest = rfIdGuest;
        return this;
    }

}
