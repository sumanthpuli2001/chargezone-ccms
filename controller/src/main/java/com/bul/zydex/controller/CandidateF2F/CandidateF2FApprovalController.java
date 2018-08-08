/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.CandidateF2F;

import com.bul.zydex.model.CandidateApplyJob;
import com.bul.zydex.model.CandidateApplyJob2;
import com.bul.zydex.model.CandidateF2FApproval;
import com.bul.zydex.model.CandidateF2FRequest;
import com.bul.zydex.model.CandidateJobApplication;
import com.bul.zydex.model.DepartmentMaster;
import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.JobtypeMaster;
import com.bul.zydex.model.LocationMaster;
import com.bul.zydex.model.MprApprovalHistory;
import com.bul.zydex.model.MprMaster;
import com.bul.zydex.model.RecruitmentMaster;
import com.bul.zydex.model.VacancyMaster;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

        f2flist = candidateF2FRequestService.interviewReqDetailread(employeeMaster.getId());

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
        DepartmentMaster departmentMaster = new DepartmentMaster();
        LocationMaster locationMaster = new LocationMaster();
        JobtypeMaster jobtypeMaster = new JobtypeMaster();
        DesignationMaster designationMaster = new DesignationMaster();
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
//        Vacancy Master-------------
        int jobtypeId = vm.getJobtypeMaster().getId();
        jobtypeMaster = jobtypeMasterService.readById(jobtypeId);
        String jobtypeNAme = jobtypeMaster.getJobTypeName();

        int department = vm.getDepartmentMaster().getId();
        departmentMaster = departmentMasterService.readById(department);
        String departmentName = departmentMaster.getDepartmentName();

        int localtion = vm.getLocationMaster().getId();
        locationMaster = locationMasterService.readById(localtion);
        String locationName = locationMaster.getLocation();

        int designation = vm.getDesignationMaster().getId();
        designationMaster = designationMasterService.readById(designation);
        String designationName = designationMaster.getDesignationName();

        String vacancyName = vm.getName();
        String fromDate = vm.getFromDate();
        String toDate = vm.getToDate();
        String description = vm.getDescription();
        String experiance = vm.getExperience();
        int salaryRange = vm.getSalaryRange();
        int position = vm.getNumberOfPosition();

//        /        Mpp Master --------------------
//        int jobtypeId2 = rm.getJobtypeMaster().getId();
//        jobtypeMaster = jobtypeMasterService.readById(jobtypeId);
//        String jobtypeNAme2 = jobtypeMaster.getJobTypeName();
//
//        int department2 = rm.getDepartmentMaster().getId();
//        departmentMaster = departmentMasterService.readById(department);
//        String departmentName2 = departmentMaster.getDepartmentName();
//
//        int localtion2 = rm.getLocationMaster().getId();
//        locationMaster = locationMasterService.readById(localtion);
//        String locationName2 = locationMaster.getLocation();
//
//        int designation2 = rm.getDesignationMaster().getId();
//        designationMaster = designationMasterService.readById(designation);
//        String designationName2 = designationMaster.getDesignationName();
//
//        int numberOfPositionMpp = rm.getNumberOfPosition();
//        int Mppbudget = rm.getBudget();
//        String MppExperience = rm.getExperiance();
//
//        request.setAttribute("jobtypeNAme2", jobtypeNAme2);
//        request.setAttribute("departmentName2", departmentName2);
//        request.setAttribute("locationName2", locationName2);
//        request.setAttribute("designationName2", designationName2);
//        request.setAttribute("numberOfPositionMpp", numberOfPositionMpp);
//        request.setAttribute("Mppbudget", Mppbudget);
//        request.setAttribute("MppExperience", MppExperience);

        //        MPR Master -------------
        if (vm.getMprMaster() != null) {
            MprMaster mm = mprMasterService.readById(vm.getMprMaster().getId());
            int mprid = mm.getId();
            List<?> list = mprApprovalHistoryService.getByMprId(mprid);
            int jobtypeId1 = mm.getJobtypeMaster().getId();
            jobtypeMaster = jobtypeMasterService.readById(jobtypeId);
            String jobtypeNAme1 = jobtypeMaster.getJobTypeName();

            int department1 = mm.getDepartmentMaster().getId();
            departmentMaster = departmentMasterService.readById(department);
            String departmentName1 = departmentMaster.getDepartmentName();

            int localtion1 = mm.getLocationMaster().getId();
            locationMaster = locationMasterService.readById(localtion);
            String locationName1 = locationMaster.getLocation();

            int designation1 = mm.getDesignationMaster().getId();
            designationMaster = designationMasterService.readById(designation);
            String designationName1 = designationMaster.getDesignationName();

            String MprName = mm.getName();
            int numberOfPositionMpr = mm.getNumberOfPosition();
            int Mprbudget = mm.getBudget();
            String MprExperience = mm.getExperience();
            String Mprdescription = mm.getDescription();
            request.setAttribute("jobtypeNAme1", jobtypeNAme1);
            request.setAttribute("departmentName1", departmentName1);
            request.setAttribute("locationName1", locationName1);
            request.setAttribute("designationName1", designationName1);
            request.setAttribute("MprName", MprName);
            request.setAttribute("numberOfPositionMpr", numberOfPositionMpr);
            request.setAttribute("Mprbudget", Mprbudget);
            request.setAttribute("MprExperience", MprExperience);
            request.setAttribute("Mprdescription", Mprdescription);
            request.setAttribute("applicationId", applicationId);
            request.setAttribute("list", list);
            request.setAttribute("mprid", mprid);
        }

        request.setAttribute("applicationId", applicationId);

        candidateF2FRequest.setCandidateApplyJob(candidateApplyJob);
        candidateF2FRequest.setVacancyMaster(vm);
        request.setAttribute("commentlist", approverCommentList);
        request.setAttribute("comitteeList", committeedetaillist);
        mv.getModelMap().put("candidateF2FRequest", candidateF2FRequest);
