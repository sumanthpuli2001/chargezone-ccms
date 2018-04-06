/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author Hussain
 */
public class EmployeeCtcDetail implements java.io.Serializable {

    private Integer id;
    private EmployeeMaster employeeMaster;
    private CtcAllowance ctcAllowance;
    private Double amount;
    private Integer status;
    private String month;
    private String year;

    public EmployeeCtcDetail() {
    }

    public EmployeeCtcDetail(Integer id, EmployeeMaster employeeMaster, CtcAllowance ctcAllowance, Double amount,Integer status,String month,String year) {
        this.id = id;
        this.employeeMaster = employeeMaster;
        this.ctcAllowance = ctcAllowance;
        this.amount = amount;
        this.status = status;
        this.month = month;
        this.year = year;
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

    public CtcAllowance getCtcAllowance() {
        return ctcAllowance;
    }

    public void setCtcAllowance(CtcAllowance ctcAllowance) {
        this.ctcAllowance = ctcAllowance;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
    
    

}
