/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.model.PayrollSavingType;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Nishant
 */
public class PayrollSavingTypeController extends PayrollSavingTypeAbstract {

    public ModelAndView createClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollSavingType payrollSavingType = new PayrollSavingType();
        mv.getModelMap().put("payrollSavingType", payrollSavingType);
        mv.setViewName("Payroll/PayrollSavingTypeCreate");
        return mv;
    }

    public ModelAndView showResult(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        List<?> list = payrollSavingTypeService.read();
        request.setAttribute("list", list);
        mv.setViewName("Payroll/PayrollSavingTypeShow");

        return mv;
    }

    public ModelAndView createSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollSavingType payrollSavingType = new PayrollSavingType();
        BindException errors = new BindException(payrollSavingType, "payrollSavingType");
        bind(request, payrollSavingType);
        payrollSavingTypeValidator.validate(payrollSavingType, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv.addAllObjects(errors.getModel());
            mv.getModelMap().put("payrollSavingType", payrollSavingType);
            mv.setViewName("Payroll/PayrollSavingTypeCreate");

        } else { if (!payrollSavingTypeService.isExist(payrollSavingType)) {
            payrollSavingTypeService.create(payrollSavingType);
            request.setAttribute("successMessage",
                    "Information : The Information is saved Successfully.");
            mv = showResult(request, response);

        }
            else {
                request.setAttribute("faliureMessage",
                        "Error : The Saving Type is already there.");
                mv.setViewName("Payroll/PayrollSavingTypeCreate");
                 mv.getModelMap().put("payrollSavingType", payrollSavingType);
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
                payrollSavingTypeService.delete(Integer.parseInt(z));
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
        PayrollSavingType payrollSavingType = new PayrollSavingType();
        String id = request.getParameter("id");
        payrollSavingType = payrollSavingTypeService.readById(Integer.parseInt(id));
        mv.getModelMap().put("payrollSavingType",payrollSavingType);
        mv.setViewName("Payroll/PayrollSavingTypeEdit");
        return mv;
    }
       
       
        public ModelAndView editSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
      PayrollSavingType payrollSavingType = new PayrollSavingType();
        BindException errors = new BindException(payrollSavingType, "payrollSavingType");
//        payrollSavingType.setId(Integer.parseInt(request.getParameter("id")));
        bind(request, payrollSavingType);
        payrollSavingTypeValidator.validate(payrollSavingType, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv = viewClick(request, response);
        } else {if(!payrollSavingTypeService.isExist(payrollSavingType)) {
            payrollSavingTypeService.update(payrollSavingType);
            request.setAttribute("successMessage",
                    "Information : The Information is Updated Successfully.");
            mv = showResult(request, response);
        }
                else {
                request.setAttribute("failureMessage",
                        "Error : The Saving Type is already there.");
                mv.setViewName("Payroll/PayrollSavingTypeEdit");
                 mv.getModelMap().put("payrollSavingType", payrollSavingType);
            }
        
//        return mv;
    }
        return mv;
      }

}
