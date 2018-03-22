/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.CandidateF2F;

import com.bul.zydex.model.CandidateApplyJob;
import com.bul.zydex.model.CandidateF2FApproval;
import com.bul.zydex.model.CandidateF2FRequest;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.VacancyMaster;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author DELL
 */
public class CandidateF2FApprovalController extends CandidateF2FApprovalAbstract {

    public ModelAndView candidateF2FInterviewList(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        List<?> f2flist = new ArrayList<>();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");

        f2flist = candidateF2FRequestService.interviewReqDetailread();

        request.setAttribute("F2FInterviewList", f2flist);

        mv.setViewName("CandidateFtoF/F2FInterviewReviewResult");
        return mv;
    }

    public ModelAndView openInterviewReviewPage(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        String applicationId = request.getParameter("id");
        CandidateF2FRequest candidateF2FRequest = new CandidateF2FRequest();
        CandidateApplyJob candidateApplyJob = new CandidateApplyJob();
        candidateF2FRequest = candidateF2FRequestService.readById(Integer.parseInt(applicationId));
        candidateApplyJob = candidateJobApplyService.readById(candidateF2FRequest.getCandidateApplyJob().getId());
        VacancyMaster vm = vacancyMasterService.readById(candidateF2FRequest.getVacancyMaster().getId());
        List<CandidateF2FApproval> committeedetaillist = new ArrayList<>();
        List<CandidateF2FApproval> comitteeList = (List<CandidateF2FApproval>) candidateF2FApprovalService.readByReqId(candidateF2FRequest.getId());
        for (CandidateF2FApproval cffa : comitteeList) {
            EmployeeMaster em = employeeMasterService.readById(cffa.getEmployeeMaster().getId());
            cffa.setEmployeeMaster(em);
            committeedetaillist.add(cffa);

        }

        candidateF2FRequest.setCandidateApplyJob(candidateApplyJob);
        candidateF2FRequest.setVacancyMaster(vm);
        request.setAttribute("comitteeList", committeedetaillist);
        mv.getModelMap().put("candidateF2FRequest", candidateF2FRequest);

        mv.setViewName("CandidateFtoF/F2FInterviewReview");
        return mv;
    }

    public ModelAndView hrApprovalSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");
        String hrRemark = request.getParameter("hrRemark");
        String btnSubmit = request.getParameter("btnSubmit");

        if (btnSubmit.equals("approve")) {
        }
        if (btnSubmit.equals("reject")) {
            
        }
        if (btnSubmit.equals("recycle")) {
            
        }
       

      
        return mv;
    }

}
