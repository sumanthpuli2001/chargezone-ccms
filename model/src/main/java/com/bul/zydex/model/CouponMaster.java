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
public class CouponMaster {

    private String couponType;
    private int srNo;
    private Double couponPrice;
    private int limitMonth;
    private int limitDay;
    private Double acPrive;
    private String dRow;
    private int qty1;
    private Double secondPrice;
    private int qty2;
    private int limitMonthSub1;
    private int limitMonthSub2;
    private String effectFrom;

    public CouponMaster() {
    }

    public CouponMaster(String couponType, int srNo, Double couponPrice, int limitMonth, int limitDay, Double acPrive, String dRow, int qty1, Double secondPrice, int qty2, int limitMonthSub1, int limitMonthSub2, String effectFrom) {
        this.couponType = couponType;
        this.srNo = srNo;
        this.couponPrice = couponPrice;
        this.limitMonth = limitMonth;
        this.limitDay = limitDay;
        this.acPrive = acPrive;
        this.dRow = dRow;
        this.qty1 = qty1;
        this.secondPrice = secondPrice;
        this.qty2 = qty2;
        this.limitMonthSub1 = limitMonthSub1;
        this.limitMonthSub2 = limitMonthSub2;
        this.effectFrom = effectFrom;
    }

    public String getCouponType() {
        return couponType;
    }

    public CouponMaster setCouponType(String couponType) {
        this.couponType = couponType;
        return this;
    }

    public int getSrNo() {
        return srNo;
    }

    public CouponMaster setSrNo(int srNo) {
        this.srNo = srNo;
        return this;
    }

    public Double getCouponPrice() {
        return couponPrice;
    }

    public CouponMaster setCouponPrice(Double couponPrice) {
        this.couponPrice = couponPrice;
        return this;
    }

    public int getLimitMonth() {
        return limitMonth;
    }

    public CouponMaster setLimitMonth(int limitMonth) {
        this.limitMonth = limitMonth;
        return this;
    }

    public int getLimitDay() {
        return limitDay;
    }

    public CouponMaster setLimitDay(int limitDay) {
        this.limitDay = limitDay;
        return this;
    }

    public Double getAcPrive() {
        return acPrive;
    }

    public CouponMaster setAcPrive(Double acPrive) {
        this.acPrive = acPrive;
        return this;
    }

    public String getdRow() {
        return dRow;
    }

    public CouponMaster setdRow(String dRow) {
        this.dRow = dRow;
        return this;
    }

    public int getQty1() {
        return qty1;
    }

    public CouponMaster setQty1(int qty1) {
        this.qty1 = qty1;
        return this;
    }

    public Double getSecondPrice() {
        return secondPrice;
    }

    public CouponMaster setSecondPrice(Double secondPrice) {
        this.secondPrice = secondPrice;
        return this;
    }

    public int getQty2() {
        return qty2;
    }

    public CouponMaster setQty2(int qty2) {
        this.qty2 = qty2;
        return this;
    }

    public int getLimitMonthSub1() {
        return limitMonthSub1;
    }

    public CouponMaster setLimitMonthSub1(int limitMonthSub1) {
        this.limitMonthSub1 = limitMonthSub1;
        return this;
    }

    public int getLimitMonthSub2() {
        return limitMonthSub2;
    }

    public CouponMaster setLimitMonthSub2(int limitMonthSub2) {
        this.limitMonthSub2 = limitMonthSub2;
        return this;
    }

    public String getEffectFrom() {
        return effectFrom;
    }

    public CouponMaster setEffectFrom(String effectFrom) {
        this.effectFrom = effectFrom;
        return this;
    }

}
