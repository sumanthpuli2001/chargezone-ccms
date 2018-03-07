/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Vacancy;

import com.bul.zydex.model.ApplayJobUserMaster;
import com.bul.zydex.model.CandidateApplyJob;
import com.bul.zydex.model.DepartmentMaster;
import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.JobtypeMaster;
import com.bul.zydex.model.LocationMaster;
import com.bul.zydex.model.MprEmployeeCategory;
import com.bul.zydex.model.MprEmployeeTypeMaster;
import com.bul.zydex.model.MprMaster;
import com.bul.zydex.model.VacancyMaster;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class VacancyController extends VacancyAbstract {

    public ModelAndView vacancyDetailList(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        VacancyMaster vacancyMaster = new VacancyMaster();
        List<?> vacancylist = vacancyMasterService.fetchVacancyDetail();
        mv.getModelMap().put("list", vacancylist);
        mv.getModelMap().put("vacancyMaster", vacancyMaster);
        mv.setViewName("Vacancy/VacancyDetailReportList");
        return mv;
    }

    public ModelAndView applyJobRegistration(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        CandidateApplyJob candidateApplyJob = new CandidateApplyJob();
        mv.getModelMap().put("candidateApplyJob", candidateApplyJob);
        mv.setViewName("Vacancy/applyJobCandidateRegistration");
        return mv;
    }

    public ModelAndView newVacancyCreate(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        MprMaster mprMaster = new MprMaster();
        VacancyMaster vacancyMaster = new VacancyMaster();
        DepartmentMaster departmentMaster = new DepartmentMaster();
        LocationMaster locationMaster = new LocationMaster();
        JobtypeMaster jobtypeMaster = new JobtypeMaster();
        MprEmployeeCategory mprEmployeeCategory = new MprEmployeeCategory();
        MprEmployeeTypeMaster employeeTypeMaster = new MprEmployeeTypeMaster();
        DesignationMaster designationMaster = new DesignationMaster();
        if (vacancyMaster.getId() != null) {
            vacancyMaster = vacancyMasterService.readById(vacancyMaster.getId());
            vacancyMaster.setLocationMaster(vacancyMaster.getLocationMaster());
            vacancyMaster.setDepartmentMaster(vacancyMaster.getDepartmentMaster());
            vacancyMaster.setJobtypeMaster(vacancyMaster.getJobtypeMaster());
            vacancyMaster.setMprEmployeeCategory(vacancyMaster.getMprEmployeeCategory());
            vacancyMaster.setMprEmployeeTypeMaster(vacancyMaster.getMprEmployeeTypeMaster());
            vacancyMaster.setDesignationMaster(vacancyMaster.getDesignationMaster());
        } else {
            vacancyMaster.setLocationMaster(new LocationMaster());
            vacancyMaster.setDepartmentMaster(new DepartmentMaster());
            vacancyMaster.setJobtypeMaster(new JobtypeMaster());
            vacancyMaster.setMprEmployeeCategory(new MprEmployeeCategory());
            vacancyMaster.setMprEmployeeTypeMaster(new MprEmployeeTypeMaster());
            vacancyMaster.setDesignationMaster(new DesignationMaster());
        }
        departmentList(request);
        employeecategoryList(request);
        employeeTypeList(request);
        designationList(request);
        Map<Integer, String> locationMap = readLocations();
        Map<Integer, String> jobtype1 = jobtypeList();
        mv.addObject("locationMap", locationMap);
        mv.addObject("jobtype1", jobtype1);
        vacancyMaster.setDepartmentMaster(new DepartmentMaster());
        vacancyMaster.setLocationMaster(new LocationMaster());
        vacancyMaster.setJobtypeMaster(new JobtypeMaster());
        vacancyMaster.setMprEmployeeCategory(new MprEmployeeCategory());
        vacancyMaster.setMprEmployeeTypeMaster(new MprEmployeeTypeMaster());
        vacancyMaster.setDesignationMaster(new DesignationMaster());
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
        mv.getModelMap().put("mprEmployeeCategory", mprEmployeeCategory);
        mv.getModelMap().put("employeeTypeMaster", employeeTypeMaster);
        mv.getModelMap().put("designationMaster", designationMaster);
        mv.getModelMap().put("vacancyMaster", vacancyMaster);
         request.setAttribute("jobtypeNAme", jobtypeNAme);
        request.setAttribute("departmentName", departmentName);
        request.setAttribute("locationName", locationName);
        request.setAttribute("position", position);
        request.setAttribute("designationName", designationName);
        request.setAttribute("experiance", experiance);
        request.setAttribute("budget", budget);
        mv.setViewName("Vacancy/CreateVacancy");
        return mv;
    }

    public ModelAndView vacancySubmitCreate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        VacancyMaster vacancyMaster = new VacancyMaster();
        DepartmentMaster departmentMaster = new DepartmentMaster();
        LocationMaster locationMaster = new LocationMaster();
        JobtypeMaster jobtypeMaster = new JobtypeMaster();
        DesignationMaster designationMaster = new DesignationMaster();
        MprEmployeeCategory mprEmployeeCategory = new MprEmployeeCategory();
        MprEmployeeTypeMaster employeeTypeMaster = new MprEmployeeTypeMaster();
        BindException errors = new BindException(vacancyMaster, "vacancyMaster");
        bind(request, vacancyMaster);

//        selectBudget(request, response);
        departmentList(request);

        vacancyValidator.validate(vacancyMaster, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : All Fields Are Mandatorys");
            mv = newVacancyCreate(request, response);
        } else {
            vacancyMaster.setStatus(0);
            vacancyMasterService.create(vacancyMaster);
            request.setAttribute("successMessage",
                    "Information : The Information is Created Successfully.");

            mv = vacancyDetailList(request, response);
        }

        return mv;
    }

    public ModelAndView clickDeleteVacancy(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        String savingList[] = request.getParameterValues("checkId");
        for (String z : savingList) {
            try {
                vacancyMasterService.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info :The Records are deleted successfully.");
            } catch (Exception e) {

            }
        }
        mv = vacancyDetailList(request, response);
        return mv;
    }

    public ModelAndView showVacancyList(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        VacancyMaster vacancyMaster = new VacancyMaster();
        List<?> vacancylist = vacancyMasterService.fetchVacancyDetail();
        mv.getModelMap().put("list", vacancylist);
        mv.getModelMap().put("vacancyMaster", vacancyMaster);
        mv.setViewName("Vacancy/ShowVacancyList");
        return mv;
    }

    public ModelAndView viewVacancy(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        VacancyMaster vacancyMaster = new VacancyMaster();
        DepartmentMaster departmentMaster = new DepartmentMaster();
        LocationMaster locationMaster = new LocationMaster();
        JobtypeMaster jobtypeMaster = new JobtypeMaster();
        DesignationMaster designationMaster = new DesignationMaster();
        MprEmployeeCategory mprEmployeeCategory = new MprEmployeeCategory();
        MprEmployeeTypeMaster employeeTypeMaster = new MprEmployeeTypeMaster();

        departmentList(request);
        designationList(request);
        employeecategoryList(request);
        employeeTypeList(request);
        Map<Integer, String> locationMap = readLocations();
        Map<Integer, String> jobtype1 = jobtypeList();
        mv.addObject("locationMap", locationMap);
        mv.addObject("jobtype1", jobtype1);

        String id = request.getParameter("id");
        vacancyMaster = vacancyMasterService.readById(Integer.parseInt(id));
        mv.getModelMap().put("departmentMaster", departmentMaster);
        mv.getModelMap().put("locationMaster", locationMaster);
        mv.getModelMap().put("jobtypeMaster", jobtypeMaster);
        mv.getModelMap().put("mprEmployeeCategory", mprEmployeeCategory);
        mv.getModelMap().put("employeeTypeMaster", employeeTypeMaster);
        mv.getModelMap().put("designationMaster", designationMaster);
        mv.getModelMap().put("vacancyMaster", vacancyMaster);
        mv.setViewName("Vacancy/OutViewVacancy");

        return mv;
    }

    public ModelAndView viewEditVacancy(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        VacancyMaster vacancyMaster = new VacancyMaster();
        DepartmentMaster departmentMaster = new DepartmentMaster();
        LocationMaster locationMaster = new LocationMaster();
        JobtypeMaster jobtypeMaster = new JobtypeMaster();
        MprEmployeeCategory mprEmployeeCategory = new MprEmployeeCategory();
        MprEmployeeTypeMaster employeeTypeMaster = new MprEmployeeTypeMaster();
        DesignationMaster designationMaster = new DesignationMaster();
        if (vacancyMaster.getId() != null) {
            vacancyMaster = vacancyMasterService.readById(vacancyMaster.getId());
            vacancyMaster.setLocationMaster(vacancyMaster.getLocationMaster());
            vacancyMaster.setDepartmentMaster(vacancyMaster.getDepartmentMaster());
            vacancyMaster.setJobtypeMaster(vacancyMaster.getJobtypeMaster());
            vacancyMaster.setMprEmployeeCategory(vacancyMaster.getMprEmployeeCategory());
            vacancyMaster.setMprEmployeeTypeMaster(vacancyMaster.getMprEmployeeTypeMaster());
            vacancyMaster.setDesignationMaster(vacancyMaster.getDesignationMaster());
        } else {
            vacancyMaster.setLocationMaster(new LocationMaster());
            vacancyMaster.setDepartmentMaster(new DepartmentMaster());
            vacancyMaster.setJobtypeMaster(new JobtypeMaster());
            vacancyMaster.setMprEmployeeCategory(new MprEmployeeCategory());
            vacancyMaster.setMprEmployeeTypeMaster(new MprEmployeeTypeMaster());
            vacancyMaster.setDesignationMaster(new DesignationMaster());
        }
        departmentList(request);
        employeecategoryList(request);
        employeeTypeList(request);
        designationList(request);
        Map<Integer, String> locationMap = readLocations();
        Map<Integer, String> jobtype1 = jobtypeList();
        mv.addObject("locationMap", locationMap);
        mv.addObject("jobtype1", jobtype1);

        String id = request.getParameter("id");
        vacancyMaster = vacancyMasterService.readById(Integer.parseInt(id));
        mv.getModelMap().put("departmentMaster", departmentMaster);
        mv.getModelMap().put("locationMaster", locationMaster);
        mv.getModelMap().put("jobtypeMaster", jobtypeMaster);
        mv.getModelMap().put("mprEmployeeCategory", mprEmployeeCategory);
        mv.getModelMap().put("employeeTypeMaster", employeeTypeMaster);
        mv.getModelMap().put("designationMaster", designationMaster);
        mv.getModelMap().put("vacancyMaster", vacancyMaster);
        mv.setViewName("Vacancy/ViewVecancy");
        return mv;
    }

    public ModelAndView editVacancy(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        VacancyMaster vacancyMaster = new VacancyMaster();

        BindException errors = new BindException(vacancyMaster, "vacancyMaster");
        bind(request, vacancyMaster);
//        payrollProfessionalTaxValidator.validate(payrollProfessionalTax, errors);
        Map<Integer, String> locationMap = readLocations();
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Professional Tax is not valid.");
            mv.addAllObjects(errors.getModel());
        } else {
            vacancyMasterService.update(vacancyMaster);
            request.setAttribute("successMessage",
                    "Information: The Information is Edited Successfully");
        }

        mv.getModelMap().put("vacancyMaster", vacancyMaster);
        mv = vacancyDetailList(request, response);

        return mv;
    }

    public ModelAndView backButton(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        mv = showVacancyList(request, response);
        return mv;
    }

    public ModelAndView jobApplaClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("Vacancy/JobVacancyLogin");
        return mv;
    }

    public ModelAndView signUp(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        ApplayJobUserMaster applayJobUserMaster = new ApplayJobUserMaster();
        mv.getModelMap().put("applayJobUserMaster", applayJobUserMaster);
        mv.setViewName("Vacancy/signUpButton");
        return mv;
    }

    public ModelAndView submitRegistration(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        CandidateApplyJob candidateApplyJob = new CandidateApplyJob();
        BindException errors = new BindException(candidateApplyJob, "candidateApplyJob");
        bind(request, candidateApplyJob);

        candidateJobApplyValidator.validate(candidateApplyJob, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : This Form All Fields Are Require");
            mv.setViewName("Vacancy/applyJobCandidateRegistration");
        }

        candidateJobApplyService.create(candidateApplyJob);

        mv.getModelMap().put("candidateApplyJob", candidateApplyJob);
        mv.setViewName("Vacancy/applyJobCandidateRegistration");
        return mv;
    }

    public ModelAndView signUpCandidate(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        ApplayJobUserMaster applayJobUserMaster = new ApplayJobUserMaster();
        BindException errors = new BindException(applayJobUserMaster, "applayJobUserMaster");
        bind(request, applayJobUserMaster);

        applayJobUserMasterValidator.validate(applayJobUserMaster, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : All Fields Are Mandatorys");
            mv = signUp(request, response);

        } else if (applayJobUserMasterSerivce.isExist(applayJobUserMaster)) {
            request.setAttribute("failureMessage",
                    "Error : UserName & Password is already used.");
            mv = signUp(request, response);
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date cDate = new Date();
            applayJobUserMaster.setCreatedDate(sdf.format(cDate));
            applayJobUserMaster.setFirstTime(0);
            applayJobUserMasterSerivce.create(applayJobUserMaster);
            request.setAttribute("successMessage",
                    "Information : signUp Successfully.");
            return new ModelAndView("Vacancy/MemberPage", "applayJobUserMaster", applayJobUserMaster);
        }
        return mv;
    }

    public ModelAndView Login(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        ApplayJobUserMaster applayJobUserMaster = new ApplayJobUserMaster();
        mv.getModelMap().put("applayJobUserMaster", applayJobUserMaster);

        mv.setViewName("Vacancy/LoginButton");
        return mv;
    }

    public ModelAndView loginCandidate(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        ApplayJobUserMaster applayJobUserMaster = new ApplayJobUserMaster();
        VacancyMaster vacancyMaster = new VacancyMaster();
        BindException errors = new BindException(applayJobUserMaster, "applayJobUserMaster");
        bind(request, applayJobUserMaster);

        applayJobUserMasterValidator.validate(applayJobUserMaster, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : All Fields Are Mandatorys");
            mv.getModelMap().put("applayJobUserMaster", applayJobUserMaster);
            mv = Login(request, response);
        } else if (applayJobUserMasterSerivce.isExist(applayJobUserMaster)) {
            request.setAttribute("successMessage",
                    "Information : Login Successfully.");
            mv.getModelMap().put("applayJobUserMaster", applayJobUserMaster);
            return new ModelAndView("Vacancy/MemberVacancyList", "applayJobUserMaster", applayJobUserMaster);
        } else {
            request.setAttribute("failureMessage",
                    "Error : Invalid UserName Or Password.");
            mv = Login(request, response);
        }
        mv.getModelMap().put("applayJobUserMaster", applayJobUserMaster);
        return mv;
    }

    public ModelAndView backToHome(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        ApplayJobUserMaster applayJobUserMaster = new ApplayJobUserMaster();
        String id = request.getParameter("id");
        applayJobUserMaster = applayJobUserMasterSerivce.readById(Integer.parseInt(id));
//          mv.getModelMap().put("recruitmentMaster", recruitmentMaster);
        mv = showVacancyList(request, response);
        return mv;
    }

    public ModelAndView applayForJob(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        ApplayJobUserMaster applayJobUserMaster = new ApplayJobUserMaster();
        VacancyMaster vacancyMaster = new VacancyMaster();
        BindException errors = new BindException(applayJobUserMaster, "applayJobUserMaster");
        bind(request, applayJobUserMaster);

        applayJobUserMasterValidator.validate(applayJobUserMaster, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : All Fields Are Mandatorys");
            mv.getModelMap().put("applayJobUserMaster", applayJobUserMaster);
            mv.setViewName("Vacancy/ApplayLoginpage");
        } else if (applayJobUserMasterSerivce.isExist(applayJobUserMaster)) {
            String id = request.getParameter("id");
            vacancyMaster = vacancyMasterService.readById(Integer.parseInt(id));
            request.setAttribute("successMessage",
                    "Information : Login Successfully.");
            mv.getModelMap().put("list", vacancyMaster);
            mv.setViewName("Vacancy/MemberVacancyList");
//            return new ModelAndView("Vacancy/MemberVacancyList", "vacancyMaster", vacancyMaster);
        } else {
            request.setAttribute("failureMessage",
                    "Error : Invalid UserName Or Password.");
            mv = Login(request, response);
        }
        mv.getModelMap().put("applayJobUserMaster", applayJobUserMaster);
        return mv;
    }

    public ModelAndView membershowVacancyList(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        VacancyMaster vacancyMaster = new VacancyMaster();
        String id = request.getParameter("id");
        vacancyMaster = vacancyMasterService.readById(Integer.parseInt(id));
//        List<?> vacancylist = vacancyMasterService.fetchVacancyDetail();
        mv.getModelMap().put("list", vacancyMaster);
//        mv.getModelMap().put("vacancyMaster", vacancyMaster);
        return mv;
    }

    public ModelAndView myProfileClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        ApplayJobUserMaster applayJobUserMaster = new ApplayJobUserMaster();
        mv.getModelMap().put("applayJobUserMaster", applayJobUserMaster);
        mv.setViewName("Vacancy/MyProfile");

        return mv;
    }

    public ModelAndView clickassessment(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        ApplayJobUserMaster applayJobUserMaster = new ApplayJobUserMaster();
        mv.getModelMap().put("applayJobUserMaster", applayJobUserMaster);
        mv.setViewName("Vacancy/AssessmentCandidate");

        return mv;
    }

    public ModelAndView backToHomeVacancyList(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        VacancyMaster vacancyMaster = new VacancyMaster();
        List<?> vacancylist = vacancyMasterService.fetchVacancyDetail();
        mv.getModelMap().put("list", vacancylist);
        mv.getModelMap().put("vacancyMaster", vacancyMaster);
        mv.setViewName("Vacancy/backToHomeVacancyList");
        return mv;
    }

}
