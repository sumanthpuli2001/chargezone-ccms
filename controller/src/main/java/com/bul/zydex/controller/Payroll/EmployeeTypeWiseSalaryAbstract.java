/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.EmployeeMultipleSalary;
import com.bul.zydex.model.EmployeeSubType;
import com.bul.zydex.model.EmployeeTypeMaster;
import com.bul.zydex.model.EmployeeTypeWiseSalary;
import com.bul.zydex.model.PayrollSalaryType;
import com.bul.zydex.service.Payroll.EmployeeMultipleSalaryService;
import com.bul.zydex.service.Payroll.EmployeeTypeWiseSalaryService;
import com.bul.zydex.service.Payroll.PayrollSalaryTypeService;
import com.bul.zydex.service.emp.EmployeeSubTypeService;
import com.bul.zydex.service.emp.EmployeeTypeService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.Validator;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public abstract class EmployeeTypeWiseSalaryAbstract extends CustomAbstract{
      protected PayrollSalaryTypeService<PayrollSalaryType> payrollSalaryTypeService;
      protected EmployeeSubTypeService<EmployeeSubType> employeeSubTypeService;
      protected EmployeeTypeService<EmployeeTypeMaster> employeeTypeService;
      protected EmployeeTypeWiseSalaryService<EmployeeTypeWiseSalary> employeeTypeWiseSalaryService;
      protected EmployeeMultipleSalaryService<EmployeeMultipleSalary> employeeMultipleSalaryService;
      protected Validator employeeTypeWiseSalaryValidator;

    public PayrollSalaryTypeService<PayrollSalaryType> getPayrollSalaryTypeService() {
        return payrollSalaryTypeService;
    }

    public void setPayrollSalaryTypeService(PayrollSalaryTypeService<PayrollSalaryType> payrollSalaryTypeService) {
        this.payrollSalaryTypeService = payrollSalaryTypeService;
    }

    public EmployeeSubTypeService<EmployeeSubType> getEmployeeSubTypeService() {
        return employeeSubTypeService;
    }

    public void setEmployeeSubTypeService(EmployeeSubTypeService<EmployeeSubType> employeeSubTypeService) {
        this.employeeSubTypeService = employeeSubTypeService;
    }

    public EmployeeTypeService<EmployeeTypeMaster> getEmployeeTypeService() {
        return employeeTypeService;
    }

    public void setEmployeeTypeService(EmployeeTypeService<EmployeeTypeMaster> employeeTypeService) {
        this.employeeTypeService = employeeTypeService;
    }

    public EmployeeTypeWiseSalaryService<EmployeeTypeWiseSalary> getEmployeeTypeWiseSalaryService() {
        return employeeTypeWiseSalaryService;
    }

    public void setEmployeeTypeWiseSalaryService(EmployeeTypeWiseSalaryService<EmployeeTypeWiseSalary> employeeTypeWiseSalaryService) {
        this.employeeTypeWiseSalaryService = employeeTypeWiseSalaryService;
    }

    public EmployeeMultipleSalaryService<EmployeeMultipleSalary> getEmployeeMultipleSalaryService() {
        return employeeMultipleSalaryService;
    }

    public void setEmployeeMultipleSalaryService(EmployeeMultipleSalaryService<EmployeeMultipleSalary> employeeMultipleSalaryService) {
        this.employeeMultipleSalaryService = employeeMultipleSalaryService;
    }

    public Validator getEmployeeTypeWiseSalaryValidator() {
        return employeeTypeWiseSalaryValidator;
    }

    public void setEmployeeTypeWiseSalaryValidator(Validator employeeTypeWiseSalaryValidator) {
        this.employeeTypeWiseSalaryValidator = employeeTypeWiseSalaryValidator;
    }
protected void EmployeeTypeList(HttpServletRequest request) {
        List<?> EmployeeTypeList = employeeTypeService.read();
        Map<Integer, String> map = new HashMap();
        for (Object obj : EmployeeTypeList) {
            EmployeeTypeMaster employeeTypeMaster = (EmployeeTypeMaster) obj;
            map.put(employeeTypeMaster.getId(), employeeTypeMaster.getTypeOfEmployee());
        }
        request.setAttribute("EmployeeTypeList", map);
    }
     
     protected void EmployeeSubTypeList(HttpServletRequest request) {
        List<?> EmployeeSubTypeList = employeeSubTypeService.read();
        Map<Integer, String> map = new HashMap();
        for (Object obj : EmployeeSubTypeList) {
            EmployeeSubType employeeSubType = (EmployeeSubType) obj;
            map.put(employeeSubType.getId(), employeeSubType.getSubType());
        }
        request.setAttribute("EmployeeSubTypeList", map);
    }
   protected void PayrollSalaryTypeList(HttpServletRequest request) {
        List<?> PayrollSalaryTypeList = payrollSalaryTypeService.read();
        Map<Integer, String> map = new HashMap();
        for (Object obj : PayrollSalaryTypeList) {
            PayrollSalaryType payrollSalaryType = (PayrollSalaryType) obj;
            map.put(payrollSalaryType.getId(), payrollSalaryType.getText());
        }
        request.setAttribute("PayrollSalaryTypeList", map);
    }
   
}
