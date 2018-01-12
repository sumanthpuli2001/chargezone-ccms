/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.model.PayrollProvidentFund;
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
public class PayrollProvidentFundController extends PayrollProvidentFundAbstract {

    public ModelAndView showResult(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollProvidentFund payrollProvidentFund = new PayrollProvidentFund();
        ZydexLocationMaster zydexLocationMaster = new ZydexLocationMaster();
        List<?> pfList = payrollProvidentFundService.read();
        for (Object obj : pfList) {
            payrollProvidentFund = (PayrollProvidentFund) obj;
            zydexLocationMaster = zydexLocationMasterService.readById(payrollProvidentFund.getZydexLocationMaster().getId());
            payrollProvidentFund.setZydexLocationMaster(zydexLocationMaster);
        }
        request.setAttribute("pfList", pfList);
        mv.setViewName("Payroll/PayrollProvidentFundResult");
        return mv;
    }

    public ModelAndView createClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollProvidentFund payrollProvidentFund = new PayrollProvidentFund();
        payrollProvidentFund.setZydexLocationMaster(new ZydexLocationMaster());
        zydexLocationList(request);
        mv.getModelMap().put("payrollProvidentFund",
                payrollProvidentFund);
        mv.setViewName("Payroll/PayrollProvidentFundCreate");
        return mv;
    }

    public ModelAndView createSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollProvidentFund payrollProvidentFund = new PayrollProvidentFund();
        PayrollProvidentFund payrollProvidentFund1 = new PayrollProvidentFund();
        BindException errors = new BindException(payrollProvidentFund, "payrollProvidentFund");
        bind(request, payrollProvidentFund);
        zydexLocationList(request);
        payrollProvidentFundValidator.validate(payrollProvidentFund, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Provident Fund is not valid.");
            mv.addAllObjects(errors.getModel());
        } else {
            boolean flag = false;
            List list = payrollProvidentFundService.read();
            for (Object o : list) {
                payrollProvidentFund1 = (PayrollProvidentFund) o;
                if (payrollProvidentFund1.getZydexLocationMaster().getId().intValue()
                        == payrollProvidentFund.getZydexLocationMaster().getId().intValue()) {
                    flag = true;
                }
            }
            if (!flag) {
                payrollProvidentFundService.create(payrollProvidentFund);

                log(request, ActionType.CREATE.toString(),
                        "The Provident Fund is created -." + payrollProvidentFund.getEpfPercentage());
                request.setAttribute("successMessage",
                        "Information : The Provident Fund is added successfully.");
            } else {
                request.setAttribute("failureMessage",
                        "Error : The Provident Fund is Already Added.");
                 mv.setViewName("Payroll/PayrollProvidentFundCreate");
                 mv.getModelMap().put("payrollProvidentFund", payrollProvidentFund);
            }
        }
        mv.getModelMap().put("payrollProvidentFund", payrollProvidentFund);
        mv.setViewName("Payroll/PayrollProvidentFundCreate");
        return mv;
    }

    public ModelAndView viewClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String fundListId = request.getParameter("id");
        PayrollProvidentFund payrollProvidentFund;
        payrollProvidentFund = payrollProvidentFundService.readById(Integer.parseInt(fundListId));
        zydexLocationList(request);
        ZydexLocationMaster zydexLocationMaster = new ZydexLocationMaster();
        zydexLocationMaster = zydexLocationMasterService.readById(payrollProvidentFund.getZydexLocationMaster().getId());
        payrollProvidentFund.setZydexLocationMaster(zydexLocationMaster);
        log(request, ActionType.VIEW.toString(),
                "The Provident Fund is Viewed -." + payrollProvidentFund.getEpfPercentage());
        mv.getModelMap().put("payrollProvidentFund",
                payrollProvidentFund);
        mv.setViewName("Payroll/PayrollProvidentFundView");
        return mv;
    }

    public ModelAndView editSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollProvidentFund payrollProvidentFund = new PayrollProvidentFund();
        BindException errors = new BindException(payrollProvidentFund, "payrollProvidentFund");
        bind(request, payrollProvidentFund);
        zydexLocationList(request);
        payrollProvidentFundValidator.validate(payrollProvidentFund, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Provident Fund is not valid.");
            mv.addAllObjects(errors.getModel());
        } else {
            
            payrollProvidentFundService.update(payrollProvidentFund);
            log(request, ActionType.UPDATE.toString(),
                    "The Provident Fund is created -." + payrollProvidentFund.getEpfPercentage());
            request.setAttribute("successMessage",
                    "Information : The Provident Fund is Updated successfully.");
        }
        mv.getModelMap().put("payrollProvidentFund", payrollProvidentFund);
        mv.setViewName("Payroll/PayrollProvidentFundView");
        
        return mv;
    }

    public ModelAndView deleteSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String ptId[] = request.getParameterValues("checkId");
        for (String z : ptId) {
            try {
                payrollProvidentFundService.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info : One or more records are deleted successfully.");
            } catch (Exception e) {
            }
        }
        mv = showResult(request, response);
        return mv;
    }

}
