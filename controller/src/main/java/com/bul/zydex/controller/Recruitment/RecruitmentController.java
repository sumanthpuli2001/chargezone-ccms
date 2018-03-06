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
        RecruitmentMaster recruitmentMaster = new RecruitmentMaster();

        List<?> recruitmentMasterList = recruitmentService.readBudgetDetail();
        mv.getModelMap().put("list", recruitmentMasterList);
        mv.getModelMap().put("recruitmentMaster", recruitmentMaster);
        mv.setViewName("Recruitment/RecruitmentCreateMPP");
        return mv;
    }

    public ModelAndView searchForCreatedBudget(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        RecruitmentMaster recruitmentMaster = new RecruitmentMaster();
        List<?> recruitmentMasterList = recruitmentService.readBudgetDetail();
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
        RecruitmentMaster recruitmentMaster = new RecruitmentMaster();
        DepartmentMaster departmentMaster = new DepartmentMaster();
        LocationMaster locationMaster = new LocationMaster();
        JobtypeMaster jobtypeMaster = new JobtypeMaster();
        BindException errors = new BindException(recruitmentMaster, "recruitmentMaster");
        bind(request, recruitmentMaster);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date cDate = new Date();
        recruitmentMaster.setMppStatus(0);
        recruitmentMaster.setCreatedDate(sdf.format(cDate));
//        selectBudget(request, response);
        departmentList(request);

        recruitmentValidator.validate(recruitmentMaster, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid");
            mv.addAllObjects(errors.getModel());
            mv = newCreateBudget(request, response);
        } else {
            recruitmentService.create(recruitmentMaster);
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

        ModelAndView mv = new ModelAndView();
        MprMaster mprMaster = new MprMaster();
        List<?> list = mprMasterService.readMprList();
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
        List<ApprovalUser> approvalList = (List<ApprovalUser>) approvalUserService.readByApprovalId(72);

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

        int position = recruitmentMaster.getNumberOfPosition();
        mprMaster.setNumberOfPosition(position);
//        selectMPRBudget(request, response);
        departmentList(request);

        mprValidator.validate(mprMaster, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid");
            mv.addAllObjects(errors.getModel());
            mv = viewClick(request, response);
        } else {
            mprMaster.setStatus(0);

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
        BindException errors = new BindException(mprMaster, "mprMaster");
        bind(request, mprMaster);
        departmentList(request);

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

        ModelAndView mv = new ModelAndView();
        MprMaster mprMaster = new MprMaster();
        List<?> list = mprMasterService.readMprList();
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

        if (btnType.equals("Approve")) {
            mprMaster = mprMasterService.readById(Integer.parseInt(empreqid));
            mprMaster.setStatus(1);
            mprMasterService.update(mprMaster);
            request.setAttribute("successMessage",
                    "Information : The Request is Approved successfully.");
        }
        if (btnType.equals("Return")) {
            mprMaster = mprMasterService.readById(Integer.parseInt(empreqid));
            mprMaster.setStatus(2);
            mprMasterService.update(mprMaster);
            request.setAttribute("successMessage",
                    "Information : The Request is Returned successfully.");
        }
        if (btnType.equals("Reject")) {
            mprMaster = mprMasterService.readById(Integer.parseInt(empreqid));
            mprMaster.setStatus(3);
            mprMasterService.update(mprMaster);
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
        
        int  designation =  recruitmentMaster.getDesignationMaster().getId();
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

        ModelAndView mv = new ModelAndView();
        RecruitmentMaster recruitmentMaster = new RecruitmentMaster();
        List<?> recruitmentMasterList = recruitmentService.readBudgetDetail();
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

        bind(request, recruitmentMaster);
        String btnType = request.getParameter("btnType");
        String mppid = request.getParameter("empreqid");

        if (btnType.equals("Approve")) {
            recruitmentMaster = recruitmentService.readById(Integer.parseInt(mppid));
            recruitmentMaster.setMppStatus(1);
            recruitmentService.update(recruitmentMaster);
            request.setAttribute("successMessage",
                    "Information : The Request is Approved successfully.");
        }
        if (btnType.equals("Recycle")) {
            recruitmentMaster = recruitmentService.readById(Integer.parseInt(mppid));
            recruitmentMaster.setMppStatus(2);
            recruitmentService.update(recruitmentMaster);
            request.setAttribute("successMessage",
                    "Information : The Request is Returned successfully.");
        }
        if (btnType.equals("Reject")) {
            recruitmentMaster = recruitmentService.readById(Integer.parseInt(mppid));
            recruitmentMaster.setMppStatus(3);
            recruitmentService.update(recruitmentMaster);
            request.setAttribute("successMessage",
                    "Information : The Request is Rejectd successfully.");

        }
        mv.getModelMap().put("recruitmentMaster", recruitmentMaster);
        mv = approvalMppCreate(request, response);
        return mv;
    }

}
