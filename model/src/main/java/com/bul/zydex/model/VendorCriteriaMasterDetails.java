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
public class VendorCriteriaMasterDetails {

    private int id;
    private String criteriaName;
    private String criteriaDescription;
    private String mandatory;
    private String compulsaryFlag;
    private int vendorCriteriaMasterId;

    public VendorCriteriaMasterDetails() {
    }

    public VendorCriteriaMasterDetails(int id, String criteriaName, String criteriaDescription, String mandatory, String compulsaryFlag, int vendorCriteriaMasterId) {
        this.id = id;
        this.criteriaName = criteriaName;
        this.criteriaDescription = criteriaDescription;
        this.mandatory = mandatory;
        this.compulsaryFlag = compulsaryFlag;
        this.vendorCriteriaMasterId = vendorCriteriaMasterId;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCriteriaName() {
        return criteriaName;
    }

    public void setCriteriaName(String criteriaName) {
        this.criteriaName = criteriaName;
    }

    public String getCriteriaDescription() {
        return criteriaDescription;
    }

    public void setCriteriaDescription(String criteriaDescription) {
        this.criteriaDescription = criteriaDescription;
    }

    public String getMandatory() {
        return mandatory;
    }

    public void setMandatory(String mandatory) {
        this.mandatory = mandatory;
    }

    public String getCompulsaryFlag() {
        return compulsaryFlag;
    }

    public void setCompulsaryFlag(String compulsaryFlag) {
        this.compulsaryFlag = compulsaryFlag;
    }

    public int getVendorCriteriaMasterId() {
        return vendorCriteriaMasterId;
    }

    public void setVendorCriteriaMasterId(int vendorCriteriaMasterId) {
        this.vendorCriteriaMasterId = vendorCriteriaMasterId;
    }

   

}
