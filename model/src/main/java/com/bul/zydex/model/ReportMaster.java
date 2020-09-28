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
public class ReportMaster {

    private String code;
    private String name;
    private String designation;
    private String department;
    private String tdate;
    private String tTime;
    private String item;
    private int numberOfItem;
    private String id;

    public ReportMaster() {
    }

    public ReportMaster(String code, String name, String designation, String department, String tdate, String tTime, String item, int numberOfItem, String id) {
        this.code = code;
        this.name = name;
        this.designation = designation;
        this.department = department;
        this.tdate = tdate;
        this.tTime = tTime;
        this.item = item;
        this.numberOfItem = numberOfItem;
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public ReportMaster setCode(String code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public ReportMaster setName(String name) {
        this.name = name;
        return this;
    }

    public String getDesignation() {
        return designation;
    }

    public ReportMaster setDesignation(String designation) {
        this.designation = designation;
        return this;
    }

    public String getDepartment() {
        return department;
    }

    public ReportMaster setDepartment(String department) {
        this.department = department;
        return this;
    }

    public String getTdate() {
        return tdate;
    }

    public ReportMaster setTdate(String tdate) {
        this.tdate = tdate;
        return this;
    }

    public String gettTime() {
        return tTime;
    }

    public ReportMaster settTime(String tTime) {
        this.tTime = tTime;
        return this;
    }

    public String getItem() {
        return item;
    }

    public ReportMaster setItem(String item) {
        this.item = item;
        return this;
    }

    public int getNumberOfItem() {
        return numberOfItem;
    }

    public ReportMaster setNumberOfItem(int numberOfItem) {
        this.numberOfItem = numberOfItem;
        return this;
    }

    public String getId() {
        return id;
    }

    public ReportMaster setId(String id) {
        this.id = id;
        return this;
    }

}
