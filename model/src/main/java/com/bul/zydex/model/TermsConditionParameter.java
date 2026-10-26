/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author Admin
 */
public class TermsConditionParameter {
    
    private int id;
    private TermsCondition termsCondition;
    private String name;
    private String description;

    public TermsConditionParameter() {
    }

    public TermsConditionParameter(int id, TermsCondition termsCondition, String name, String description) {
        this.id = id;
        this.termsCondition = termsCondition;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TermsCondition getTermsCondition() {
        return termsCondition;
    }

    public void setTermsCondition(TermsCondition termsCondition) {
        this.termsCondition = termsCondition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    

   
}
