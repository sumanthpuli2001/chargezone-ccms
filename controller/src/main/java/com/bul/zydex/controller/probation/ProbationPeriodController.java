/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.probation;

import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.LeaveTypeMaster;
import com.bul.zydex.model.ProbationPeriod;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author AJAY
 */
public class ProbationPeriodController extends ProbationPeriodAbstract {

    public ModelAndView createClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ProbationPeriod probationPeriod = new ProbationPeriod();
        DesignationMaster designationMaster = new DesignationMaster();
        probationPeriod.setDesignationMaster(designationMaster);
        designationList(request);
        mv.getModelMap().put("probationPeriod", probationPeriod);
        mv.setViewName("Probation/ProbationPeriodCreate");
        return mv;
    }

    public ModelAndView createSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ProbationPeriod probationPeriod = new ProbationPeriod();
        BindException errors = new BindException(probationPeriod, "probationPeriod");
        bind(request, probationPeriod);
        designationList(request);
        probationPeriodValidator.validate(probationPeriod, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv.addAllObjects(errors.getModel());
            mv.getModelMap().put("probationPeriod", probationPeriod);
            mv.setViewName("Probation/ProbationPeriodCreate");
        } else {
            boolean isExist = probationPeriodService.isExist(probationPeriod);
            if (isExist) {
                probationPeriodService.create(probationPeriod);
                request.setAttribute("successMessage",
                        "Information : The Information is saved Successfully.");
            } else {
                request.setAttribute("failureMessage",
                        "Error : Information Is Already Exist.");
            }

            mv = showResult(request, response);
        }
        return mv;
    }

    public ModelAndView showResult(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<?> list = probationPeriodService.readprobationPeriod();
        mv.getModelMap().put("list", list);
        mv.setViewName("Probation/ProbationPeriodResult");
        return mv;
    }

    public ModelAndView viewClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ProbationPeriod probationPeriod = new ProbationPeriod();
        DesignationMaster designationMaster = new DesignationMaster();
        String id = request.getParameter("id");
        designationList(request);
        probationPeriod = probationPeriodService.readById(Integer.parseInt(id));
        designationMaster = designationMasterService.readById(probationPeriod.getDesignationMaster().getId());
        probationPeriod.setDesignationMaster(designationMaster);
        request.setAttribute("probationPeriod", probationPeriod);
        mv.setViewName("Probation/ProbationPeriodView");
        return mv;
    }

    public ModelAndView editSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ProbationPeriod probationPeriod = new ProbationPeriod();
        BindException errors = new BindException(probationPeriod, "probationPeriod");
        bind(request, probationPeriod);
        designationList(request);
        probationPeriodValidator.validate(probationPeriod, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv.addAllObjects(errors.getModel());
            mv.getModelMap().put("probationPeriod", probationPeriod);
            mv.setViewName("Probation/ProbationPeriodCreate");
        } else {
            boolean isExist = probationPeriodService.isExist(probationPeriod);
            if (isExist) {
                probationPeriodService.update(probationPeriod);
                request.setAttribute("successMessage",
                        "Information : The Information is Updated Successfully.");
            } else {
                request.setAttribute("failureMessage",
                        "Error : Information Is Already Exist.");
            }
            mv = showResult(request, response);
        }
        return mv;
    }

    public ModelAndView deleteSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String checkId[] = request.getParameterValues("checkId");
        for (String z : checkId) {
            try {
                probationPeriodService.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info : One or more records are deleted successfully.");
            } catch (Exception e) {

            }
        }
        mv = showResult(request, response);
        return mv;
    }

}
