/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author BlackBull
 */
public class RegisterMobForPunch {

    private Integer id;
    private EmployeeMaster employeeMaster;
    private Integer imeiNo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EmployeeMaster getEmployeeMaster() {
        return employeeMaster;
    }

    public void setEmployeeMaster(EmployeeMaster employeeMaster) {
        this.employeeMaster = employeeMaster;
    }

    public Integer getImeiNo() {
        return imeiNo;
    }

    public void setImeiNo(Integer imeiNo) {
        this.imeiNo = imeiNo;
    }
    
    

}
