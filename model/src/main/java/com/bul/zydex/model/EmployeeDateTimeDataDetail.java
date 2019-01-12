/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author Teja
 */
public class EmployeeDateTimeDataDetail implements java.io.Serializable
{
    private Integer id;
    private EmployeeDatetimeData employeeDatetimeData;
    private String createdDate;
    private String updatedDate;
    private String createdBy;
    private String updatedBy;

    public EmployeeDateTimeDataDetail() {
    }

    public EmployeeDateTimeDataDetail(EmployeeDatetimeData employeeDatetimeData, String createdDate, String updatedDate, String createdBy, String updatedBy) {
        this.employeeDatetimeData = employeeDatetimeData;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EmployeeDatetimeData getEmployeeDatetimeData() {
        return employeeDatetimeData;
    }

    public void setEmployeeDatetimeData(EmployeeDatetimeData employeeDatetimeData) {
        this.employeeDatetimeData = employeeDatetimeData;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
    
}
