/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author Bulwark-5
 */
public class DepartmentMaster {
    
    private int id;
    private String departmentName;

    public DepartmentMaster() {
    }

    public DepartmentMaster(int id, String departmentName) {
        this.id = id;
        this.departmentName = departmentName;
    }

    public int getId() {
        return id;
    }

    public DepartmentMaster setId(int id) {
        this.id = id;
        return this;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public DepartmentMaster setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
        return this;
    }
    
    
    
}
