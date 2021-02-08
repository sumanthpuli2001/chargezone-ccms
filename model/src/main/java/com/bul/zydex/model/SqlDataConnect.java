/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author jaimini.parmar
 */
public class SqlDataConnect {

    private int id;
    private String connectString;

    public SqlDataConnect() {
    }

    public SqlDataConnect(int id, String connectString) {
        this.id = id;
        this.connectString = connectString;
    }

    public int getId() {
        return id;
    }

    public SqlDataConnect setId(int id) {
        this.id = id;
        return this;
    }

    public String getConnectString() {
        return connectString;
    }

    public SqlDataConnect setConnectString(String connectString) {
        this.connectString = connectString;
        return this;
    }
}
