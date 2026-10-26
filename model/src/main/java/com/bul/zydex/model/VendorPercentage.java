/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author bulwarks-2
 */
public class VendorPercentage {

    private Integer id;
    private String technicalPercentage;
    private String hrPercentage;
    private String safteyPercentage;
    private String itPercentage;

    public VendorPercentage() {
    }

    public VendorPercentage(Integer id, String technicalPercentage, String hrPercentage, String safteyPercentage, String itPercentage) {
        this.id = id;
        this.technicalPercentage = technicalPercentage;
        this.hrPercentage = hrPercentage;
        this.safteyPercentage = safteyPercentage;
        this.itPercentage = itPercentage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTechnicalPercentage() {
        return technicalPercentage;
    }

    public void setTechnicalPercentage(String technicalPercentage) {
        this.technicalPercentage = technicalPercentage;
    }

    public String getHrPercentage() {
        return hrPercentage;
    }

    public void setHrPercentage(String hrPercentage) {
        this.hrPercentage = hrPercentage;
    }

    public String getSafteyPercentage() {
        return safteyPercentage;
    }

    public void setSafteyPercentage(String safteyPercentage) {
        this.safteyPercentage = safteyPercentage;
    }

    public String getItPercentage() {
        return itPercentage;
    }

    public void setItPercentage(String itPercentage) {
        this.itPercentage = itPercentage;
    }

}
