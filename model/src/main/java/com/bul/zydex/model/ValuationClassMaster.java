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
public class ValuationClassMaster {

    private Integer id;
    private String valuationClass;
    private String description;

    public ValuationClassMaster() {
    }

    public ValuationClassMaster(Integer id, String valuationClass, String description) {
        this.id = id;
        this.valuationClass = valuationClass;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValuationClass() {
        return valuationClass;
    }

    public void setValuationClass(String valuationClass) {
        this.valuationClass = valuationClass;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    

}
