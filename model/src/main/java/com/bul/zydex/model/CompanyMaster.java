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
public class CompanyMaster {

    private int id;
    private String companyCode;
    private String description;
    private String city;

    public CompanyMaster() {
    }

    public CompanyMaster(int id, String companyCode, String description, String city) {
	this.id = id;
	this.companyCode = companyCode;
	this.description = description;
	this.city = city;
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

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public String getCity() {
	return city;
    }

    public void setCity(String city) {
	this.city = city;
    }

    
}