//        Vacancy Master-------------
        mv.getModelMap().put("departmentMaster", departmentMaster);
        mv.getModelMap().put("locationMaster", locationMaster);
        mv.getModelMap().put("jobtypeMaster", jobtypeMaster);
        mv.getModelMap().put("designationMaster", designationMaster);
        request.setAttribute("jobtypeNAme", jobtypeNAme);
        request.setAttribute("departmentName", departmentName);
        request.setAttribute("locationName", locationName);
        request.setAttribute("position", position);
        request.setAttribute("designationName", designationName);
        request.setAttribute("experiance", experiance);
        request.setAttribute("vacancyName", vacancyName);
        request.setAttribute("fromDate", fromDate);
        request.setAttribute("toDate", toDate);
        request.setAttribute("description", description);
//        MPR Master -------------

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
        MprApprovalHistory mprApprovalHistory = new MprApprovalHistory();
        CandidateF2FRequest candidateF2FRequest = new CandidateF2FRequest();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        bind(request, candidateF2FRequest);
        String btnType = request.getParameter("btnType");
        String applicationId = request.getParameter("applicationId");
        String mprid = request.getParameter("mprid");
        String message = request.getParameter("message");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date cDate = new Date();
        MprMaster mprmaster = mprMasterService.readById(Integer.parseInt(mprid));
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

            mprApprovalHistory.setMprMaster(mprmaster);
            mprApprovalHistory.setApprovalUserId(employeeMaster.getId());
            mprApprovalHistory.setApprovalUserName(employeeMaster.getEmployeeName());
            mprApprovalHistory.setComment(candidateF2FRequest.getMessage());
            mprApprovalHistory.setStatusMessage("Face To Face Approve");
            mprApprovalHistory.setCreatedBy(employeeMaster.getId());
            mprApprovalHistory.setCreateDate(sdf.format(cDate));
            mprApprovalHistory.setApplicationId(Integer.parseInt(applicationId));
            mprApprovalHistoryService.create(mprApprovalHistory);

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

            mprApprovalHistory.setMprMaster(mprmaster);
            mprApprovalHistory.setApprovalUserId(employeeMaster.getId());
            mprApprovalHistory.setApprovalUserName(employeeMaster.getEmployeeName());
            mprApprovalHistory.setComment(candidateF2FRequest.getMessage());
            mprApprovalHistory.setStatusMessage("Face To Face ON HOLD");
            mprApprovalHistory.setCreatedBy(employeeMaster.getId());
            mprApprovalHistory.setCreateDate(sdf.format(cDate));
            mprApprovalHistory.setApplicationId(Integer.parseInt(applicationId));
            mprApprovalHistoryService.create(mprApprovalHistory);

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

            mprApprovalHistory.setMprMaster(mprmaster);
            mprApprovalHistory.setApprovalUserId(employeeMaster.getId());
            mprApprovalHistory.setApprovalUserName(employeeMaster.getEmployeeName());
            mprApprovalHistory.setComment(candidateF2FRequest.getMessage());
            mprApprovalHistory.setStatusMessage("Face To Face REJECT");
            mprApprovalHistory.setCreatedBy(employeeMaster.getId());
            mprApprovalHistory.setCreateDate(sdf.format(cDate));
            mprApprovalHistory.setApplicationId(Integer.parseInt(applicationId));
            mprApprovalHistoryService.create(mprApprovalHistory);

            request.setAttribute("successMessage",
                    "Information : The Request is Rejected successfully.");

        }
        List<?> f2flist = new ArrayList<>();
        f2flist = candidateF2FRequestService.interviewReqDetailread(employeeMaster.getId());
        request.setAttribute("F2FInterviewList", f2flist);
        mv.setViewName("CandidateFtoF/F2FInterviewReviewResult");
        return mv;
    }

    public ModelAndView showViewClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        String applicationId = request.getParameter("id");
        DepartmentMaster departmentMaster = new DepartmentMaster();
        LocationMaster locationMaster = new LocationMaster();
        JobtypeMaster jobtypeMaster = new JobtypeMaster();
        DesignationMaster designationMaster = new DesignationMaster();
        CandidateF2FRequest candidateF2FRequest = new CandidateF2FRequest();
        CandidateApplyJob candidateApplyJob = new CandidateApplyJob();
        candidateF2FRequest = candidateF2FRequestService.readById(Integer.parseInt(applicationId));
        candidateApplyJob = candidateJobApplyService.readById(candidateF2FRequest.getCandidateApplyJob().getId());
        CandidateApplyJob2 candidateApplyJob2 = candidateApplyJob2Service.readByApplyJobId(candidateApplyJob.getId());
        VacancyMaster vm = vacancyMasterService.readByVacancyId(candidateF2FRequest.getVacancyMaster().getId());

        List<CandidateF2FApproval> committeedetaillist = new ArrayList<>();
        List<CandidateF2FApproval> comitteeList = (List<CandidateF2FApproval>) candidateF2FApprovalService.readByReqId(candidateF2FRequest.getId());
        for (CandidateF2FApproval cffa : comitteeList) {
            EmployeeMaster em = employeeMasterService.readById(cffa.getEmployeeMaster().getId());
            cffa.setEmployeeMaster(em);
            committeedetaillist.add(cffa);

        }

        List<?> approverCommentList = candidateF2FApprovalService.readEmployeeCommentByReqId(candidateF2FRequest.getId());
        candidateF2FRequest.setMessage(candidateF2FRequest.getMessage());

        //        Vacancy Master-------------
        int jobtypeId = vm.getJobtypeMaster().getId();
        jobtypeMaster = jobtypeMasterService.readById(jobtypeId);
        String jobtypeNAme = jobtypeMaster.getJobTypeName();

        int department = vm.getDepartmentMaster().getId();
        departmentMaster = departmentMasterService.readById(department);
        String departmentName = departmentMaster.getDepartmentName();

        int localtion = vm.getLocationMaster().getId();
        locationMaster = locationMasterService.readById(localtion);
        String locationName = locationMaster.getLocation();

        int designation = vm.getDesignationMaster().getId();
        designationMaster = designationMasterService.readById(designation);
        String designationName = designationMaster.getDesignationName();

        String vacancyName = vm.getName();
        String fromDate = vm.getFromDate();
        String toDate = vm.getToDate();
        String description = vm.getDescription();
        String experiance = vm.getExperience();
        int salaryRange = vm.getSalaryRange();
        int position = vm.getNumberOfPosition();

        //        MPR Master -------------
        if (vm.getMprMaster() != null) {
            MprMaster mm = mprMasterService.readByMPRId(vm.getMprMaster().getId());
            int jobtypeId1 = mm.getJobtypeMaster().getId();
            jobtypeMaster = jobtypeMasterService.readById(jobtypeId);
            String jobtypeNAme1 = jobtypeMaster.getJobTypeName();

            int department1 = mm.getDepartmentMaster().getId();
            departmentMaster = departmentMasterService.readById(department);
            String departmentName1 = departmentMaster.getDepartmentName();

            int localtion1 = mm.getLocationMaster().getId();
            locationMaster = locationMasterService.readById(localtion);
            String locationName1 = locationMaster.getLocation();

            int designation1 = mm.getDesignationMaster().getId();
            designationMaster = designationMasterService.readById(designation);
            String designationName1 = designationMaster.getDesignationName();

            String MprName = mm.getName();
            int numberOfPositionMpr = mm.getNumberOfPosition();
            int Mprbudget = mm.getBudget();
            int mprId = mm.getId();
            String MprExperience = mm.getExperience();
            String Mprdescription = mm.getDescription();
            List<?> list = mprApprovalHistoryService.getByMprId(mprId);
            request.setAttribute("applicationId", applicationId);
            request.setAttribute("jobtypeNAme1", jobtypeNAme1);
            request.setAttribute("departmentName1", departmentName1);
            request.setAttribute("locationName1", locationName1);
            request.setAttribute("designationName1", designationName1);
            request.setAttribute("MprName", MprName);
            request.setAttribute("numberOfPositionMpr", numberOfPositionMpr);
            request.setAttribute("Mprbudget", Mprbudget);
            request.setAttribute("MprExperience", MprExperience);
            request.setAttribute("Mprdescription", Mprdescription);
            request.setAttribute("candidateApplyJob", candidateApplyJob);
            request.setAttribute("list", list);
        }

        candidateF2FRequest.setCandidateApplyJob(candidateApplyJob);
        candidateF2FRequest.setVacancyMaster(vm);
        request.setAttribute("commentlist", approverCommentList);
        request.setAttribute("comitteeList", committeedetaillist);
        mv.getModelMap().put("candidateF2FRequest", candidateF2FRequest);
