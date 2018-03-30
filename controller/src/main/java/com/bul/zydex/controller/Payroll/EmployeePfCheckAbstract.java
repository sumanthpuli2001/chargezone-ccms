/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.AdditionalAmountCheck;
import com.bul.zydex.model.EmployeeAdditionalSalary;
import com.bul.zydex.model.EmployeeDeductionAmount;
import com.bul.zydex.model.EmployeeSalaryProcess;
import com.bul.zydex.model.EmployeeSubType;
import com.bul.zydex.model.EmployeeTypeMaster;
import com.bul.zydex.model.EmployeeTypeWiseSalary;
import com.bul.zydex.model.PayrollAdditionalAmount;
import com.bul.zydex.model.PayrollDeduction;
import com.bul.zydex.model.PayrollPfCheck;
import com.bul.zydex.model.PayrollProfessionalTax;
import com.bul.zydex.model.PayrollProvidentFund;
import com.bul.zydex.model.PayrollPtCheck;
import com.bul.zydex.model.PayrollRecurringAdditionalAmount;
import com.bul.zydex.model.PayrollRecurringDeduction;
import com.bul.zydex.model.PayrollSalaryType;
import com.bul.zydex.model.RetirementAge;
import com.bul.zydex.service.Payroll.AdditionalAmountCheckService;
import com.bul.zydex.service.Payroll.EmployeeAdditionalSalaryService;
import com.bul.zydex.service.Payroll.EmployeeDeductionAmountService;
import com.bul.zydex.service.Payroll.EmployeeSalaryProcessService;
import com.bul.zydex.service.Payroll.EmployeeTypeWiseSalaryService;
import com.bul.zydex.service.Payroll.PayrollAdditionalAmountService;
import com.bul.zydex.service.Payroll.PayrollDeductionService;
import com.bul.zydex.service.Payroll.PayrollPfCheckService;
import com.bul.zydex.service.Payroll.PayrollProfessionalTaxService;
import com.bul.zydex.service.Payroll.PayrollProvidentFundService;
import com.bul.zydex.service.Payroll.PayrollPtCheckService;
import com.bul.zydex.service.Payroll.PayrollRecurringAdditionalAmountService;
import com.bul.zydex.service.Payroll.PayrollRecurringDeductionService;
import com.bul.zydex.service.Payroll.PayrollSalaryTypeService;
import com.bul.zydex.service.Payroll.RetirementAgeService;
import com.bul.zydex.service.emp.EmployeeSubTypeService;
import com.bul.zydex.service.emp.EmployeeTypeService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public class EmployeePfCheckAbstract  extends CustomAbstract{
    protected EmployeeSalaryProcessService<EmployeeSalaryProcess> employeeSalaryProcessService;
    protected EmployeeTypeService<EmployeeTypeMaster> employeeTypeService;
    protected EmployeeSubTypeService<EmployeeSubType> employeeSubTypeService;
    protected EmployeeAdditionalSalaryService<EmployeeAdditionalSalary> employeeAdditionalSalaryService;
    protected EmployeeDeductionAmountService<EmployeeDeductionAmount> employeeDeductionAmountService;
    protected PayrollAdditionalAmountService<PayrollAdditionalAmount> payrollAdditionalAmountService;
    protected EmployeeTypeWiseSalaryService<EmployeeTypeWiseSalary> employeeTypeWiseSalaryService;
    protected PayrollSalaryTypeService<PayrollSalaryType> payrollSalaryTypeService;
    protected AdditionalAmountCheckService<AdditionalAmountCheck> additionalAmountCheckService;
    protected PayrollRecurringAdditionalAmountService<PayrollRecurringAdditionalAmount> payrollRecurringAdditionalAmountService;
    protected PayrollDeductionService<PayrollDeduction> payrollDeductionService;
    protected PayrollRecurringDeductionService<PayrollRecurringDeduction> payrollRecurringDeductionService;
    protected PayrollPtCheckService<PayrollPtCheck> payrollPtCheckService;
    protected PayrollProfessionalTaxService<PayrollProfessionalTax> payrollProfessionalTaxService;
    protected PayrollPfCheckService<PayrollPfCheck> payrollPfCheckService;
    protected PayrollProvidentFundService<PayrollProvidentFund> payrollProvidentFundService;
    protected RetirementAgeService<RetirementAge> retirementAgeService;

    public EmployeeSalaryProcessService<EmployeeSalaryProcess> getEmployeeSalaryProcessService() {
        return employeeSalaryProcessService;
    }

    public void setEmployeeSalaryProcessService(EmployeeSalaryProcessService<EmployeeSalaryProcess> employeeSalaryProcessService) {
        this.employeeSalaryProcessService = employeeSalaryProcessService;
    }

    public EmployeeTypeService<EmployeeTypeMaster> getEmployeeTypeService() {
        return employeeTypeService;
    }

    public void setEmployeeTypeService(EmployeeTypeService<EmployeeTypeMaster> employeeTypeService) {
        this.employeeTypeService = employeeTypeService;
    }

    public EmployeeSubTypeService<EmployeeSubType> getEmployeeSubTypeService() {
        return employeeSubTypeService;
    }

    public void setEmployeeSubTypeService(EmployeeSubTypeService<EmployeeSubType> employeeSubTypeService) {
        this.employeeSubTypeService = employeeSubTypeService;
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

    public PayrollAdditionalAmountService<PayrollAdditionalAmount> getPayrollAdditionalAmountService() {
        return payrollAdditionalAmountService;
    }

    public void setPayrollAdditionalAmountService(PayrollAdditionalAmountService<PayrollAdditionalAmount> payrollAdditionalAmountService) {
        this.payrollAdditionalAmountService = payrollAdditionalAmountService;
    }

    public EmployeeTypeWiseSalaryService<EmployeeTypeWiseSalary> getEmployeeTypeWiseSalaryService() {
        return employeeTypeWiseSalaryService;
    }

    public void setEmployeeTypeWiseSalaryService(EmployeeTypeWiseSalaryService<EmployeeTypeWiseSalary> employeeTypeWiseSalaryService) {
        this.employeeTypeWiseSalaryService = employeeTypeWiseSalaryService;
    }

    public PayrollSalaryTypeService<PayrollSalaryType> getPayrollSalaryTypeService() {
        return payrollSalaryTypeService;
    }

    public void setPayrollSalaryTypeService(PayrollSalaryTypeService<PayrollSalaryType> payrollSalaryTypeService) {
        this.payrollSalaryTypeService = payrollSalaryTypeService;
    }

    public AdditionalAmountCheckService<AdditionalAmountCheck> getAdditionalAmountCheckService() {
        return additionalAmountCheckService;
    }

    public void setAdditionalAmountCheckService(AdditionalAmountCheckService<AdditionalAmountCheck> additionalAmountCheckService) {
        this.additionalAmountCheckService = additionalAmountCheckService;
    }

    public PayrollRecurringAdditionalAmountService<PayrollRecurringAdditionalAmount> getPayrollRecurringAdditionalAmountService() {
        return payrollRecurringAdditionalAmountService;
    }

    public void setPayrollRecurringAdditionalAmountService(PayrollRecurringAdditionalAmountService<PayrollRecurringAdditionalAmount> payrollRecurringAdditionalAmountService) {
        this.payrollRecurringAdditionalAmountService = payrollRecurringAdditionalAmountService;
    }

    public PayrollDeductionService<PayrollDeduction> getPayrollDeductionService() {
        return payrollDeductionService;
    }

    public void setPayrollDeductionService(PayrollDeductionService<PayrollDeduction> payrollDeductionService) {
        this.payrollDeductionService = payrollDeductionService;
    }

    public PayrollRecurringDeductionService<PayrollRecurringDeduction> getPayrollRecurringDeductionService() {
        return payrollRecurringDeductionService;
    }

    public void setPayrollRecurringDeductionService(PayrollRecurringDeductionService<PayrollRecurringDeduction> payrollRecurringDeductionService) {
        this.payrollRecurringDeductionService = payrollRecurringDeductionService;
    }

    public PayrollPtCheckService<PayrollPtCheck> getPayrollPtCheckService() {
        return payrollPtCheckService;
    }

    public void setPayrollPtCheckService(PayrollPtCheckService<PayrollPtCheck> payrollPtCheckService) {
        this.payrollPtCheckService = payrollPtCheckService;
    }

    public PayrollProfessionalTaxService<PayrollProfessionalTax> getPayrollProfessionalTaxService() {
        return payrollProfessionalTaxService;
    }

    public void setPayrollProfessionalTaxService(PayrollProfessionalTaxService<PayrollProfessionalTax> payrollProfessionalTaxService) {
        this.payrollProfessionalTaxService = payrollProfessionalTaxService;
    }

    public PayrollPfCheckService<PayrollPfCheck> getPayrollPfCheckService() {
        return payrollPfCheckService;
    }

    public void setPayrollPfCheckService(PayrollPfCheckService<PayrollPfCheck> payrollPfCheckService) {
        this.payrollPfCheckService = payrollPfCheckService;
    }

    public PayrollProvidentFundService<PayrollProvidentFund> getPayrollProvidentFundService() {
        return payrollProvidentFundService;
    }

    public void setPayrollProvidentFundService(PayrollProvidentFundService<PayrollProvidentFund> payrollProvidentFundService) {
        this.payrollProvidentFundService = payrollProvidentFundService;
    }

    public RetirementAgeService<RetirementAge> getRetirementAgeService() {
        return retirementAgeService;
    }

    public void setRetirementAgeService(RetirementAgeService<RetirementAge> retirementAgeService) {
        this.retirementAgeService = retirementAgeService;
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
    
}
