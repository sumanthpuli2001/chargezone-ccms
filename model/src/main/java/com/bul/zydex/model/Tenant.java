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
public class Tenant {

    private int id;
    private String tenant;

    public Tenant() {
    }

    public Tenant(int id, String tenant) {
	this.id = id;
	this.tenant = tenant;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getTenant() {
	return tenant;
    }

    public void setTenant(String tenant) {
	this.tenant = tenant;
    }

}
