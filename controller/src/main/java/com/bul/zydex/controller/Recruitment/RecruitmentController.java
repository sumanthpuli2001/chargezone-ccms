/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Recruitment;

import com.bul.zydex.model.ApprovalUser;
import com.bul.zydex.model.CandidateApplyJob;
import com.bul.zydex.model.DepartmentMaster;
import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.JobtypeMaster;
import com.bul.zydex.model.LocationMaster;
import com.bul.zydex.model.MprApproval;
import com.bul.zydex.model.MprEmployeeCategory;
import com.bul.zydex.model.MprEmployeeTypeMaster;
import com.bul.zydex.model.MprMaster;
import com.bul.zydex.model.QulificationMaster;
import com.bul.zydex.model.RecruitmentMaster;
import com.bul.zydex.model.RecruitmentMppApproval;
import com.bul.zydex.model.VacancyMaster;
import java.text.SimpleDateFormat;
import java.util.Date;
//import com.bul.zydex.model.RecruitmentMaster;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Vikas
 */
public class RecruitmentController extends RecruitmentAbstract {

    public ModelAndView recruitmentCreate(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        RecruitmentMaster recruitmentMaster = new RecruitmentMaster();

        List<?> recruitmentMasterList = recruitmentService.readMppListByUserId(employeeMaster.getId());
        mv.getModelMap().put("list", recruitmentMasterList);
        mv.getModelMap().put("recruitmentMaster", recruitmentMaster);
        mv.setViewName("Recruitment/RecruitmentCreateMPP");
        return mv;
    }

    public ModelAndView searchForCreatedBudget(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        ModelAndView mv = new ModelAndView();
        RecruitmentMaster recruitmentMaster = new RecruitmentMaster();
        List<?> recruitmentMasterList = recruitmentService.searchMppApproval(employeeMaster.getId());
        mv.getModelMap().put("list", recruitmentMasterList);
        mv.getModelMap().put("recruitmentMaster", recruitmentMaster);
        mv.setViewName("Recruitment/SearchForBudgetCreated");
        return mv;
    }

    public ModelAndView newCreateBudget(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        RecruitmentMaster recruitmentMaster = new RecruitmentMaster();
        DepartmentMaster departmentMaster = new DepartmentMaster();
        LocationMaster locationMaster = new LocationMaster();
        JobtypeMaster jobtypeMaster = new JobtypeMaster();
        DesignationMaster designationMaster = new DesignationMaster();

        if (recruitmentMaster.getId() != null) {
            recruitmentMaster = recruitmentService.readById(recruitmentMaster.getId());
            recruitmentMaster.setLocationMaster(recruitmentMaster.getLocationMaster());
            recruitmentMaster.setDepartmentMaster(recruitmentMaster.getDepartmentMaster());
            recruitmentMaster.setDesignationMaster(recruitmentMaster.getDesignationMaster());
            recruitmentMaster.setJobtypeMaster(recruitmentMaster.getJobtypeMaster());
        } else {
            recruitmentMaster.setLocationMaster(new LocationMaster());
            recruitmentMaster.setDepartmentMaster(new DepartmentMaster());
            recruitmentMaster.setJobtypeMaster(new JobtypeMaster());
            recruitmentMaster.setDesignationMaster(new DesignationMaster());
        }
//        selectBudget(request, response);
        departmentList(request);
        designationList(request);

        Map<Integer, String> locationMap = readLocations();
        Map<Integer, String> jobtype1 = jobtypeList();
        mv.addObject("locationMap", locationMap);
        mv.addObject("jobtype1", jobtype1);
        recruitmentMaster.setDepartmentMaster(new DepartmentMaster());
        recruitmentMaster.setLocationMaster(new LocationMaster());
        recruitmentMaster.setJobtypeMaster(new JobtypeMaster());
        recruitmentMaster.setDesignationMaster(new DesignationMaster());
        mv.getModelMap().put("recruitmentMaster", recruitmentMaster);
        mv.getModelMap().put("departmentMaster", departmentMaster);
        mv.getModelMap().put("designationMaster", designationMaster);
        mv.getModelMap().put("locationMaster", locationMaster);
        mv.getModelMap().put("jobtypeMaster", jobtypeMaster);
        mv.setViewName("Recruitment/CreateNewBudget");
        return mv;
    }

    public ModelAndView budgetCreateDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        RecruitmentMaster recruitmentMaster = new RecruitmentMaster();
        DepartmentMaster departmentMaster = new DepartmentMaster();
        LocationMaster locationMaster = new LocationMaster();
        JobtypeMaster jobtypeMaster = new JobtypeMaster();
        BindException errors = new BindException(recruitmentMaster, "recruitmentMaster");
        bind(request, recruitmentMaster);
        List<ApprovalUser> approvalList = (List<ApprovalUser>) approvalUserService.readByApprovalId(99);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date cDate = new Date();

