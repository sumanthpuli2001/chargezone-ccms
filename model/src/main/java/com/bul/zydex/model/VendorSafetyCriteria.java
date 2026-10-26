/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author admin
 */
public class VendorSafetyCriteria {

    private int id;
    private String criteriaName;
    private String criteriaDescription;
    private String groupId;
    private String mandatory;
    private String compulsaryFlag;

    public VendorSafetyCriteria() {
    }

    public VendorSafetyCriteria(int id, String criteriaName, String criteriaDescription, String groupId, String mandatory, String compulsaryFlag) {
        this.id = id;
        this.criteriaName = criteriaName;
        this.criteriaDescription = criteriaDescription;
        this.groupId = groupId;
        this.mandatory = mandatory;
        this.compulsaryFlag =compulsaryFlag;

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

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
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

}