//        Vacancy Master-------------
        mv.getModelMap().put("departmentMaster", departmentMaster);
        mv.getModelMap().put("locationMaster", locationMaster);
        mv.getModelMap().put("jobtypeMaster", jobtypeMaster);
        mv.getModelMap().put("designationMaster", designationMaster);
        request.setAttribute("jobtypeNAme", jobtypeNAme);
        request.setAttribute("departmentName", departmentName);
        request.setAttribute("locationName", locationName);
        request.setAttribute("position", position);
        request.setAttribute("designationName", designationName);
        request.setAttribute("experiance", experiance);
        request.setAttribute("vacancyName", vacancyName);
        request.setAttribute("fromDate", fromDate);
        request.setAttribute("toDate", toDate);
        request.setAttribute("description", description);
//        MPR Master -------------

        mv.setViewName("CandidateFtoF/ShowF2FInterview");
        return mv;
    }

    public ModelAndView submitByApprover(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        CandidateF2FRequest candidateF2FRequest = new CandidateF2FRequest();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        bind(request, candidateF2FRequest);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date cDate = new Date();
        MprApprovalHistory mprApprovalHistory = new MprApprovalHistory();
        String btnType = request.getParameter("btnType");
        String applicationId = request.getParameter("applicationId");
        String message = request.getParameter("interviewerRemark");
        String technicalKnowledge = request.getParameter("technicalKnowledge");
        String experience = request.getParameter("experience");
        String commSkill = request.getParameter("commSkill");
        String interPerSkill = request.getParameter("interPerSkill");
        String leaderSkill = request.getParameter("leaderSkill");
        String excellent = request.getParameter("excellent");
        String strengths = request.getParameter("strengths");
        String weaknesses = request.getParameter("weaknesses");
        String typeOfTraining = request.getParameter("typeOfTraining");
        String technicalareas = request.getParameter("technicalareas");
        String otherSkills = request.getParameter("otherSkills");

        candidateF2FRequest = candidateF2FRequestService.readById(Integer.parseInt(applicationId));
        CandidateJobApplication cja = candidateJobApplicationService.readById(candidateF2FRequest.getCandidateJobApplication().getId());

        CandidateF2FApproval candidateF2FApproval = candidateF2FApprovalService.readByEmpIdAndReqId(employeeMaster.getId(), candidateF2FRequest.getId());
        VacancyMaster vm = vacancyMasterService.readById(cja.getVacancyMaster().getId());
        candidateF2FApproval.setComment(message);
        candidateF2FApproval.setStatus(1);
        candidateF2FApprovalService.update(candidateF2FApproval);

        candidateF2FRequest.setStatus(1);
        candidateF2FRequest.setUserStatus(1);
        candidateF2FRequest.setTechnicalKnowledge(Integer.parseInt(technicalKnowledge));
        candidateF2FRequest.setExperience(Integer.parseInt(experience));
        candidateF2FRequest.setCommSkill(Integer.parseInt(commSkill));
        candidateF2FRequest.setInterPerSkill(Integer.parseInt(interPerSkill));
        candidateF2FRequest.setLeaderSkill(Integer.parseInt(leaderSkill));
        candidateF2FRequest.setExcellent(Integer.parseInt(excellent));
        candidateF2FRequest.setStrengths(strengths);
        candidateF2FRequest.setWeaknesses(weaknesses);
        candidateF2FRequest.setTypeOfTraining(typeOfTraining);
        candidateF2FRequest.setTechnicalareas(technicalareas);
        candidateF2FRequest.setOtherSkills(otherSkills);
        candidateF2FRequestService.update(candidateF2FRequest);

        mprApprovalHistory.setApprovalUserId(employeeMaster.getId());
        mprApprovalHistory.setApprovalUserName(employeeMaster.getEmployeeName());
        mprApprovalHistory.setCreateDate(sdf.format(cDate));
        mprApprovalHistory.setCreatedBy(employeeMaster.getId());
        mprApprovalHistory.setStatus(10);
        mprApprovalHistory.setComment("Face To Face Invitation submit");
        mprApprovalHistory.setStatusMessage("Face To Face Invitation submit");
        mprApprovalHistory.setMprMaster(vm.getMprMaster());
        mprApprovalHistory.setApplicationId(Integer.parseInt(applicationId));
        mprApprovalHistoryService.create(mprApprovalHistory);

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
        DepartmentMaster departmentMaster = new DepartmentMaster();
        LocationMaster locationMaster = new LocationMaster();
        JobtypeMaster jobtypeMaster = new JobtypeMaster();
        DesignationMaster designationMaster = new DesignationMaster();
        CandidateF2FRequest candidateF2FRequest = new CandidateF2FRequest();
        CandidateApplyJob candidateApplyJob = new CandidateApplyJob();
        candidateF2FRequest = candidateF2FRequestService.readById(Integer.parseInt(applicationId));
        candidateApplyJob = candidateJobApplyService.readById(candidateF2FRequest.getCandidateApplyJob().getId());
        VacancyMaster vm = vacancyMasterService.readById(candidateF2FRequest.getVacancyMaster().getId());
        MprMaster mm = mprMasterService.readByMPRId(vm.getMprMaster().getId());
        RecruitmentMaster rm = recruitmentService.readById(mm.getRecruitmentMaster().getId());
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

        int jobtypeId = vm.getJobtypeMaster().getId();
        jobtypeMaster = jobtypeMasterService.readById(jobtypeId);
        String jobtypeNAme = jobtypeMaster.getJobTypeName();

        int department = vm.getDepartmentMaster().getId();
        departmentMaster = departmentMasterService.readById(department);
        String departmentName = departmentMaster.getDepartmentName();

        int localtion = vm.getLocationMaster().getId();
        locationMaster = locationMasterService.readById(localtion);
        String locationName = locationMaster.getLocation();

        int designation = vm.getDesignationMaster().getId();
        designationMaster = designationMasterService.readById(designation);
        String designationName = designationMaster.getDesignationName();

        String vacancyName = vm.getName();
        String fromDate = vm.getFromDate();
        String toDate = vm.getToDate();
        String description = vm.getDescription();
        String experiance = vm.getExperience();
        int salaryRange = vm.getSalaryRange();
        int position = vm.getNumberOfPosition();

        //        Mpp Master --------------------
        int jobtypeId2 = rm.getJobtypeMaster().getId();
        jobtypeMaster = jobtypeMasterService.readById(jobtypeId);
        String jobtypeNAme2 = jobtypeMaster.getJobTypeName();

        int department2 = rm.getDepartmentMaster().getId();
        departmentMaster = departmentMasterService.readById(department);
        String departmentName2 = departmentMaster.getDepartmentName();

        int localtion2 = rm.getLocationMaster().getId();
        locationMaster = locationMasterService.readById(localtion);
        String locationName2 = locationMaster.getLocation();

        int designation2 = rm.getDesignationMaster().getId();
        designationMaster = designationMasterService.readById(designation);
        String designationName2 = designationMaster.getDesignationName();

        int numberOfPositionMpp = rm.getNumberOfPosition();
        int Mppbudget = rm.getBudget();
        String MppExperience = rm.getExperiance();

        //        MPR Master -------------
        int jobtypeId1 = mm.getJobtypeMaster().getId();
        jobtypeMaster = jobtypeMasterService.readById(jobtypeId);
        String jobtypeNAme1 = jobtypeMaster.getJobTypeName();

        int department1 = mm.getDepartmentMaster().getId();
        departmentMaster = departmentMasterService.readById(department);
        String departmentName1 = departmentMaster.getDepartmentName();

        int localtion1 = mm.getLocationMaster().getId();
        locationMaster = locationMasterService.readById(localtion);
        String locationName1 = locationMaster.getLocation();

        int designation1 = mm.getDesignationMaster().getId();
        designationMaster = designationMasterService.readById(designation);
        String designationName1 = designationMaster.getDesignationName();

        String MprName = mm.getName();
        int numberOfPositionMpr = mm.getNumberOfPosition();
        int Mprbudget = mm.getBudget();
        int mprId = mm.getId();
        String MprExperience = mm.getExperience();
        String Mprdescription = mm.getDescription();
        List<?> list = mprApprovalHistoryService.getByMprId(mprId);

//        ////////---- MPP s
        request.setAttribute("jobtypeNAme2", jobtypeNAme2);
        request.setAttribute("departmentName2", departmentName2);
        request.setAttribute("locationName2", locationName2);
        request.setAttribute("designationName2", designationName2);
        request.setAttribute("numberOfPositionMpp", numberOfPositionMpp);
        request.setAttribute("Mppbudget", Mppbudget);
        request.setAttribute("MppExperience", MppExperience);

        request.setAttribute("applicationId", applicationId);

        candidateF2FRequest.setCandidateApplyJob(candidateApplyJob);
        candidateF2FRequest.setVacancyMaster(vm);
        request.setAttribute("commentlist", approverCommentList);
        request.setAttribute("comitteeList", committeedetaillist);
        mv.getModelMap().put("candidateF2FRequest", candidateF2FRequest);
//        Vacancy Master-------------
        mv.getModelMap().put("departmentMaster", departmentMaster);
        mv.getModelMap().put("locationMaster", locationMaster);
        mv.getModelMap().put("jobtypeMaster", jobtypeMaster);
        mv.getModelMap().put("designationMaster", designationMaster);
        request.setAttribute("jobtypeNAme", jobtypeNAme);
        request.setAttribute("departmentName", departmentName);
        request.setAttribute("locationName", locationName);
        request.setAttribute("position", position);
        request.setAttribute("designationName", designationName);
        request.setAttribute("experiance", experiance);
        request.setAttribute("vacancyName", vacancyName);
        request.setAttribute("fromDate", fromDate);
        request.setAttribute("toDate", toDate);
        request.setAttribute("description", description);
//        MPR Master -------------
        request.setAttribute("jobtypeNAme1", jobtypeNAme1);
        request.setAttribute("departmentName1", departmentName1);
        request.setAttribute("locationName1", locationName1);
        request.setAttribute("designationName1", designationName1);
        request.setAttribute("MprName", MprName);
        request.setAttribute("numberOfPositionMpr", numberOfPositionMpr);
        request.setAttribute("Mprbudget", Mprbudget);
        request.setAttribute("MprExperience", MprExperience);
        request.setAttribute("Mprdescription", Mprdescription);

        request.setAttribute("commentlist", approverCommentList);
        request.setAttribute("comitteeList", committeedetaillist);
        mv.getModelMap().put("candidateF2FRequest", candidateF2FRequest);
        request.setAttribute("list", list);
        mv.setViewName("CandidateFtoF/showClickAdmin");
        return mv;
    }

    public ModelAndView reviewAscommitteeAndHrClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        String applicationId = request.getParameter("id");
        DepartmentMaster departmentMaster = new DepartmentMaster();
        LocationMaster locationMaster = new LocationMaster();
        JobtypeMaster jobtypeMaster = new JobtypeMaster();
        DesignationMaster designationMaster = new DesignationMaster();
        CandidateF2FRequest candidateF2FRequest = new CandidateF2FRequest();
        CandidateApplyJob candidateApplyJob = new CandidateApplyJob();
        candidateF2FRequest = candidateF2FRequestService.readById(Integer.parseInt(applicationId));
        candidateApplyJob = candidateJobApplyService.readById(candidateF2FRequest.getCandidateApplyJob().getId());
        VacancyMaster vm = vacancyMasterService.readById(candidateF2FRequest.getVacancyMaster().getId());
        MprMaster mm = mprMasterService.readById(vm.getMprMaster().getId());
        RecruitmentMaster rm = recruitmentService.readById(mm.getRecruitmentMaster().getId());
        List<CandidateF2FApproval> committeedetaillist = new ArrayList<>();
        List<CandidateF2FApproval> comitteeList = (List<CandidateF2FApproval>) candidateF2FApprovalService.readByReqId(candidateF2FRequest.getId());
        for (CandidateF2FApproval cffa : comitteeList) {
            EmployeeMaster em = employeeMasterService.readById(cffa.getEmployeeMaster().getId());
            cffa.setEmployeeMaster(em);
            committeedetaillist.add(cffa);

        }

        List<?> approverCommentList = candidateF2FApprovalService.readEmployeeCommentByReqId(candidateF2FRequest.getId());