        departmentList(request);

        recruitmentValidator.validate(recruitmentMaster, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid");
            mv.addAllObjects(errors.getModel());
            mv = newCreateBudget(request, response);
        } else {
            recruitmentMaster.setMppStatus(0);
            recruitmentMaster.setCurrentLevel(1);
            recruitmentMaster.setTotalLevel(approvalList.size());

            recruitmentMaster.setCreatedDate(sdf.format(cDate));
            recruitmentMaster.setCreatedBy(employeeMaster.getId());

            recruitmentService.create(recruitmentMaster);

            for (ApprovalUser au : approvalList) {
                RecruitmentMppApproval mppApproval = new RecruitmentMppApproval();
                mppApproval.setEmployeeMaster(au.getEmployeeMaster());
                mppApproval.setRecruitmentMaster(recruitmentMaster);
                mppApproval.setLevel(au.getLevel());
                recruitmentMppApprovalService.create(mppApproval);
            }

            request.setAttribute("successMessage",
                    "Information : The Information is saved Successfully.");

            mv = recruitmentCreate(request, response);
        }

        return mv;
    }

    public ModelAndView budgetdeleteSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        String savingList[] = request.getParameterValues("checkId");
        for (String z : savingList) {
            try {
                
                RecruitmentMppApproval recruitmentMppApproval = new RecruitmentMppApproval();
                List<?>list = recruitmentMppApprovalService.recruitmentMppdelete(z);
                for(Object object : list){
                    recruitmentMppApproval = (RecruitmentMppApproval) object;
                    recruitmentMppApprovalService.delete(recruitmentMppApproval.getId());
                }
                
                recruitmentService.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info :Records are deleted successfully.");
            } catch (Exception e) {

            }
        }
        mv = recruitmentCreate(request, response);
        return mv;
    }

    public ModelAndView createMpr(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        ModelAndView mv = new ModelAndView();
        MprMaster mprMaster = new MprMaster();
        List<?> list = mprMasterService.readMprListByUserId(employeeMaster.getId());
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("mprMaster", mprMaster);
        mv.setViewName("Recruitment/createNewMpr");
        return mv;
    }

    public ModelAndView requestForManPower(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        MprMaster mprMaster = new MprMaster();
        DepartmentMaster departmentMaster = new DepartmentMaster();
        LocationMaster locationMaster = new LocationMaster();
        JobtypeMaster jobtypeMaster = new JobtypeMaster();
        DesignationMaster designationMaster = new DesignationMaster();
        if (mprMaster.getId() != null) {
            mprMaster = mprMasterService.readById(mprMaster.getId());
            mprMaster.setLocationMaster(mprMaster.getLocationMaster());
            mprMaster.setDepartmentMaster(mprMaster.getDepartmentMaster());
            mprMaster.setJobtypeMaster(mprMaster.getJobtypeMaster());
            mprMaster.setDesignationMaster(mprMaster.getDesignationMaster());
        } else {
            mprMaster.setLocationMaster(new LocationMaster());
            mprMaster.setDepartmentMaster(new DepartmentMaster());
            mprMaster.setJobtypeMaster(new JobtypeMaster());
            mprMaster.setDesignationMaster(new DesignationMaster());
        }
//        selectMPRBudget(request, response);
        departmentList(request);
        designationList(request);
        Map<Integer, String> locationMap = readLocations();
        Map<Integer, String> jobtype1 = jobtypeList();
        mv.addObject("locationMap", locationMap);
        mv.addObject("jobtype1", jobtype1);
        mprMaster.setDepartmentMaster(new DepartmentMaster());
        mprMaster.setLocationMaster(new LocationMaster());
        mprMaster.setJobtypeMaster(new JobtypeMaster());
        mprMaster.setDesignationMaster(new DesignationMaster());
        mv.getModelMap().put("mprMaster", mprMaster);
        mv.getModelMap().put("departmentMaster", departmentMaster);
        mv.getModelMap().put("locationMaster", locationMaster);
        mv.getModelMap().put("jobtypeMaster", jobtypeMaster);
        mv.getModelMap().put("designationMaster", designationMaster);
        mv.setViewName("Recruitment/RequestForManPower");
        return mv;
    }

    public ModelAndView detailCreateForMpr(HttpServletRequest request, HttpServletResponse response) throws Exception {
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("recruitmentMasterid");
        MprMaster mprMaster = new MprMaster();
        RecruitmentMaster recruitmentMaster = new RecruitmentMaster();
        DepartmentMaster departmentMaster = new DepartmentMaster();
        LocationMaster locationMaster = new LocationMaster();
        JobtypeMaster jobtypeMaster = new JobtypeMaster();
        DesignationMaster designationMaster = new DesignationMaster();
        MprEmployeeCategory mprEmployeeCategory = new MprEmployeeCategory();
        MprEmployeeTypeMaster employeeTypeMaster = new MprEmployeeTypeMaster();
        BindException errors = new BindException(mprMaster, "mprMaster");
        bind(request, mprMaster);
        List<ApprovalUser> approvalList = (List<ApprovalUser>) approvalUserService.readByApprovalId(99);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date cDate = new Date();

        recruitmentMaster = recruitmentService.readById(Integer.parseInt(id));
        int jobtype = recruitmentMaster.getJobtypeMaster().getId();
        jobtypeMaster = jobtypeMasterService.readById(jobtype);
        mprMaster.setJobtypeMaster(jobtypeMaster);

        int department = recruitmentMaster.getDepartmentMaster().getId();
        departmentMaster = departmentMasterService.readById(department);
        mprMaster.setDepartmentMaster(departmentMaster);

        int location = recruitmentMaster.getLocationMaster().getId();
        locationMaster = locationMasterService.readById(location);
        mprMaster.setLocationMaster(locationMaster);

        int designation = recruitmentMaster.getDesignationMaster().getId();
        designationMaster = designationMasterService.readById(designation);
        mprMaster.setDesignationMaster(designationMaster);

        String experiance = recruitmentMaster.getExperiance();
        mprMaster.setExperience(experiance);

        int position = recruitmentMaster.getNumberOfPosition();
        mprMaster.setNumberOfPosition(position);
//        selectMPRBudget(request, response);
        departmentList(request);

        mprValidator.validate(mprMaster, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid");
            mv.addAllObjects(errors.getModel());
            mv.setViewName("Recruitment/MprSearchCreateBudget");
//            mv = viewClick(request, response);
        } else {
            mprMaster.setStatus(0);
            mprMaster.setCurrentLevel(1);
            mprMaster.setTotalLevel(approvalList.size());

            mprMaster.setCreatedBy(employeeMaster.getId());
            mprMaster.setCreatedDate(sdf.format(cDate));

            mprMasterService.create(mprMaster);

            for (ApprovalUser au : approvalList) {
                MprApproval ma = new MprApproval();
                ma.setEmployeeMaster(au.getEmployeeMaster());
                ma.setMprMaster(mprMaster);
                ma.setLevel(au.getLevel());
                mprApprovalService.create(ma);
            }

            request.setAttribute("successMessage",
                    "Information : The Information is saved Successfully.");

            mv = createMpr(request, response);
        }
        return mv;
    }

    public ModelAndView viewClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        RecruitmentMaster recruitmentMaster = new RecruitmentMaster();
        MprMaster mprMaster = new MprMaster();
        DepartmentMaster departmentMaster = new DepartmentMaster();
        LocationMaster locationMaster = new LocationMaster();
        JobtypeMaster jobtypeMaster = new JobtypeMaster();
        DesignationMaster designationMaster = new DesignationMaster();
        if (mprMaster.getId() != null) {
            mprMaster = mprMasterService.readById(mprMaster.getId());
            mprMaster.setLocationMaster(mprMaster.getLocationMaster());
            mprMaster.setDepartmentMaster(mprMaster.getDepartmentMaster());
            mprMaster.setJobtypeMaster(mprMaster.getJobtypeMaster());
            mprMaster.setDesignationMaster(mprMaster.getDesignationMaster());
        } else {
            mprMaster.setLocationMaster(new LocationMaster());
            mprMaster.setDepartmentMaster(new DepartmentMaster());
            mprMaster.setJobtypeMaster(new JobtypeMaster());
            mprMaster.setDesignationMaster(new DesignationMaster());
        }
