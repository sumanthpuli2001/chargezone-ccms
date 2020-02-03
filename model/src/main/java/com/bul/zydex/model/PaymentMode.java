/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author admin
 */
public class PaymentMode {
   
     private Integer id;
     private String amountTo;
     private String amountFrom;
     private String charges;
     private String applicableTaxes;
     private String modeOfPayment;

    public PaymentMode(Integer id, String amountTo, String amountFrom, String charges, String applicableTaxes, String modeOfPayment) {
        this.id = id;
        this.amountTo = amountTo;
        this.amountFrom = amountFrom;
        this.charges = charges;
        this.applicableTaxes = applicableTaxes;
        this.modeOfPayment = modeOfPayment;
    }

    public PaymentMode() {
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAmountTo() {
        return amountTo;
    }

    public void setAmountTo(String amountTo) {
        this.amountTo = amountTo;
    }

    public String getAmountFrom() {
        return amountFrom;
    }

    public void setAmountFrom(String amountFrom) {
        this.amountFrom = amountFrom;
    }

    public String getCharges() {
        return charges;
    }

    public void setCharges(String charges) {
        this.charges = charges;
    }

    public String getApplicableTaxes() {
        return applicableTaxes;
    }

    public void setApplicableTaxes(String applicableTaxes) {
        this.applicableTaxes = applicableTaxes;
    }

    public String getModeOfPayment() {
        return modeOfPayment;
    }

    public void setModeOfPayment(String modeOfPayment) {
        this.modeOfPayment = modeOfPayment;
    }
}