//        Vacancy Master-------------
        int jobtypeId = vm.getJobtypeMaster().getId();
        jobtypeMaster = jobtypeMasterService.readById(jobtypeId);
        String jobtypeNAme = jobtypeMaster.getJobTypeName();

        int department = vm.getDepartmentMaster().getId();
        departmentMaster = departmentMasterService.readById(department);
        String departmentName = departmentMaster.getDepartmentName();

        int localtion = vm.getLocationMaster().getId();
        locationMaster = locationMasterService.readById(localtion);
        String locationName = locationMaster.getLocation();

        int designation = vm.getDesignationMaster().getId();
        designationMaster = designationMasterService.readById(designation);
        String designationName = designationMaster.getDesignationName();

        String vacancyName = vm.getName();
        String fromDate = vm.getFromDate();
        String toDate = vm.getToDate();
        String description = vm.getDescription();
        String experiance = vm.getExperience();
        int salaryRange = vm.getSalaryRange();
        int position = vm.getNumberOfPosition();

//        /        Mpp Master --------------------
        int jobtypeId2 = rm.getJobtypeMaster().getId();
        jobtypeMaster = jobtypeMasterService.readById(jobtypeId);
        String jobtypeNAme2 = jobtypeMaster.getJobTypeName();

        int department2 = rm.getDepartmentMaster().getId();
        departmentMaster = departmentMasterService.readById(department);
        String departmentName2 = departmentMaster.getDepartmentName();

        int localtion2 = rm.getLocationMaster().getId();
        locationMaster = locationMasterService.readById(localtion);
        String locationName2 = locationMaster.getLocation();

        int designation2 = rm.getDesignationMaster().getId();
        designationMaster = designationMasterService.readById(designation);
        String designationName2 = designationMaster.getDesignationName();

        int numberOfPositionMpp = rm.getNumberOfPosition();
        int Mppbudget = rm.getBudget();
        String MppExperience = rm.getExperiance();

        request.setAttribute("jobtypeNAme2", jobtypeNAme2);
        request.setAttribute("departmentName2", departmentName2);
        request.setAttribute("locationName2", locationName2);
        request.setAttribute("designationName2", designationName2);
        request.setAttribute("numberOfPositionMpp", numberOfPositionMpp);
        request.setAttribute("Mppbudget", Mppbudget);
        request.setAttribute("MppExperience", MppExperience);

        //        MPR Master -------------
        int jobtypeId1 = mm.getJobtypeMaster().getId();
        jobtypeMaster = jobtypeMasterService.readById(jobtypeId);
        String jobtypeNAme1 = jobtypeMaster.getJobTypeName();

        int department1 = mm.getDepartmentMaster().getId();
        departmentMaster = departmentMasterService.readById(department);
        String departmentName1 = departmentMaster.getDepartmentName();

        int localtion1 = mm.getLocationMaster().getId();
        locationMaster = locationMasterService.readById(localtion);
        String locationName1 = locationMaster.getLocation();

        int designation1 = mm.getDesignationMaster().getId();
        designationMaster = designationMasterService.readById(designation);
        String designationName1 = designationMaster.getDesignationName();

        String MprName = mm.getName();
        int numberOfPositionMpr = mm.getNumberOfPosition();
        int Mprbudget = mm.getBudget();
        String MprExperience = mm.getExperience();
        String Mprdescription = mm.getDescription();

        request.setAttribute("applicationId", applicationId);

        candidateF2FRequest.setCandidateApplyJob(candidateApplyJob);
        candidateF2FRequest.setVacancyMaster(vm);
        request.setAttribute("commentlist", approverCommentList);
        request.setAttribute("comitteeList", committeedetaillist);
        mv.getModelMap().put("candidateF2FRequest", candidateF2FRequest);
