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
public class RechargeMaster {

    private Double limit;
    private String startDate;
    private String endDate;
    private String dRow;

    public RechargeMaster() {
    }

    public RechargeMaster(Double limit, String startDate, String endDate, String dRow) {
        this.limit = limit;
        this.startDate = startDate;
        this.endDate = endDate;
        this.dRow = dRow;
    }

    public Double getLimit() {
        return limit;
    }

    public RechargeMaster setLimit(Double limit) {
        this.limit = limit;
        return this;
    }

    public String getStartDate() {
        return startDate;
    }

    public RechargeMaster setStartDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    public String getEndDate() {
        return endDate;
    }

    public RechargeMaster setEndDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    public String getdRow() {
        return dRow;
    }

    public RechargeMaster setdRow(String dRow) {
        this.dRow = dRow;
        return this;
    }

}