//        selectMPRBudget(request, response);
        departmentList(request);
        designationList(request);
        Map<Integer, String> locationMap = readLocations();
        Map<Integer, String> jobtype1 = jobtypeList();
        mv.addObject("locationMap", locationMap);
        mv.addObject("jobtype1", jobtype1);
        mprMaster.setDepartmentMaster(new DepartmentMaster());
        mprMaster.setLocationMaster(new LocationMaster());
        mprMaster.setJobtypeMaster(new JobtypeMaster());
        mprMaster.setDesignationMaster(new DesignationMaster());
        String id = request.getParameter("id");
        recruitmentMaster = recruitmentService.readById(Integer.parseInt(id));
        int jobtypeId = recruitmentMaster.getJobtypeMaster().getId();
        jobtypeMaster = jobtypeMasterService.readById(jobtypeId);
        String jobtypeNAme = jobtypeMaster.getJobTypeName();
        mv.getModelMap().put("mprMaster", mprMaster);
        mv.getModelMap().put("departmentMaster", departmentMaster);
        mv.getModelMap().put("locationMaster", locationMaster);
        mv.getModelMap().put("jobtypeMaster", jobtypeMaster);
        mv.getModelMap().put("designationMaster", designationMaster);
        mv.getModelMap().put("recruitmentMaster", recruitmentMaster);
        mv.setViewName("Recruitment/MprSearchCreateBudget");
        return mv;
    }

    public ModelAndView mprdeleteData(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        String savingList[] = request.getParameterValues("checkId");
        for (String z : savingList) {
            try {
                mprMasterService.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info : Records are deleted successfully.");
            } catch (Exception e) {

            }
        }
        mv = createMpr(request, response);
        return mv;
    }

    public ModelAndView editMprClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        MprMaster mprMaster = new MprMaster();

        departmentList(request);
        designationList(request);
        Map<Integer, String> locationMap = readLocations();
        Map<Integer, String> jobtype1 = jobtypeList();
        mv.addObject("locationMap", locationMap);
        mv.addObject("jobtype1", jobtype1);

        String id = request.getParameter("id");
        mprMaster = mprMasterService.readById(Integer.parseInt(id));
        mv.getModelMap().put("mprMaster", mprMaster);
        mv.setViewName("Recruitment/MprEditSubmit");
        return mv;
    }

    public ModelAndView mprEditSubmitDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        MprMaster mprMaster = new MprMaster();
        MprMaster mprMaster1 = mprMasterService.readById(mprMaster.getId());
        BindException errors = new BindException(mprMaster, "mprMaster");
        bind(request, mprMaster);
        departmentList(request);

        mprMaster.setStatus(0);

        mprMaster.setCurrentLevel(1);
        mprMaster.setTotalLevel(mprMaster1.getTotalLevel());

        mprMaster.setCreatedBy(mprMaster1.getCreatedBy());
        mprMaster.setCreatedDate(mprMaster1.getCreatedDate());

        mprMasterService.update(mprMaster);
        request.setAttribute("successMessage",
                "Information : The Information is Updated Successfully.");

        mv = createMpr(request, response);

        return mv;
    }

    ///////////  MPP Edit -------------
    public ModelAndView editMppRClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        RecruitmentMaster recruitmentMaster = new RecruitmentMaster();
        DepartmentMaster departmentMaster = new DepartmentMaster();
        LocationMaster locationMaster = new LocationMaster();
        JobtypeMaster jobtypeMaster = new JobtypeMaster();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date cDate = new Date();
        recruitmentMaster.setCreatedDate(sdf.format(cDate));

        departmentList(request);
        designationList(request);
        Map<Integer, String> locationMap = readLocations();
        Map<Integer, String> jobtype1 = jobtypeList();
        mv.addObject("locationMap", locationMap);
        mv.addObject("jobtype1", jobtype1);

        String id = request.getParameter("id");
        recruitmentMaster = recruitmentService.readById(Integer.parseInt(id));
        mv.getModelMap().put("recruitmentMaster", recruitmentMaster);
        mv.setViewName("Recruitment/RecruitmentEditView");

        return mv;
    }

    public ModelAndView budgetEditSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        RecruitmentMaster recruitmentMaster = new RecruitmentMaster();

        BindException errors = new BindException(recruitmentMaster, "recruitmentMaster");
        bind(request, recruitmentMaster);
