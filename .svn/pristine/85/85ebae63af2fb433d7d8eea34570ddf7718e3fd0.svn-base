/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.appraisalPerformance;

import com.bul.zydex.model.CompetencyEvaluationMaster;
import com.bul.zydex.model.CompetencyEvaluationTextmaster;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author admin
 */
public class CompetencyEvaluationTextmasterController extends CompetencyEvaluationTextmasterAbstract {

    public ModelAndView createClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        CompetencyEvaluationTextmaster competencyEvaluationTextmaster = new CompetencyEvaluationTextmaster();
        competencyEvaluationTextmaster.setCompetencyEvaluationMaster(new CompetencyEvaluationMaster());
        competencyList(request);
        mv.getModelMap().put("competencyEvaluationTextmaster", competencyEvaluationTextmaster);
        mv.setViewName("Appraisal/CompetencyEvaluationTextInfo");
        return mv;
    }

    public ModelAndView createSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        CompetencyEvaluationTextmaster competencyEvaluationTextmaster = new CompetencyEvaluationTextmaster();
        CompetencyEvaluationMaster competencyEvaluationMaster = new CompetencyEvaluationMaster();
        BindException errors = new BindException(competencyEvaluationTextmaster, "competencyEvaluationTextmaster");
        bind(request, competencyEvaluationTextmaster);
        competencyEvaluationTextmasterValidator.validate(competencyEvaluationTextmaster, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv.addAllObjects(errors.getModel());
            mv.setViewName("Appraisal/CompetencyEvaluationTextInfo");
//            mv = createClick(request, response);
        } else {
            String competencyId = request.getParameter("competencyEvaluationMaster.id");
            competencyEvaluationMaster.setId(Integer.parseInt(competencyId));
            competencyEvaluationTextmaster.setCompetencyEvaluationMaster(competencyEvaluationMaster);
            competencyEvaluationTextmasterService.create(competencyEvaluationTextmaster);
            request.setAttribute("successMessage",
                    "Information : The Information is saved Successfully.");
            mv = searchSubmit(request, response);
        }
        //mv.getModelMap().put("competencyEvaluationTextmaster", competencyEvaluationTextmaster);
        //mv.setViewName("Appraisal/CompetencyEvaluationTextInfo");
        return mv;
    }

    public ModelAndView searchSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        CompetencyEvaluationTextmaster competencyEvaluationTextmaster = new CompetencyEvaluationTextmaster();

        List<?> competencyEvaluationTextmasterList = competencyEvaluationTextmasterService.readCompetencyEvaluationDetail();

        mv.getModelMap().put("list", competencyEvaluationTextmasterList);
        mv.getModelMap().put("competencyEvaluationMasterList", competencyEvaluationTextmasterList);
        mv.setViewName("Appraisal/CompetencyEvaluationTextInfoResult");

        return mv;
    }

    public ModelAndView deleteSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String competencyId[] = request.getParameterValues("checkId");
        for (String z : competencyId) {
            try {
                competencyEvaluationTextmasterService.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info : One or more records are deleted successfully.");
            } catch (Exception e) {

            }
        }
        mv = searchSubmit(request, response);
        return mv;
    }

    public ModelAndView ajaxCall(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String competencyEvaluationId = request.getParameter("competencyEvaluationId");
        CompetencyEvaluationMaster competencyEvaluationMaster = new CompetencyEvaluationMaster();
        CompetencyEvaluationTextmaster competencyEvaluationTextmaster = new CompetencyEvaluationTextmaster();
        CompetencyEvaluationTextmaster competencyEvaluationTextmaster1 = new CompetencyEvaluationTextmaster();
        //employeeMaster.setId(Integer.parseInt(id));
        competencyEvaluationMaster.setId(Integer.parseInt(competencyEvaluationId));
        competencyEvaluationTextmaster.setCompetencyEvaluationMaster(competencyEvaluationMaster);
        List<?> list = competencyEvaluationTextmasterService.readCompetencyEvaluationIdWiseDetail(competencyEvaluationTextmaster);
        //String dataByPrNo = "";
        //String deviation = "";
        int competencyId = 0;
        String competencyText = "";
//        if (!list.isEmpty()) {
//            for (Object o : list) {
//
//                Object[] competencyTextId = (Object[]) o;
////                competencyEvaluationTextmaster = (CompetencyEvaluationTextmaster) o;
//                //for(int i=0; i <= list.size(); i++){
//                competencyId = (Integer) competencyTextId[0];
//                competencyText = (String) competencyTextId[1];
//                competencyEvaluationTextmaster.setId(competencyId);
//                competencyEvaluationTextmaster.setInfoText(competencyText);
//
//            }
//        }
//        if (deviation.equals("no")) {
//            dataByPrNo = "Yes";
//        } else {
//            dataByPrNo = "";
//        }
        request.setAttribute("list", list); 
        request.setAttribute("competencyEvaluationId", competencyEvaluationId); 
//        mv.getModelMap().put("competencyEvaluationTextmaster", competencyEvaluationTextmaster);
        mv.setViewName("Appraisal/SubPerformanceAppraisalForm");
        return mv;
    }
}
