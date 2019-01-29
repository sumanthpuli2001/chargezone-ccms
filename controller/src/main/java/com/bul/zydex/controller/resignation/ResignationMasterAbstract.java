/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.resignation;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.DisplaymorNotes;
import com.bul.zydex.model.EmployeeCtcDetail;
import com.bul.zydex.model.EmployeeDeductionAmount;
import com.bul.zydex.model.EmployeeLeaveBalance;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.EmployeeSalaryProcess;
import com.bul.zydex.model.ExitInterviewMaster;
import com.bul.zydex.model.FormateFullNdFinalLetter;
import com.bul.zydex.model.FullAndFinalSettlement;
import com.bul.zydex.model.NoDueMaster;
import com.bul.zydex.model.ResignationMaster;
import com.bul.zydex.model.UserRightMaster;
import com.bul.zydex.service.FormateFullNdFinalLetter.FormateFullNdFinalLetterService;
import com.bul.zydex.service.Payroll.DisplaymorNotesService;
import com.bul.zydex.service.Payroll.EmployeeDeductionAmountService;
import com.bul.zydex.service.Payroll.EmployeeSalaryProcessService;
import com.bul.zydex.service.UserRight.UserRightMasterService;
import com.bul.zydex.service.exitInterview.ExitInterviewMasterService;
import com.bul.zydex.service.leave.EmployeeLeaveBalanceService;
import com.bul.zydex.service.nodue.NoDueMasterService;
import com.bul.zydex.service.policy.EmployeeCtcDetailService;
import com.bul.zydex.service.resignation.FullAndFinalSettlementService;
import com.bul.zydex.service.resignation.ResignationMasterService;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.Validator;

/**
 *
 * @author dhruv
 */
public abstract class ResignationMasterAbstract extends CustomAbstract {

    protected ResignationMasterService<ResignationMaster> resignationMasterService;
    protected ExitInterviewMasterService<ExitInterviewMaster> exitInterviewMasterService;
    protected NoDueMasterService<NoDueMaster> noDueMasterService;
    protected Validator resignationMasterValidator;
    protected UserRightMasterService<UserRightMaster> userRightMasterService;
    protected FullAndFinalSettlementService<FullAndFinalSettlement> fullAndFinalSettlementService;
    protected EmployeeSalaryProcessService<EmployeeSalaryProcess> employeeSalaryProcessService;
    protected EmployeeCtcDetailService<EmployeeCtcDetail> employeeCtcDetailService;
    protected EmployeeDeductionAmountService<EmployeeDeductionAmount> employeeDeductionAmountService;
    protected FormateFullNdFinalLetterService<FormateFullNdFinalLetter> formateFullNdFinalLetterService;
    protected DisplaymorNotesService<DisplaymorNotes> displaymorNotesService;
    protected Validator fullAndFinalSettlementValidator;
    protected EmployeeLeaveBalanceService<EmployeeLeaveBalance> employeeLeaveBalanceService;

    public UserRightMasterService<UserRightMaster> getUserRightMasterService() {
        return userRightMasterService;
    }

    public void setUserRightMasterService(UserRightMasterService<UserRightMaster> userRightMasterService) {
        this.userRightMasterService = userRightMasterService;
    }

    public Validator getResignationMasterValidator() {
        return resignationMasterValidator;
    }

    public void setResignationMasterValidator(Validator resignationMasterValidator) {
        this.resignationMasterValidator = resignationMasterValidator;
    }

    public ResignationMasterService<ResignationMaster> getResignationMasterService() {
        return resignationMasterService;
    }

    public void setResignationMasterService(ResignationMasterService<ResignationMaster> resignationMasterService) {
        this.resignationMasterService = resignationMasterService;
    }

    public ExitInterviewMasterService<ExitInterviewMaster> getExitInterviewMasterService() {
        return exitInterviewMasterService;
    }

    public void setExitInterviewMasterService(ExitInterviewMasterService<ExitInterviewMaster> exitInterviewMasterService) {
        this.exitInterviewMasterService = exitInterviewMasterService;
    }

