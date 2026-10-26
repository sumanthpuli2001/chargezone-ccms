/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.sap.system.model;

/**
 *
 * @author admin
 */
public class SapSystem implements Cloneable
{
    private final String name;
    private final String host;
    private final String client;
    private final String systemNumber;
    private final String user;
    private final String password;
    private final String language = "en";
    
    public SapSystem(final String name, final String host, final String client, final String systemNumber, final String user, final String password) {
        this.name = name;
        this.client = client;
        this.user = user;
        this.password = password;
        this.host = host;
        this.systemNumber = systemNumber;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getClient() {
        return this.client;
    }
    
    public String getUser() {
        return this.user;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public String getLanguage() {
        return "en";
    }
    
    public String getHost() {
        return this.host;
    }
    
    public String getSystemNumber() {
        return this.systemNumber;
    }
    
    @Override
    public String toString() {
        return "Client " + this.client + " User " + this.user + " PW " + this.password + " Language " + "en" + " Host " + this.host + " SysID " + this.systemNumber;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = 31 * result + ((this.client == null) ? 0 : this.client.hashCode());
        result = 31 * result + ((this.host == null) ? 0 : this.host.hashCode());
        result = 31 * result + (("en" == null) ? 0 : "en".hashCode());
        result = 31 * result + ((this.name == null) ? 0 : this.name.hashCode());
        result = 31 * result + ((this.password == null) ? 0 : this.password.hashCode());
        result = 31 * result + ((this.systemNumber == null) ? 0 : this.systemNumber.hashCode());
        result = 31 * result + ((this.user == null) ? 0 : this.user.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        final SapSystem other = (SapSystem)obj;
        if (this.client == null) {
            if (other.client != null) {
                return false;
            }
        }
        else if (!this.client.equals(other.client)) {
            return false;
        }
        if (this.host == null) {
            if (other.host != null) {
                return false;
            }
        }
        else if (!this.host.equals(other.host)) {
            return false;
        }
        if ("en" == null) {
            other.getClass();
            if ("en" != null) {
                return false;
            }
        }
        else {
            final String s = "en";
            other.getClass();
            if (!s.equals("en")) {
                return false;
            }
        }
        if (this.name == null) {
            if (other.name != null) {
                return false;
            }
        }
        else if (!this.name.equals(other.name)) {
            return false;
        }
        if (this.password == null) {
            if (other.password != null) {
                return false;
            }
        }
        else if (!this.password.equals(other.password)) {
            return false;
        }
        if (this.systemNumber == null) {
            if (other.systemNumber != null) {
                return false;
            }
        }
        else if (!this.systemNumber.equals(other.systemNumber)) {
            return false;
        }
        if (this.user == null) {
            if (other.user != null) {
                return false;
            }
        }
        else if (!this.user.equals(other.user)) {
            return false;
        }
        return true;
    }
    
    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
