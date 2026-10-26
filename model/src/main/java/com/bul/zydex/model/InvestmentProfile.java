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
public class InvestmentProfile {
    private int id;
    private String investmentProfile;

    public InvestmentProfile() {
    }

    public InvestmentProfile(int id, String investmentProfile) {
        this.id = id;
        this.investmentProfile = investmentProfile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInvestmentProfile() {
        return investmentProfile;
    }

    public void setInvestmentProfile(String investmentProfile) {
        this.investmentProfile = investmentProfile;
    }
    
    
}
