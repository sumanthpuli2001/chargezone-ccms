/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Vacancy;

import com.bul.zydex.model.ApplayJobUserMaster;
import com.bul.zydex.model.CandidateApplyJob;
import com.bul.zydex.model.CandidateJobApplication;
import com.bul.zydex.model.DepartmentMaster;
import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.JobtypeMaster;
import com.bul.zydex.model.LocationMaster;
import com.bul.zydex.model.MprEmployeeCategory;
import com.bul.zydex.model.MprEmployeeTypeMaster;
import com.bul.zydex.model.MprMaster;
import com.bul.zydex.model.QuestionAns;
import com.bul.zydex.model.QuestionAnswerSubmit;
import com.bul.zydex.model.QuestionDetails;
import com.bul.zydex.model.QuestionLibrary;
import com.bul.zydex.model.VacancyMaster;
import com.bul.zydex.util.ActionType;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.validation.BindException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Vikas
 */
public class VacancyController extends VacancyAbstract {

    public ModelAndView vacancyDetailList(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        VacancyMaster vacancyMaster = new VacancyMaster();
        List<?> vacancylist = vacancyMasterService.fetchCreatedVacancy(employeeMaster.getId());
        mv.getModelMap().put("list", vacancylist);
        mv.getModelMap().put("vacancyMaster", vacancyMaster);
        mv.setViewName("Vacancy/VacancyDetailReportList");
        return mv;
    }

