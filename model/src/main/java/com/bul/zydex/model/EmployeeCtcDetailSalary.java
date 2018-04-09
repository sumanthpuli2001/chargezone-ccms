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
public class EmployeeCtcDetailSalary implements java.io.Serializable {

    private Integer id;
    private EmployeeMaster employeeMaster;
    private CtcAllowance ctcAllowance;
    private String month;
    private String year;
    private Double amount;
    private String monthly;
    private String yearly;

    public EmployeeCtcDetailSalary() {
    }

    public EmployeeCtcDetailSalary(Integer id, EmployeeMaster employeeMaster, CtcAllowance ctcAllowance, String month, String year, Double amount,String monthly,String yearly) {
        this.id = id;
        this.employeeMaster = employeeMaster;
       
        this.ctcAllowance = ctcAllowance;
        this.month = month;
        this.year = year;
        this.amount = amount;
        this.monthly = monthly;
        this.yearly = yearly;
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getMonthly() {
        return monthly;
    }

    public void setMonthly(String monthly) {
        this.monthly = monthly;
    }

    public String getYearly() {
        return yearly;
    }

    public void setYearly(String yearly) {
        this.yearly = yearly;
    }
    
    
}
