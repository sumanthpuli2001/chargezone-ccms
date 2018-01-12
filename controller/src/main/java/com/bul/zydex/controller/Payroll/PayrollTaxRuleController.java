/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.model.PayrollTaxRule;
import com.bul.zydex.model.ZydexLocationMaster;
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
public class PayrollTaxRuleController extends PayrollTaxRuleAbstract {

    public ModelAndView createClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollTaxRule payrollTaxRule = new PayrollTaxRule();
        zydexLocationList(request);
        payrollTaxRule.setZydexLocationMaster(new ZydexLocationMaster());
        mv.getModelMap().put("payrollTaxRule",
                payrollTaxRule);
        mv.setViewName("Payroll/PayrollTaxRuleCreate");
        return mv;
    }

    public ModelAndView createSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollTaxRule payrollTaxRule = new PayrollTaxRule();
        BindException errors = new BindException(payrollTaxRule, "payrollTaxRule");
        bind(request, payrollTaxRule);
        zydexLocationList(request);
        payrollTaxRuleValidator.validate(payrollTaxRule, errors);

        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Tax Rule is not valid.");
            mv.addAllObjects(errors.getModel());
            mv.getModelMap()
                    .put("payrollTaxRule", payrollTaxRule);
            mv.setViewName("Payroll/PayrollTaxRuleCreate");
        } else {
            if (payrollTaxRuleService.isExist(payrollTaxRule)) {
                 request.setAttribute("failureMessage",
                        "Error : The payroll Tax Rule is already there.");
                 mv.getModelMap().put("payrollTaxRule", payrollTaxRule);
                mv.setViewName("Payroll/PayrollTaxRuleCreate");
           
        } else {
                payrollTaxRuleService.create(payrollTaxRule);
            log(request, ActionType.CREATE.toString(),
                    "The Tax Rule is created -."
                    + payrollTaxRule.getTaxPercentage());
            request.setAttribute("successMessage",
                    "Information: The Tax Rule is Created successfully");
            mv = showResult(request, response);
            }
        
//        return mv;
    }
       
        return mv;
    }

    public ModelAndView showResult(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollTaxRule payrollTaxRule = new PayrollTaxRule();
        ZydexLocationMaster zydexLocationMaster = new ZydexLocationMaster();
        List<?> taxRuleList = payrollTaxRuleService.read();
        for (Object obj : taxRuleList) {
            payrollTaxRule = (PayrollTaxRule) obj;
            zydexLocationMaster = zydexLocationMasterService.readById(payrollTaxRule.getZydexLocationMaster().getId());
            payrollTaxRule.setZydexLocationMaster(zydexLocationMaster);
        }
        request.setAttribute("taxRuleList", taxRuleList);
        mv.setViewName("Payroll/PayrollTaxRuleResult");
        return mv;
    }

    public ModelAndView viewClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollTaxRule payrollTaxRule = new PayrollTaxRule();
        ZydexLocationMaster zydexLocationMaster = new ZydexLocationMaster();
        String id = request.getParameter("id");
        zydexLocationList(request);
        payrollTaxRule = payrollTaxRuleService.readById(Integer.parseInt(id));
        zydexLocationMaster = zydexLocationMasterService.readById(payrollTaxRule.getZydexLocationMaster().getId());
        payrollTaxRule.setZydexLocationMaster(zydexLocationMaster);
        mv.getModelMap().put("payrollTaxRule", payrollTaxRule);
        mv.setViewName("Payroll/PayrollTaxRuleView");
        return mv;
    }

    public ModelAndView editSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollTaxRule payrollTaxRule = new PayrollTaxRule();
        BindException errors = new BindException(payrollTaxRule, "payrollTaxRule");
        bind(request, payrollTaxRule);
        zydexLocationList(request);
        payrollTaxRuleValidator.validate(payrollTaxRule, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Tax Rule is not valid.");
            mv.addAllObjects(errors.getModel());
            mv.getModelMap()
                    .put("payrollTaxRule", payrollTaxRule);
            mv.setViewName("Payroll/PayrollTaxRuleView");
        } else  {
            
            
            payrollTaxRuleService.update(payrollTaxRule);
            log(request, ActionType.UPDATE.toString(),
                    "The Tax Rule is Updated -."
                    + payrollTaxRule.getTaxPercentage());
            request.setAttribute("successMessage",
                    "Information: The Tax Rule is Updated successfully");
            mv = showResult(request, response);
        }
        
        return mv;
    }

    public ModelAndView deleteSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String ptId[] = request.getParameterValues("checkId");
        for (String z : ptId) {
            try {
                payrollTaxRuleService.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info : One or more records are deleted successfully.");
            } catch (Exception e) {
            }
        }
        mv = showResult(request, response);
        return mv;
    }

}
