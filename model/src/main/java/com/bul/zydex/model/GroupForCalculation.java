/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author bulwarks-2
 */
public class GroupForCalculation {
    private Integer id;
    private String groupCalculation;

    public GroupForCalculation() {
    }

    public GroupForCalculation(Integer id, String groupCalculation) {
        this.id = id;
        this.groupCalculation = groupCalculation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupCalculation() {
        return groupCalculation;
    }

    public void setGroupCalculation(String groupCalculation) {
        this.groupCalculation = groupCalculation;
    }
    
}
