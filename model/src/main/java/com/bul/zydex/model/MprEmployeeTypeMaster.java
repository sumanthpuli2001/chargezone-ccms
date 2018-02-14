/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author Vikas
 */
public class MprEmployeeTypeMaster implements java.io.Serializable {

    private Integer id;
    private String employeeType;

    public MprEmployeeTypeMaster() {

    }

    public MprEmployeeTypeMaster(String employeeType) {
        this.employeeType = employeeType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

}
