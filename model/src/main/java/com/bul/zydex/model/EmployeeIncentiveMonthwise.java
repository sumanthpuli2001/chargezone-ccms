/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Hussain
 */
public class EmployeeIncentiveMonthwise implements java.io.Serializable {

    private Integer id;
    private Double incentiveAmount;
    private String month;
    private String year;
    private Float attenDay;

    public EmployeeIncentiveMonthwise() {
    }

    public EmployeeIncentiveMonthwise(Double incentiveAmount, String month, String year,Float attenDay) {

        this.incentiveAmount = incentiveAmount;
        this.month = month;
        this.year = year;
        this.attenDay = attenDay;

    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getIncentiveAmount() {
        return incentiveAmount;
    }

    public void setIncentiveAmount(Double incentiveAmount) {
        this.incentiveAmount = incentiveAmount;
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

    public Float getAttenDay() {
        return attenDay;
    }

    public void setAttenDay(Float attenDay) {
        this.attenDay = attenDay;
    }
    

}
