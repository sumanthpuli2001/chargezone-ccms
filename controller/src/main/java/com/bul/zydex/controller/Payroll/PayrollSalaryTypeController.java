/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.model.PayrollSalaryType;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Nishant
 */
public class PayrollSalaryTypeController extends PayrollSalaryTypeAbstract {
    
      public ModelAndView createClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollSalaryType payrollSalaryType = new PayrollSalaryType();
        mv.getModelMap().put("payrollSalaryType", payrollSalaryType);
        mv.setViewName("Payroll/PayrollSalaryTypeCreate");
        return mv;
    }
    
     public ModelAndView showResult(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        List<?> list1 = payrollSalaryTypeService.read();
        request.setAttribute("list", list1);
        mv.setViewName("Payroll/PayrollSalaryTypeShow");

        return mv;
    }
      public ModelAndView createSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollSalaryType payrollSalaryType = new PayrollSalaryType();
        BindException errors = new BindException(payrollSalaryType, "payrollSalaryType");
        bind(request, payrollSalaryType);
        payrollSalaryTypeValidator.validate(payrollSalaryType, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv.addAllObjects(errors.getModel());
            mv.getModelMap().put("payrollSalaryType", payrollSalaryType);
            mv.setViewName("Payroll/PayrollSalaryTypeCreate");

        } else {if (!payrollSalaryTypeService.isExist(payrollSalaryType)) {
            payrollSalaryTypeService.create(payrollSalaryType);
            request.setAttribute("successMessage",
                    "Information : The Information is saved Successfully.");
            mv = showResult(request, response);

        }
          else {
                request.setAttribute("failureMessage",
                        "Error : The Salary Type is already there.");
                mv.setViewName("Payroll/PayrollSalaryTypeCreate");
                 mv.getModelMap().put("payrollSalaryType", payrollSalaryType);
            }
        
//        return mv;
    }
        return mv;
    }
       public ModelAndView deleteSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String savingList[] = request.getParameterValues("checkId");
        for (String z : savingList) {
            try {
                payrollSalaryTypeService.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info : One or more records are deleted successfully.");
            } catch (Exception e) {

            }
        }
        mv = showResult(request, response);
        return mv;
    }
       
        public ModelAndView viewClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollSalaryType payrollSalaryType = new PayrollSalaryType();
        String id = request.getParameter("id");
        payrollSalaryType = payrollSalaryTypeService.readById(Integer.parseInt(id));
        mv.getModelMap().put("payrollSalaryType",payrollSalaryType);
        mv.setViewName("Payroll/PayrollSalaryTypeEdit");
        return mv;
    }
       
       
        public ModelAndView editSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
       PayrollSalaryType payrollSalaryType = new PayrollSalaryType();
        BindException errors = new BindException(payrollSalaryType, "payrollSalaryType");
//        payrollSavingType.setId(Integer.parseInt(request.getParameter("id")));
        bind(request, payrollSalaryType);
        payrollSalaryTypeValidator.validate(payrollSalaryType, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv = viewClick(request, response);
        } else {if (!payrollSalaryTypeService.isExist(payrollSalaryType)) {
            payrollSalaryTypeService.update(payrollSalaryType);
            request.setAttribute("successMessage",
                    "Information : The Information is Updated Successfully.");
            mv = showResult(request, response);
        }

        else {
                request.setAttribute("failureMessage",
                        "Error : The Salary Type is already there.");
                mv.setViewName("Payroll/PayrollSalaryTypeCreate");
                 mv.getModelMap().put("payrollSalaryType", payrollSalaryType);
            }
        
//        return mv;
        
        
      }
          return mv;

   
        }
    
}
