/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.model.PayrollFinancialYear;
import com.bul.zydex.model.ZydexLocationMaster;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public class PayrollFinancialYearController extends PayrollFinancialYearAbstract{
    public ModelAndView showResult(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollFinancialYear payrollFinancialYear = new PayrollFinancialYear();
        ZydexLocationMaster zydexLocationMaster = new ZydexLocationMaster();

        List<?> list = payrollFinancialYearService.read();
        mv.setViewName("Payroll/PayrollFinancialYearShow");
         for (Object obj : list) {
            payrollFinancialYear = (PayrollFinancialYear) obj;
            zydexLocationMaster = zydexLocationMasterService.readById(payrollFinancialYear.getZydexLocationMaster().getId());
            payrollFinancialYear.setZydexLocationMaster(zydexLocationMaster);
        }

        request.setAttribute("list", list);
        return mv;
       
    }
     public ModelAndView createClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollFinancialYear payrollFinancialYear = new PayrollFinancialYear();
        zydexLocationList(request);
       payrollFinancialYear.setZydexLocationMaster(new ZydexLocationMaster());
        mv.getModelMap().put("payrollFinancialYear",payrollFinancialYear);
        mv.setViewName("Payroll/PayrollFinancialYearCreate");
        return mv;
    }
      public ModelAndView createSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollFinancialYear payrollFinancialYear = new PayrollFinancialYear();
        BindException errors = new BindException(payrollFinancialYear, "payrollFinancialYear");
        zydexLocationList(request);
        bind(request,payrollFinancialYear);
        payrollFinancialYearValidator.validate(payrollFinancialYear, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv.addAllObjects(errors.getModel());
            mv.getModelMap().put("payrollFinancialYear", payrollFinancialYear);
            mv.setViewName("Payroll/PayrollFinancialYearCreate");

        } else {if (!payrollFinancialYearService.isExist(payrollFinancialYear)) {
            payrollFinancialYearService.create(payrollFinancialYear);
            request.setAttribute("successMessage",
                    "Information : The Information is saved Successfully.");
            mv = showResult(request, response);

        }
         else {
                request.setAttribute("failureMessage",
                        "Error : The Payroll Financial Year is already there.");
                mv.setViewName("Payroll/PayrollFinancialYearCreate");
                 mv.getModelMap().put("payrollFinancialYear", payrollFinancialYear);
            }
        
//        return mv;
    }
        return mv;
    }
     public ModelAndView deleteSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String ptId[] = request.getParameterValues("checkId");
        for (String z : ptId) {
            try {
                payrollFinancialYearService.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info : One or more records are deleted successfully.");
            } catch (Exception e) {
            }
        }
        mv = showResult(request, response);
        return mv;
    }
}
