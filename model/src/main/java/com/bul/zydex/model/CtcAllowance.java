/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Hussain
 */
public class CtcAllowance implements java.io.Serializable {

    private Integer id;
    private String ctcName;
    private Set employeeCtcDetail = new HashSet(0);

    public CtcAllowance() {
    }

    public CtcAllowance(Integer id, String ctcName) {
        this.id = id;
        this.ctcName = ctcName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCtcName() {
        return ctcName;
    }

    public void setCtcName(String ctcName) {
        this.ctcName = ctcName;
    }

    public Set getEmployeeCtcDetail() {
        return employeeCtcDetail;
    }

    public void setEmployeeCtcDetail(Set employeeCtcDetail) {
        this.employeeCtcDetail = employeeCtcDetail;
    }
    

}