//        Vacancy Master-------------
        mv.getModelMap().put("departmentMaster", departmentMaster);
        mv.getModelMap().put("locationMaster", locationMaster);
        mv.getModelMap().put("jobtypeMaster", jobtypeMaster);
        mv.getModelMap().put("designationMaster", designationMaster);
        request.setAttribute("jobtypeNAme", jobtypeNAme);
        request.setAttribute("departmentName", departmentName);
        request.setAttribute("locationName", locationName);
        request.setAttribute("position", position);
        request.setAttribute("designationName", designationName);
        request.setAttribute("experiance", experiance);
        request.setAttribute("vacancyName", vacancyName);
        request.setAttribute("fromDate", fromDate);
        request.setAttribute("toDate", toDate);
        request.setAttribute("description", description);
//        MPR Master -------------
        request.setAttribute("jobtypeNAme1", jobtypeNAme1);
        request.setAttribute("departmentName1", departmentName1);
        request.setAttribute("locationName1", locationName1);
        request.setAttribute("designationName1", designationName1);
        request.setAttribute("MprName", MprName);
        request.setAttribute("numberOfPositionMpr", numberOfPositionMpr);
        request.setAttribute("Mprbudget", Mprbudget);
        request.setAttribute("MprExperience", MprExperience);
        request.setAttribute("Mprdescription", Mprdescription);
        request.setAttribute("applicationId", applicationId);

        candidateF2FRequest.setCandidateApplyJob(candidateApplyJob);
        candidateF2FRequest.setVacancyMaster(vm);
        request.setAttribute("commentlist", approverCommentList);
        request.setAttribute("comitteeList", committeedetaillist);
        mv.getModelMap().put("candidateF2FRequest", candidateF2FRequest);

        mv.setViewName("CandidateFtoF/reviewAscommitteeAndHrClick");
        return mv;
    }

    public ModelAndView approvalFaceToFaceInvitationForCommASHr(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        CandidateF2FRequest candidateF2FRequest = new CandidateF2FRequest();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        bind(request, candidateF2FRequest);
        String btnType = request.getParameter("btnType");
        String applicationId = request.getParameter("applicationId");
        String message = request.getParameter("message");
        String InterviewerAsHr = request.getParameter("InterviewerAsHr");
        candidateF2FRequest = candidateF2FRequestService.readById(Integer.parseInt(applicationId));
        CandidateF2FApproval candidateF2FApproval = candidateF2FApprovalService.readByEmpIdAndReqId(employeeMaster.getId(), candidateF2FRequest.getId());

        candidateF2FApproval.setComment(InterviewerAsHr);
        candidateF2FApproval.setStatus(1);
        candidateF2FApprovalService.update(candidateF2FApproval);

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
        f2flist = candidateF2FRequestService.interviewReqDetailread(employeeMaster.getId());
        request.setAttribute("F2FInterviewList", f2flist);
        mv.setViewName("CandidateFtoF/F2FInterviewReviewResult");
        return mv;
    }

}
