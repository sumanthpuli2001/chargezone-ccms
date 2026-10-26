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
public class LocationMasters {

    private int id;
    private String companyCode;
    private String plantCode;
    private String loactionCode;
    private String loactionName;
    private String address;

    public LocationMasters() {
    }

    public LocationMasters(int id, String companyCode, String plantCode, String loactionCode, String loactionName, String address) {
	this.id = id;
	this.companyCode = companyCode;
	this.plantCode = plantCode;
	this.loactionCode = loactionCode;
	this.loactionName = loactionName;
	this.address = address;
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

    public String getPlantCode() {
	return plantCode;
    }

    public void setPlantCode(String plantCode) {
	this.plantCode = plantCode;
    }

    public String getLoactionCode() {
	return loactionCode;
    }

    public void setLoactionCode(String loactionCode) {
	this.loactionCode = loactionCode;
    }

    public String getLoactionName() {
	return loactionName;
    }

    public void setLoactionName(String loactionName) {
	this.loactionName = loactionName;
    }

    public String getAddress() {
	return address;
    }

    public void setAddress(String address) {
	this.address = address;
    }

    
    
    
    
}
