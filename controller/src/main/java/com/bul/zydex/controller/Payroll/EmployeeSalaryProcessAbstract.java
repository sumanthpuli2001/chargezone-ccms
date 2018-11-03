/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.AdditionalAmountCheck;
import com.bul.zydex.model.Company;
import com.bul.zydex.model.CtcAllowance;
import com.bul.zydex.model.EmployeeAdditionalSalary;
import com.bul.zydex.model.EmployeeCtcDetail;
import com.bul.zydex.model.EmployeeCtcDetailSalary;
import com.bul.zydex.model.EmployeeDatetimeData;
import com.bul.zydex.model.EmployeeDeductionAmount;
import com.bul.zydex.model.EmployeeExcelRecord;
import com.bul.zydex.model.EmployeePolicyDetail;
import com.bul.zydex.model.EmployeeSalaryProcess;
import com.bul.zydex.model.EmployeeShiftData;
import com.bul.zydex.model.EmployeeSubType;
import com.bul.zydex.model.EmployeeTypeMaster;
import com.bul.zydex.model.EmployeeTypeWiseSalary;
import com.bul.zydex.model.LocationMaster;
import com.bul.zydex.model.PayrollAdditionalAmount;
import com.bul.zydex.model.PayrollBonus;
import com.bul.zydex.model.PayrollDeduction;
import com.bul.zydex.model.PayrollEsicDeduction;
import com.bul.zydex.model.PayrollFinancialYear;
import com.bul.zydex.model.PayrollLoanDetail;
import com.bul.zydex.model.PayrollLoanRemainingAmount;
import com.bul.zydex.model.PayrollLoanType;
import com.bul.zydex.model.PayrollPfCheck;
import com.bul.zydex.model.PayrollPfRecord;
import com.bul.zydex.model.PayrollProfessionalTax;
import com.bul.zydex.model.PayrollProvidentFund;
import com.bul.zydex.model.PayrollPtCheck;
import com.bul.zydex.model.PayrollRecurringAdditionalAmount;
import com.bul.zydex.model.PayrollRecurringDeduction;
import com.bul.zydex.model.PayrollSalaryLock;
import com.bul.zydex.model.PayrollSalaryType;
import com.bul.zydex.model.PayrollTaxDeclarationPeriodMaster;
import com.bul.zydex.model.PayrollTaxDeductionComponent;
import com.bul.zydex.model.PayrollTaxDeductionMaster;
import com.bul.zydex.model.PayrollTaxRateMaster;
import com.bul.zydex.model.PolicyMaster;
import com.bul.zydex.model.RetirementAge;
import com.bul.zydex.model.TaxDeductionDecarationSubmit;
import com.bul.zydex.model.TaxSavingSubmit;
import com.bul.zydex.service.EmployeeCtcDetailSalary.EmployeeCtcDetailSalaryService;
import com.bul.zydex.service.EmployeePolicyDetail.EmployeePolicyDetailService;
import com.bul.zydex.service.Payroll.AdditionalAmountCheckService;
import com.bul.zydex.service.Payroll.EmployeeAdditionalSalaryService;
import com.bul.zydex.service.Payroll.EmployeeDeductionAmountService;
import com.bul.zydex.service.Payroll.EmployeeExcelRecordService;
import com.bul.zydex.service.Payroll.EmployeeSalaryProcessService;
import com.bul.zydex.service.Payroll.EmployeeTypeWiseSalaryService;
import com.bul.zydex.service.Payroll.PayrollAdditionalAmountService;
import com.bul.zydex.service.Payroll.PayrollBonusService;
import com.bul.zydex.service.Payroll.PayrollDeductionService;
import com.bul.zydex.service.Payroll.PayrollEsicDeductionService;
import com.bul.zydex.service.Payroll.PayrollFinancialYearService;
import com.bul.zydex.service.Payroll.PayrollLoanDetailService;
import com.bul.zydex.service.Payroll.PayrollLoanRemainingAmountService;
import com.bul.zydex.service.Payroll.PayrollLoanTypeService;
import com.bul.zydex.service.Payroll.PayrollPfCheckService;
import com.bul.zydex.service.Payroll.PayrollPfRecordService;
import com.bul.zydex.service.Payroll.PayrollProfessionalTaxService;
import com.bul.zydex.service.Payroll.PayrollProvidentFundService;
import com.bul.zydex.service.Payroll.PayrollPtCheckService;
import com.bul.zydex.service.Payroll.PayrollRecurringAdditionalAmountService;
import com.bul.zydex.service.Payroll.PayrollRecurringDeductionService;
import com.bul.zydex.service.Payroll.PayrollSalaryLockService;
import com.bul.zydex.service.Payroll.PayrollSalaryTypeService;
import com.bul.zydex.service.Payroll.PayrollTaxDeclarationPeriodMasterService;
import com.bul.zydex.service.Payroll.PayrollTaxDeductionComponentService;
import com.bul.zydex.service.Payroll.PayrollTaxDeductionMasterService;
import com.bul.zydex.service.Payroll.PayrollTaxRateMasterService;
import com.bul.zydex.service.Payroll.RetirementAgeService;
import com.bul.zydex.service.Payroll.TaxDeductionDecarationSubmitService;
import com.bul.zydex.service.Payroll.TaxSavingSubmitService;
import com.bul.zydex.service.company.CompanyMasterService;
import com.bul.zydex.service.emp.EmployeeSubTypeService;
import com.bul.zydex.service.emp.EmployeeTypeService;
import com.bul.zydex.service.location.LocationMasterService;
import com.bul.zydex.service.policy.CtcAllowanceService;
import com.bul.zydex.service.policy.EmployeeCtcDetailService;
import com.bul.zydex.service.policy.PolicyMasterService;
import com.bul.zydex.service.shift.EmployeeDatetimeDataService;
import com.bul.zydex.service.shift.EmployeeShiftDataService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.Validator;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public class EmployeeSalaryProcessAbstract extends CustomAbstract {

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
    protected PayrollSalaryLockService<PayrollSalaryLock> payrollSalaryLockService;
    protected EmployeeExcelRecordService<EmployeeExcelRecord> employeeExcelRecordService;
    protected PolicyMasterService<PolicyMaster> policyMasterService;
    protected EmployeePolicyDetailService<EmployeePolicyDetail> employeePolicyDetailService;
    protected PayrollLoanDetailService<PayrollLoanDetail> payrollLoanDetailService;
    protected PayrollLoanTypeService<PayrollLoanType> payrollLoanTypeService;
    protected PayrollEsicDeductionService<PayrollEsicDeduction> payrollEsicDeductionService;
    protected PayrollBonusService<PayrollBonus> payrollBonusService;
    protected PayrollLoanRemainingAmountService<PayrollLoanRemainingAmount> payrollLoanRemainingAmountService;
    protected CtcAllowanceService<CtcAllowance> ctcAllowanceService;
    protected EmployeeCtcDetailService<EmployeeCtcDetail> employeeCtcDetailService;
    protected EmployeeCtcDetailSalaryService<EmployeeCtcDetailSalary> employeeCtcDetailSalaryService;
    protected PayrollFinancialYearService<PayrollFinancialYear> payrollFinancialYearService;
    protected TaxSavingSubmitService<TaxSavingSubmit> taxSavingSubmitService;
    protected TaxDeductionDecarationSubmitService<TaxDeductionDecarationSubmit> taxDeductionDecarationSubmitService;
    protected PayrollTaxDeductionComponentService<PayrollTaxDeductionComponent> payrollTaxDeductionComponentService;
    protected PayrollTaxDeductionMasterService<PayrollTaxDeductionMaster> payrollTaxDeductionMasterService;
    protected PayrollTaxDeclarationPeriodMasterService<PayrollTaxDeclarationPeriodMaster> payrollTaxDeclarationPeriodMasterService;
    protected PayrollTaxRateMasterService<PayrollTaxRateMaster> payrollTaxRateMasterService;
    protected EmployeeShiftDataService<EmployeeShiftData> employeeShiftDataService;
    protected PayrollPfRecordService<PayrollPfRecord> payrollPfRecordService;
    protected RetirementAgeService<RetirementAge> retirementAgeService;
    protected EmployeeDatetimeDataService<EmployeeDatetimeData> employeeDatetimeDataService;
    protected CompanyMasterService<Company> companyMasterService;
    protected LocationMasterService<LocationMaster> locationMasterService;

    Validator employeeSalaryProcessValidator;

    public EmployeeDatetimeDataService<EmployeeDatetimeData> getEmployeeDatetimeDataService() {
        return employeeDatetimeDataService;
    }

    public void setEmployeeDatetimeDataService(EmployeeDatetimeDataService<EmployeeDatetimeData> employeeDatetimeDataService) {
        this.employeeDatetimeDataService = employeeDatetimeDataService;
    }

    public EmployeeShiftDataService<EmployeeShiftData> getEmployeeShiftDataService() {
        return employeeShiftDataService;
    }

    public void setEmployeeShiftDataService(EmployeeShiftDataService<EmployeeShiftData> employeeShiftDataService) {
        this.employeeShiftDataService = employeeShiftDataService;
    }

    public PayrollSalaryLockService<PayrollSalaryLock> getPayrollSalaryLockService() {
        return payrollSalaryLockService;
    }

    public void setPayrollSalaryLockService(PayrollSalaryLockService<PayrollSalaryLock> payrollSalaryLockService) {
        this.payrollSalaryLockService = payrollSalaryLockService;
    }

    public EmployeeExcelRecordService<EmployeeExcelRecord> getEmployeeExcelRecordService() {
        return employeeExcelRecordService;
    }

    public void setEmployeeExcelRecordService(EmployeeExcelRecordService<EmployeeExcelRecord> employeeExcelRecordService) {
        this.employeeExcelRecordService = employeeExcelRecordService;
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

    public PayrollAdditionalAmountService<PayrollAdditionalAmount> getPayrollAdditionalAmountService() {
        return payrollAdditionalAmountService;
    }

    public void setPayrollAdditionalAmountService(PayrollAdditionalAmountService<PayrollAdditionalAmount> payrollAdditionalAmountService) {
        this.payrollAdditionalAmountService = payrollAdditionalAmountService;
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

    public Validator getEmployeeSalaryProcessValidator() {
        return employeeSalaryProcessValidator;
    }

    public void setEmployeeSalaryProcessValidator(Validator employeeSalaryProcessValidator) {
        this.employeeSalaryProcessValidator = employeeSalaryProcessValidator;
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

    public PolicyMasterService<PolicyMaster> getPolicyMasterService() {
        return policyMasterService;
    }

    public void setPolicyMasterService(PolicyMasterService<PolicyMaster> policyMasterService) {
        this.policyMasterService = policyMasterService;
    }

    public EmployeePolicyDetailService<EmployeePolicyDetail> getEmployeePolicyDetailService() {
        return employeePolicyDetailService;
    }

    public void setEmployeePolicyDetailService(EmployeePolicyDetailService<EmployeePolicyDetail> employeePolicyDetailService) {
        this.employeePolicyDetailService = employeePolicyDetailService;
    }

    public PayrollLoanDetailService<PayrollLoanDetail> getPayrollLoanDetailService() {
        return payrollLoanDetailService;
    }

    public void setPayrollLoanDetailService(PayrollLoanDetailService<PayrollLoanDetail> payrollLoanDetailService) {
        this.payrollLoanDetailService = payrollLoanDetailService;
    }

    public PayrollLoanTypeService<PayrollLoanType> getPayrollLoanTypeService() {
        return payrollLoanTypeService;
    }

    public void setPayrollLoanTypeService(PayrollLoanTypeService<PayrollLoanType> payrollLoanTypeService) {
        this.payrollLoanTypeService = payrollLoanTypeService;
    }

    public PayrollEsicDeductionService<PayrollEsicDeduction> getPayrollEsicDeductionService() {
        return payrollEsicDeductionService;
    }

    public void setPayrollEsicDeductionService(PayrollEsicDeductionService<PayrollEsicDeduction> payrollEsicDeductionService) {
        this.payrollEsicDeductionService = payrollEsicDeductionService;
    }

    public PayrollBonusService<PayrollBonus> getPayrollBonusService() {
        return payrollBonusService;
    }

    public void setPayrollBonusService(PayrollBonusService<PayrollBonus> payrollBonusService) {
        this.payrollBonusService = payrollBonusService;
    }

    public PayrollLoanRemainingAmountService<PayrollLoanRemainingAmount> getPayrollLoanRemainingAmountService() {
        return payrollLoanRemainingAmountService;
    }

    public void setPayrollLoanRemainingAmountService(PayrollLoanRemainingAmountService<PayrollLoanRemainingAmount> payrollLoanRemainingAmountService) {
        this.payrollLoanRemainingAmountService = payrollLoanRemainingAmountService;
    }

    public CtcAllowanceService<CtcAllowance> getCtcAllowanceService() {
        return ctcAllowanceService;
    }

    public void setCtcAllowanceService(CtcAllowanceService<CtcAllowance> ctcAllowanceService) {
        this.ctcAllowanceService = ctcAllowanceService;
    }

    public EmployeeCtcDetailService<EmployeeCtcDetail> getEmployeeCtcDetailService() {
        return employeeCtcDetailService;
    }

    public void setEmployeeCtcDetailService(EmployeeCtcDetailService<EmployeeCtcDetail> employeeCtcDetailService) {
        this.employeeCtcDetailService = employeeCtcDetailService;
    }

    public EmployeeCtcDetailSalaryService<EmployeeCtcDetailSalary> getEmployeeCtcDetailSalaryService() {
        return employeeCtcDetailSalaryService;
    }

    public void setEmployeeCtcDetailSalaryService(EmployeeCtcDetailSalaryService<EmployeeCtcDetailSalary> employeeCtcDetailSalaryService) {
        this.employeeCtcDetailSalaryService = employeeCtcDetailSalaryService;
    }

    public PayrollFinancialYearService<PayrollFinancialYear> getPayrollFinancialYearService() {
        return payrollFinancialYearService;
    }

    public void setPayrollFinancialYearService(PayrollFinancialYearService<PayrollFinancialYear> payrollFinancialYearService) {
        this.payrollFinancialYearService = payrollFinancialYearService;
    }

    public TaxSavingSubmitService<TaxSavingSubmit> getTaxSavingSubmitService() {
        return taxSavingSubmitService;
    }

    public void setTaxSavingSubmitService(TaxSavingSubmitService<TaxSavingSubmit> taxSavingSubmitService) {
        this.taxSavingSubmitService = taxSavingSubmitService;
    }

    public TaxDeductionDecarationSubmitService<TaxDeductionDecarationSubmit> getTaxDeductionDecarationSubmitService() {
        return taxDeductionDecarationSubmitService;
    }

    public void setTaxDeductionDecarationSubmitService(TaxDeductionDecarationSubmitService<TaxDeductionDecarationSubmit> taxDeductionDecarationSubmitService) {
        this.taxDeductionDecarationSubmitService = taxDeductionDecarationSubmitService;
    }

    public PayrollTaxDeductionComponentService<PayrollTaxDeductionComponent> getPayrollTaxDeductionComponentService() {
        return payrollTaxDeductionComponentService;
    }

    public void setPayrollTaxDeductionComponentService(PayrollTaxDeductionComponentService<PayrollTaxDeductionComponent> payrollTaxDeductionComponentService) {
        this.payrollTaxDeductionComponentService = payrollTaxDeductionComponentService;
    }

    public PayrollTaxDeductionMasterService<PayrollTaxDeductionMaster> getPayrollTaxDeductionMasterService() {
        return payrollTaxDeductionMasterService;
    }

    public void setPayrollTaxDeductionMasterService(PayrollTaxDeductionMasterService<PayrollTaxDeductionMaster> payrollTaxDeductionMasterService) {
        this.payrollTaxDeductionMasterService = payrollTaxDeductionMasterService;
    }

    public PayrollTaxDeclarationPeriodMasterService<PayrollTaxDeclarationPeriodMaster> getPayrollTaxDeclarationPeriodMasterService() {
        return payrollTaxDeclarationPeriodMasterService;
    }

    public void setPayrollTaxDeclarationPeriodMasterService(PayrollTaxDeclarationPeriodMasterService<PayrollTaxDeclarationPeriodMaster> payrollTaxDeclarationPeriodMasterService) {
        this.payrollTaxDeclarationPeriodMasterService = payrollTaxDeclarationPeriodMasterService;
    }

    public PayrollTaxRateMasterService<PayrollTaxRateMaster> getPayrollTaxRateMasterService() {
        return payrollTaxRateMasterService;
    }

    public void setPayrollTaxRateMasterService(PayrollTaxRateMasterService<PayrollTaxRateMaster> payrollTaxRateMasterService) {
        this.payrollTaxRateMasterService = payrollTaxRateMasterService;
    }

    public PayrollPfRecordService<PayrollPfRecord> getPayrollPfRecordService() {
        return payrollPfRecordService;
    }

    public void setPayrollPfRecordService(PayrollPfRecordService<PayrollPfRecord> payrollPfRecordService) {
        this.payrollPfRecordService = payrollPfRecordService;
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

    protected void companyList(HttpServletRequest request) {

        Company company = new Company();
        List<?> companyList = companyMasterService.read();
        Map<Integer, String> dm = new HashMap<>();
        for (Object o : companyList) {
            company = (Company) o;
            dm.put(company.getCompanyId(), company.getCompanyName());
        }

        request.setAttribute("companyList", dm);
    }
     protected void locationList(HttpServletRequest request) {
        LocationMaster locationMaster = new LocationMaster();
        List<?> location = locationMasterService.read();

        Map<Integer, String> location1 = new HashMap<>();
        for (Object o : location) {
            locationMaster = (LocationMaster) o;
            location1.put(locationMaster.getId(), locationMaster.getLocation());
        }
        request.setAttribute("location", location1);
    }

    public CompanyMasterService<Company> getCompanyMasterService() {
        return companyMasterService;
    }

    public void setCompanyMasterService(CompanyMasterService<Company> companyMasterService) {
        this.companyMasterService = companyMasterService;
    }

    public LocationMasterService<LocationMaster> getLocationMasterService() {
        return locationMasterService;
    }

    public void setLocationMasterService(LocationMasterService<LocationMaster> locationMasterService) {
        this.locationMasterService = locationMasterService;
    }
     

}
