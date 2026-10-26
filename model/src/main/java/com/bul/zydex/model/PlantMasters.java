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
public class PlantMasters {

    private int id;
    private String companyCode;
    private String plantCode;
    private String plantName;
    private String address;
    private String gst;
    private String purchasingOrganisation;
    private String postalCode;
    private String country;
    private String region;
    private String language;

    public PlantMasters() {
    }

    public PlantMasters(int id, String companyCode, String plantCode, String plantName, String address, String gst, String purchasingOrganisation, String postalCode, String country, String region, String language) {
	this.id = id;
	this.companyCode = companyCode;
	this.plantCode = plantCode;
	this.plantName = plantName;
	this.address = address;
	this.gst = gst;
	this.purchasingOrganisation = purchasingOrganisation;
	this.postalCode = postalCode;
	this.country = country;
	this.region = region;
	this.language = language;
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

    public String getPlantName() {
	return plantName;
    }

    public void setPlantName(String plantName) {
	this.plantName = plantName;
    }

    public String getAddress() {
	return address;
    }

    public void setAddress(String address) {
	this.address = address;
    }

    public String getGst() {
	return gst;
    }

    public void setGst(String gst) {
	this.gst = gst;
    }

    public String getPurchasingOrganisation() {
	return purchasingOrganisation;
    }

    public void setPurchasingOrganisation(String purchasingOrganisation) {
	this.purchasingOrganisation = purchasingOrganisation;
    }

    public String getPostalCode() {
	return postalCode;
    }

    public void setPostalCode(String postalCode) {
	this.postalCode = postalCode;
    }

    public String getCountry() {
	return country;
    }

    public void setCountry(String country) {
	this.country = country;
    }

    public String getRegion() {
	return region;
    }

    public void setRegion(String region) {
	this.region = region;
    }

    public String getLanguage() {
	return language;
    }

    public void setLanguage(String language) {
	this.language = language;
    }

}