    public NoDueMasterService<NoDueMaster> getNoDueMasterService() {
        return noDueMasterService;
    }

    public void setNoDueMasterService(NoDueMasterService<NoDueMaster> noDueMasterService) {
        this.noDueMasterService = noDueMasterService;
    }

    public FullAndFinalSettlementService<FullAndFinalSettlement> getFullAndFinalSettlementService() {
        return fullAndFinalSettlementService;
    }

    public void setFullAndFinalSettlementService(FullAndFinalSettlementService<FullAndFinalSettlement> fullAndFinalSettlementService) {
        this.fullAndFinalSettlementService = fullAndFinalSettlementService;
    }

    public EmployeeSalaryProcessService<EmployeeSalaryProcess> getEmployeeSalaryProcessService() {
        return employeeSalaryProcessService;
    }

    public void setEmployeeSalaryProcessService(EmployeeSalaryProcessService<EmployeeSalaryProcess> employeeSalaryProcessService) {
        this.employeeSalaryProcessService = employeeSalaryProcessService;
    }

    public EmployeeCtcDetailService<EmployeeCtcDetail> getEmployeeCtcDetailService() {
        return employeeCtcDetailService;
    }

    public void setEmployeeCtcDetailService(EmployeeCtcDetailService<EmployeeCtcDetail> employeeCtcDetailService) {
        this.employeeCtcDetailService = employeeCtcDetailService;
    }

    public EmployeeDeductionAmountService<EmployeeDeductionAmount> getEmployeeDeductionAmountService() {
        return employeeDeductionAmountService;
    }

    public void setEmployeeDeductionAmountService(EmployeeDeductionAmountService<EmployeeDeductionAmount> employeeDeductionAmountService) {
        this.employeeDeductionAmountService = employeeDeductionAmountService;
    }

    public FormateFullNdFinalLetterService<FormateFullNdFinalLetter> getFormateFullNdFinalLetterService() {
        return formateFullNdFinalLetterService;
    }

    public void setFormateFullNdFinalLetterService(FormateFullNdFinalLetterService<FormateFullNdFinalLetter> formateFullNdFinalLetterService) {
        this.formateFullNdFinalLetterService = formateFullNdFinalLetterService;
    }

    public Validator getFullAndFinalSettlementValidator() {
        return fullAndFinalSettlementValidator;
    }

    public void setFullAndFinalSettlementValidator(Validator fullAndFinalSettlementValidator) {
        this.fullAndFinalSettlementValidator = fullAndFinalSettlementValidator;
    }

    public DisplaymorNotesService<DisplaymorNotes> getDisplaymorNotesService() {
        return displaymorNotesService;
    }

    public void setDisplaymorNotesService(DisplaymorNotesService<DisplaymorNotes> displaymorNotesService) {
        this.displaymorNotesService = displaymorNotesService;
    }

    public EmployeeLeaveBalanceService<EmployeeLeaveBalance> getEmployeeLeaveBalanceService() {
        return employeeLeaveBalanceService;
    }

    public void setEmployeeLeaveBalanceService(EmployeeLeaveBalanceService<EmployeeLeaveBalance> employeeLeaveBalanceService) {
        this.employeeLeaveBalanceService = employeeLeaveBalanceService;
    }

    public void selectResignedEmployee(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        List<?> list = resignationMasterService.readResignedEmployees();
        String tempStr = "[";
        Object[] arrayOfObject;

        EmployeeMaster employeeMaster;
        boolean flag = false;
        for (Iterator<? extends Object> it = list.iterator(); it.hasNext();) {
            arrayOfObject = (Object[]) it.next();

            if (flag) {
                tempStr += ", ";
            }
            flag = true;
            tempStr += "{id: \"" + arrayOfObject[0]
                    + "\", name: \"" + arrayOfObject[1]
                    + "  /" + arrayOfObject[2]
                    + "  /" + arrayOfObject[3] + "\"}";
//                    + "  /" + arrayOfObject[4]
//                    + "  /" + arrayOfObject[5] 

        }
        tempStr += "]";

        request.setAttribute("resignedEmployeelist", tempStr);
    }
}
