/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.CandidateF2F;

import com.bul.zydex.model.CandidateApplyJob;
import com.bul.zydex.model.CandidateF2FApproval;
import com.bul.zydex.model.CandidateF2FRequest;
import com.bul.zydex.model.CandidateJobApplication;
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

    public ModelAndView candidateF2FReqListForInterviewer(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        List<?> f2flist = new ArrayList<>();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");

        f2flist = candidateF2FApprovalService.readByEmpId(employeeMaster.getId());

        request.setAttribute("F2FInterviewList", f2flist);

        mv.setViewName("CandidateFtoF/F2FReqForApprovalResult");
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

        List<?> approverCommentList = candidateF2FApprovalService.readEmployeeCommentByReqId(candidateF2FRequest.getId());

        request.setAttribute("applicationId", applicationId);

        candidateF2FRequest.setCandidateApplyJob(candidateApplyJob);
        candidateF2FRequest.setVacancyMaster(vm);
        request.setAttribute("commentlist", approverCommentList);
        request.setAttribute("comitteeList", committeedetaillist);
        mv.getModelMap().put("candidateF2FRequest", candidateF2FRequest);

        mv.setViewName("CandidateFtoF/F2FInterviewReview");
        return mv;
    }

    public ModelAndView openF2FApproverReviewPage(HttpServletRequest request,
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
        request.setAttribute("applicationId", applicationId);
        mv.getModelMap().put("candidateF2FRequest", candidateF2FRequest);

        mv.setViewName("CandidateFtoF/F2FReqApproverReview");
        return mv;
    }

    public ModelAndView approvalFaceToFaceInvitation(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        CandidateF2FRequest candidateF2FRequest = new CandidateF2FRequest();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        bind(request, candidateF2FRequest);
        String btnType = request.getParameter("btnType");
        String applicationId = request.getParameter("applicationId");
        String message = request.getParameter("message");

        candidateF2FRequest = candidateF2FRequestService.readById(Integer.parseInt(applicationId));
        CandidateJobApplication cja = candidateJobApplicationService.readById(candidateF2FRequest.getCandidateJobApplication().getId());

        if (btnType.equals("APPROVE")) {

            candidateF2FRequest.setStatus(2);
            candidateF2FRequest.setHrStatus(1);
            candidateF2FRequest.setMessage(message);
            candidateF2FRequest.setHrEmpId(employeeMaster.getId());
            candidateF2FRequest.setHrName(employeeMaster.getEmployeeName());
            candidateF2FRequestService.update(candidateF2FRequest);

            /////////approve
            cja.setStatus(11);
            candidateJobApplicationService.update(cja);
            request.setAttribute("successMessage",
                    "Information : The Request is Approved successfully.");

        }
        if (btnType.equals("ON HOLD")) {

            candidateF2FRequest.setStatus(3);
            candidateF2FRequest.setHrStatus(1);
            candidateF2FRequest.setMessage(message);
            candidateF2FRequest.setHrEmpId(employeeMaster.getId());
            candidateF2FRequest.setHrName(employeeMaster.getEmployeeName());
            candidateF2FRequestService.update(candidateF2FRequest);

            ///hold
            cja.setStatus(9);
            candidateJobApplicationService.update(cja);
            request.setAttribute("successMessage",
                    "Information : The Request is Hold successfully.");
        }
        if (btnType.equals("REJECT")) {

            candidateF2FRequest.setStatus(4);
            candidateF2FRequest.setHrStatus(1);
            candidateF2FRequest.setMessage(message);
            candidateF2FRequest.setHrEmpId(employeeMaster.getId());
            candidateF2FRequest.setHrName(employeeMaster.getEmployeeName());
            candidateF2FRequestService.update(candidateF2FRequest);

            ///////reject
            cja.setStatus(10);
            candidateJobApplicationService.update(cja);
            request.setAttribute("successMessage",
                    "Information : The Request is Rejected successfully.");

        }
        List<?> f2flist = new ArrayList<>();
        f2flist = candidateF2FRequestService.interviewReqDetailread();
        request.setAttribute("F2FInterviewList", f2flist);
        mv.setViewName("CandidateFtoF/F2FInterviewReviewResult");
        return mv;
    }

    public ModelAndView showViewClick(HttpServletRequest request,
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

        List<?> approverCommentList = candidateF2FApprovalService.readEmployeeCommentByReqId(candidateF2FRequest.getId());
        candidateF2FRequest.setMessage(candidateF2FRequest.getMessage());

        request.setAttribute("applicationId", applicationId);

        candidateF2FRequest.setCandidateApplyJob(candidateApplyJob);
        candidateF2FRequest.setVacancyMaster(vm);
        request.setAttribute("commentlist", approverCommentList);
        request.setAttribute("comitteeList", committeedetaillist);
        mv.getModelMap().put("candidateF2FRequest", candidateF2FRequest);

        mv.setViewName("CandidateFtoF/ShowF2FInterview");
        return mv;
    }

    public ModelAndView submitByApprover(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        CandidateF2FRequest candidateF2FRequest = new CandidateF2FRequest();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        bind(request, candidateF2FRequest);
        String btnType = request.getParameter("btnType");
        String applicationId = request.getParameter("applicationId");
        String message = request.getParameter("interviewerRemark");

        candidateF2FRequest = candidateF2FRequestService.readById(Integer.parseInt(applicationId));
        CandidateJobApplication cja = candidateJobApplicationService.readById(candidateF2FRequest.getCandidateJobApplication().getId());

        CandidateF2FApproval candidateF2FApproval = candidateF2FApprovalService.readByEmpIdAndReqId(employeeMaster.getId(), candidateF2FRequest.getId());

        candidateF2FApproval.setComment(message);
        candidateF2FApproval.setStatus(1);
        candidateF2FApprovalService.update(candidateF2FApproval);

        candidateF2FRequest.setStatus(1);
        candidateF2FRequest.setUserStatus(1);
        candidateF2FRequestService.update(candidateF2FRequest);

        List<?> f2flist = new ArrayList<>();
        f2flist = candidateF2FApprovalService.readByEmpId(employeeMaster.getId());
        request.setAttribute("F2FInterviewList", f2flist);
        mv.setViewName("CandidateFtoF/F2FReqForApprovalResult");
        return mv;
    }

    public ModelAndView showclickAdmin(HttpServletRequest request,
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

        request.setAttribute("applicationId", applicationId);

        candidateF2FRequest.setCandidateApplyJob(candidateApplyJob);
        candidateF2FRequest.setVacancyMaster(vm);
        List<?> approverCommentList = candidateF2FApprovalService.readEmployeeCommentByReqId(candidateF2FRequest.getId());
        request.setAttribute("commentlist", approverCommentList);
        request.setAttribute("comitteeList", committeedetaillist);
        mv.getModelMap().put("candidateF2FRequest", candidateF2FRequest);

        mv.setViewName("CandidateFtoF/showClickAdmin");
        return mv;
    }

}
