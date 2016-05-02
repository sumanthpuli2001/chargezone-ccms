/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.leave;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.EmployeeLeaveBalance;
import com.bul.zydex.service.leave.EmployeeLeaveBalanceService;
import org.springframework.validation.Validator;

/**
 *
 * @author AJAY
 */
public abstract class EmployeeLeaveBalanceAbstract extends CustomAbstract {

    protected EmployeeLeaveBalanceService<EmployeeLeaveBalance> employeeLeaveBalanceService;
    protected Validator employeeLeaveBalanceValidator;

    public EmployeeLeaveBalanceService<EmployeeLeaveBalance> getEmployeeLeaveBalanceService() {
        return employeeLeaveBalanceService;
    }

    public void setEmployeeLeaveBalanceService(EmployeeLeaveBalanceService<EmployeeLeaveBalance> employeeLeaveBalanceService) {
        this.employeeLeaveBalanceService = employeeLeaveBalanceService;
    }

    public Validator getEmployeeLeaveBalanceValidator() {
        return employeeLeaveBalanceValidator;
    }

    public void setEmployeeLeaveBalanceValidator(Validator employeeLeaveBalanceValidator) {
        this.employeeLeaveBalanceValidator = employeeLeaveBalanceValidator;
    }

}
