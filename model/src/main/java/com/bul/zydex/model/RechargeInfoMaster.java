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
public class RechargeInfoMaster {

    private int id;
    private String rfId;
    private String amount;
    private String date;
    private String rAmount;

    public RechargeInfoMaster() {
    }

    public RechargeInfoMaster(int id, String rfId, String amount, String date, String rAmount) {
        this.id = id;
        this.rfId = rfId;
        this.amount = amount;
        this.date = date;
        this.rAmount = rAmount;
    }

    public int getId() {
        return id;
    }

    public RechargeInfoMaster setId(int id) {
        this.id = id;
        return this;
    }

    public String getRfId() {
        return rfId;
    }

    public RechargeInfoMaster setRfId(String rfId) {
        this.rfId = rfId;
        return this;
    }

    public String getAmount() {
        return amount;
    }

    public RechargeInfoMaster setAmount(String amount) {
        this.amount = amount;
        return this;
    }

    public String getDate() {
        return date;
    }

    public RechargeInfoMaster setDate(String date) {
        this.date = date;
        return this;
    }

    public String getrAmount() {
        return rAmount;
    }

    public RechargeInfoMaster setrAmount(String rAmount) {
        this.rAmount = rAmount;
        return this;
    }

}
