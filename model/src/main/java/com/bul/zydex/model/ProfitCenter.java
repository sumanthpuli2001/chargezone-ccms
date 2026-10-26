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
public class ProfitCenter {

    private int id;
    private String profitCenter;

    public ProfitCenter() {
    }

    public ProfitCenter(int id, String profitCenter) {
	this.id = id;
	this.profitCenter = profitCenter;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getProfitCenter() {
	return profitCenter;
    }

    public void setProfitCenter(String profitCenter) {
	this.profitCenter = profitCenter;
    }
    

}
