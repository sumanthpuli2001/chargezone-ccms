/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author Hussain
 */
public class DisplaymorNotes implements java.io.Serializable {

    private Integer id;
    private String payrollNotes;

    public DisplaymorNotes() {
    }

    public DisplaymorNotes(Integer id, String payrollNotes) {
        this.id = id;
        this.payrollNotes = payrollNotes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPayrollNotes() {
        return payrollNotes;
    }

    public void setPayrollNotes(String payrollNotes) {
        this.payrollNotes = payrollNotes;
    }
    
}
