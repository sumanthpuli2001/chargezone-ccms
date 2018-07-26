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
import com.bul.zydex.model.EmployeePolicyDetail;
import com.bul.zydex.model.EmployeeSalaryProcess;
import com.bul.zydex.model.EmployeeSubType;
import com.bul.zydex.model.EmployeeTypeMaster;
import com.bul.zydex.model.EmployeeTypeWiseSalary;
import com.bul.zydex.model.PayrollAdditionalAmount;
import com.bul.zydex.model.PayrollDeduction;
import com.bul.zydex.model.PayrollFinancialYear;
import com.bul.zydex.model.PayrollFormSixteenMaster;
import com.bul.zydex.model.PayrollPfCheck;
import com.bul.zydex.model.PayrollProfessionalTax;
import com.bul.zydex.model.PayrollProvidentFund;
import com.bul.zydex.model.PayrollPtCheck;
import com.bul.zydex.model.PayrollRecurringAdditionalAmount;
import com.bul.zydex.model.PayrollRecurringDeduction;
import com.bul.zydex.model.PayrollSalaryType;
import com.bul.zydex.model.PayrollTaxDeductionComponent;
import com.bul.zydex.model.PayrollTaxDeductionMaster;
import com.bul.zydex.model.TaxDeductionDecarationSubmit;
import com.bul.zydex.model.TaxSavingSubmit;
import com.bul.zydex.model.ZydexLocationMaster;
import com.bul.zydex.service.EmployeePolicyDetail.EmployeePolicyDetailService;
import com.bul.zydex.service.Payroll.AdditionalAmountCheckService;
import com.bul.zydex.service.Payroll.EmployeeAdditionalSalaryService;
import com.bul.zydex.service.Payroll.EmployeeDeductionAmountService;
import com.bul.zydex.service.Payroll.EmployeeSalaryProcessService;
import com.bul.zydex.service.Payroll.EmployeeTypeWiseSalaryService;
import com.bul.zydex.service.Payroll.PayrollAdditionalAmountService;
import com.bul.zydex.service.Payroll.PayrollDeductionService;
import com.bul.zydex.service.Payroll.PayrollFinancialYearService;
import com.bul.zydex.service.Payroll.PayrollFormSixteenMasterService;
import com.bul.zydex.service.Payroll.PayrollPfCheckService;
import com.bul.zydex.service.Payroll.PayrollProfessionalTaxService;
import com.bul.zydex.service.Payroll.PayrollProvidentFundService;
import com.bul.zydex.service.Payroll.PayrollPtCheckService;
import com.bul.zydex.service.Payroll.PayrollRecurringAdditionalAmountService;
import com.bul.zydex.service.Payroll.PayrollRecurringDeductionService;
import com.bul.zydex.service.Payroll.PayrollSalaryTypeService;
import com.bul.zydex.service.Payroll.PayrollSavingAmountService;
import com.bul.zydex.service.Payroll.PayrollTaxDeductionComponentService;
import com.bul.zydex.service.Payroll.PayrollTaxDeductionMasterService;
import com.bul.zydex.service.Payroll.TaxDeductionDecarationSubmitService;
import com.bul.zydex.service.Payroll.TaxSavingSubmitService;
import com.bul.zydex.service.emp.EmployeeSubTypeService;
import com.bul.zydex.service.emp.EmployeeTypeService;
import com.bul.zydex.service.zydexLocation.ZydexLocationMasterService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public class PayrollEmployeeFormSixteenAbstract extends CustomAbstract {

    protected PayrollFormSixteenMasterService<PayrollFormSixteenMaster> payrollFormSixteenMasterService;
    protected PayrollFinancialYearService<PayrollFinancialYear> payrollFinancialYearService;
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
    protected ZydexLocationMasterService<ZydexLocationMaster> zydexLocationMasterService;
    protected PayrollSavingAmountService<ZydexLocationMaster> payrollSavingAmountService;
    protected PayrollTaxDeductionMasterService<PayrollTaxDeductionMaster> payrollTaxDeductionMasterService;
    protected PayrollTaxDeductionComponentService<PayrollTaxDeductionComponent> payrollTaxDeductionComponentService;
    protected TaxDeductionDecarationSubmitService<TaxDeductionDecarationSubmit> taxDeductionDecarationSubmitService;
    protected TaxSavingSubmitService<TaxSavingSubmit> taxSavingSubmitService;
    protected EmployeePolicyDetailService<EmployeePolicyDetail> employeePolicyDetailService;

    public EmployeePolicyDetailService<EmployeePolicyDetail> getEmployeePolicyDetailService() {
        return employeePolicyDetailService;
    }

    public void setEmployeePolicyDetailService(EmployeePolicyDetailService<EmployeePolicyDetail> employeePolicyDetailService) {
        this.employeePolicyDetailService = employeePolicyDetailService;
    }    

    public TaxDeductionDecarationSubmitService<TaxDeductionDecarationSubmit> getTaxDeductionDecarationSubmitService() {
        return taxDeductionDecarationSubmitService;
    }

    public void setTaxDeductionDecarationSubmitService(TaxDeductionDecarationSubmitService<TaxDeductionDecarationSubmit> taxDeductionDecarationSubmitService) {
        this.taxDeductionDecarationSubmitService = taxDeductionDecarationSubmitService;
    }
    
    public PayrollSavingAmountService<ZydexLocationMaster> getPayrollSavingAmountService() {
        return payrollSavingAmountService;
    }

    public void setPayrollSavingAmountService(PayrollSavingAmountService<ZydexLocationMaster> payrollSavingAmountService) {
        this.payrollSavingAmountService = payrollSavingAmountService;
    }

    public PayrollFormSixteenMasterService<PayrollFormSixteenMaster> getPayrollFormSixteenMasterService() {
        return payrollFormSixteenMasterService;
    }

    public void setPayrollFormSixteenMasterService(PayrollFormSixteenMasterService<PayrollFormSixteenMaster> payrollFormSixteenMasterService) {
        this.payrollFormSixteenMasterService = payrollFormSixteenMasterService;
    }

    public PayrollFinancialYearService<PayrollFinancialYear> getPayrollFinancialYearService() {
        return payrollFinancialYearService;
    }

    public void setPayrollFinancialYearService(PayrollFinancialYearService<PayrollFinancialYear> payrollFinancialYearService) {
        this.payrollFinancialYearService = payrollFinancialYearService;
    }

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

    public PayrollTaxDeductionMasterService<PayrollTaxDeductionMaster> getPayrollTaxDeductionMasterService() {
        return payrollTaxDeductionMasterService;
    }

    public void setPayrollTaxDeductionMasterService(PayrollTaxDeductionMasterService<PayrollTaxDeductionMaster> payrollTaxDeductionMasterService) {
        this.payrollTaxDeductionMasterService = payrollTaxDeductionMasterService;
    }

    public PayrollTaxDeductionComponentService<PayrollTaxDeductionComponent> getPayrollTaxDeductionComponentService() {
        return payrollTaxDeductionComponentService;
    }

    public void setPayrollTaxDeductionComponentService(PayrollTaxDeductionComponentService<PayrollTaxDeductionComponent> payrollTaxDeductionComponentService) {
        this.payrollTaxDeductionComponentService = payrollTaxDeductionComponentService;
    }

    public TaxSavingSubmitService<TaxSavingSubmit> getTaxSavingSubmitService() {
        return taxSavingSubmitService;
    }

    public void setTaxSavingSubmitService(TaxSavingSubmitService<TaxSavingSubmit> taxSavingSubmitService) {
        this.taxSavingSubmitService = taxSavingSubmitService;
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

    protected void financialYearList(HttpServletRequest request) {
        List<?> financialYearList = payrollFinancialYearService.read();
        Map<Integer, String> map = new HashMap();
        for (Object obj : financialYearList) {
            PayrollFinancialYear payrollFinancialYear = (PayrollFinancialYear) obj;
            map.put(payrollFinancialYear.getId(), payrollFinancialYear.getTitle());
        }
        request.setAttribute("financialYearList", map);
    }
}
