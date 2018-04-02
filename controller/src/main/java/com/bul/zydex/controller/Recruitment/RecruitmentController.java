/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Recruitment;

import com.bul.zydex.model.ApprovalUser;
import com.bul.zydex.model.CandidateApplyJob;
import com.bul.zydex.model.CandidateJobApplication;
import com.bul.zydex.model.DepartmentMaster;
import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.JobtypeMaster;
import com.bul.zydex.model.LocationMaster;
import com.bul.zydex.model.MprApproval;
import com.bul.zydex.model.MprEmployeeCategory;
import com.bul.zydex.model.MprEmployeeTypeMaster;
import com.bul.zydex.model.MprMaster;
import com.bul.zydex.model.OnlineAssessment;
import com.bul.zydex.model.QulificationMaster;
import com.bul.zydex.model.RecruitmentApprovalHistory;
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
        List<ApprovalUser> approvalList = (List<ApprovalUser>) approvalUserService.readByApprovalId(1);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date cDate = new Date();

        departmentList(request);
        designationList(request);
        Map<Integer, String> locationMap = readLocations();
        Map<Integer, String> jobtype1 = jobtypeList();
        mv.addObject("locationMap", locationMap);
        mv.addObject("jobtype1", jobtype1);

        recruitmentValidator.validate(recruitmentMaster, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "All field are Required.Please Enter Valid data");
            mv.addAllObjects(errors.getModel());
            mv.setViewName("Recruitment/CreateNewBudget");
//            mv = newCreateBudget(request, response);
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

            RecruitmentApprovalHistory approvalHistory = new RecruitmentApprovalHistory();
            approvalHistory.setRecruitmentMaster(recruitmentMaster);
            approvalHistory.setApprovalUserId(employeeMaster.getId());
            approvalHistory.setApprovalUserName(employeeMaster.getEmployeeName());
            approvalHistory.setCreatedBy(employeeMaster.getId());
            approvalHistory.setCreateDate(sdf.format(cDate));
            approvalHistory.setStatus(0);
            recruitmentApprovalHistoryService.create(approvalHistory);

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
                List<?> list = recruitmentMppApprovalService.recruitmentMppdelete(z);
                for (Object object : list) {
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
        List<ApprovalUser> approvalList = (List<ApprovalUser>) approvalUserService.readByApprovalId(1);

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

        int mppvalue = recruitmentMaster.getBudget();
        int mprvalue = mprMaster.getBudget();

        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid");
//            mv.addAllObjects(errors.getModel());
            String jobtypeNAme = jobtypeMaster.getJobTypeName();

            String departmentName = departmentMaster.getDepartmentName();

            String locationName = locationMaster.getLocation();

            String designationName = designationMaster.getDesignationName();

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
//            mv.setViewName("Recruitment/MprSearchCreateBudget");
//            mv = viewClick(request, response);
        } else if (mprvalue > mppvalue) {
            request.setAttribute("failureMessage",
                    "MPR Budget Should be less than MPP Budget");
//            mv.addAllObjects(errors.getModel());
            String jobtypeNAme = jobtypeMaster.getJobTypeName();

            String departmentName = departmentMaster.getDepartmentName();

            String locationName = locationMaster.getLocation();

            String designationName = designationMaster.getDesignationName();

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

        } else {
            mprMaster.setRemainingBudget(mprvalue);
            mprMaster.setStatus(0);
            mprMaster.setCurrentLevel(1);
            mprMaster.setTotalLevel(approvalList.size());
            mprMaster.setRecruitmentMaster(recruitmentMaster);
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

                MprApproval mprApproval = new MprApproval();
                List<?> list = mprApprovalService.mPrDelete(z);
                for (Object object : list) {
                    mprApproval = (MprApproval) object;
                    mprApprovalService.delete(mprApproval.getId());
                }

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
        RecruitmentMaster rm = recruitmentService.readById(mprMaster.getRecruitmentMaster().getId());

        int Mppbudget = rm.getBudget();

        mv.getModelMap().put("mprMaster", mprMaster);
        mv.getModelMap().put("Mppbudget", Mppbudget);
        mv.setViewName("Recruitment/MprEditSubmit");
        return mv;
    }

    public ModelAndView mprEditSubmitDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        MprMaster mprMaster = new MprMaster();
        BindException errors = new BindException(mprMaster, "mprMaster");
        bind(request, mprMaster);
        departmentList(request);
        MprMaster mprMaster1 = mprMasterService.readById(mprMaster.getId());

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
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        BindException errors = new BindException(recruitmentMaster, "recruitmentMaster");
        bind(request, recruitmentMaster);
