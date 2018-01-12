/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.PayrollAdditionalAmount;
import com.bul.zydex.util.ActionType;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author AJAY <ajay@bulwarks.com>
 */
public class PayrollAdditionalAmountController extends PayrollAdditionalAmountAbstract {

    public ModelAndView createClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollAdditionalAmount payrollAdditionalAmount = new PayrollAdditionalAmount();
        payrollAdditionalAmount.setEmployeeMaster(new EmployeeMaster());
        selectedEmployeeFor360Feedback(request, new EmployeeMaster());
        selectEmployee(request, response);
        mv.getModelMap().put("payrollAdditionalAmount", payrollAdditionalAmount);
        mv.setViewName("Payroll/PayrollAdditionalAmountDayWiseCreate");
        return mv;
    }

    public ModelAndView createSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollAdditionalAmount payrollAdditionalAmount = new PayrollAdditionalAmount();
        BindException errors = new BindException(payrollAdditionalAmount, "payrollAdditionalAmount");
        bind(request, payrollAdditionalAmount);
        EmployeeMaster employeeMaster = new EmployeeMaster();
        String empId = request.getParameter("empId");
        if (null != empId && !"".equals(empId)) {
            employeeMaster.setId(Integer.parseInt(empId));
            payrollAdditionalAmount.setEmployeeMaster(employeeMaster);
        } else {
            payrollAdditionalAmount.setEmployeeMaster(new EmployeeMaster());
        }
        selectedEmployeeFor360Feedback(request, employeeMaster);
        selectEmployee(request, response);
        payrollAdditionalAmountValidator.validate(payrollAdditionalAmount, errors);
        if (errors.hasErrors()) {
            request.setAttribute("faliureMessage",
                    "Error : The Payroll Additional Amount is not valid.");
            mv.addAllObjects(errors.getModel());
            mv.setViewName("Payroll/PayrollAdditionalAmountDayWiseCreate");
        } else {
            payrollAdditionalAmountService.create(payrollAdditionalAmount);
            log(request, ActionType.CREATE.toString(),
                    "The Additional Amount is created -." + payrollAdditionalAmount.getTitle());
            request.setAttribute("successMessage",
                    "Information: The Additional Amount is created successfully");
            mv = showResult(request, response);
        }
        return mv;
    }

    public ModelAndView showResult(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollAdditionalAmount payrollAdditionalAmount = new PayrollAdditionalAmount();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        List<?> list = payrollAdditionalAmountService.read();
        for (Object obj : list) {
            payrollAdditionalAmount = (PayrollAdditionalAmount) obj;
            employeeMaster = employeeMasterService.readById(payrollAdditionalAmount.getEmployeeMaster().getId());
            payrollAdditionalAmount.setEmployeeMaster(employeeMaster);
        }
        request.setAttribute("additionalAmountList", list);
        mv.setViewName("Payroll/PayrollAdditionalAmountDayWiseResult");
        return mv;
    }

    public ModelAndView viewClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollAdditionalAmount payrollAdditionalAmount = new PayrollAdditionalAmount();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        String id = request.getParameter("id");
        payrollAdditionalAmount = payrollAdditionalAmountService.readById(Integer.parseInt(id));
        employeeMaster = employeeMasterService.readById(payrollAdditionalAmount.getEmployeeMaster().getId());
        payrollAdditionalAmount.setEmployeeMaster(employeeMaster);
        mv.getModelMap().put("payrollAdditionalAmount", payrollAdditionalAmount);
        mv.setViewName("Payroll/PayrollAdditionalAmountDayWiseView");

        return mv;
    }

    public ModelAndView editSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollAdditionalAmount payrollAdditionalAmount = new PayrollAdditionalAmount();
        BindException errors = new BindException(payrollAdditionalAmount, "payrollAdditionalAmount");
        bind(request, payrollAdditionalAmount);
        payrollAdditionalAmountValidator.validate(payrollAdditionalAmount, errors);
        if (errors.hasErrors()) {
            request.setAttribute("faliureMessage",
                    "Error : The Payroll Additional Amount is not valid.");
            mv.addAllObjects(errors.getModel());
            mv.setViewName("Payroll/PayrollAdditionalAmountDayWiseView");
        } else {
            payrollAdditionalAmountService.update(payrollAdditionalAmount);
            log(request, ActionType.UPDATE.toString(),
                    "The Additional Amount is Updated -." + payrollAdditionalAmount.getTitle());
            request.setAttribute("successMessage",
                    "Information: The Additional Amount is Updated successfully");
//                        mv = searchSubmit(request, response);
            mv = showResult(request, response);
        }
        return mv;
    }

    public ModelAndView deleteSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String ptId[] = request.getParameterValues("checkId");
        for (String z : ptId) {
            try {
                payrollAdditionalAmountService.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info : One or more records are deleted successfully.");
            } catch (Exception e) {
            }
        }
        mv = showResult(request, response);
        return mv;
    }

}
