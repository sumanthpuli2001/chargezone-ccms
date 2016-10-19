/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Position;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.EmployeeReferral;
import com.bul.zydex.model.PositionReferMaster;
import com.bul.zydex.service.Position.PositionReferMasterService;
import com.bul.zydex.service.empreferral.EmployeeReferralService;
import org.springframework.validation.Validator;

/**
 *
 * @author Irfan
 */
public class PositionReferMasterAbstract extends CustomAbstract{
    
    protected Validator positionReferMasterValidator;
    protected PositionReferMasterService<PositionReferMaster> positionReferMasterService;
    protected EmployeeReferralService<EmployeeReferral> employeeReferralService;

    public EmployeeReferralService<EmployeeReferral> getEmployeeReferralService() {
        return employeeReferralService;
    }

    public void setEmployeeReferralService(EmployeeReferralService<EmployeeReferral> employeeReferralService) {
        this.employeeReferralService = employeeReferralService;
    }

    public Validator getPositionReferMasterValidator() {
        return positionReferMasterValidator;
    }

    public void setPositionReferMasterValidator(Validator positionReferMasterValidator) {
        this.positionReferMasterValidator = positionReferMasterValidator;
    }

    public PositionReferMasterService<PositionReferMaster> getPositionReferMasterService() {
        return positionReferMasterService;
    }

    public void setPositionReferMasterService(PositionReferMasterService<PositionReferMaster> positionReferMasterService) {
        this.positionReferMasterService = positionReferMasterService;
    }

}
