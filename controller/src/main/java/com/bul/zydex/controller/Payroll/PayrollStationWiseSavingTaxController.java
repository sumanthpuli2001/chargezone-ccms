/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.model.PayrollStationWiseSavingTax;
import com.bul.zydex.model.ZydexLocationMaster;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Nishant
 */
public class PayrollStationWiseSavingTaxController extends PayrollStationWiseSavingTaxAbstract{
    
     public ModelAndView showResult(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollStationWiseSavingTax payrollStationWiseSavingTax = new PayrollStationWiseSavingTax();
        ZydexLocationMaster zydexLocationMaster = new ZydexLocationMaster();
        List<?> list = payrollStationWiseSavingTaxService.read();
          for (Object obj : list) {
            payrollStationWiseSavingTax= (PayrollStationWiseSavingTax) obj;
            zydexLocationMaster = zydexLocationMasterService.readById(payrollStationWiseSavingTax.getZydexLocationMaster().getId());
            payrollStationWiseSavingTax.setZydexLocationMaster(zydexLocationMaster);
        }
        request.setAttribute("list", list);
        mv.setViewName("Payroll/PayrollStationWiseSavingTaxShow");

        return mv;
    }
     
    public ModelAndView createClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollStationWiseSavingTax payrollStationWiseSavingTax = new PayrollStationWiseSavingTax();
        zydexLocationList(request);
        payrollStationWiseSavingTax.setZydexLocationMaster(new ZydexLocationMaster());
        mv.getModelMap().put("payrollStationWiseSavingTax", payrollStationWiseSavingTax);
        mv.setViewName("Payroll/PayrollStationWiseSavingTaxCreate");
        return mv;
       
    }  
    
     public ModelAndView createSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollStationWiseSavingTax payrollStationWiseSavingTax = new PayrollStationWiseSavingTax();
        BindException errors = new BindException(payrollStationWiseSavingTax,"payrollStationWiseSavingTax");
        bind(request, payrollStationWiseSavingTax);
        zydexLocationList(request);
        payrollStationWiseSavingTaxValidator.validate(payrollStationWiseSavingTax, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv.addAllObjects(errors.getModel());
            mv.getModelMap().put("payrollStationWiseSavingTax", payrollStationWiseSavingTax);
            mv.setViewName("Payroll/PayrollStationWiseSavingTaxCreate");

        } else {
              if (payrollStationWiseSavingTaxService.isExist(payrollStationWiseSavingTax)) {
                 request.setAttribute("failureMessage",
                        "Error : The Saving Duration is already there.");
                 mv.getModelMap().put("payrollStationWiseSavingTax", payrollStationWiseSavingTax);
                mv.setViewName("Payroll/PayrollStationWiseSavingTaxCreate");
           
        } else {
            payrollStationWiseSavingTaxService.create(payrollStationWiseSavingTax);
            
            request.setAttribute("successMessage",
                    "Information : The Information is saved Successfully.");
            mv = showResult(request, response);
            
              }
        } 
        return mv;
     }
    public ModelAndView viewClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollStationWiseSavingTax payrollStationWiseSavingTax = new PayrollStationWiseSavingTax();
        ZydexLocationMaster zydexLocationMaster = new ZydexLocationMaster();
        String id = request.getParameter("id");
        zydexLocationList(request);
        payrollStationWiseSavingTax = payrollStationWiseSavingTaxService.readById(Integer.parseInt(id));
        zydexLocationMaster = zydexLocationMasterService.readById( payrollStationWiseSavingTax.getZydexLocationMaster().getId());
        payrollStationWiseSavingTax.setZydexLocationMaster(zydexLocationMaster);
        mv.getModelMap().put("payrollStationWiseSavingTax",payrollStationWiseSavingTax);
        mv.setViewName("Payroll/PayrollStationWiseSavingTaxEdit");
        return mv;
    }

    public ModelAndView editSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollStationWiseSavingTax payrollStationWiseSavingTax = new PayrollStationWiseSavingTax();
        BindException errors = new BindException(payrollStationWiseSavingTax, "payrollStationWiseSavingTax");
        bind(request, payrollStationWiseSavingTax);
        zydexLocationList(request);
        payrollStationWiseSavingTaxValidator.validate(payrollStationWiseSavingTax, errors);
        if (errors.hasErrors()) {
            request.setAttribute("faliureMessage",
                    "Error : The Saving Duration is not valid.");
            mv.addAllObjects(errors.getModel());
            mv.getModelMap().put("payrollStationWiseSavingTax", payrollStationWiseSavingTax);
            mv.setViewName("Payroll/PayrollStationWiseSavingTaxEdit");
        } else {
            payrollStationWiseSavingTaxService.update(payrollStationWiseSavingTax);
  
            request.setAttribute("successMessage",
                    "Information: The Saving Duration is Updated successfulsly");
            mv = showResult(request, response);
        } 
         return mv;
    }
    
     public ModelAndView deleteSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String ptId[] = request.getParameterValues("checkId");
        for (String z : ptId) {
            try {
                payrollStationWiseSavingTaxService.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info : One or more records are deleted successfully.");
            } catch (Exception e) {
            }
        }
        mv = showResult(request, response);
        return mv;
    }
     
}
