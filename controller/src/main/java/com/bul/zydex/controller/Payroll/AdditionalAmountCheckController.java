/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.model.AdditionalAmountCheck;
import com.bul.zydex.model.PayrollSalaryType;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public class AdditionalAmountCheckController extends AdditionalAmountCheckAbstract{
    
    
      public ModelAndView showResult(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<?> list1 = additionalAmountCheckService.read();
          for (Object obj : list1) {
              AdditionalAmountCheck additionalAmountCheck = (AdditionalAmountCheck)obj;
              
             PayrollSalaryType payrollSalaryType = payrollSalaryTypeService.readById(additionalAmountCheck.getPayrollSalaryType().getId());
              additionalAmountCheck.setPayrollSalaryType(payrollSalaryType);
          }
        request.setAttribute("list", list1);
        mv.setViewName("Payroll/AdditionalAmountCheckShow");

        return mv;
    }
       public ModelAndView createClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AdditionalAmountCheck  additionalAmountCheck = new  AdditionalAmountCheck();
        PayrollSalaryType payrollSalaryType = new PayrollSalaryType();
        SalaryTypeList(request);
       additionalAmountCheck.setPayrollSalaryType(new PayrollSalaryType());
        mv.getModelMap().put("additionalAmountCheck", additionalAmountCheck);
        mv.setViewName("Payroll/AdditionalAmountCheckCreate");
        return mv;
    }
    public ModelAndView createSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AdditionalAmountCheck  additionalAmountCheck = new  AdditionalAmountCheck();
        BindException errors = new BindException(additionalAmountCheck, "additionalAmountCheck");
        bind(request, additionalAmountCheck);
        SalaryTypeList(request);
        additionalAmountCheckValidator.validate(additionalAmountCheck, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv.addAllObjects(errors.getModel());
            mv.getModelMap().put("additionalAmountCheck", additionalAmountCheck);
            mv.setViewName("Payroll/AdditionalAmountCheckCreate");

        } else {
            additionalAmountCheckService.create(additionalAmountCheck);

            request.setAttribute("successMessage",
                    "Information : The Information is saved Successfully.");
            mv = showResult(request, response);

        }
        return mv;
    }
      public ModelAndView viewClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
         ModelAndView mv = new ModelAndView();
         AdditionalAmountCheck  additionalAmountCheck = new  AdditionalAmountCheck();
         PayrollSalaryType payrollSalaryType = new PayrollSalaryType();
         String id = request.getParameter("id");
         SalaryTypeList(request);
         additionalAmountCheck = additionalAmountCheckService.readById(Integer.parseInt(id));
         payrollSalaryType = payrollSalaryTypeService.readById(additionalAmountCheck.getPayrollSalaryType().getId());
         additionalAmountCheck.setPayrollSalaryType(payrollSalaryType);
         mv.getModelMap().put("additionalAmountCheck", additionalAmountCheck);
         mv.setViewName("Payroll/AdditionalAmountCheckEdit");
         return mv;
    }

    public ModelAndView editSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
       AdditionalAmountCheck  additionalAmountCheck = new  AdditionalAmountCheck();
        BindException errors = new BindException(additionalAmountCheck, "additionalAmountCheck");
        bind(request, additionalAmountCheck);
        SalaryTypeList(request);
        additionalAmountCheckValidator.validate(additionalAmountCheck, errors);
        if (errors.hasErrors()) {
            request.setAttribute("faliureMessage",
                    "Error : The Additional Amount Check is not valid.");
            mv.addAllObjects(errors.getModel());
            mv.getModelMap().put("additionalAmountCheck", additionalAmountCheck);
            mv.setViewName("Payroll/AdditionalAmountCheckEdit");
        } else {
            additionalAmountCheckService.update(additionalAmountCheck);

            request.setAttribute("successMessage",
                    "Information: The Additional Amount Check is Updated successfully");
            mv = showResult(request, response);
        }
        return mv;
    }

    public ModelAndView deleteSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String ptId[] = request.getParameterValues("checkId");
        for (String z : ptId) {
            try {
                additionalAmountCheckService.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info : One or more records are deleted successfully.");
            } catch (Exception e) {
            }
        }
        mv = showResult(request, response);
        return mv;
    }
}
