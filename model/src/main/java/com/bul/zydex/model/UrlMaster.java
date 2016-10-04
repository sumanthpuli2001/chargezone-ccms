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
public class UrlMaster {
    private Integer id;
    private String ipAddress;
    private Integer portNumber;
    
    public UrlMaster(){
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

   

    public Integer getPortNumber() {
        return portNumber;
    }

    public void setPortNumber(Integer portNumber) {
        this.portNumber = portNumber;
    }
    
      public UrlMaster(int id,String ipAddress,int portNumber) {
       this.id = id;
       this.ipAddress = ipAddress;
       this.portNumber = portNumber;
     
    }
}
