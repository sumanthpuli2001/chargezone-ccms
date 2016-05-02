/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.policy;

import com.bul.zydex.model.LevelMaster;
import com.bul.zydex.model.PolicyMaster;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author AJAY
 */
public class PolicyMasterController extends PolicyMasterAbstract {

    public ModelAndView showList(HttpServletRequest request, HttpServletResponse response, PolicyMaster policyMaster) throws Exception {
        ModelAndView mv = new ModelAndView("Policy/PolicyList", "policyMaster", policyMaster);
        List<?> policyList = policyMasterService.read();
        mv.addObject("policyList", policyList);
        return mv;

    }

    public ModelAndView createClick(HttpServletRequest request, HttpServletResponse response, PolicyMaster policyMaster) throws Exception {

        return new ModelAndView("Policy/PolicyCreate", "policyMaster", policyMaster);
    }

    public ModelAndView createSubmit(HttpServletRequest request, HttpServletResponse response, PolicyMaster policyMaster) throws Exception {
        BindException errors = new BindException(policyMaster, "policyMaster");
        bind(request, policyMaster);
        policyMasterValidator.validate(policyMaster, errors);
        ModelAndView mv = new ModelAndView();
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage", "Error : Information Is Not Valid.");
            mv.addAllObjects(errors.getModel());
            mv.setViewName("Policy/PolicyCreate");
        } else {
            if (policyMasterService.isExist(policyMaster)) {
                policyMasterService.createOrUpdate(policyMaster);
                List<?> policyList = policyMasterService.read();
                mv.addObject("policyList", policyList);
                mv.addObject("successMessage", "Information : Information Saved Successfully.");
                mv.setViewName("Policy/PolicyList");
            } else {
                mv.setViewName("Policy/PolicyCreate");
                mv.addObject("failureMessage", "Error : Information Is Already Exist. ");
            }
        }
        mv.getModelMap().put("policyMaster", policyMaster);
        return mv;
    }

    public ModelAndView deleteClick(HttpServletRequest request, HttpServletResponse response, PolicyMaster policyMaster) throws Exception {
        String[] checkId = request.getParameterValues("checkId");
        String checkStr = "";
        ModelAndView mv = new ModelAndView();
        int count = 0;
        boolean flag = false;
        for (String checkedValues : checkId) {
            try {
                policyMasterService.delete(Integer.parseInt(checkedValues));
            } catch (Exception e) {
                try {
                    policyMaster = policyMasterService.readById(Integer.parseInt(checkedValues));
                    if (count == 0) {
                        checkStr += policyMaster.getPolicyName();
                    } else {
                        checkStr += "," + policyMaster.getPolicyName();
                    }
                    count++;
                    flag = true;
                } catch (Exception ee) {

                }
            }
        }
        if (flag) {
            request.setAttribute("failureMessage", "Error : In Use, Can't Be Deleted.....  " + "<b>" + checkStr + "</b>");
        } else {
            request.setAttribute("successMessage", "Information Is Deleted Successfully.");
        }
        mv.setViewName("forward:policyMaster.htm?act=showList");
        return mv;
    }
}
