/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.EmployeeAdditionalSalary;
import com.bul.zydex.model.EmployeeDeductionAmount;
import com.bul.zydex.model.EmployeePolicyDetail;
import com.bul.zydex.model.EmployeeSalaryProcess;
import com.bul.zydex.model.PayrollSalaryType;
import com.bul.zydex.service.EmployeePolicyDetail.EmployeePolicyDetailService;
import com.bul.zydex.service.Payroll.EmployeeAdditionalSalaryService;
import com.bul.zydex.service.Payroll.EmployeeDeductionAmountService;
import com.bul.zydex.service.Payroll.EmployeeSalaryProcessService;
import com.bul.zydex.service.Payroll.PayrollSalaryTypeService;

/**
 *
 * @author OptiPlex
 */
public abstract class CompanyMonthlyReportAbstract extends CustomAbstract {

    protected EmployeeSalaryProcessService<EmployeeSalaryProcess> employeeSalaryProcessService;
    protected EmployeeAdditionalSalaryService<EmployeeAdditionalSalary> employeeAdditionalSalaryService;
    protected EmployeeDeductionAmountService<EmployeeDeductionAmount> employeeDeductionAmountService;
    protected EmployeePolicyDetailService<EmployeePolicyDetail> employeePolicyDetailService;
    protected PayrollSalaryTypeService<PayrollSalaryType> payrollSalaryTypeService;

    public EmployeeSalaryProcessService<EmployeeSalaryProcess> getEmployeeSalaryProcessService() {
        return employeeSalaryProcessService;
    }

    public void setEmployeeSalaryProcessService(EmployeeSalaryProcessService<EmployeeSalaryProcess> employeeSalaryProcessService) {
        this.employeeSalaryProcessService = employeeSalaryProcessService;
    }

    public EmployeeAdditionalSalaryService<EmployeeAdditionalSalary> getEmployeeAdditionalSalaryService() {
        return employeeAdditionalSalaryService;
    }

    public void setEmployeeAdditionalSalaryService(EmployeeAdditionalSalaryService<EmployeeAdditionalSalary> employeeAdditionalSalaryService) {
        this.employeeAdditionalSalaryService = employeeAdditionalSalaryService;
    }

    public EmployeeDeductionAmountService<EmployeeDeductionAmount> getEmployeeDeductionAmountService() {
        return employeeDeductionAmountService;
    }

    public void setEmployeeDeductionAmountService(EmployeeDeductionAmountService<EmployeeDeductionAmount> employeeDeductionAmountService) {
        this.employeeDeductionAmountService = employeeDeductionAmountService;
    }

    public EmployeePolicyDetailService<EmployeePolicyDetail> getEmployeePolicyDetailService() {
        return employeePolicyDetailService;
    }

    public void setEmployeePolicyDetailService(EmployeePolicyDetailService<EmployeePolicyDetail> employeePolicyDetailService) {
        this.employeePolicyDetailService = employeePolicyDetailService;
    }

    public PayrollSalaryTypeService<PayrollSalaryType> getPayrollSalaryTypeService() {
        return payrollSalaryTypeService;
    }

    public void setPayrollSalaryTypeService(PayrollSalaryTypeService<PayrollSalaryType> payrollSalaryTypeService) {
        this.payrollSalaryTypeService = payrollSalaryTypeService;
    }
}
