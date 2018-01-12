/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.model.PayrollProfessionalTax;
import com.bul.zydex.util.ActionType;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author AJAY <ajay@bulwarks.com>
 */
public class PayrollProfessionalTaxController extends PayrollProfessionalTaxAbstract {

    public ModelAndView createClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollProfessionalTax payrollProfessionalTax = new PayrollProfessionalTax();
        mv.getModelMap().put("payrollProfessionalTax",
                payrollProfessionalTax);
        mv.setViewName("Payroll/PayrollProfessionalTaxCreate");
        return mv;
    }

    public ModelAndView createSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollProfessionalTax payrollProfessionalTax = new PayrollProfessionalTax();

        BindException errors = new BindException(payrollProfessionalTax, "payrollProfessionalTax");
        bind(request, payrollProfessionalTax);
        payrollProfessionalTaxValidator.validate(payrollProfessionalTax, errors);

        if (errors.hasErrors()) {
            request.setAttribute("faliureMessage",
                    "Error : The Professional Tax is not valid.");
            mv.addAllObjects(errors.getModel());
        } else {
            payrollProfessionalTaxService.create(payrollProfessionalTax);

            request.setAttribute("successMessage",
                    "Information: The Professional Tax is Created successfully");
        }

        mv.getModelMap().put("payrollProfessionalTax", payrollProfessionalTax);
        mv.setViewName("Payroll/PayrollProfessionalTaxCreate");
        mv = showResult(request, response);
        return mv;
    }

    public ModelAndView showResult(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollProfessionalTax payrollProfessionalTax = new PayrollProfessionalTax();
//        ZydexLocationMaster zydexLocationMaster = new ZydexLocationMaster();
        List<?> ptList = payrollProfessionalTaxService.read();
        for (Object obj : ptList) {
            payrollProfessionalTax = (PayrollProfessionalTax) obj;
//            zydexLocationMaster = zydexLocationMasterService.readById(payrollProfessionalTax.getZydexLocationMaster().getId());
//            payrollProfessionalTax.setZydexLocationMaster(zydexLocationMaster);
        }
        request.setAttribute("ptList", ptList);
        mv.setViewName("Payroll/PayrollProfessionalTaxResult");
        return mv;
    }

    public ModelAndView viewClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollProfessionalTax payrollProfessionalTax = new PayrollProfessionalTax();
        String id = request.getParameter("id");
        zydexLocationList(request);
        payrollProfessionalTax = payrollProfessionalTaxService.readById(Integer.parseInt(id));
//        zydexLocationMaster = zydexLocationMasterService.readById(payrollProfessionalTax.getZydexLocationMaster().getId());
//        payrollProfessionalTax.setZydexLocationMaster(zydexLocationMaster);
        mv.getModelMap().put("payrollProfessionalTax", payrollProfessionalTax);
        mv.setViewName("Payroll/PayrollProfessionalTaxView");
      
        return mv;
    }

    public ModelAndView editSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollProfessionalTax payrollProfessionalTax = new PayrollProfessionalTax();

        BindException errors = new BindException(payrollProfessionalTax, "payrollProfessionalTax");
        bind(request, payrollProfessionalTax);
        payrollProfessionalTaxValidator.validate(payrollProfessionalTax, errors);
        zydexLocationList(request);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Professional Tax is not valid.");
            mv.addAllObjects(errors.getModel());
        } else {
            payrollProfessionalTaxService.update(payrollProfessionalTax);
            log(request, ActionType.UPDATE.toString(),
                    "The Professional Tax is Updated -."
                    + payrollProfessionalTax.getAmount());
            request.setAttribute("successMessage",
                    "Information: The Professional Tax is Updated successfully");
        }

        mv.getModelMap().put("payrollProfessionalTax", payrollProfessionalTax);
        mv.setViewName("Payroll/PayrollProfessionalTaxView");
        return mv;
    }

    public ModelAndView deleteSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String ptId[] = request.getParameterValues("checkId");
        for (String z : ptId) {
            try {
                payrollProfessionalTaxService.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info : One or more records are deleted successfully.");
            } catch (Exception e) {
            }
        }
        mv = showResult(request, response);
        return mv;
    }

}
