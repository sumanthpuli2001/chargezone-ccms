/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author Sumanth
 */
public class PurchasingOrganisation {

    private int id;
    private String companyCode;
    private String purchasingOrganisation;
    private String description;

    public PurchasingOrganisation() {
    }

    public PurchasingOrganisation(int id, String companyCode, String purchasingOrganisation, String description) {
	this.id = id;
	this.companyCode = companyCode;
	this.purchasingOrganisation = purchasingOrganisation;
	this.description = description;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getCompanyCode() {
	return companyCode;
    }

    public void setCompanyCode(String companyCode) {
	this.companyCode = companyCode;
    }

    public String getPurchasingOrganisation() {
	return purchasingOrganisation;
    }

    public void setPurchasingOrganisation(String purchasingOrganisation) {
	this.purchasingOrganisation = purchasingOrganisation;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    
    
    
    
}
