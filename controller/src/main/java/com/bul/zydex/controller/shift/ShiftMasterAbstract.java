/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.shift;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.EmployeeDatetimeData;
import com.bul.zydex.model.ShiftMaster;
import com.bul.zydex.service.shift.EmployeeDatetimeDataService;
import com.bul.zydex.service.shift.ShiftMasterService;
import org.springframework.validation.Validator;

/**
 *
 * @author AJAY
 */
public class ShiftMasterAbstract extends CustomAbstract {

    protected ShiftMasterService<ShiftMaster> shiftMasterService;
    protected EmployeeDatetimeDataService<EmployeeDatetimeData> employeeDatetimeDataService;
    protected Validator shiftMasterValidator;

    public ShiftMasterService<ShiftMaster> getShiftMasterService() {
        return shiftMasterService;
    }

    public void setShiftMasterService(ShiftMasterService<ShiftMaster> shiftMasterService) {
        this.shiftMasterService = shiftMasterService;
    }

    public Validator getShiftMasterValidator() {
        return shiftMasterValidator;
    }

    public void setShiftMasterValidator(Validator shiftMasterValidator) {
        this.shiftMasterValidator = shiftMasterValidator;
    }

    public EmployeeDatetimeDataService<EmployeeDatetimeData> getEmployeeDatetimeDataService() {
        return employeeDatetimeDataService;
    }

    public void setEmployeeDatetimeDataService(EmployeeDatetimeDataService<EmployeeDatetimeData> employeeDatetimeDataService) {
        this.employeeDatetimeDataService = employeeDatetimeDataService;
    }
    
    

}
