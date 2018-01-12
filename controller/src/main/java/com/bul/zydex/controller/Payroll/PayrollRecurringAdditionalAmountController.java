/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.PayrollRecurringAdditionalAmount;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public class PayrollRecurringAdditionalAmountController extends PayrollRecurringAdditionalAmountAbstract{
    
     public ModelAndView showResult(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollRecurringAdditionalAmount  payrollRecurringAdditionalAmount = new PayrollRecurringAdditionalAmount();
        EmployeeMaster employeeMaster= new EmployeeMaster();
        List<?>  RecurringAdditionalAmountList = payrollRecurringAdditionalAmountService.read();
        for (Object obj : RecurringAdditionalAmountList) {
             payrollRecurringAdditionalAmount=(PayrollRecurringAdditionalAmount) obj;
            employeeMaster = employeeMasterService.readById(payrollRecurringAdditionalAmount.getEmployeeMaster().getId());
             payrollRecurringAdditionalAmount.setEmployeeMaster(employeeMaster);
        }
        request.setAttribute("RecurringAdditionalAmountList", RecurringAdditionalAmountList);
        mv.setViewName("Payroll/PayrollRecurringAdditionalAmountShow");
        return mv;
    }
     
      public ModelAndView createClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollRecurringAdditionalAmount  payrollRecurringAdditionalAmount = new PayrollRecurringAdditionalAmount();
        EmployeeMaster employeeMaster= new EmployeeMaster();
        selectedEmployeeFor360Feedback(request, employeeMaster); 
        selectEmployee(request,response);
        
        payrollRecurringAdditionalAmount.setEmployeeMaster(new EmployeeMaster());
     
       
        mv.getModelMap().put("payrollRecurringAdditionalAmount",payrollRecurringAdditionalAmount);
        mv.setViewName("Payroll/PayrollRecurringAdditionalAmountCreate");
        return mv;
    }
     
      public ModelAndView createSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
         PayrollRecurringAdditionalAmount payrollRecurringAdditionalAmount = new PayrollRecurringAdditionalAmount();
        EmployeeMaster employeemaster= new EmployeeMaster();
        BindException errors = new BindException(payrollRecurringAdditionalAmount,"payrollRecurringAdditionalAmount");
        bind(request, payrollRecurringAdditionalAmount);
        EmployeeMaster employeeMaster = new EmployeeMaster();
        String empId = request.getParameter("empId");
        if(null != empId && !"".equals(empId)){
            employeeMaster.setId(Integer.parseInt(empId));
            payrollRecurringAdditionalAmount.setEmployeeMaster(employeeMaster);
        }else{
            payrollRecurringAdditionalAmount.setEmployeeMaster(new EmployeeMaster());
        }
            selectedEmployeeFor360Feedback(request, employeeMaster); 
        selectEmployee(request,response);
        payrollRecurringAdditionalAmountValidator.validate(payrollRecurringAdditionalAmount, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv.addAllObjects(errors.getModel());
            mv.setViewName("Payroll/PayrollRecurringAdditionalAmountCreate");
        } else {
            payrollRecurringAdditionalAmountService.create(payrollRecurringAdditionalAmount);
            request.setAttribute("successMessage",
                    "Information : The Information is saved Successfully.");
            mv = showResult(request, response);

        }

        return mv;
    }
     public ModelAndView viewClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
       PayrollRecurringAdditionalAmount payrollRecurringAdditionalAmount = new PayrollRecurringAdditionalAmount();
        EmployeeMaster employeeMaster= new EmployeeMaster();
        String id = request.getParameter("id");
        
      
         payrollRecurringAdditionalAmount = payrollRecurringAdditionalAmountService.readById(Integer.parseInt(id));
        employeeMaster = employeeMasterService.readById(payrollRecurringAdditionalAmount.getEmployeeMaster().getId());
         payrollRecurringAdditionalAmount.setEmployeeMaster(employeeMaster);
        mv.getModelMap().put("payrollRecurringAdditionalAmount", payrollRecurringAdditionalAmount);
        mv.setViewName("Payroll/PayrollRecurringAdditionalAmountEdit");
        return mv;
    }
      
       public ModelAndView editSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
           PayrollRecurringAdditionalAmount payrollRecurringAdditionalAmount = new PayrollRecurringAdditionalAmount();
        BindException errors = new BindException(payrollRecurringAdditionalAmount, "payrollRecurringAdditionalAmount");
        bind(request, payrollRecurringAdditionalAmount);
        
        payrollRecurringAdditionalAmountValidator.validate(payrollRecurringAdditionalAmount, errors);
        
        if (errors.hasErrors()) {
            request.setAttribute("faliureMessage",
                    "Error : The Recurring Additional Amount is not valid.");
            mv.addAllObjects(errors.getModel());
            mv.getModelMap()
                    .put("payrollRecurringAdditionalAmount",payrollRecurringAdditionalAmount);
            mv.setViewName("Payroll/PayrollRecurringAdditionalAmountEdit");
        } 
        else {
            payrollRecurringAdditionalAmountService.update(payrollRecurringAdditionalAmount);
            request.setAttribute("successMessage",
                    "Information: The Recurring Additional Amount is Updated successfully");
            mv = showResult(request, response);
        }
        return mv;
    }
      public ModelAndView deleteSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String ptId[] = request.getParameterValues("checkId");
        for (String z : ptId) {
            try {
                payrollRecurringAdditionalAmountService.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info : One or more records are deleted successfully.");
            } catch (Exception e) {
            }
        }
        mv = showResult(request, response);
        return mv;
    }
      
}
