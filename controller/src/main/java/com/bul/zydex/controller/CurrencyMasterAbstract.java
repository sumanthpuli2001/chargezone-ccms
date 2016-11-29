package com.bul.zydex.controller;


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
