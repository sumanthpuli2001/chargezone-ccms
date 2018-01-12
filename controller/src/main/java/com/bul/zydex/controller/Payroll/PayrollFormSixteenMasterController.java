/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.model.PayrollFinancialYear;
import com.bul.zydex.model.PayrollFormSixteenMaster;
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
public class PayrollFormSixteenMasterController extends PayrollFormSixteenMasterAbstract{
    
    
     public ModelAndView showResult(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollFormSixteenMaster payrollFormSixteenMaster = new PayrollFormSixteenMaster();
        ZydexLocationMaster zydexLocationMaster = new ZydexLocationMaster();
        PayrollFinancialYear payrollFinancialYear = new PayrollFinancialYear();
        List<?> list = payrollFormSixteenMasterService.read();
        for (Object obj : list) {
            payrollFormSixteenMaster = (PayrollFormSixteenMaster) obj;
            zydexLocationMaster = zydexLocationMasterService.readById(payrollFormSixteenMaster.getZydexLocationMaster().getId());
            payrollFinancialYear = payrollFinancialYearService.readById(payrollFormSixteenMaster.getPayrollFinancialYear().getId());
            payrollFormSixteenMaster.setZydexLocationMaster(zydexLocationMaster);
            payrollFormSixteenMaster.setPayrollFinancialYear(payrollFinancialYear);
        }
        request.setAttribute("list", list);
        mv.setViewName("Payroll/PayrollFormSixteenMastershow");
        return mv;
    }
     public ModelAndView createClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollFormSixteenMaster payrollFormSixteenMaster = new PayrollFormSixteenMaster();
        PayrollFinancialYear payrollFinancialYear = new PayrollFinancialYear();
        zydexLocationList(request);
        payrollFormSixteenMaster.setZydexLocationMaster(new ZydexLocationMaster());
        financialYearList(request);
        payrollFormSixteenMaster.setPayrollFinancialYear(new PayrollFinancialYear());
        mv.getModelMap().put("payrollFormSixteenMaster",payrollFormSixteenMaster);
        mv.setViewName("Payroll/PayrollFormSixteenMasterCreate");
        return mv;
    }

    public ModelAndView createSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollFormSixteenMaster payrollFormSixteenMaster = new PayrollFormSixteenMaster();
        PayrollFinancialYear payrollFinancialYear = new PayrollFinancialYear();
        BindException errors = new BindException(payrollFormSixteenMaster, "payrollFormSixteenMaster");
        bind(request, payrollFormSixteenMaster);
        zydexLocationList(request);
        financialYearList(request);
        payrollFormSixteenMasterValidator.validate(payrollFormSixteenMaster, errors);

        if (errors.hasErrors()) {
            request.setAttribute("faliureMessage",
                    "Error : The Form Sixteen is not valid.");
            mv.addAllObjects(errors.getModel());
            mv.getModelMap()
                    .put("payrollFormSixteenMaster", payrollFormSixteenMaster);
            mv.setViewName("Payroll/PayrollFormSixteenMasterCreate");
        } else {
            payrollFormSixteenMasterService.create(payrollFormSixteenMaster);
         
                    
                  
            request.setAttribute("successMessage",
                    "Information: The Form Sixteen is Created successfully");
            mv = showResult(request, response);
        }
        return mv;
    }
      public ModelAndView viewClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollFormSixteenMaster payrollFormSixteenMaster = new PayrollFormSixteenMaster();
        PayrollFinancialYear payrollFinancialYear = new PayrollFinancialYear();
        ZydexLocationMaster zydexLocationMaster = new ZydexLocationMaster();
        String id = request.getParameter("id");
        zydexLocationList(request);
        financialYearList(request);
        payrollFormSixteenMaster = payrollFormSixteenMasterService.readById(Integer.parseInt(id));
        zydexLocationMaster = zydexLocationMasterService.readById(payrollFormSixteenMaster.getZydexLocationMaster().getId());
        payrollFormSixteenMaster.setZydexLocationMaster(zydexLocationMaster);
        mv.getModelMap().put("payrollFormSixteenMaster", payrollFormSixteenMaster);
        mv.setViewName("Payroll/PayrollFormSixteenMasterEdit");
        return mv;
    }

    public ModelAndView editSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollFormSixteenMaster payrollFormSixteenMaster = new PayrollFormSixteenMaster();
        BindException errors = new BindException(payrollFormSixteenMaster, "payrollFormSixteenMaster");
        bind(request, payrollFormSixteenMaster);
        zydexLocationList(request);
        financialYearList(request);
        payrollFormSixteenMasterValidator.validate(payrollFormSixteenMaster, errors);
        if (errors.hasErrors()) {
            request.setAttribute("faliureMessage",
                    "Error : The Form Sixteen is not valid.");
            mv.addAllObjects(errors.getModel());
            mv.getModelMap()
                    .put("payrollFormSixteenMaster",payrollFormSixteenMaster);
            mv.setViewName("Payroll/PayrollFormSixteenMasterEdit");
        } else {
            payrollFormSixteenMasterService.update(payrollFormSixteenMaster);
            
            request.setAttribute("successMessage",
                    "Information: The Form Sixteen  is Updated successfully");
            mv = showResult(request, response);
        }
        return mv;
    }
    
     public ModelAndView deleteSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String savingList[] = request.getParameterValues("checkId");
        for (String z : savingList) {
            try {
                payrollFormSixteenMasterService.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info : One or more records are deleted successfully.");
            } catch (Exception e) {

            }
        }
        mv = showResult(request, response);
        return mv;
    }
   
}