//        payrollProfessionalTaxValidator.validate(payrollProfessionalTax, errors);
        Map<Integer, String> locationMap = readLocations();
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error :  not valid.");
            mv.addAllObjects(errors.getModel());
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date cDate = new Date();
            recruitmentMaster.setUpdatedDate(sdf.format(cDate));
            recruitmentService.update(recruitmentMaster);
//            log(request, ActionType.UPDATE.toString(),
//                    "The Professional Tax is Updated -."
//                    + payrollProfessionalTax.getAmount());
            request.setAttribute("successMessage",
                    "Information: The MPP is Updated successfully");
        }

        mv.getModelMap().put("recruitmentMaster", recruitmentMaster);
        mv = recruitmentCreate(request, response);

        return mv;
    }

    public ModelAndView recruitmentApprovalCreate(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");

        ModelAndView mv = new ModelAndView();
        MprMaster mprMaster = new MprMaster();
//        List<?> list = mprMasterService.readMprList();

        List<?> list = mprApprovalService.readApprovalMPRList(employeeMaster.getId());
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("mprMaster", mprMaster);
        mv.setViewName("Recruitment/ApprovalRecruitment");
        return mv;
    }

    public ModelAndView viewClickApprove(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        MprMaster mprMaster = new MprMaster();
        RecruitmentMaster recruitmentMaster = new RecruitmentMaster();
        DepartmentMaster departmentMaster = new DepartmentMaster();
        LocationMaster locationMaster = new LocationMaster();
        JobtypeMaster jobtypeMaster = new JobtypeMaster();
        DesignationMaster designationMaster = new DesignationMaster();

        if (mprMaster.getId() != null) {
            mprMaster = mprMasterService.readById(mprMaster.getId());
            mprMaster.setLocationMaster(mprMaster.getLocationMaster());
            mprMaster.setDepartmentMaster(mprMaster.getDepartmentMaster());
            mprMaster.setJobtypeMaster(mprMaster.getJobtypeMaster());
            mprMaster.setDesignationMaster(mprMaster.getDesignationMaster());
        } else {
            mprMaster.setLocationMaster(new LocationMaster());
            mprMaster.setDepartmentMaster(new DepartmentMaster());
            mprMaster.setJobtypeMaster(new JobtypeMaster());
            mprMaster.setDesignationMaster(new DesignationMaster());
        }
//        selectMPRBudget(request, response);
        departmentList(request);
        designationList(request);
        Map<Integer, String> locationMap = readLocations();
        Map<Integer, String> jobtype1 = jobtypeList();
        mv.addObject("locationMap", locationMap);
        mv.addObject("jobtype1", jobtype1);
        mprMaster.setDepartmentMaster(new DepartmentMaster());
        mprMaster.setLocationMaster(new LocationMaster());
        mprMaster.setJobtypeMaster(new JobtypeMaster());
        mprMaster.setDesignationMaster(new DesignationMaster());

        String id = request.getParameter("id");
        mprMaster = mprMasterService.readById(Integer.parseInt(id));
        mv.getModelMap().put("mprMaster", mprMaster);
        mv.getModelMap().put("departmentMaster", departmentMaster);
        mv.getModelMap().put("locationMaster", locationMaster);
        mv.getModelMap().put("jobtypeMaster", jobtypeMaster);
        mv.getModelMap().put("designationMaster", designationMaster);
        mv.getModelMap().put("recruitmentMaster", recruitmentMaster);
        mv.setViewName("Recruitment/ViewApprovlPage");
        return mv;
    }

    public ModelAndView approveSubmitForMpr(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");

        ModelAndView mv = new ModelAndView();
        MprMaster mprMaster = new MprMaster();
        RecruitmentMaster recruitmentMaster = new RecruitmentMaster();
        DepartmentMaster departmentMaster = new DepartmentMaster();
        LocationMaster locationMaster = new LocationMaster();
        JobtypeMaster jobtypeMaster = new JobtypeMaster();
        DesignationMaster designationMaster = new DesignationMaster();

        bind(request, mprMaster);
        String btnType = request.getParameter("btnType");
        String empreqid = request.getParameter("empreqid");
        String approvalComment = request.getParameter("approvalComment");
        mprMaster = mprMasterService.readById(Integer.parseInt(empreqid));
        MprApproval mprApproval = mprApprovalService.readByMprIdAndEmpId(mprMaster.getId(), employeeMaster.getId());
        int userLevel = mprApproval.getLevel();
        int CurrentLevel = mprMaster.getCurrentLevel();
        int totalLevel = mprMaster.getTotalLevel();

        if (btnType.equals("Approve")) {

            if (userLevel == totalLevel) {
                mprMaster.setStatus(5);

            } else {
                mprMaster.setStatus(4);

                mprMaster.setCurrentLevel(CurrentLevel + 1);

            }

            mprApproval.setComment(approvalComment);
            mprMasterService.update(mprMaster);
            mprApprovalService.update(mprApproval);
            request.setAttribute("successMessage",
                    "Information : The Request is Approved successfully.");
        }
        if (btnType.equals("Return")) {
//            mprMaster = mprMasterService.readById(Integer.parseInt(empreqid));

            if (userLevel > 1) {
                mprMaster.setStatus(2);
                mprMaster.setCurrentLevel(CurrentLevel - 1);

            } else {
                mprMaster.setStatus(1);
                mprMaster.setCurrentLevel(CurrentLevel - 1);

            }
            mprApproval.setComment(approvalComment);
            mprMasterService.update(mprMaster);
            mprApprovalService.update(mprApproval);
            request.setAttribute("successMessage",
                    "Information : The Request is Returned successfully.");
        }
        if (btnType.equals("Reject")) {
//            mprMaster = mprMasterService.readById(Integer.parseInt(empreqid));
            mprMaster.setStatus(3);
            mprApproval.setComment(approvalComment);
            mprMasterService.update(mprMaster);
            mprApprovalService.update(mprApproval);
            request.setAttribute("successMessage",
                    "Information : The Request is Rejectd successfully.");

        }
        mv.getModelMap().put("mprMaster", mprMaster);
        mv = recruitmentApprovalCreate(request, response);
        return mv;
    }

    public ModelAndView candidateList(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        CandidateApplyJob candidateApplyJob = new CandidateApplyJob();
        List<?> candidateApplyJobList = candidateJobApplyService.fetchcandidatelist();
        mv.getModelMap().put("list", candidateApplyJobList);
        mv.getModelMap().put("candidateApplyJob", candidateApplyJob);
        mv.setViewName("Recruitment/CandidateRequestList");
        return mv;
    }

    public ModelAndView CandidateViewClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        CandidateApplyJob candidateApplyJob = new CandidateApplyJob();
        String id = request.getParameter("id");
        candidateApplyJob = candidateJobApplyService.readById(Integer.parseInt(id));
        mv.getModelMap().put("candidateApplyJob", candidateApplyJob);
        mv.setViewName("Recruitment/CandidateApproval");
        return mv;
    }

    public ModelAndView mprCreateClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        RecruitmentMaster recruitmentMaster = new RecruitmentMaster();
        MprMaster mprMaster = new MprMaster();
        DepartmentMaster departmentMaster = new DepartmentMaster();
        LocationMaster locationMaster = new LocationMaster();
        JobtypeMaster jobtypeMaster = new JobtypeMaster();
        DesignationMaster designationMaster = new DesignationMaster();
        if (mprMaster.getId() != null) {
            mprMaster = mprMasterService.readById(mprMaster.getId());
            mprMaster.setLocationMaster(mprMaster.getLocationMaster());
            mprMaster.setDepartmentMaster(mprMaster.getDepartmentMaster());
            mprMaster.setJobtypeMaster(mprMaster.getJobtypeMaster());
            mprMaster.setDesignationMaster(mprMaster.getDesignationMaster());
        } else {
            mprMaster.setLocationMaster(new LocationMaster());
            mprMaster.setDepartmentMaster(new DepartmentMaster());
            mprMaster.setJobtypeMaster(new JobtypeMaster());
            mprMaster.setDesignationMaster(new DesignationMaster());
        }