    public ModelAndView applyJobRegistration(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        String vacancyId = request.getParameter("vacancyId");
        int vacId = Integer.parseInt(vacancyId);
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession();
        ApplayJobUserMaster ajuMaster = (ApplayJobUserMaster) session.getAttribute("ApplayJobUserMaster");

        List<CandidateApplyJob> candidateProfile = (List<CandidateApplyJob>) candidateJobApplyService.readProfileByCandidateUserID(ajuMaster.getId());
//        VacancyMaster master=
        List<?> CandidateJobApplyList = new ArrayList<>();
        if (!candidateProfile.isEmpty()) {
            CandidateApplyJob caj = (CandidateApplyJob) candidateProfile.get(0);
            CandidateJobApplication cja = candidateJobApplicationService.readByCandidateIdAndVacancyId(caj.getId(), vacId);
            cja.setStatus(1);
            candidateJobApplicationService.update(cja);

            CandidateJobApplyList = candidateJobApplicationService.readByCandidateId(caj.getId());

        }
        request.setAttribute("list", CandidateJobApplyList);
        mv.getModelMap().put("applayJobUserMaster", ajuMaster);
        mv.setViewName("Vacancy/MemberVacancyList");

//        CandidateApplyJob candidateApplyJob = new CandidateApplyJob();
//
//        mv.getModelMap().put("candidateApplyJob", candidateApplyJob);
//        mv.setViewName("Vacancy/applyJobCandidateRegistration");
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
        DesignationMaster designationMaster = new DesignationMaster();
        if (vacancyMaster.getId() != null) {
            vacancyMaster = vacancyMasterService.readById(vacancyMaster.getId());
            vacancyMaster.setLocationMaster(vacancyMaster.getLocationMaster());
            vacancyMaster.setDepartmentMaster(vacancyMaster.getDepartmentMaster());
            vacancyMaster.setJobtypeMaster(vacancyMaster.getJobtypeMaster());
            vacancyMaster.setDesignationMaster(vacancyMaster.getDesignationMaster());
        } else {
            vacancyMaster.setLocationMaster(new LocationMaster());
            vacancyMaster.setDepartmentMaster(new DepartmentMaster());
            vacancyMaster.setJobtypeMaster(new JobtypeMaster());
            vacancyMaster.setDesignationMaster(new DesignationMaster());
        }
        departmentList(request);
        designationList(request);
        Map<Integer, String> locationMap = readLocations();
        Map<Integer, String> jobtype1 = jobtypeList();
        mv.addObject("locationMap", locationMap);
        mv.addObject("jobtype1", jobtype1);
        vacancyMaster.setDepartmentMaster(new DepartmentMaster());
        vacancyMaster.setLocationMaster(new LocationMaster());
        vacancyMaster.setJobtypeMaster(new JobtypeMaster());
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
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date cDate = new Date();
        String id = request.getParameter("mprMasterid");
        DepartmentMaster departmentMaster = new DepartmentMaster();
        MprMaster mprMaster = new MprMaster();
        LocationMaster locationMaster = new LocationMaster();
        JobtypeMaster jobtypeMaster = new JobtypeMaster();
        DesignationMaster designationMaster = new DesignationMaster();
        MprEmployeeCategory mprEmployeeCategory = new MprEmployeeCategory();
        MprEmployeeTypeMaster employeeTypeMaster = new MprEmployeeTypeMaster();
        BindException errors = new BindException(vacancyMaster, "vacancyMaster");
        bind(request, vacancyMaster);

        mprMaster = mprMasterService.readById(Integer.parseInt(id));

        vacancyMaster.setMprMaster(mprMaster);

        int jobtype = mprMaster.getJobtypeMaster().getId();
        jobtypeMaster = jobtypeMasterService.readById(jobtype);
        vacancyMaster.setJobtypeMaster(jobtypeMaster);

        int department = mprMaster.getDepartmentMaster().getId();
        departmentMaster = departmentMasterService.readById(department);
        vacancyMaster.setDepartmentMaster(departmentMaster);

        int jobrole = mprMaster.getDesignationMaster().getId();
        designationMaster = designationMasterService.readById(jobrole);
        vacancyMaster.setDesignationMaster(designationMaster);

        String experiance = mprMaster.getExperience();
        vacancyMaster.setExperience(experiance);

        int location = mprMaster.getLocationMaster().getId();
        locationMaster = locationMasterService.readById(location);
        vacancyMaster.setLocationMaster(locationMaster);

        int position = mprMaster.getNumberOfPosition();
        vacancyMaster.setNumberOfPosition(position);

//        selectBudget(request, response);
        departmentList(request);

        vacancyValidator.validate(vacancyMaster, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : All Fields Are Mandatorys");

            String jobtypeNAme = jobtypeMaster.getJobTypeName();

            String departmentName = departmentMaster.getDepartmentName();

            String locationName = locationMaster.getLocation();

            String designationName = designationMaster.getDesignationName();

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
            mv.addAllObjects(errors.getModel());
            mv.setViewName("Vacancy/CreateVacancy");

        } else {
            vacancyMaster.setStatus(0);
            vacancyMaster.setCreatedBy(employeeMaster.getId());
            vacancyMaster.setCreatedDate(sdf.format(cDate));
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
        Map<Integer, String> locationMap = readLocations();
        Map<Integer, String> jobtype1 = jobtypeList();
        mv.addObject("locationMap", locationMap);
        mv.addObject("jobtype1", jobtype1);

        String id = request.getParameter("id");
        vacancyMaster = vacancyMasterService.readById(Integer.parseInt(id));
        mv.getModelMap().put("departmentMaster", departmentMaster);
        mv.getModelMap().put("locationMaster", locationMaster);
        mv.getModelMap().put("jobtypeMaster", jobtypeMaster);
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
        DesignationMaster designationMaster = new DesignationMaster();
        if (vacancyMaster.getId() != null) {
            vacancyMaster = vacancyMasterService.readById(vacancyMaster.getId());
            vacancyMaster.setLocationMaster(vacancyMaster.getLocationMaster());
            vacancyMaster.setDepartmentMaster(vacancyMaster.getDepartmentMaster());
            vacancyMaster.setJobtypeMaster(vacancyMaster.getJobtypeMaster());
            vacancyMaster.setDesignationMaster(vacancyMaster.getDesignationMaster());
        } else {
            vacancyMaster.setLocationMaster(new LocationMaster());
            vacancyMaster.setDepartmentMaster(new DepartmentMaster());
            vacancyMaster.setJobtypeMaster(new JobtypeMaster());
            vacancyMaster.setDesignationMaster(new DesignationMaster());
        }
        departmentList(request);
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

        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartRequest.getFile("photograph");
        if (candidateJobApplyService.isExist(multipartFile.getOriginalFilename())) {
            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard"
                    + File.separator + "candidateimage" + File.separator;
            String fileLocationURL1 = "StorageYard"
                    + File.separator + "candidateimage" + File.separator;
            File Folder1 = new File(fileLocationURL);
            if (!Folder1.exists()) {
                Folder1.mkdirs();
            }
            if (multipartFile != null && multipartFile.getSize() > 0) {
                try {
                    File file2 = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", "_"));
                    File file = new File(fileLocationURL1 + multipartFile.getOriginalFilename().replaceAll(" ", "_"));
                    multipartFile.transferTo(file2);
                    candidateApplyJob.setPhotograph(multipartFile.getOriginalFilename().replaceAll(" ", "_"));
                } catch (Exception e) {

                }
            }
        }
        MultipartHttpServletRequest multipartRequest1 = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile1 = multipartRequest.getFile("certificateId1");
        if (candidateJobApplyService.isExistCertificateAttach(multipartFile1.getOriginalFilename())) {
            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard"
                    + File.separator + "CertificateAttach" + File.separator;
            String fileLocationURL1 = "StorageYard"
                    + File.separator + "CertificateAttach" + File.separator;
            File Folder1 = new File(fileLocationURL);
            if (!Folder1.exists()) {
                Folder1.mkdirs();
            }
            if (multipartFile1 != null && multipartFile1.getSize() > 0) {
                try {
                    File file2 = new File(fileLocationURL + multipartFile1.getOriginalFilename().replaceAll(" ", "_"));
                    File file = new File(fileLocationURL1 + multipartFile1.getOriginalFilename().replaceAll(" ", "_"));
                    multipartFile1.transferTo(file2);
                    candidateApplyJob.setCertificateAttach(multipartFile1.getOriginalFilename().replaceAll(" ", "_"));
                } catch (Exception e) {

                }
            }
        }
        candidateJobApplyValidator.validate(candidateApplyJob, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : This Form All Fields Are Require");
            mv.addAllObjects(errors.getModel());
            mv.getModelMap().put("candidateApplyJob", candidateApplyJob);
            mv.setViewName("Vacancy/applyJobCandidateRegistration");
        } else {

            ApplayJobUserMaster ajuMaster = (ApplayJobUserMaster) session.getAttribute("ApplayJobUserMaster");
            candidateApplyJob.setApplayJobUserMaster(ajuMaster);
            List<CandidateApplyJob> list = (List<CandidateApplyJob>) candidateJobApplyService.readProfileByCandidateUserID(ajuMaster.getId());
            if (!list.isEmpty()) {
            } else {
                candidateJobApplyService.create(candidateApplyJob);
            }

            VacancyMaster vacancyMaster = new VacancyMaster();
            List<?> vacancylist = vacancyMasterService.fetchVacancyDetail();
            mv.getModelMap().put("list", vacancylist);
            mv.getModelMap().put("vacancyMaster", vacancyMaster);
            mv.setViewName("Vacancy/ShowVacancyList");
        }

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
                    "Error : UserName is already used.");
            mv = signUp(request, response);
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date cDate = new Date();
            applayJobUserMaster.setCreatedDate(sdf.format(cDate));
            applayJobUserMaster.setFirstTime(0);
            applayJobUserMaster.setProfileSubmit(0);
            applayJobUserMasterSerivce.create(applayJobUserMaster);
            request.setAttribute("successMessage",
                    "Information : signUp Successfully.");
            return new ModelAndView("Vacancy/ApplayLoginpage", "applayJobUserMaster", applayJobUserMaster);
        }
        return mv;
    }

    public ModelAndView Login(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        ApplayJobUserMaster applayJobUserMaster = new ApplayJobUserMaster();
        mv.getModelMap().put("applayJobUserMaster", applayJobUserMaster);

        mv.setViewName("Vacancy/ApplayLoginpage");
        return mv;
    }

    public ModelAndView loginCandidate(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        ApplayJobUserMaster applayJobUserMaster = new ApplayJobUserMaster();
        VacancyMaster vacancyMaster = new VacancyMaster();
        BindException errors = new BindException(applayJobUserMaster, "applayJobUserMaster");
        bind(request, applayJobUserMaster);
        String userName = applayJobUserMaster.getUserName();
        String PassString = applayJobUserMaster.getPassword();

        if (!"".equals(userName) && !"".equals(PassString)) {
            ApplayJobUserMaster ajum = new ApplayJobUserMaster();
            ajum.setUserName(userName);
            ajum.setPassword(PassString);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date cDate = new Date();

            ApplayJobUserMaster master = applayJobUserMasterSerivce.checkByUserNameandPass(ajum);
            if (null != master) {
                HttpSession session1 = request.getSession(false);
                session1.setAttribute("ApplayJobUserMaster", master);

                request.setAttribute("successMessage",
                        "Information : Login Successfully.");

                List<CandidateApplyJob> candidateProfile = (List<CandidateApplyJob>) candidateJobApplyService.readProfileByCandidateUserID(master.getId());
                List<?> CandidateJobApplyList = new ArrayList<>();
                if (!candidateProfile.isEmpty()) {
                    CandidateApplyJob caj = (CandidateApplyJob) candidateProfile.get(0);
                    if ("" != request.getParameter("id")) {
                        String id = request.getParameter("id");
                        int VacId = Integer.parseInt(id);
                        vacancyMaster = vacancyMasterService.readById(VacId);
                        CandidateJobApplication application = candidateJobApplicationService.readByCandidateIdAndVacancyId(caj.getId(), vacancyMaster.getId());
                        if (null == application) {

                            CandidateJobApplication candidateJobApplication = new CandidateJobApplication();
                            candidateJobApplication.setVacancyMaster(vacancyMaster);
                            candidateJobApplication.setApplayJobUserMaster(master);
                            candidateJobApplication.setCreatedBy(master.getId());
                            candidateJobApplication.setCreatedDate(sdf.format(cDate));
                            candidateJobApplication.setStatus(0);

                            candidateJobApplication.setCandidateApplyJob(caj);

                            candidateJobApplicationService.create(candidateJobApplication);
                        } else {
                            request.setAttribute("successMessage",
                                    "You are already apply for this job.");
                            List<?> vacancylist = vacancyMasterService.fetchVacancyDetail();
                            mv.getModelMap().put("list", vacancylist);
                            mv.getModelMap().put("vacancyMaster", vacancyMaster);
                            mv.setViewName("Vacancy/ShowVacancyList");
                            return mv;

                        }
                    }

                    CandidateJobApplyList = candidateJobApplicationService.readByCandidateId(caj.getId());
                }

//              ApplayJobUserMaster applayJobUserMaster = new ApplayJobUserMaster();
                request.setAttribute("successMessage",
                        "Information : Login Successfully.");
                request.setAttribute("list", CandidateJobApplyList);
                mv.getModelMap().put("applayJobUserMaster", master);

                mv.setViewName("Vacancy/MemberVacancyList");
                return mv;

            } else {
                request.setAttribute("failureMessage",
                        "Error : Invalid UserName Or Password.");
                mv = Login(request, response);
            }
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

        HttpSession session = request.getSession();
        ApplayJobUserMaster ajuMaster = (ApplayJobUserMaster) session.getAttribute("ApplayJobUserMaster");

        ModelAndView mv = new ModelAndView();
        ApplayJobUserMaster applayJobUserMaster = new ApplayJobUserMaster();
        VacancyMaster vacancyMaster = new VacancyMaster();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date cDate = new Date();
        String id = request.getParameter("id");
        vacancyMaster = vacancyMasterService.readById(Integer.parseInt(id));

        if (null != ajuMaster) {

            List<CandidateApplyJob> candidateProfile = (List<CandidateApplyJob>) candidateJobApplyService.readProfileByCandidateUserID(ajuMaster.getId());

            if (!candidateProfile.isEmpty()) {

                CandidateApplyJob caj = (CandidateApplyJob) candidateProfile.get(0);

                CandidateJobApplication application = candidateJobApplicationService.readByCandidateIdAndVacancyId(caj.getId(), vacancyMaster.getId());
                if (null == application) {

                    CandidateJobApplication candidateJobApplication = new CandidateJobApplication();
                    candidateJobApplication.setVacancyMaster(vacancyMaster);
                    candidateJobApplication.setApplayJobUserMaster(ajuMaster);
                    candidateJobApplication.setCreatedBy(ajuMaster.getId());
                    candidateJobApplication.setCreatedDate(sdf.format(cDate));
                    candidateJobApplication.setStatus(0);

                    candidateJobApplication.setCandidateApplyJob(caj);

                    candidateJobApplicationService.create(candidateJobApplication);

                    List<?> CandidateJobApplyList = candidateJobApplicationService.readByCandidateId(caj.getId());

                    request.setAttribute("list", CandidateJobApplyList);
                    mv.getModelMap().put("ajuMaster", ajuMaster);
                    mv.setViewName("Vacancy/MemberVacancyList");
                    return mv;

                } else {
                    request.setAttribute("successMessage",
                            "You are already apply for this job.");
                    List<?> vacancylist = vacancyMasterService.fetchVacancyDetail();
                    mv.getModelMap().put("list", vacancylist);
                    mv.getModelMap().put("vacancyMaster", vacancyMaster);
                    mv.setViewName("Vacancy/ShowVacancyList");
                    return mv;

                }
            } else {
                CandidateApplyJob candidateApplyJob = new CandidateApplyJob();

                mv.getModelMap().put("candidateApplyJob", candidateApplyJob);
                mv.setViewName("Vacancy/applyJobCandidateRegistration");
            }

        } else {
            request.setAttribute("vacid", id);
            mv.getModelMap().put("applayJobUserMaster", applayJobUserMaster);
            mv.setViewName("Vacancy/ApplayLoginpage");

        }

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
//        CandidateApplyJob candidateApplyJob = new CandidateApplyJob();
        String id = request.getParameter("id");
        CandidateApplyJob candidateApplyJob = candidateJobApplyService.readByapplayjobusermasterid(Integer.parseInt(id));
        mv.getModelMap().put("candidateApplyJob", candidateApplyJob);
        mv.setViewName("Vacancy/MyProfile");

        return mv;
    }

    public ModelAndView clickassessment(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        ApplayJobUserMaster applayJobUserMaster = new ApplayJobUserMaster();
        String id = request.getParameter("id");
        Integer applayJobUserMasterId = 0;
        Integer candidateApplyJobid = 0;
        List listOfFinalList = new ArrayList();
        List<?> list1 = candidateJobApplicationService.readOnlineAssementCandidate(Integer.parseInt(id));
        if (!list1.isEmpty()) {
            for (Object o1 : list1) {
                Object str[] = (Object[]) o1;
                Integer CandidateJobApplicationID = (Integer) str[0];
                applayJobUserMasterId = (Integer) str[1];
                candidateApplyJobid = (Integer) str[2];
                Integer vacancyMasterID = (Integer) str[3];

                List<?> list2 = onlineAssessmentService.readOnlineAssementCandidateList(CandidateJobApplicationID);
                if (!list2.isEmpty()) {
                    for (Object o2 : list2) {
                        Object str1[] = (Object[]) o2;
                        List finalList = new ArrayList();
                        Integer onlineAssessmentID = (Integer) str1[0];
                        finalList.add(onlineAssessmentID);
                        Integer candidateJobApplicationID = (Integer) str1[1];
                        finalList.add(candidateJobApplicationID);
                        Integer questionPaperId = (Integer) str1[2];
                        finalList.add(questionPaperId);
                        Double passingPercentage = (Double) str1[3];
                        finalList.add(passingPercentage);
                        String validityFrom = (String) str1[4];
                        finalList.add(validityFrom);
                        String validityTo = (String) str1[5];
                        finalList.add(validityTo);
                        String duration = (String) str1[6];
                        finalList.add(duration);
                        Integer noOfAttampt = (Integer) str1[7];
                        finalList.add(noOfAttampt);
                        Integer noOfQue = (Integer) str1[8];
                        finalList.add(noOfQue);
                        Double totalMarks = (Double) str1[9];
                        finalList.add(totalMarks);
                        String paperName = (String) str1[10];
                        finalList.add(paperName);
                        finalList.add(candidateApplyJobid);
                        listOfFinalList.add(finalList);
                    }
                }

            }
        }
        mv.getModelMap().put("list2", listOfFinalList);
//        mv.getModelMap().put("candidateApplyJobid", candidateApplyJobid);
        mv.setViewName("Vacancy/AssementOnline");

        return mv;
    }

//    }
    public ModelAndView backToHomeVacancyList(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        VacancyMaster vacancyMaster = new VacancyMaster();
        List<?> vacancylist = vacancyMasterService.fetchVacancyDetail();
        mv.getModelMap().put("list", vacancylist);
        mv.getModelMap().put("vacancyMaster", vacancyMaster);
        mv.setViewName("Vacancy/ShowVacancyList");
        return mv;
    }

    public ModelAndView createVacancyNewButton(HttpServletRequest request,
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
            vacancyMaster.setDesignationMaster(vacancyMaster.getDesignationMaster());
        } else {
            vacancyMaster.setLocationMaster(new LocationMaster());
            vacancyMaster.setDepartmentMaster(new DepartmentMaster());
            vacancyMaster.setJobtypeMaster(new JobtypeMaster());
            vacancyMaster.setDesignationMaster(new DesignationMaster());
        }
        departmentList(request);
        designationList(request);
        Map<Integer, String> locationMap = readLocations();
        Map<Integer, String> jobtype1 = jobtypeList();
        mv.addObject("locationMap", locationMap);
        mv.addObject("jobtype1", jobtype1);
        vacancyMaster.setDepartmentMaster(new DepartmentMaster());
        vacancyMaster.setLocationMaster(new LocationMaster());
        vacancyMaster.setJobtypeMaster(new JobtypeMaster());
        vacancyMaster.setDesignationMaster(new DesignationMaster());
        mv.getModelMap().put("departmentMaster", departmentMaster);
        mv.getModelMap().put("locationMaster", locationMaster);
        mv.getModelMap().put("jobtypeMaster", jobtypeMaster);
        mv.getModelMap().put("designationMaster", designationMaster);
        mv.getModelMap().put("vacancyMaster", vacancyMaster);
        mv.setViewName("Vacancy/NewButtonCreateVacancy");
        return mv;
    }

    public ModelAndView logout(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        ApplayJobUserMaster ajuMaster = (ApplayJobUserMaster) session.getAttribute("ApplayJobUserMaster");
        session.invalidate();
        VacancyMaster vacancyMaster = new VacancyMaster();
        List<?> vacancylist = vacancyMasterService.fetchVacancyDetail();
        mv.getModelMap().put("list", vacancylist);
        mv.getModelMap().put("vacancyMaster", vacancyMaster);
        mv.setViewName("Vacancy/ShowVacancyList");
        return mv;

    }

    public ModelAndView candidateProfile(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        ApplayJobUserMaster ajuMaster = (ApplayJobUserMaster) session.getAttribute("ApplayJobUserMaster");
        List<CandidateApplyJob> candidateProfile = (List<CandidateApplyJob>) candidateJobApplyService.readProfileByCandidateUserID(ajuMaster.getId());
        List<?> CandidateJobApplyList = new ArrayList<>();

        if (!candidateProfile.isEmpty()) {
            CandidateApplyJob caj = (CandidateApplyJob) candidateProfile.get(0);
            CandidateJobApplyList = candidateJobApplicationService.readByCandidateId(caj.getId());
        }

        request.setAttribute("list", CandidateJobApplyList);
        mv.getModelMap().put("ajuMaster", ajuMaster);
        mv.setViewName("Vacancy/MemberVacancyList");
        return mv;

    }

    public ModelAndView candidateEditProfile(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();
        ApplayJobUserMaster ajuMaster = (ApplayJobUserMaster) session.getAttribute("ApplayJobUserMaster");
        CandidateApplyJob candidateApplyJob = new CandidateApplyJob();
        BindException errors = new BindException(candidateApplyJob, "candidateApplyJob");
        bind(request, candidateApplyJob);

        CandidateApplyJob caj = candidateJobApplyService.readById(candidateApplyJob.getId());

        String fileLocationURL = getServletContext().getRealPath("/")
                + File.separator + "StorageYard"
                + File.separator + "candidateimage" + File.separator + "" + caj.getPhotograph();
        File File = new File(fileLocationURL);
        File.delete();

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartRequest.getFile("photograph");
//        if (candidateJobApplyService.isExist(multipartFile.getOriginalFilename())) {
        String fileLocationURL2 = getServletContext().getRealPath("/")
                + File.separator + "StorageYard"
                + File.separator + "candidateimage" + File.separator;
        String fileLocationURL1 = "StorageYard"
                + File.separator + "candidateimage" + File.separator;
        File Folder1 = new File(fileLocationURL2);
        if (!Folder1.exists()) {
            Folder1.mkdirs();
        }
        if (multipartFile != null && multipartFile.getSize() > 0) {
            try {
                File file2 = new File(fileLocationURL2 + multipartFile.getOriginalFilename().replaceAll(" ", "_"));
                File file = new File(fileLocationURL1 + multipartFile.getOriginalFilename().replaceAll(" ", "_"));
                multipartFile.transferTo(file2);
                candidateApplyJob.setPhotograph(multipartFile.getOriginalFilename().replaceAll(" ", "_"));
            } catch (Exception e) {

            }
        }
//        }

        String fileLocationURL11 = getServletContext().getRealPath("/")
                + File.separator + "StorageYard"
                + File.separator + "CertificateAttach" + File.separator + "" + caj.getCertificateAttach();
        File File1 = new File(fileLocationURL11);
        File1.delete();

        MultipartHttpServletRequest multipartRequest1 = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile1 = multipartRequest.getFile("certificateId1");
//        if (candidateJobApplyService.isExistCertificateAttach(multipartFile1.getOriginalFilename())) {
        String fileLocationURL3 = getServletContext().getRealPath("/")
                + File1.separator + "StorageYard"
                + File1.separator + "CertificateAttach" + File1.separator;
        String fileLocationURL12 = "StorageYard"
                + File1.separator + "CertificateAttach" + File1.separator;
        File Folder12 = new File(fileLocationURL3);
        if (!Folder12.exists()) {
            Folder12.mkdirs();
        }
        if (multipartFile1 != null && multipartFile1.getSize() > 0) {
            try {
                File file2 = new File(fileLocationURL3 + multipartFile1.getOriginalFilename().replaceAll(" ", "_"));
                File file = new File(fileLocationURL12 + multipartFile1.getOriginalFilename().replaceAll(" ", "_"));
                multipartFile1.transferTo(file2);
                candidateApplyJob.setCertificateAttach(multipartFile1.getOriginalFilename().replaceAll(" ", "_"));
            } catch (Exception e) {

            }
        }
//        }

        candidateApplyJob.setApplayJobUserMaster(caj.getApplayJobUserMaster());
        candidateJobApplyService.update(candidateApplyJob);
        request.setAttribute("successMessage",
                "Information : The Information is Updated Successfully.");

        List<?> CandidateJobApplyList = candidateJobApplicationService.readByCandidateId(caj.getId());

        request.setAttribute("list", CandidateJobApplyList);
        mv.getModelMap().put("ajuMaster", ajuMaster);
        mv.setViewName("Vacancy/MemberVacancyList");

        return mv;
    }

    public ModelAndView clickassessmentOnlineTest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        ApplayJobUserMaster applayJobUserMaster = new ApplayJobUserMaster();
        String id = request.getParameter("id");
        String candidateID = request.getParameter("candidateID");
        List listOfFinalList = new ArrayList();
        List<?> list1 = questionDetailsService.takeTestOnlineAssementCandidate(Integer.parseInt(id));
        for (Object o1 : list1) {
            Object str[] = (Object[]) o1;
            List finalList = new ArrayList();
            Integer questionDetailsID = (Integer) str[0];
            Integer questionPaperId = (Integer) str[1];
            Integer questionLibraryID = (Integer) str[2];
            QuestionLibrary questionLibrary = new QuestionLibrary();
            questionLibrary = questionLibraryService.readById(questionLibraryID);
            Integer questionLibraryid = questionLibrary.getId();
            String question = questionLibrary.getQuestion();
            finalList.add(question);
            Integer type = questionLibrary.getType();
            finalList.add(type);
            finalList.add(questionLibraryid);

            List<?> list2 = questionAnsService.takeTestOnlineAssementCandidateAnswer(questionLibraryid);
            for (Object o2 : list2) {
                Object str1[] = (Object[]) o2;
                Integer questionAnsID = (Integer) str1[0];
                String answer = (String) str1[2];
                finalList.add(answer);
                finalList.add(questionAnsID);
            }
            listOfFinalList.add(finalList);
        }
