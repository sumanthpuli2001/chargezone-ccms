/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.DepartmentMaster;
import com.bul.zydex.model.PayrollLoanDetail;
import com.bul.zydex.model.PayrollLoanRemainingAmount;
import com.bul.zydex.model.PayrollLoanType;
import com.bul.zydex.service.Payroll.PayrollLoanDetailService;
import com.bul.zydex.service.Payroll.PayrollLoanRemainingAmountService;
import com.bul.zydex.service.Payroll.PayrollLoanTypeService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author OptiPlex
 */
public abstract class LoanReportAbstract extends CustomAbstract {

    protected PayrollLoanTypeService<PayrollLoanType> payrollLoanTypeService;

    protected PayrollLoanDetailService<PayrollLoanDetail> payrollLoanDetailService;

    protected PayrollLoanRemainingAmountService<PayrollLoanRemainingAmount> payrollLoanRemainingAmountService;

    public void setPayrollLoanTypeService(PayrollLoanTypeService<PayrollLoanType> payrollLoanTypeService) {
        this.payrollLoanTypeService = payrollLoanTypeService;
    }

    public PayrollLoanTypeService<PayrollLoanType> getPayrollLoanTypeService() {
        return payrollLoanTypeService;
    }

    public void setPayrollLoanDetailService(PayrollLoanDetailService<PayrollLoanDetail> payrollLoanDetailService) {
        this.payrollLoanDetailService = payrollLoanDetailService;
    }

    public PayrollLoanDetailService<PayrollLoanDetail> getPayrollLoanDetailService() {
        return payrollLoanDetailService;
    }

    public void setPayrollLoanRemainingAmountService(PayrollLoanRemainingAmountService<PayrollLoanRemainingAmount> payrollLoanRemainingAmountService) {
        this.payrollLoanRemainingAmountService = payrollLoanRemainingAmountService;
    }

    public PayrollLoanRemainingAmountService<PayrollLoanRemainingAmount> getPayrollLoanRemainingAmountService() {
        return payrollLoanRemainingAmountService;
    }

    protected void loanTypeList(HttpServletRequest request) {
        PayrollLoanType loanTypeMaster = new PayrollLoanType();
        List<?> loanTypeList = payrollLoanTypeService.read();

        Map<Integer, String> loanTypes = new HashMap<>();
        for (Object o : loanTypeList) {
            loanTypeMaster = (PayrollLoanType) o;
            loanTypes.put(loanTypeMaster.getId(), loanTypeMaster.getText());
        }
        request.setAttribute("loanTypes", loanTypes);
    }

    protected void departmentList(HttpServletRequest request) {
        DepartmentMaster departmentMaster = new DepartmentMaster();
        List<?> depttList = departmentMasterService.read();
        Map<Integer, String> dm = new HashMap<>();
        for (Object o : depttList) {
            departmentMaster = (DepartmentMaster) o;
            dm.put(departmentMaster.getId(), departmentMaster.getDepartmentName());
        }

        request.setAttribute("deptMap", dm);
    }

}