//        payrollProfessionalTaxValidator.validate(payrollProfessionalTax, errors);

        RecruitmentMaster rm = recruitmentService.readById(recruitmentMaster.getId());

        Map<Integer, String> locationMap = readLocations();
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error :  not valid.");
            mv.addAllObjects(errors.getModel());
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date cDate = new Date();
            recruitmentMaster.setMppStatus(0);
            recruitmentMaster.setCurrentLevel(1);
            recruitmentMaster.setTotalLevel(rm.getTotalLevel());
            recruitmentMaster.setUpdatedDate(sdf.format(cDate));
            recruitmentMaster.setUpdatedBy(employeeMaster.getId());
            recruitmentMaster.setCreatedBy(rm.getCreatedBy());
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
        OnlineAssessment onlineAssessment = new OnlineAssessment();
//        List<?> candidateApplyJobList = candidateJobApplyService.fetchcandidatelist();
        List<?> candidateJobList = candidateJobApplicationService.readCandidateApplyForJob();

        mv.getModelMap().put("list", candidateJobList);
        questionList(request);
        mv.getModelMap().put("onlineAssessment", onlineAssessment);
        mv.getModelMap().put("candidateApplyJob", candidateApplyJob);
        mv.setViewName("Recruitment/CandidateRequestList");
        return mv;
    }

    public ModelAndView CandidateViewClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        CandidateApplyJob candidateApplyJob = new CandidateApplyJob();
        String id = request.getParameter("id");
        DepartmentMaster departmentMaster = new DepartmentMaster();
        LocationMaster locationMaster = new LocationMaster();
        JobtypeMaster jobtypeMaster = new JobtypeMaster();
        DesignationMaster designationMaster = new DesignationMaster();
        int candJobApplicationid = Integer.parseInt(id);
        CandidateJobApplication cja = candidateJobApplicationService.readById(candJobApplicationid);
        candidateApplyJob = candidateJobApplyService.readById(cja.getCandidateApplyJob().getId());
        VacancyMaster vm = vacancyMasterService.readById(cja.getVacancyMaster().getId());
        MprMaster mm = mprMasterService.readById(vm.getMprMaster().getId());
        RecruitmentMaster rm = recruitmentService.readById(mm.getRecruitmentMaster().getId());

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

        OnlineAssessment onlineAssessment = new OnlineAssessment();
        questionList(request);
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

        request.setAttribute("jobtypeNAme2", jobtypeNAme2);
        request.setAttribute("departmentName2", departmentName2);
        request.setAttribute("locationName2", locationName2);
        request.setAttribute("designationName2", designationName2);
        request.setAttribute("numberOfPositionMpp", numberOfPositionMpp);
        request.setAttribute("Mppbudget", Mppbudget);
        request.setAttribute("MppExperience", MppExperience);