//        
        mv.getModelMap().put("list2", listOfFinalList);
        mv.getModelMap().put("candidateID", candidateID);
        mv.setViewName("Vacancy/OnlineTestQuestionPaper");

        return mv;
    }

    public ModelAndView clickSubmitQuestionAnswer(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();

        CandidateApplyJob candidateApplyJob = new CandidateApplyJob();

        String candidateiD = request.getParameter("candidateId");
        String[] question = request.getParameterValues("finalData1");
        String[] email = request.getParameterValues("finalData");
//       
        String[] doneId1 = email[0].split(",");
        String[] doneId2 = question[0].split(",");
        String emailId = "";
        String emailId1 = "";
//        for (String s1 : doneId1) {
//            emailId += s1 + ",";
//            if (emailId == "") {
//                questionAnswerSubmit.setDescription(emailId);
//                questionAnswerSubmit.setQuestionAnsId(questionAns);
//            } else {
//                questionAns.setId(Integer.parseInt(s1));
//                questionAnswerSubmit.setQuestionAnsId(questionAns);// Question Anaswer Id set
//
//            }
//           
//
//            for (String s2 : doneId2) {
//                emailId1 += s2 + ",";
//               
//
//            }
//        }
//        
        for (int i = 0; i < doneId2.length; i++) {
            QuestionAnswerSubmit questionAnswerSubmit = new QuestionAnswerSubmit();
            QuestionAns questionAns = new QuestionAns();
            QuestionLibrary questionLibrary = new QuestionLibrary();
            String ques = doneId2[i];
            String ans = doneId1[i];
            boolean parsable = true;
            try {
                Integer.parseInt(ans);
                questionAns.setId(Integer.parseInt(ans));
            } catch (Exception e) {
                parsable = false;
                questionAnswerSubmit.setDescription(ans);
            }
//            return parsable;

            questionAnswerSubmit.setQuestionAnsId(questionAns);// Question Anaswer Id set
            candidateApplyJob.setId(Integer.parseInt(candidateiD));
            questionAnswerSubmit.setCandidateApplyJobId(candidateApplyJob);/// candidate Apply job ID set 
            questionLibrary.setId(Integer.parseInt(ques));
            questionAnswerSubmit.setQuestionLibraryId(questionLibrary);
            questionAnswerSubmitService.create(questionAnswerSubmit);
//             mv.setViewName("Vacancy/AssementOnline");
        }
        request.setAttribute("successMessage", "Information : The Data Submitted Successfully.");
        mv.setViewName("Vacancy/OnlineTestQuestionPaper");
        return mv;
    }

    public ModelAndView CreateNewVacancy(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        VacancyMaster vacancyMaster = new VacancyMaster();
        DepartmentMaster departmentMaster = new DepartmentMaster();
        LocationMaster locationMaster = new LocationMaster();
        JobtypeMaster jobtypeMaster = new JobtypeMaster();
        BindException errors = new BindException(vacancyMaster, "vacancyMaster");
        bind(request, vacancyMaster);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date cDate = new Date();

        departmentList(request);
        designationList(request);
        Map<Integer, String> locationMap = readLocations();
        Map<Integer, String> jobtype1 = jobtypeList();
        mv.addObject("locationMap", locationMap);
        mv.addObject("jobtype1", jobtype1);

        vacancyValidator.validate(vacancyMaster, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "All field are Required.Please Enter Valid data");
            mv.addAllObjects(errors.getModel());
            mv.setViewName("Vacancy/NewButtonCreateVacancy");
        } else {
            vacancyMaster.setStatus(0);
            vacancyMaster.setCreatedBy(employeeMaster.getId());
            vacancyMaster.setCreatedDate(sdf.format(cDate));

            vacancyMasterService.create(vacancyMaster);

            request.setAttribute("successMessage",
                    "Information : The Information is saved Successfully.");

            mv = vacancyDetailList(request, response);
        }

        return mv;
    }

    public ModelAndView vacancyFetch(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        VacancyMaster vacancyMaster = new VacancyMaster();

        List<?> vacancyList = vacancyMasterService.fetchVacancyDetail();
        mv.getModelMap().put("list", vacancyList);
        mv.getModelMap().put("vacancyMaster", vacancyMaster);
        mv.setViewName("Vacancy/vacancyList");
        return mv;
    }
}
