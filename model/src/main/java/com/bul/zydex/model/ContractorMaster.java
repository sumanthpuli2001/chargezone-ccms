/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

import java.util.Date;

/**
 *
 * @author Aman Bahukhandi
 */
public class ContractorMaster {

    private String contractorCode;
    private String name;
    private String duration;
    private String startDate;
    private String endDate;
    private String approved;
    private int numberPerson;
    private String department;
    private String dRow;
    private String rfId;

    public ContractorMaster() {
    }

    public ContractorMaster(String contractorCode, String name, String duration, String startDate, String endDate, String approved, int numberPerson, String department, String dRow, String rfId) {
        this.contractorCode = contractorCode;
        this.name = name;
        this.duration = duration;
        this.startDate = startDate;
        this.endDate = endDate;
        this.approved = approved;
        this.numberPerson = numberPerson;
        this.department = department;
        this.dRow = dRow;
        this.rfId = rfId;
    }

    public String getContractorCode() {
        return contractorCode;
    }

    public ContractorMaster setContractorCode(String contractorCode) {
        this.contractorCode = contractorCode;
        return this;
    }

    public String getName() {
        return name;
    }

    public ContractorMaster setName(String name) {
        this.name = name;
        return this;
    }

    public String getDuration() {
        return duration;
    }

    public ContractorMaster setDuration(String duration) {
        this.duration = duration;
        return this;
    }

    public String getStartDate() {
        return startDate;
    }

    public ContractorMaster setStartDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    public String getEndDate() {
        return endDate;
    }

    public ContractorMaster setEndDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    public String getApproved() {
        return approved;
    }

    public ContractorMaster setApproved(String approved) {
        this.approved = approved;
        return this;
    }

    public int getNumberPerson() {
        return numberPerson;
    }

    public ContractorMaster setNumberPerson(int numberPerson) {
        this.numberPerson = numberPerson;
        return this;
    }

    public String getDepartment() {
        return department;
    }

    public ContractorMaster setDepartment(String department) {
        this.department = department;
        return this;
    }

    public String getdRow() {
        return dRow;
    }

    public ContractorMaster setdRow(String dRow) {
        this.dRow = dRow;
        return this;
    }

    public String getRfId() {
        return rfId;
    }

    public ContractorMaster setRfId(String rfId) {
        this.rfId = rfId;
        return this;
    }

}