//              MPR Master -------------
        request.setAttribute("jobtypeNAme1", jobtypeNAme1);
        request.setAttribute("departmentName1", departmentName1);
        request.setAttribute("locationName1", locationName1);
        request.setAttribute("designationName1", designationName1);
        request.setAttribute("MprName", MprName);
        request.setAttribute("numberOfPositionMpr", numberOfPositionMpr);
        request.setAttribute("Mprbudget", Mprbudget);
        request.setAttribute("MprExperience", MprExperience);
        request.setAttribute("Mprdescription", Mprdescription);
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
//        // onlineAssessment -------------
        mv.getModelMap().put("onlineAssessment", onlineAssessment);
        request.setAttribute("candidateJobApplication", cja);
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
        RecruitmentMaster recruitmentMaster1 = new RecruitmentMaster();
        RecruitmentApprovalHistory approvalHistory = new RecruitmentApprovalHistory();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        bind(request, recruitmentMaster1);
        String btnType = request.getParameter("btnType");
        String mppid = request.getParameter("empreqid");
        String approvalComment = request.getParameter("approvalComment");
        RecruitmentMaster recruitmentMaster = recruitmentService.readById(Integer.parseInt(mppid));
        RecruitmentMppApproval recruitmentMppApproval = recruitmentMppApprovalService.mppreadByIdAndEmpId(recruitmentMaster.getId(), employeeMaster.getId());
        int userLevel = recruitmentMppApproval.getLevel();
        int CurrentLevel = recruitmentMaster.getCurrentLevel();
        int totalLevel = recruitmentMaster.getTotalLevel();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date cDate = new Date();

        if (btnType.equals("Approve")) {

            if (userLevel == totalLevel) {
                recruitmentMaster.setMppStatus(5);
                approvalHistory.setStatus(5);
            } else {
                recruitmentMaster.setMppStatus(4);
                approvalHistory.setStatus(4);
                recruitmentMaster.setCurrentLevel(CurrentLevel + 1);

            }

//            recruitmentMaster.setApprovalComment(approvalComment);
            recruitmentMppApproval.setComment(approvalComment);
            recruitmentService.update(recruitmentMaster);
            recruitmentMppApprovalService.update(recruitmentMppApproval);
            approvalHistory.setRecruitmentMaster(recruitmentMaster);
            approvalHistory.setApprovalUserId(employeeMaster.getId());
            approvalHistory.setApprovalUserName(employeeMaster.getEmployeeName());
            approvalHistory.setCreateDate(sdf.format(cDate));
            approvalHistory.setCreatedBy(employeeMaster.getId());
            approvalHistory.setComment(approvalComment);
            approvalHistory.setStatusMessage(btnType);
            recruitmentApprovalHistoryService.create(approvalHistory);
            request.setAttribute("successMessage",
                    "Information : The Request is Approved successfully.");
        }
        if (btnType.equals("Recycle")) {

            if (userLevel > 1) {
                recruitmentMaster.setMppStatus(2);
                recruitmentMaster.setCurrentLevel(CurrentLevel - 1);
                approvalHistory.setStatus(2);
            } else {
                recruitmentMaster.setMppStatus(1);
                approvalHistory.setStatus(1);
                recruitmentMaster.setCurrentLevel(CurrentLevel - 1);

            }

//            recruitmentMaster.setApprovalComment(approvalComment);
            recruitmentMppApproval.setComment(approvalComment);
            recruitmentService.update(recruitmentMaster);
            recruitmentMppApprovalService.update(recruitmentMppApproval);
            approvalHistory.setRecruitmentMaster(recruitmentMaster);
            approvalHistory.setApprovalUserId(employeeMaster.getId());
            approvalHistory.setApprovalUserName(employeeMaster.getEmployeeName());
            approvalHistory.setCreateDate(sdf.format(cDate));
            approvalHistory.setCreatedBy(employeeMaster.getId());
            approvalHistory.setComment(approvalComment);
            approvalHistory.setStatusMessage(btnType);
            recruitmentApprovalHistoryService.create(approvalHistory);

            request.setAttribute("successMessage",
                    "Information : The Request is Returned successfully.");
        }
        if (btnType.equals("Reject")) {

            recruitmentMaster.setMppStatus(3);
            recruitmentMppApproval.setComment(approvalComment);
            recruitmentService.update(recruitmentMaster);
            recruitmentMppApprovalService.update(recruitmentMppApproval);

            approvalHistory.setRecruitmentMaster(recruitmentMaster);
            approvalHistory.setApprovalUserId(employeeMaster.getId());
            approvalHistory.setApprovalUserName(employeeMaster.getEmployeeName());
            approvalHistory.setCreateDate(sdf.format(cDate));
            approvalHistory.setCreatedBy(employeeMaster.getId());
            approvalHistory.setComment(approvalComment);
            approvalHistory.setStatus(3);
            approvalHistory.setStatusMessage(btnType);
//            recruitmentMaster.setApprovalComment(approvalComment);
            recruitmentApprovalHistoryService.create(approvalHistory);
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
        List<?> recruitmentMppApproval = recruitmentMppApprovalService.readByMppId(Integer.parseInt(id));
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
        request.setAttribute("recruitmentMppApproval", recruitmentMppApproval);
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
        MprMaster mprMaster = new MprMaster();
        List<?> mprMasterList = mprMasterService.readMprList();
        mv.getModelMap().put("list", mprMasterList);
        mv.getModelMap().put("mprMaster", mprMaster);
        mv.setViewName("MPR/ShowAllMprList");
        return mv;
    }

    public ModelAndView allMppFetch(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        RecruitmentMaster recruitmentMaster = new RecruitmentMaster();
        MprMaster mprMaster = new MprMaster();
        List<?> mpplist = recruitmentService.fetchAllMpp();
        mv.getModelMap().put("list", mpplist);
        mv.getModelMap().put("recruitmentMaster", recruitmentMaster);
        mv.setViewName("Recruitment/MppShowAllList");
        return mv;
    }

    public ModelAndView viewMppOnly(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        RecruitmentMaster recruitmentMaster = new RecruitmentMaster();
        DepartmentMaster departmentMaster = new DepartmentMaster();
        LocationMaster locationMaster = new LocationMaster();
        JobtypeMaster jobtypeMaster = new JobtypeMaster();
        DesignationMaster designationMaster = new DesignationMaster();

        departmentList(request);
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
        int budget = recruitmentMaster.getBudget();
        int mppId = recruitmentMaster.getId();
        List<?> list = recruitmentApprovalHistoryService.getByRecruitementMasterId(mppId);
        mv.getModelMap().put("recruitmentMaster", recruitmentMaster);
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
        request.setAttribute("budget", budget);
        request.setAttribute("list", list);
        mv.setViewName("Recruitment/ApprovalOnlyViewMpp");

        return mv;
    }

}
