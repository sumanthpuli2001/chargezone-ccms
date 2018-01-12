/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.PayrollFormSixteenMaster;
import com.bul.zydex.model.PayrollSavingAmount;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public class PayrollSavingAmountController extends PayrollSavingAmountAbstract {

    public ModelAndView createSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollSavingAmount payrollSavingAmount = new PayrollSavingAmount();
//          PayrollSavingAmount payrollSavingAmount = new PayrollSavingAmount();
        BindException errors = new BindException(payrollSavingAmount, "payrollSavingAmount");
        bind(request, payrollSavingAmount);

        int savingTypeCount = Integer.parseInt(request.getParameter("savingTypeCount"));
        String empId = request.getParameter("employeeId");
        String yearId = request.getParameter("yearId");
        EmployeeMaster employeeMaster = employeeMasterService.readById(Integer.parseInt(empId));

        payrollSavingAmount.setEmployeeMaster(employeeMaster);
        PayrollFormSixteenMaster payrollFormSixteenMaster = new PayrollFormSixteenMaster();
        payrollFormSixteenMaster.setId(Integer.parseInt(yearId));
        payrollSavingAmount.setPayrollFormSixteenMaster(payrollFormSixteenMaster);
        for (int i = 1; i <= savingTypeCount; i++) {
            String savingType = request.getParameter("savingType" + i);
            double savingTypeAmount = Double.parseDouble(request.getParameter("savingTypeAmount" + i));

            payrollSavingAmount.setSavingType(savingType);
            payrollSavingAmount.setSavingTypeAmount(savingTypeAmount);
            payrollSavingAmountService.create(payrollSavingAmount);
        }

        request.setAttribute("successMessage",
                "Information:  Payroll Saving Amount is Created successfully");

        mv.getModelMap().put("payrollSavingAmount", payrollSavingAmount);
        mv.setViewName("Payroll/PayrollEmployeeSavingView");
        return mv;
    }
}
