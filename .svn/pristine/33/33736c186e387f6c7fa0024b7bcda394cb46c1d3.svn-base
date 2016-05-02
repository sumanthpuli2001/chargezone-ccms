/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.appraisalPerformance;

import com.bul.zydex.model.CompetencyEvaluationMaster;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author admin
 */
public class CompetencyEvaluationMasterController extends CompetencyEvaluationMasterAbstract{
     public ModelAndView createClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        CompetencyEvaluationMaster competencyEvaluationMaster = new CompetencyEvaluationMaster();

        mv.getModelMap().put("competencyEvaluationMaster", competencyEvaluationMaster);
        mv.setViewName("Appraisal/CompetencyEvaluation");
        return mv;
    } 
      public ModelAndView createSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        CompetencyEvaluationMaster competencyEvaluationMaster = new CompetencyEvaluationMaster();
        BindException errors = new BindException(competencyEvaluationMaster, "competencyEvaluationMaster");
        bind(request, competencyEvaluationMaster);
        competencyEvaluationMasterValidator.validate(competencyEvaluationMaster, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
              mv.addAllObjects(errors.getModel());
//            mv = createClick(request, response);
            mv.setViewName("Appraisal/CompetencyEvaluation");
        } else {
            competencyEvaluationMasterService.create(competencyEvaluationMaster);
            request.setAttribute("successMessage",
                    "Information : The Information is saved Successfully.");
            mv = searchSubmit(request, response);
        }
        //mv.setViewName("Appraisal/CompetencyEvaluation");
        return mv;
    }
      public ModelAndView searchSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        CompetencyEvaluationMaster competencyEvaluationMaster = new CompetencyEvaluationMaster();
        List<?> competencyEvaluationMasterList = competencyEvaluationMasterService.read();

        mv.getModelMap().put("list", competencyEvaluationMasterList);
        mv.getModelMap().put("competencyEvaluationMasterList", competencyEvaluationMasterList);
        mv.setViewName("Appraisal/CompetencyEvaluationResult");

        return mv;
    }
      public ModelAndView deleteSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String competencyId[] = request.getParameterValues("checkId");
        for (String z : competencyId) {
            try {
                competencyEvaluationMasterService.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info : One or more records are deleted successfully.");
            } catch (Exception e) {

            }
        }
        mv = searchSubmit(request, response);
        return mv;
    }
}
