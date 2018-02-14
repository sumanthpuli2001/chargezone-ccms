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
public class MprEmployeeCategory implements java.io.Serializable {

    private Integer id;
    private String employeeCategory;

    public MprEmployeeCategory() {
    }

    public MprEmployeeCategory(String employeeCategory) {
        this.employeeCategory = employeeCategory;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmployeeCategory() {
        return employeeCategory;
    }

    public void setEmployeeCategory(String employeeCategory) {
        this.employeeCategory = employeeCategory;
    }

}
