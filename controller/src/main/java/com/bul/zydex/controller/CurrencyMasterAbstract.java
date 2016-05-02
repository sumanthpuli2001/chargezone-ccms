/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller;

import com.bul.zydex.model.CurrencyMaster;
import com.bul.zydex.service.CurrencyMasterService;
import org.springframework.validation.Validator;

/**
 *
 * @author AJAY
 */
public class CurrencyMasterAbstract extends CustomAbstract {

    protected Validator currencyMasterValidator;

    public Validator getCurrencyMasterValidator() {
        return currencyMasterValidator;
    }

    public void setCurrencyMasterValidator(Validator currencyMasterValidator) {
        this.currencyMasterValidator = currencyMasterValidator;
    }

}
