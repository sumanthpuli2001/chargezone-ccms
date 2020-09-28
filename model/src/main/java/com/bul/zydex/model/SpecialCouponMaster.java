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
public class SpecialCouponMaster {

    private int srNo;
    private String couponType;
    private String department;
    private int limitMonth;
    private int limitDay;
    private String designation;
    private String dRow;
    private String changeAfterDayLimit;

    public SpecialCouponMaster() {
    }

    public SpecialCouponMaster(int srNo, String couponType, String department, int limitMonth, int limitDay, String designation, String dRow, String changeAfterDayLimit) {
        this.srNo = srNo;
        this.couponType = couponType;
        this.department = department;
        this.limitMonth = limitMonth;
        this.limitDay = limitDay;
        this.designation = designation;
        this.dRow = dRow;
        this.changeAfterDayLimit = changeAfterDayLimit;
    }

    public int getSrNo() {
        return srNo;
    }

    public SpecialCouponMaster setSrNo(int srNo) {
        this.srNo = srNo;
        return this;
    }

    public String getCouponType() {
        return couponType;
    }

    public SpecialCouponMaster setCouponType(String couponType) {
        this.couponType = couponType;
        return this;
    }

    public String getDepartment() {
        return department;
    }

    public SpecialCouponMaster setDepartment(String department) {
        this.department = department;
        return this;
    }

    public int getLimitMonth() {
        return limitMonth;
    }

    public SpecialCouponMaster setLimitMonth(int limitMonth) {
        this.limitMonth = limitMonth;
        return this;
    }

    public int getLimitDay() {
        return limitDay;
    }

    public SpecialCouponMaster setLimitDay(int limitDay) {
        this.limitDay = limitDay;
        return this;
    }

    public String getDesignation() {
        return designation;
    }

    public SpecialCouponMaster setDesignation(String designation) {
        this.designation = designation;
        return this;
    }

    public String getdRow() {
        return dRow;
    }

    public SpecialCouponMaster setdRow(String dRow) {
        this.dRow = dRow;
        return this;
    }

    public String getChangeAfterDayLimit() {
        return changeAfterDayLimit;
    }

    public SpecialCouponMaster setChangeAfterDayLimit(String changeAfterDayLimit) {
        this.changeAfterDayLimit = changeAfterDayLimit;
        return this;
    }

}
