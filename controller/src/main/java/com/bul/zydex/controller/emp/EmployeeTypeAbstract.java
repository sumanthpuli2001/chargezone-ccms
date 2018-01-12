/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.emp;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.EmployeeType;
import com.bul.zydex.model.EmployeeTypeMaster;
import com.bul.zydex.service.emp.EmployeeTypeService;
import com.bul.zydex.validator.emp.EmployeeTypeValidator;
import org.springframework.validation.Validator;

/**
 *
 * @author Nishant
 */
public abstract class EmployeeTypeAbstract extends CustomAbstract {

    protected EmployeeTypeService<EmployeeTypeMaster> employeeTypeService;
    protected Validator employeeTypeValidator;

    public EmployeeTypeService<EmployeeTypeMaster> getEmployeeTypeService() {
        return employeeTypeService;
    }

    public void setEmployeeTypeService(EmployeeTypeService<EmployeeTypeMaster> employeeTypeService) {
        this.employeeTypeService = employeeTypeService;
    }

    public Validator getEmployeeTypeValidator() {
        return employeeTypeValidator;
    }

    public void setEmployeeTypeValidator(Validator employeeTypeValidator) {
        this.employeeTypeValidator = employeeTypeValidator;
    }

}
