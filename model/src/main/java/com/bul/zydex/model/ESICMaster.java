/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bul.zydex.model;

/**
 *
 * @author Rishi
 */
public class ESICMaster implements java.io.Serializable{
    
      private Integer id;
      private String bankName;
      private String companyName;
      private String address;
      private String employeeCodeNo;

    public ESICMaster() {
    }

    public ESICMaster(Integer id, String bankName, String companyName, String address, String employeeCodeNo) {
        this.id = id;
        this.bankName = bankName;
        this.companyName = companyName;
        this.address = address;
        this.employeeCodeNo = employeeCodeNo;
    }

    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmployeeCodeNo() {
        return employeeCodeNo;
    }

    public void setEmployeeCodeNo(String employeeCodeNo) {
        this.employeeCodeNo = employeeCodeNo;
    }



      
      
      
    
}