//        selectMPRBudget(request, response);
        departmentList(request);
        designationList(request);
        Map<Integer, String> locationMap = readLocations();
        Map<Integer, String> jobtype1 = jobtypeList();
        mv.addObject("locationMap", locationMap);
        mv.addObject("jobtype1", jobtype1);
        mprMaster.setDepartmentMaster(new DepartmentMaster());
        mprMaster.setLocationMaster(new LocationMaster());
        mprMaster.setJobtypeMaster(new JobtypeMaster());
        mprMaster.setDesignationMaster(new DesignationMaster());
        String id = request.getParameter("id");

        recruitmentMaster = recruitmentService.readById(Integer.parseInt(id));

        int jobtypeId = recruitmentMaster.getJobtypeMaster().getId();
        jobtypeMaster = jobtypeMasterService.readById(jobtypeId);
        String jobtypeNAme = jobtypeMaster.getJobTypeName();

        int department = recruitmentMaster.getDepartmentMaster().getId();
        departmentMaster = departmentMasterService.readById(department);
        String departmentName = departmentMaster.getDepartmentName();

        int localtion = recruitmentMaster.getLocationMaster().getId();
        locationMaster = locationMasterService.readById(localtion);
        String locationName = locationMaster.getLocation();

        int designation = recruitmentMaster.getDesignationMaster().getId();
        designationMaster = designationMasterService.readById(designation);
        String designationName = designationMaster.getDesignationName();

        String experiance = recruitmentMaster.getExperiance();

        int position = recruitmentMaster.getNumberOfPosition();

        mv.getModelMap().put("mprMaster", mprMaster);
        mv.getModelMap().put("departmentMaster", departmentMaster);
        mv.getModelMap().put("locationMaster", locationMaster);
        mv.getModelMap().put("jobtypeMaster", jobtypeMaster);
        mv.getModelMap().put("designationMaster", designationMaster);
        mv.getModelMap().put("recruitmentMaster", recruitmentMaster);
        request.setAttribute("jobtypeNAme", jobtypeNAme);
        request.setAttribute("departmentName", departmentName);
        request.setAttribute("locationName", locationName);
        request.setAttribute("position", position);
        request.setAttribute("designationName", designationName);
        request.setAttribute("experiance", experiance);
        mv.setViewName("Recruitment/MprSearchCreateBudget");

        return mv;
    }

    public ModelAndView assessmentClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("Recruitment/CandidateAssessment");
        return mv;
    }

    public ModelAndView approvalMppCreate(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        ModelAndView mv = new ModelAndView();
        RecruitmentMaster recruitmentMaster = new RecruitmentMaster();
//        List<?> recruitmentMasterList = recruitmentService.readBudgetDetail();
        List<?> recruitmentMasterList = recruitmentMppApprovalService.mPpReadApprovalList(employeeMaster.getId());

        mv.getModelMap().put("list", recruitmentMasterList);
        mv.getModelMap().put("recruitmentMaster", recruitmentMaster);
        mv.setViewName("Recruitment/MppApprovalList");
        return mv;
    }

    public ModelAndView mPPViewApproval(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        RecruitmentMaster recruitmentMaster = new RecruitmentMaster();
        DepartmentMaster departmentMaster = new DepartmentMaster();
        LocationMaster locationMaster = new LocationMaster();
        JobtypeMaster jobtypeMaster = new JobtypeMaster();

        departmentList(request);
        Map<Integer, String> locationMap = readLocations();
        Map<Integer, String> jobtype1 = jobtypeList();
        mv.addObject("locationMap", locationMap);
        mv.addObject("jobtype1", jobtype1);

        String id = request.getParameter("id");
        recruitmentMaster = recruitmentService.readById(Integer.parseInt(id));
        mv.getModelMap().put("recruitmentMaster", recruitmentMaster);
        mv.setViewName("Recruitment/ApprovalForMPpHr");

        return mv;
    }

    public ModelAndView submitMppApprove(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        RecruitmentMaster recruitmentMaster = new RecruitmentMaster();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        bind(request, recruitmentMaster);
        String btnType = request.getParameter("btnType");
        String mppid = request.getParameter("empreqid");
        String approvalComment = request.getParameter("approvalComment");
        recruitmentMaster = recruitmentService.readById(Integer.parseInt(mppid));
        RecruitmentMppApproval recruitmentMppApproval = recruitmentMppApprovalService.mppreadByIdAndEmpId(recruitmentMaster.getId(), employeeMaster.getId());
        int userLevel = recruitmentMppApproval.getLevel();
        int CurrentLevel = recruitmentMaster.getCurrentLevel();
        int totalLevel = recruitmentMaster.getTotalLevel();

        if (btnType.equals("Approve")) {

            if (userLevel == totalLevel) {
                recruitmentMaster.setMppStatus(5);

            } else {
                recruitmentMaster.setMppStatus(4);

                recruitmentMaster.setCurrentLevel(CurrentLevel + 1);

            }

//            recruitmentMaster.setApprovalComment(approvalComment);
            recruitmentMppApproval.setComment(approvalComment);
            recruitmentService.update(recruitmentMaster);
            recruitmentMppApprovalService.update(recruitmentMppApproval);
            request.setAttribute("successMessage",
                    "Information : The Request is Approved successfully.");
        }
        if (btnType.equals("Recycle")) {

            if (userLevel > 1) {
                recruitmentMaster.setMppStatus(2);
                recruitmentMaster.setCurrentLevel(CurrentLevel - 1);

            } else {
                recruitmentMaster.setMppStatus(1);
                recruitmentMaster.setCurrentLevel(CurrentLevel - 1);

            }

//            recruitmentMaster.setApprovalComment(approvalComment);
            recruitmentMppApproval.setComment(approvalComment);
            recruitmentService.update(recruitmentMaster);
            recruitmentMppApprovalService.update(recruitmentMppApproval);
            request.setAttribute("successMessage",
                    "Information : The Request is Returned successfully.");
        }
        if (btnType.equals("Reject")) {

            recruitmentMaster.setMppStatus(3);
            recruitmentMppApproval.setComment(approvalComment);
//            recruitmentMaster.setApprovalComment(approvalComment);
            recruitmentService.update(recruitmentMaster);
            recruitmentMppApprovalService.update(recruitmentMppApproval);
            request.setAttribute("successMessage",
                    "Information : The Request is Rejectd successfully.");

        }
        mv.getModelMap().put("recruitmentMaster", recruitmentMaster);
        mv = approvalMppCreate(request, response);
        return mv;
    }

    public ModelAndView viewMPPShow(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        RecruitmentMaster recruitmentMaster = new RecruitmentMaster();
        DepartmentMaster departmentMaster = new DepartmentMaster();
        LocationMaster locationMaster = new LocationMaster();
        JobtypeMaster jobtypeMaster = new JobtypeMaster();
        DesignationMaster designationMaster = new DesignationMaster();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date cDate = new Date();
        recruitmentMaster.setCreatedDate(sdf.format(cDate));

        departmentList(request);
        designationList(request);
        Map<Integer, String> locationMap = readLocations();
        Map<Integer, String> jobtype1 = jobtypeList();
        mv.addObject("locationMap", locationMap);
        mv.addObject("jobtype1", jobtype1);

        String id = request.getParameter("id");
        recruitmentMaster = recruitmentService.readById(Integer.parseInt(id));

        int jobtypeId = recruitmentMaster.getJobtypeMaster().getId();
        jobtypeMaster = jobtypeMasterService.readById(jobtypeId);
        String jobtypeNAme = jobtypeMaster.getJobTypeName();

        int department = recruitmentMaster.getDepartmentMaster().getId();
        departmentMaster = departmentMasterService.readById(department);
        String departmentName = departmentMaster.getDepartmentName();

        int localtion = recruitmentMaster.getLocationMaster().getId();
        locationMaster = locationMasterService.readById(localtion);
        String locationName = locationMaster.getLocation();

        int designation = recruitmentMaster.getDesignationMaster().getId();
        designationMaster = designationMasterService.readById(designation);
        String designationName = designationMaster.getDesignationName();

        String experiance = recruitmentMaster.getExperiance();

        int position = recruitmentMaster.getNumberOfPosition();

        mv.getModelMap().put("recruitmentMaster", recruitmentMaster);
        mv.getModelMap().put("departmentMaster", departmentMaster);
        mv.getModelMap().put("locationMaster", locationMaster);
        mv.getModelMap().put("jobtypeMaster", jobtypeMaster);
        mv.getModelMap().put("designationMaster", designationMaster);
        mv.getModelMap().put("recruitmentMaster", recruitmentMaster);
        request.setAttribute("jobtypeNAme", jobtypeNAme);
        request.setAttribute("departmentName", departmentName);
        request.setAttribute("locationName", locationName);
        request.setAttribute("position", position);
        request.setAttribute("designationName", designationName);
        request.setAttribute("experiance", experiance);
        mv.setViewName("Recruitment/ViewMppShow");

        return mv;
    }

    public ModelAndView mprViewOnly(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        MprMaster mprMaster = new MprMaster();
        VacancyMaster vacancyMaster = new VacancyMaster();
        DepartmentMaster departmentMaster = new DepartmentMaster();
        LocationMaster locationMaster = new LocationMaster();
        JobtypeMaster jobtypeMaster = new JobtypeMaster();
        DesignationMaster designationMaster = new DesignationMaster();

        departmentList(request);
        designationList(request);
        Map<Integer, String> locationMap = readLocations();
        Map<Integer, String> jobtype1 = jobtypeList();
        mv.addObject("locationMap", locationMap);
        mv.addObject("jobtype1", jobtype1);

        String id = request.getParameter("id");
        mprMaster = mprMasterService.readById(Integer.parseInt(id));

        int jobtypeId = mprMaster.getJobtypeMaster().getId();
        jobtypeMaster = jobtypeMasterService.readById(jobtypeId);
        String jobtypeNAme = jobtypeMaster.getJobTypeName();

        int department = mprMaster.getDepartmentMaster().getId();
        departmentMaster = departmentMasterService.readById(department);
        String departmentName = departmentMaster.getDepartmentName();

        int localtion = mprMaster.getLocationMaster().getId();
        locationMaster = locationMasterService.readById(localtion);
        String locationName = locationMaster.getLocation();

        int designation = mprMaster.getDesignationMaster().getId();
        designationMaster = designationMasterService.readById(designation);
        String designationName = designationMaster.getDesignationName();

        String experiance = mprMaster.getExperience();

        int position = mprMaster.getNumberOfPosition();
        int budget = mprMaster.getBudget();
        mv.getModelMap().put("mprMaster", mprMaster);
        mv.getModelMap().put("departmentMaster", departmentMaster);
        mv.getModelMap().put("locationMaster", locationMaster);
        mv.getModelMap().put("jobtypeMaster", jobtypeMaster);
        mv.getModelMap().put("designationMaster", designationMaster);
        mv.getModelMap().put("vacancyMaster", vacancyMaster);
        request.setAttribute("jobtypeNAme", jobtypeNAme);
        request.setAttribute("departmentName", departmentName);
        request.setAttribute("locationName", locationName);
        request.setAttribute("position", position);
        request.setAttribute("designationName", designationName);
        request.setAttribute("experiance", experiance);
        request.setAttribute("budget", budget);
        mv.setViewName("Recruitment/MPRViewOnly");
        return mv;
    }

    public ModelAndView allMprFetch(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        RecruitmentMaster recruitmentMaster = new RecruitmentMaster();
        MprMaster mprMaster = new MprMaster();
        List<?> mprMasterList = mprMasterService.readMprList();
        mv.getModelMap().put("list", mprMasterList);
        mv.getModelMap().put("mprMaster", mprMaster);
        mv.setViewName("MPR/ShowAllMprList");
        return mv;
    }

}
