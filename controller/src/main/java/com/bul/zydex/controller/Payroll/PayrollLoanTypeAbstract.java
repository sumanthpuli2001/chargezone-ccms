/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.PayrollLoanDetail;
import com.bul.zydex.model.PayrollLoanType;
import com.bul.zydex.model.PayrollSalaryType;
import com.bul.zydex.service.Payroll.PayrollLoanDetailService;
import com.bul.zydex.service.Payroll.PayrollLoanTypeService;
import java.text.DateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.Validator;

/**
 *
 * @author Nishant
 */
public abstract class PayrollLoanTypeAbstract extends CustomAbstract {

    protected PayrollLoanTypeService<PayrollLoanType> payrollLoanTypeService;
    protected PayrollLoanDetailService<PayrollLoanDetail> payrollLoanDetailService;
    protected Validator payrollLoanTypeValidator;
    protected Validator payrollLoanTypeDetailsValidator;

    public PayrollLoanTypeService<PayrollLoanType> getPayrollLoanTypeService() {
        return payrollLoanTypeService;
    }

    public void setPayrollLoanTypeService(PayrollLoanTypeService<PayrollLoanType> payrollLoanTypeService) {
        this.payrollLoanTypeService = payrollLoanTypeService;
    }

    public PayrollLoanDetailService<PayrollLoanDetail> getPayrollLoanDetailService() {
        return payrollLoanDetailService;
    }

    public void setPayrollLoanDetailService(PayrollLoanDetailService<PayrollLoanDetail> payrollLoanDetailService) {
        this.payrollLoanDetailService = payrollLoanDetailService;
    }

    public Validator getPayrollLoanTypeValidator() {
        return payrollLoanTypeValidator;
    }

    public void setPayrollLoanTypeValidator(Validator payrollLoanTypeValidator) {
        this.payrollLoanTypeValidator = payrollLoanTypeValidator;
    }

    public DateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public Validator getPayrollLoanTypeDetailsValidator() {
        return payrollLoanTypeDetailsValidator;
    }

    public void setPayrollLoanTypeDetailsValidator(Validator payrollLoanTypeDetailsValidator) {
        this.payrollLoanTypeDetailsValidator = payrollLoanTypeDetailsValidator;
    }

   

    protected void PayrollLoanTypeList(HttpServletRequest request) {
        List<?> PayrollLoanTypeList = payrollLoanTypeService.read();
        Map<Integer, String> map = new HashMap();
        for (Object obj : PayrollLoanTypeList) {
            PayrollLoanType payrollLoanType = (PayrollLoanType) obj;
            map.put(payrollLoanType.getId(), payrollLoanType.getText());
        }
        request.setAttribute("PayrollLoanTypeList", map);
    }

}
