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
public class ConnectionType {

    private int id;
    private String connectionType;

    public ConnectionType() {
    }

    public ConnectionType(int id, String connectionType) {
	this.id = id;
	this.connectionType = connectionType;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getConnectionType() {
	return connectionType;
    }

    public void setConnectionType(String connectionType) {
	this.connectionType = connectionType;
    }

    
    
    
}
