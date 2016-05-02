/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.appraisalPerformance;

import com.bul.zydex.model.AppraisalPerformanceKra;
import com.bul.zydex.model.UpdateAppraisalPerformanceKra;
import com.bul.zydex.service.appraisalPerformance.UpdateAppraisalPerformanceKraService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author admin
 */
public class UpdateAppraisalPerformanceKraController extends UpdateAppraisalPerformanceKraAbstract {

    public ModelAndView historyAjaxCall(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String kraId = request.getParameter("kraId");
        AppraisalPerformanceKra appraisalPerformanceKra = new AppraisalPerformanceKra();
        appraisalPerformanceKra.setId(Integer.parseInt(kraId));
        UpdateAppraisalPerformanceKra updateAppraisalPerformanceKra = new UpdateAppraisalPerformanceKra();
        updateAppraisalPerformanceKra.setAppraisalPerformanceKra(appraisalPerformanceKra);
        List<?> updateKraList = updateAppraisalPerformanceKraService.readByUpdateKragoal(updateAppraisalPerformanceKra);
        request.setAttribute("updateKraList", updateKraList);

//        request.setAttribute("list", list); 
//        mv.getModelMap().put("competencyEvaluationTextmaster", competencyEvaluationTextmaster);
        mv.setViewName("Appraisal/HistoryUpdateKraPerformanceAppraisalForm");
        return mv;
    }  
}
