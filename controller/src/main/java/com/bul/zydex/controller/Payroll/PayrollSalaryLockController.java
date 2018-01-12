/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.model.PayrollSalaryLock;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public class PayrollSalaryLockController extends PayrollSalaryLockAbstract{
    
     public ModelAndView createClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollSalaryLock payrollSalaryLock = new PayrollSalaryLock();
        payrollSalaryLock = payrollSalaryLockService.readById(1);
        mv.getModelMap().put("payrollSalaryLock", payrollSalaryLock);
        mv.setViewName("Payroll/PayrollSalaryLockCreate");
        return mv;
    }
    public ModelAndView createSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
         PayrollSalaryLock payrollSalaryLock = new PayrollSalaryLock();
        BindException errors = new BindException(payrollSalaryLock, "payrollSalaryLock");
        bind(request, payrollSalaryLock);
       payrollSalaryLockValidator.validate(payrollSalaryLock, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv.addAllObjects(errors.getModel());
            mv.getModelMap().put("payrollSalaryLock", payrollSalaryLock);
            mv.setViewName("Payroll/PayrollSalaryLockCreate");

        } else {
            payrollSalaryLockService.update(payrollSalaryLock);
            request.setAttribute("successMessage",
                    "Information : The Information is saved Successfully.");
            mv = createClick(request, response);

        }
         return mv;
          
        

    }
      
   
    
    
    
}
