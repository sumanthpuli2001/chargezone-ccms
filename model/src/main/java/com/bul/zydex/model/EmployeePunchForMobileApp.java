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
public class EmployeePunchForMobileApp implements java.io.Serializable {
      private int id;
     private EmployeeMaster employeeMaster;
     private String punchTime;
     private String punchLocation;
     public EmployeePunchForMobileApp(){
     }

    public EmployeePunchForMobileApp(int id) {
        this.id = id;
    }
    
      public EmployeePunchForMobileApp(int id,EmployeeMaster employeeMaster,String punchTime,String punchLocation) {
        this.id = id;
        this.employeeMaster = employeeMaster;
        this.punchTime = punchTime;
        this.punchLocation=punchLocation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EmployeeMaster getEmployeeMaster() {
        return employeeMaster;
    }

    public void setEmployeeMaster(EmployeeMaster employeeMaster) {
        this.employeeMaster = employeeMaster;
    }

    public String getPunchTime() {
        return punchTime;
    }

    public void setPunchTime(String punchTime) {
        this.punchTime = punchTime;
    }

    public String getPunchLocation() {
        return punchLocation;
    }

    public void setPunchLocation(String punchLocation) {
        this.punchLocation = punchLocation;
    }
      
     
    
}
