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
public class PolicyDropDown implements java.io.Serializable{
    
    private Integer id;
    private String name;
    
    public PolicyDropDown(){
        
    }

    public PolicyDropDown(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    

}
