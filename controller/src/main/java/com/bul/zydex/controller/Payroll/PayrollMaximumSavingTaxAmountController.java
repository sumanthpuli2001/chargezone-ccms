/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.model.PayrollMaximumSavingTaxAmount;
import com.bul.zydex.model.ZydexLocationMaster;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author AJAY <ajay@bulwarks.com>
 */
public class PayrollMaximumSavingTaxAmountController extends PayrollMaximumSavingTaxAmountAbstract {

    public ModelAndView createClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollMaximumSavingTaxAmount payrollMaximumSavingTaxAmount = new PayrollMaximumSavingTaxAmount();
        zydexLocationList(request);
        payrollMaximumSavingTaxAmount.setZydexLocationMaster(new ZydexLocationMaster());
        mv.getModelMap().put("payrollMaximumSavingTaxAmount",
                payrollMaximumSavingTaxAmount);
        mv.setViewName("Payroll/PayrollMaximumSavingTaxAmountCreate");
        return mv;
    }

    public ModelAndView createSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollMaximumSavingTaxAmount payrollMaximumSavingTaxAmount = new PayrollMaximumSavingTaxAmount();
        BindException errors = new BindException(payrollMaximumSavingTaxAmount, "payrollMaximumSavingTaxAmount");
        bind(request, payrollMaximumSavingTaxAmount);
        zydexLocationList(request);
        payrollMaximumSavingTaxAmountValidator.validate(payrollMaximumSavingTaxAmount, errors);

        if (errors.hasErrors()) {
            request.setAttribute("faliureMessage",
                    "Error : The Maximum Saving Tax Amount is not valid.");
            mv.addAllObjects(errors.getModel());
            mv.getModelMap()
                    .put("payrollMaximumSavingTaxAmount", payrollMaximumSavingTaxAmount);
            mv.setViewName("Payroll/PayrollMaximumSavingTaxAmountCreate");
        } else {if (!payrollMaximumSavingTaxAmountService.isExist(payrollMaximumSavingTaxAmount)) {
            payrollMaximumSavingTaxAmountService.create(payrollMaximumSavingTaxAmount);

            request.setAttribute("successMessage",
                    "Information: Maximum Saving Tax Amount is Created successfully");
            mv = showResult(request, response);
        }
         else {
                request.setAttribute("failureMessage",
                        "Error : The Maximum Saving Tax is already there.");
                mv.setViewName("Payroll/PayrollMaximumSavingTaxAmountCreate");
                 mv.getModelMap().put("payrollMaximumSavingTaxAmount", payrollMaximumSavingTaxAmount);
            }
        
//        return mv;
    }
        return mv;
    }

    public ModelAndView showResult(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollMaximumSavingTaxAmount payrollMaximumSavingTaxAmount = new PayrollMaximumSavingTaxAmount();
        ZydexLocationMaster zydexLocationMaster = new ZydexLocationMaster();
        List<?> maximumSavingAmountList = payrollMaximumSavingTaxAmountService.read();
        for (Object obj : maximumSavingAmountList) {
            payrollMaximumSavingTaxAmount = (PayrollMaximumSavingTaxAmount) obj;
            zydexLocationMaster = zydexLocationMasterService.readById(payrollMaximumSavingTaxAmount.getZydexLocationMaster().getId());
            payrollMaximumSavingTaxAmount.setZydexLocationMaster(zydexLocationMaster);
        }
        request.setAttribute("maximumSavingAmountList", maximumSavingAmountList);
        mv.setViewName("Payroll/PayrollMaximumSavingTaxAmountResult");
        return mv;
    }

    public ModelAndView viewClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollMaximumSavingTaxAmount payrollMaximumSavingTaxAmount = new PayrollMaximumSavingTaxAmount();
        ZydexLocationMaster zydexLocationMaster = new ZydexLocationMaster();
        String id = request.getParameter("id");
        zydexLocationList(request);
        payrollMaximumSavingTaxAmount = payrollMaximumSavingTaxAmountService.readById(Integer.parseInt(id));
        zydexLocationMaster = zydexLocationMasterService.readById(payrollMaximumSavingTaxAmount.getZydexLocationMaster().getId());
        payrollMaximumSavingTaxAmount.setZydexLocationMaster(zydexLocationMaster);
        mv.getModelMap().put("payrollMaximumSavingTaxAmount", payrollMaximumSavingTaxAmount);
        mv.setViewName("Payroll/PayrollMaximumSavingTaxAmountView");
        return mv;
    }

    public ModelAndView editSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollMaximumSavingTaxAmount payrollMaximumSavingTaxAmount = new PayrollMaximumSavingTaxAmount();
        BindException errors = new BindException(payrollMaximumSavingTaxAmount, "payrollMaximumSavingTaxAmount");
        bind(request, payrollMaximumSavingTaxAmount);
        zydexLocationList(request);
        payrollMaximumSavingTaxAmountValidator.validate(payrollMaximumSavingTaxAmount, errors);

        if (errors.hasErrors()) {
            request.setAttribute("faliureMessage",
                    "Error : The Maximum Saving Tax Amount is not valid.");
            mv.addAllObjects(errors.getModel());
            mv.getModelMap()
                    .put("payrollMaximumSavingTaxAmount", payrollMaximumSavingTaxAmount);
            mv.setViewName("Payroll/PayrollMaximumSavingTaxAmountView");
        } else {
            payrollMaximumSavingTaxAmountService.update(payrollMaximumSavingTaxAmount);

            request.setAttribute("successMessage",
                    "Information: Maximum Saving Tax Amount is Updated successfully");
            mv = showResult(request, response);
        }
         
        return mv;
    }

    public ModelAndView deleteSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String ptId[] = request.getParameterValues("checkId");
        for (String z : ptId) {
            try {
                payrollMaximumSavingTaxAmountService.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info : One or more records are deleted successfully.");
            } catch (Exception e) {
            }
        }
        mv = showResult(request, response);
        return mv;
    }

}
