/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.shift;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.MaxDayLateAllowed;
import com.bul.zydex.service.shift.MaxDayLateAllowedService;
import org.springframework.validation.Validator;

/**
 *
 * @author AJAY
 */
public class MaxDayLateAllowedAbstract extends CustomAbstract {

    protected MaxDayLateAllowedService<MaxDayLateAllowed> maxDayLateAllowedService;
    protected Validator maxDayLateAllowedValidator;

    public MaxDayLateAllowedService<MaxDayLateAllowed> getMaxDayLateAllowedService() {
        return maxDayLateAllowedService;
    }

    public void setMaxDayLateAllowedService(MaxDayLateAllowedService<MaxDayLateAllowed> maxDayLateAllowedService) {
        this.maxDayLateAllowedService = maxDayLateAllowedService;
    }

    public Validator getMaxDayLateAllowedValidator() {
        return maxDayLateAllowedValidator;
    }

    public void setMaxDayLateAllowedValidator(Validator maxDayLateAllowedValidator) {
        this.maxDayLateAllowedValidator = maxDayLateAllowedValidator;
    }

}
