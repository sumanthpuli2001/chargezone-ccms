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
public class PunchedDataMaster {

    private long srNo;
    private String item;
    private String empCode;
    private String lDate;
    private String lTime;
    private String quantity;
    private Double price;
    private String cid;
    private int disp;
    private String remark;

    public PunchedDataMaster() {
    }

    public long getSrNo() {
        return srNo;
    }

    public PunchedDataMaster setSrNo(long srNo) {
        this.srNo = srNo;
        return this;
    }

    public String getItem() {
        return item;
    }

    public PunchedDataMaster setItem(String item) {
        this.item = item;
        return this;
    }

    public String getEmpCode() {
        return empCode;
    }

    public PunchedDataMaster setEmpCode(String empCode) {
        this.empCode = empCode;
        return this;
    }

    public String getlDate() {
        return lDate;
    }

    public PunchedDataMaster setlDate(String lDate) {
        this.lDate = lDate;
        return this;
    }

    public String getlTime() {
        return lTime;
    }

    public PunchedDataMaster setlTime(String lTime) {
        this.lTime = lTime;
        return this;
    }

    public String getQuantity() {
        return quantity;
    }

    public PunchedDataMaster setQuantity(String quantity) {
        this.quantity = quantity;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public PunchedDataMaster setPrice(Double price) {
        this.price = price;
        return this;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public int getDisp() {
        return disp;
    }

    public PunchedDataMaster setDisp(int disp) {
        this.disp = disp;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public PunchedDataMaster setRemark(String remark) {
        this.remark = remark;
        return this;
    }

}
